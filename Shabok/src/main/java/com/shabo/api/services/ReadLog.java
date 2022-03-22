package com.shabo.api.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.TableMapEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;
import com.pusher.rest.Pusher;

import static com.shabo.api.security.Constants.CHAT_TABLE_NAME;

public class ReadLog {

	public static void main(String[] args) throws IOException {

		final Map<String, Long> tableMap = new HashMap<String, Long>();
		BinaryLogClient client = new BinaryLogClient(System.getenv("MYSQL_HOST"),
				Integer.valueOf(System.getenv("MYSQL_PORT")), System.getenv("MYSQL_REPLICATION_USER"),
				System.getenv("MYSQL_REPLICATION_PASSWORD"));
		Pusher pusher = new Pusher("1365332", "5a6efca0471ef02c22de", "1f6dfd84bd08bf624cb1");
		pusher.setCluster("eu");
		pusher.setEncrypted(true);

		client.registerEventListener(event -> {
			EventData data = event.getData();

			if (data instanceof TableMapEventData) {
				TableMapEventData tableData = (TableMapEventData) data;
				tableMap.put(tableData.getTable(), tableData.getTableId());
			} else if (data instanceof WriteRowsEventData) {
				WriteRowsEventData eventData = (WriteRowsEventData) data;
				if (eventData.getTableId() == tableMap.get(CHAT_TABLE_NAME)) {
					for (Object[] product : eventData.getRows()) {
						pusher.trigger(CHAT_TABLE_NAME, "insert", getProductMap(product));
					}
				}
			}
		});
		client.connect();
	}

	static Map<String, String> getProductMap(Object[] product) {
		Map<String, String> map = new HashMap<>();
		map.put("id", java.lang.String.valueOf(product[0]));
		map.put("emisor", java.lang.String.valueOf(product[1]));
		map.put("receptor", java.lang.String.valueOf(product[2]));
		map.put("mensaje", java.lang.String.valueOf(product[3]));
		map.put("estado", java.lang.String.valueOf(product[4]));
		map.put("hora", java.lang.String.valueOf(product[5]));

		return map;
	}
}
