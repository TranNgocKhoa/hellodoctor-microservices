#!/usr/bin/env bash

kill $(lsof -t -i:8080);
kill $(lsof -t -i:8761);
kill $(lsof -t -i:8888);
kill $(lsof -t -i:8081);

rm -rf ./logs;