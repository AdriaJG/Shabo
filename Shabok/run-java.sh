#!/bin/bash
mvn dependency:go-offline
mvn clean fabric8:deploy -Popenshift