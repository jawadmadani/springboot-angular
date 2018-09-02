pipeline {
  agent any
  stages {
    stage('sonarqube') {
      agent {
        docker {
          image 'sonarqube'
        }

      }
      steps {
        sh 'mvn sonar:sonar'
      }
    }
  }
}