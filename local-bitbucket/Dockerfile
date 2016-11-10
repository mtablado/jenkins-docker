FROM atlassian/bitbucket-server:latest

# RUN_USER arg is defined at bitbucket-server image.
USER root
RUN chown -R ${RUN_USER} /var/atlassian/application-data/bitbucket
VOLUME ["/var/atlassian/application-data/bitbucket"]