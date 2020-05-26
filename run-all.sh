#!/usr/bin/env bash

rm -rf ./logs
mkdir ./logs
touch ./logs/config.log;
touch ./logs/discovery.log;
touch ./logs/dummy.log;
touch ./logs/gateway.log;

cd ./config-server;
mvn spring-boot:run -Dspring-boot.run.profiles=local > ../logs/config.log &
cd ..;
sh ./wait-for-it.sh localhost:8888 -t 20 --strict --

cd ./discovery;
echo "Current folder: "; pwd;
echo "";
mvn spring-boot:run > ../logs/discovery.log &
cd ..;
sh ./wait-for-it.sh localhost:8761 -t 20 --strict --

cd ./gateway;
echo "Current folder: "; pwd;
echo "";
mvn spring-boot:run -Dspring-boot.run.profiles=local > ../logs/gateway.log &
cd ..;

cd ./dummy;
echo "Current folder: "; pwd;
echo "";
mvn spring-boot:run -Dspring-boot.run.profiles=local > ../logs/dummy.log &
cd ..;

sh ./wait-for-it.sh localhost:8080 -t 20 --strict -- echo "Finish";