pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Compile Stage') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage ('Sonarqube deployment Stage') {
            steps{
                sh 'mvn sonar:sonar'
            }

        }
    }
}
