pipeline {
    agent any
    tools {
            maven 'Maven3.9.9' // Ensure 'Maven3.9.9' is configured in Jenkins global tool configuration
        }
    stages {
        stage("Compile and Clean") {
            steps {
//                 checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Ashutosh-rajput/DevOpsTesting']])
                sh 'mvn clean compile'
            }
        }
        stage("Deploy"){
            steps{
                sh 'mvn package'
            }
        }
        stage("Build docker image") {
            steps {
                script {
                    // Define the image name
                    def imageName = "ashutoshrajput81/testawscicd"

                    // Check if the image exists locally
                    def imageExists = sh(
                        script: "docker images -q ${imageName}",
                        returnStdout: true
                    ).trim()

                    // If the image exists, delete it
                    if (imageExists) {
                        echo "Deleting existing Docker image: ${imageName}"
                        sh "docker rmi -f ${imageName}"
                    } else {
                        echo "No existing image found. Proceeding with build."
                    }

                    // Build the new Docker image
                    sh "docker build -t ${imageName} ."
                }
            }
        }
        stage("Push Docker Image to Docker hub") {
            steps {
                script {
                    withCredentials([string(credentialsId: 'Dockerhubpwdid', variable: 'Dockerhubpwd')]) {
                        sh 'docker login -u ashutoshrajput81 -p ${Dockerhubpwd}'
                    }
                    sh 'docker push ashutoshrajput81/testawscicd'
                }
            }
        }
        stage("Cleanup previous containers") {
                    steps {
                        script {
                            def containerId = sh(
                                script: "docker ps -q --filter ancestor=ashutoshrajput81/testawscicd",
                                returnStdout: true
                            ).trim()

                            if (containerId) {
                                echo "Stopping and removing container: ${containerId}"
                                sh "docker stop ${containerId}"
                                sh "docker rm ${containerId}"
                            } else {
                                echo "No running container found."
                            }
                        }
                    }
                }
        stage("Docker Deploy"){
            steps{
                sh 'docker run -itd -p 8090:8090 ashutoshrajput81/testawscicd'}}
    }
}
