pipeline {
    agent any
     tools {
         maven "Maven3"
         jdk 'jdk8'
    }
    stages {
        stage('git checkOut'){
            steps {
                checkout([$class           : 'GitSCM', branches: [[name: '*/master']],
                          userRemoteConfigs: [[credentialsId: 'f91cb269-b472-479d-8359-2e577834a69a',
                                               url: 'http://uugit.uupt.com/TestGroup/teststatistics-app.git']]])
            }
        }
        stage('maven clean compile') {
        steps {
            echo "开始执行编译"
            bat "mvn clean compile"
        }
        }
        stage('jacoco dump') {
              steps {
                powershell  "cd C:\\Users\\Administrator\\Downloads\\jacoco-0.8.8\\lib"
                bat  "java -jar jacococli.jar dump --address 192.168.6.110 --destfile C:\\Users\\Administrator\\Downloads\\jacoco.exec --port 6300"
           }
        }
        stage('jacoco Report') {
            steps {
               bat  "cd C:\\Users\\Administrator\\Downloads\\jacoco-0.8.8\\lib"
               bat  "java -jar jacococli.jar report C:\\Users\\Administrator\\Downloads\\jacoco.exec --classfiles target/classes --sourcefiles src/main/java --encoding utf-8 --html report"
            }
        }
        stage('publishHTML & Clean Workspace') {
            steps {
               publishHTML([allowMissing:true , alwaysLinkToLastBuild:true , keepAll:false , reportDir: "report", reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
            }
        }
    
    }
}
