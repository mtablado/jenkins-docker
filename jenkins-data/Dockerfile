FROM debian
MAINTAINER Francesc Morales Barbera

ARG environment

# `/usr/share/jenkins/ref/` contains all reference configuration we want 
# to set on a fresh new installation. Use it to bundle additional plugins 
# or config file with your custom jenkins Docker image.
RUN mkdir -p /usr/share/jenkins/ref/

# Install plugins with plugins.txt
#COPY "$environment/plugins.sh" /usr/local/bin/plugins.sh
#COPY "$environment/plugins.txt" /usr/share/jenkins/plugins.txt
#RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

#adding predefined plugins
COPY "$environment/plugins" /usr/share/jenkins/ref/plugins

#adding predefined user admin
COPY "$environment/users" /usr/share/jenkins/ref/users

#adding predefined jobs
COPY "$environment/jobs" /usr/share/jenkins/ref/jobs

#adding predefined config
COPY "$environment/config.xml" /usr/share/jenkins/ref/config.xml
COPY "$environment/hudson.plugins.git.GitSCM.xml" /usr/share/jenkins/ref/hudson.plugins.git.GitSCM.xml
COPY "$environment/org.jfrog.hudson.ArtifactoryBuilder.xml" /usr/share/jenkins/ref/org.jfrog.hudson.ArtifactoryBuilder.xml
COPY "$environment/credentials.xml" /usr/share/jenkins/ref/credentials.xml

# This ssh files are will be moved to jenkins user home 
# (and removed from jenkins app home) at jenkins.sh script.
COPY "$environment/ssh/id_rsa" /usr/share/jenkins/ref/.ssh/
COPY "$environment/ssh/id_rsa.pub" /usr/share/jenkins/ref/.ssh/

VOLUME ["/var/jenkins_home", "/usr/share/jenkins/ref/"]
