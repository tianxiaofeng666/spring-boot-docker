pipeline {
    agent {
        node {
            label 'maven'
        }
    }

    stages {
        stage ('拉取代码') {
            steps {
                checkout(scm)
                echo "hello！success！"}
            }
        }

    }
}