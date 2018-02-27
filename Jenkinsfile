pipeline {
  agent any
  stages {
    stage('Pre') {
      parallel {
        stage('Pre') {
          steps {
            echo 'test...'
          }
        }
        stage('print') {
          steps {
            echo 'aaaaaaa'
            echo 'aaasss'
          }
        }
      }
    }
  }
}