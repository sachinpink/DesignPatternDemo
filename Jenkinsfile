pipeline
{
  agent any
     stages
    {
        stage('Checkout')
         {
           steps {
                // fixed branch syntax (colon) for git step
                git url: 'https://github.com/sachinpink/DesignPatternDemo.git', branch: 'main'
             }

          }
        stage('Test')
        {
          steps {
            // run mvn in a cross-platform way: use sh on Unix agents and bat on Windows agents
            script {
              if (isUnix()) {
                sh 'mvn clean test -Dbrowser=chrome -DUI_Execution=yes -DlocalExecution=no -Dcucumber.filter.tags=@login'
              } else {
                bat 'mvn -B clean test -Dbrowser=chrome -DUI_Execution=yes -DlocalExecution=no -Dcucumber.filter.tags=@login'
              }
            }
          }
        }
    }
  post
  {
     always
         {
          echo 'Execution completed successfully'
       }
    }
}