#!/bin/bash
HOME=/home/ec2-user

WORK=/home/ec2-user/jar

NAME=galaxy-spring-boot-1.0.0

IMAGE_TAG=$(echo $RANDOM)

date=$(date +%Y-%m-%d)

cd $WORK

sudo mv *.jar $HOME/${NAME}.jar

cd $HOME

sudo docker build -t 688559712485.dkr.ecr.us-west-1.amazonaws.com/galaxy-spring-boot .

sudo docker tag 688559712485.dkr.ecr.us-west-1.amazonaws.com/galaxy-spring-boot:latest 688559712485.dkr.ecr.us-west-1.amazonaws.com/galaxy-spring-boot:${date}_${IMAGE_TAG}

sudo docker push 688559712485.dkr.ecr.us-west-1.amazonaws.com/galaxy-spring-boot:latest

sudo docker push 688559712485.dkr.ecr.us-west-1.amazonaws.com/galaxy-spring-boot:${date}_$IMAGE_TAG

sudo docker rmi -f 688559712485.dkr.ecr.us-west-1.amazonaws.com/galaxy-spring-boot:${date}_$IMAGE_TAG



