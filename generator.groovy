import groovy.io.FileType

def listOfFiles = []

//Separate folders
def separator = "/"
def folders = pipelinePath.split(separator)

// Create folders for the path
def folderName
def firstFolder = true
folders.each{ dir ->
	if(firstFolder){
		folderName = dir
		folder(folderName)
		firstFolder = false
	}else{
		folderName = folderName + separator + dir
		folder(folderName)
	}
}
def pipelineFolderName = folderName + separator + pipelineName
folder(pipelineFolderName)  

// Time to create Job.
def jobName = pipelineFolderName + separator + pipelineName
pipelineJob(jobName) {
    definition {
        cpsScm {
			scm{
				git{
					branch("*/develop")
					remote{
						url("ssh://git@192.168.99.100:7999/ci/jenkins-files.git")
						credentials("jenkins (Jenkins SSH key)")	
					}
				}
			}
            scriptPath("${pipelineType}/jenkinsfile")
        }
    }
}

//Generate properties file
new File("/var/jenkins_home/workspace/${pipelineFolderName}/properties").mkdirs()  
def propsFile = new File("/var/jenkins_home/workspace/${pipelineFolderName}/properties/config.properties")
propsFile.write("gitURL=${gitURL}\npipelineType=${pipelineType}\npipelineName=${pipelineName}\npipelinePath=${pipelinePath}")

//Run new pipeline
queue(jobName)

// https://github.com/mtablado/jenkins-docker.git