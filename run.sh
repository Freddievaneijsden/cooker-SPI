#!/bin/bash

java --module-path \
  Consumer/target/Consumer-1.0-SNAPSHOT.jar:Interface/target/Interface-1.0-SNAPSHOT.jar:Provider/target/Provider-1.0-SNAPSHOT.jar \
  -m com.example.consumer/com.example.consumer.Main
