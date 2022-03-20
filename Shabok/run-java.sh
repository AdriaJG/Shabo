#!/bin/bash
mvn dependency:go-offline
mvn clear fabric8:deploy -Popenshift