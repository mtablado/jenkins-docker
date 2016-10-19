# jenkins-docker

Commands to generate this environment:

to build this images:

	- docker build -t pruebas:1.0 jenkins-data-sample/ "Jenkins data Build image"
	- docker build -t jenkins-app jenkins-master/
	
to run this images:

	- docker run -v /c/Users/jenkins:/var/jenkins_home --name data-jenkins pruebas:1.0 "Jenkins Dir Have to be write permisions to everyone"
	- docker run -p 8080:8080 -p 50000:50000 --volumes-from data-jenkins --name jenkins-app  jenkins-app
	
