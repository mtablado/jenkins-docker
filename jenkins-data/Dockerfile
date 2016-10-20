FROM debian
MAINTAINER Francesc Morales Barbera

# `/usr/share/jenkins/ref/` contains all reference configuration we want 
# to set on a fresh new installation. Use it to bundle additional plugins 
# or config file with your custom jenkins Docker image.
RUN mkdir -p /usr/share/jenkins/ref/

# Install plugins with plugins.txt
#COPY plugins.sh /usr/local/bin/plugins.sh
#COPY plugins.txt /usr/share/jenkins/plugins.txt
#RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

#adding predefined plugins
COPY plugins /usr/share/jenkins/ref/plugins

#adding predefined user admin
COPY users /usr/share/jenkins/ref/users

VOLUME ["/var/jenkins_home", "/usr/share/jenkins/ref/"]
