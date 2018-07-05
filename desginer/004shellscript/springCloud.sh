#! /bin/bash

## killall java
jps_current=$(jps)
echo "当前的java进程："$jps_current

kill_java=$(killall -9 java)
echo "kill all java process success ."

## pull
project_path=/webapp/source/wm.program
cd $project_path
pwd=$(pwd)
echo "切换到git目录："$pwd
git_pull=$(git pull)
echo "从github同步："$git_pull

## mvn package
pageage_info=$(mvn clean package -Dmaven.test.skip=true)
echo "maven package info："$pageage_info

## nohup
jar_path=/webapp/snapshots/1.0.0-SNAPSHOT
cd $jar_path
pwd1=$(pwd)
echo "切换到jar目录："$pwd1
authserver_start=$(nohup java -jar application-authserver-1.0.0-SNAPSHOT.jar >> /webapp/nohuplog/authserver.log 2>&1 &)
echo "后台启动authserver"$authserver_start
basicmanager_start=$(nohup java -jar application-basicmanager-1.0.0-SNAPSHOT.jar >> /webapp/nohuplog/basicmanager.log 2>&1 &)
echo "后台启动basicmanage："$basicmanager_start
gateway_start=$(nohup java -jar server-gateway-1.0.0-SNAPSHOT.jar >> /webapp/nohuplog/gateway.log 2>&1 &)
echo "后台启动gateway:"$gateway_start


