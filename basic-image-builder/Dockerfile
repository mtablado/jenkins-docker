FROM tehranian/dind-jenkins-slave

ENV DOCKER_VERSION 1.12.2-0~trusty
ENV DOCKER_DAEMON_ARGS --insecure-registry docker-virtual.art.local

RUN apt-get update && apt-get install -y docker-engine=$DOCKER_VERSION && rm -rf /var/lib/apt/lists/*
