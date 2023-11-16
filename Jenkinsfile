pipeline {
    agent any

    environment {
        GRADLE_HOME = tool 'GRADLE_ENV'
        PATH = "${GRADLE_HOME}/bin:${PATH}"
        registry = ""
        dockerContainerName = 'bookapi'
        dockerImageName = 'bookapi-api'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Utilisation de 'bat' pour exécuter des commandes spécifiques à Windows
                    bat "gradle clean build"
                }
            }
        }

        stage('clean container') {
            steps {
                script {
                    // Utilisation de 'bat' pour exécuter des commandes spécifiques à Windows
                    bat 'docker ps -f name=${dockerContainerName} -q | Where-Object { docker container stop $_ }'
                    bat 'docker container ls -a -fname=${dockerContainerName} -q | Where-Object { docker container rm $_ }'
                    bat 'docker images -q --filter=reference=${dockerImageName} | Where-Object { docker rmi -f $_ }'
                }
            }
        }

        stage('docker-compose start') {
            steps {
                script {
                    // Utilisation de 'bat' pour exécuter des commandes spécifiques à Windows
                    bat 'docker-compose up -d'
                }
            }
        }
    }
}
