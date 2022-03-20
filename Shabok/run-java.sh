#!/bin/bash
mvn clean package spring-boot:repackage
java -jar target/*.war