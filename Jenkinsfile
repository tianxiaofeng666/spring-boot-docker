pipeline {
    agent any

    environment {
        DOCKER_ID = 'txf317512'
        REPOSITORY_NAME = 'k8s'
        TAG_NAME = 'spring-boot-dcoker'
        DOCKER_USERNAME = 'txf317512'
        DOCKER_PASSWORD = 'Txf317512'
    }

    stages {
        stage('打包镜像') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
                sh 'docker build -f Dockerfile -t $DOCKER_ID/$REPOSITORY_NAME:$TAG_NAME-$BUILD_NUMBER .'
            }
        }
        stage('上传镜像') {
            steps {
                sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                sh 'docker push $DOCKER_ID/$REPOSITORY_NAME:$TAG_NAME-$BUILD_NUMBER'
            }
        }
        stage('发布') {
            steps {
                sh 'echo Deploy stage ...'
            }
        }
    }
}