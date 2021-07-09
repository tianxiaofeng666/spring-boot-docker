pipeline {
    agent any

    environment {
        DOCKER_ID = 'txf317512'
        REPOSITORY_NAME = 'k8s'
        TAG_NAME = 'spring-boot-dcoker'
        DOCKER_USERNAME = 'txf317512'
        DOCKER_PASSWORD = 'Txf317512'
        PORT = 1111
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
                sh '''
                    process_id=$(ps -ef | grep 'app.jar' | grep -v grep | awk '{print $2}')
                    echo $process_id
                    if [ -z "$process_id" ]; then
                        echo "服务未启动"
                    else
                        echo "停止正在进行服务"
                        kill -9 $process_id
                        echo "开始启动服务"
                    fi
                    docker run -d -p $PORT:$PORT $DOCKER_ID/$REPOSITORY_NAME:$TAG_NAME-$BUILD_NUMBER
                '''
            }
        }
    }
}