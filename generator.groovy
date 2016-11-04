import groovy.io.FileType

def listOfFiles = []

// print values of Jenkins parameters
println "Name: ${pipelineName}"
println "Path: ${pipelinePath}"
println "Type: ${pipelineType}"
println "URL: ${gitURL}"

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
						github("francescmorales/propertiesAndJenkinsFiles")
					}
				}
			}
            scriptPath("jenkinsfile")
        }
    }
}

def propsFile = new File("/var/jenkins_home/workspace/${pipelineFolderName}/properties/config.properties")
propsFile.write("gitURL=${gitURL}")

queue(jobName)

// https://github.com/mtablado/jenkins-docker.git