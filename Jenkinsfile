pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'echo Build stage ...'
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('Test') {
            steps {
                sh 'echo Test stage ...'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo Deploy stage ...'
            }
        }
    }
}