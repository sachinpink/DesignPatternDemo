pipeline {
    agent any
    tools {
        maven 'Maven 3.9'
    }
    parameters {
        choice(name: 'TAGS', choices: ['@login','@smoke'], description: 'Select cucumber tag')
        choice(name: 'BROWSER', choices: ['chrome','firefox','edge'], description: 'Select browser')
        string(name: 'LocalExecuation', defaultValue: 'yes', description: 'Select Remove or Local execution')
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/sachinpink/DesignPatternDemo.git', branch: 'main'
            }
        }
        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh "mvn clean test -Dbrowser=${params.BROWSER} -DUI_Execution=yes -DlocalExecution=${params.LocalExecuation} -Dcucumber.filter.tags=${params.TAGS}"
                    } else {
                        bat "mvn -B clean test -Dbrowser=${params.BROWSER} -DUI_Execution=yes -DlocalExecution=${params.LocalExecuation} -Dcucumber.filter.tags=${params.TAGS}"
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
