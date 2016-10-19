FROM debian
MAINTAINER Francesc Morales Barbera

RUN mkdir -p /var/log/jenkins

# `/usr/share/jenkins/ref/` contains all reference configuration we want 
# to set on a fresh new installation. Use it to bundle additional plugins 
# or config file with your custom jenkins Docker image.
RUN mkdir -p /usr/share/jenkins/ref/

COPY plugins /usr/share/jenkins/ref/plugins


VOLUME ["/var/log/jenkins", "/var/jenkins_home", "/usr/share/jenkins/ref/"]