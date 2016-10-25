FROM ubuntu:latest

ENV JENKINS_HOME /var/jenkins_home

ARG user=jenkins
ARG group=jenkins
ARG uid=1000
ARG gid=1000

RUN apt-get update
RUN apt-get -y install openssh-client 

# Jenkins is run with user 'jenkins', uid = 1000
# If you bind mount a volume from the host or a data container, 
# ensure you use the same uid
RUN groupadd -g ${gid} ${group} \
    && useradd -d "$JENKINS_HOME" -u ${uid} -g ${gid} -m -s /bin/bash ${user}

# Check why doesn't overwrite the file.	
# TODO Documentar como vincular los ficheros en volumenes, o enviar mediante COPY/ADD o con Docker-compose.
USER ${user}
CMD echo -e  'y' | ssh-keygen -q -t rsa -N '' -f /keys/id_rsa 
