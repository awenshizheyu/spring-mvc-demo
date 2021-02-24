pipeline {
  agent any
  stages {
    stage('One') {
      parallel {
        stage('One') {
          steps {
            echo 'hello'
          }
        }

        stage('Two') {
          steps {
            echo 'hello two'
          }
        }

      }
    }

  }
}