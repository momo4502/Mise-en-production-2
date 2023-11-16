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
                    // Type de build: Build complet
                    // Utilisation de 'bat' pour exécuter des commandes spécifiques à Windows
                    bat "gradle clean build"
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
