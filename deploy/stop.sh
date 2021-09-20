#!/bin/bash

Service_name=galaxy-spring-boot
Docker_running=`sudo docker ps |sudo grep $Service_name|wc -l`

if [ "$Docker_running" -gt 0 ];then
     sudo docker rm -f $Service_name >/dev/null 2>1
     sudo docker rm -f `sudo docker ps -qa` >/dev/null 2>1
     sudo docker rmi -f `sudo docker images|sudo grep -v openjdk|sudo awk '{print $3}'|sudo grep -v IMAGE` >/dev/null 2>1
else
     sudo echo 'pass stop.'
fi


