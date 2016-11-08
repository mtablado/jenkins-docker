# jenkins-docker

Commands to generate this environment:

to build this images:

	- docker build -t pruebas:1.0 jenkins-data-sample/ "Jenkins data Build image"
	- docker build -t jenkins-app jenkins-master/
	
to run this images:

	- docker run -v /c/Users/jenkins:/var/jenkins_home --name data-jenkins pruebas:1.0 "Jenkins Dir Have to be write permisions to everyone"
	- docker run -p 8080:8080 -p 50000:50000 --volumes-from data-jenkins --name jenkins-app  jenkins-app
	
## Bind shared folders on Virtualbox and boot2docker

The first thing you need to do is to add a shared folder to your VirtualBox. You can use the GUI as the following image:

![ddd](./images/shared-folder.png)

... or execute the `sharedfolder add boot2docker-vm -name /docker-workspaces -hostpath c:/devel/docker-workspaces` windows command.

After adding the shared folder you need to mount it inside the virtual machine by running:

```
sudo mkdir /docker-workspaces 
sudo mount -t vboxsf /docker-workspaces /docker-workspaces
```


### Permanent shared folder

If you want to permanently add this shared folder you need to create the `/var/lib/boot2docker` file (using `docker-machine ssh`) with this content (lines above without `sudo`)

```
mkdir /docker-workspaces 
mount -t vboxsf /docker-workspaces /docker-workspaces
```


This file will be launched by `/opt/bootscript.sh`. Look at the following snippet:

```
# Allow local HD customisation
if [ -e /var/lib/boot2docker/bootlocal.sh ]; then
   /var/lib/boot2docker/bootlocal.sh > /var/log/bootlocal.log 2>&1 &
fi
```

Reference: [Docker: Permanently Mount a VirtualBox Shared Folder](http:// http://www.developmentalmadness.com/2016/03/05/docker-permanently-mount-a-virtualbox-shared-folder/)

