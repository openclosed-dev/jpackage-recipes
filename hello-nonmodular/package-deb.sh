#!/bin/bash

rm -f target/*.deb

jpackage --name hello-nonmodular \
    --app-version 1.0.0 \
    --input target/jars \
    --dest target \
    --main-jar hello-nonmodular-1.0.0.jar \
    --main-class org.example.DemoApplication \
    --verbose
