pipeline {
    agent any   
    tools {       
        jdk 'JDK11'       
        maven 'Mvn3'   
    }   
    stages {       
        stage('test java installation') {           
            steps {
                dir('your-sub-directory'){             
                    sh "$PWD"           
                }                
                sh 'java -version'                          
            }       
        }       
        stage('test maven installation') {           
            steps {   
                dir('your-sub-directory'){             
                    sh "$PWD"           
                }            
                sh 'mvn -version'                      
            }       
        }   
    } 
} 