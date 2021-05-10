pipeline {
    agent any   
    tools {       
        jdk 'JDK11'       
        maven 'Mvn3'   
    }   
    stages {       
        stage('test java installation') {           
            steps {              
                sh 'java -version'                          
            }       
        }       
        stage('test maven installation') {           
            steps {              
                sh 'mvn -version'                      
            }       
        }   
    } 
} 