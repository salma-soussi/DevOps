
pipeline {
    agent none
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dh_cred')
    }
    stages {
         stage('Checkout'){
            agent any
            steps{
                //Changez avec votre lien github
                git branch: 'main', url: 'https://github.com/salma-soussi/DevOps.git'
            }
        }
        stage('Init'){
            agent any
            steps{
            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Build frontend') {
            agent any
            steps {
                dir('paper-kit-2-angular-master'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }
        stage('Build backend') {
            agent any
            steps {
                dir('plantManagement'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/backend:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/backend:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/backend:$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }
 
    }
}
