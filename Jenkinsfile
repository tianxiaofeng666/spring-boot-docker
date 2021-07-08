pipeline {
    agent any

    environment {
        DOCKER_ID = 'txf317512'
        REPOSITORY_NAME = 'k8s'
        TAG_NAME = 'spring-boot-dcoker'
    }

    stages {
        stage('打包镜像') {
            steps {
                sh 'echo Build stage ...'
                sh 'mvn clean package -Dmaven.test.skip=true'
                sh 'docker build -f Dockerfile -t $DOCKER_ID/$REPOSITORY_NAME:$TAG_NAME-$BUILD_NUMBER .'
            }
        }
        stage('上传镜像') {
            steps {
                sh 'echo upload image ...'
                sh 'echo Txf317512 | docker login -u txf317512 --password-stdin'
                sh 'docker push $DOCKER_ID/$REPOSITORY_NAME:$TAG_NAME-$BUILD_NUMBER'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo Deploy stage ...'
            }
        }
    }
}