#!groovy
pipeline {

    agent any

    parameters {
        string(name: 'tomcat_dev', defaultValue: '35.166.210.154', description: 'Staging Server')
        string(name: 'tomcat_prod', defaultValue: '34.209.233.6', description: 'Production Server')
    }


    triggers {

        pollSCM('* * * * *')

    }

    stage('Git checkout') { // for display purposes

        steps{

        }
            git 'https://github.com/ryanisenia/selenium_automation_pipeline.git'
        }

        post {

            success {

                echo 'Now Checking Out...'

            }

        }

    stage('Smoke') {
        try {
            sh "mvn clean test"
        } catch (err) {

        } finally {
            echo 'Now Error Handling...'
        }
    }

    stage ('End-To-End'){

        steps {

            build job: 'maven-project'

        }

    }

//    stage ('Deployments'){
//        parallel{
//            stage ('Deploy to Staging'){
//                steps {
//                    bat "winscp -i /home/jenkins/tomcat-demo.pem **/target/*.war ec2-user@${params.tomcat_dev}:/var/lib/tomcat7/webapps"
//                }
//            }
//
//            stage ("Deploy to Production"){
//                steps {
//                    bat "winscp -i /home/jenkins/tomcat-demo.pem **/target/*.war ec2-user@${params.tomcat_prod}:/var/lib/tomcat7/webapps"
//                }
//            }
//        }
//    }




}