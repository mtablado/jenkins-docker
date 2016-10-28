FROM atlassian/bitbucket-server:latest

RUN ls -lia /var/atlassian/application-data \
	&& chown -R ${RUN_USER} /var/atlassian/application-data/bitbucket \
	&& ls -lia /var/atlassian/application-data
VOLUME ["/var/atlassian/application-data/bitbucket"]