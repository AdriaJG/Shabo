#!/bin/bash
mvn dependency:go-offline
mvn build fabric8:deploy -Popenshift