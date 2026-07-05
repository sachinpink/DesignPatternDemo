pipeline
{
  agent any
   tools {
          maven 'Maven 3.9'
      }
      parameters {
       choice(name: 'TAGS', choices: ['@login','@smoke'], description: 'Select cucumber tag'),
       choice(name: 'BROWSER', choices: ['chrome','firefox','edge'], description: 'Select browser')
       string(name: 'LocalExecuation', defaultValue: 'yes', description: 'Select Remove or Local execution')

       }
     stages {
        stage('Checkout')
         {
           steps {
                git url: 'https://github.com/sachinpink/DesignPatternDemo.git', branch: 'main'
             }

          }
        stage('Test')
        {
          steps {
            // run mvn in a cross-platform way: use sh on Unix agents and bat on Windows agents
            script {
              if (isUnix()) {
                sh 'mvn clean test -Dbrowser=${BROWSER} -DUI_Execution=yes -DlocalExecution=${LocalExecuation} -Dcucumber.filter.tags=${TAGS}'
              } else {
                bat 'mvn -B clean test -Dbrowser=${BROWSER} -DUI_Execution=yes -DlocalExecution=${LocalExecuation} -Dcucumber.filter.tags=${TAGS}'
              }
            }
          }
        }
    }
  post {
        success {
        echo 'Execution completed successfully'
       }
       failure {
               echo 'Execution failed'
          }
    }
}