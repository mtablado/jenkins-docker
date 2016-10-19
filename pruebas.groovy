node {
    stage('compile'){
        echo 'Hello World'
        def workspace = pwd()
        echo "compile workspace=${workspace}"
        sh 'touch compile'
        sh 'ls'
    }
    stage('Unit_test'){
        echo 'Hello World'
        sh 'touch test'
        sh 'ls'
    }
    stage('QA_Sonar'){
        echo 'Hello World'     
    }
    stage('Deploy_Artifact'){
        echo 'Hello World'     
    }
    stage('Deploy_to_Dev'){
        echo 'Hello World'     
    }
}