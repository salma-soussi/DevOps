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
             when {
                changeset "**/paper-kit-2-angular-master/**"
                beforeAgent true
            }

            steps {
                dir('paper-kit-2-angular-master'){
                    sh 'docker build -t soussisalma/frontend:$BUILD_ID .'
                    sh 'docker push soussisalma/frontend:$BUILD_ID'
                    sh 'docker rmi soussisalma/frontend:$BUILD_ID'
                }
            }
        }
        stage('Build backend') {
            agent any
            when {
                changeset "**/plantManagement/**"
                beforeAgent true
            }
            steps {
                dir('plantManagement'){
                    sh 'docker build -t soussisalma/backend:$BUILD_ID .'
                    sh 'docker push soussisalma/backend:$BUILD_ID'
                    sh 'docker rmi soussisalma/backend:$BUILD_ID'
                }
            }
        }

        stage('Logout'){
            agent any
            steps{
                sh 'docker logout'
            }
        }
    }
}

