pipeline{
    agent any
    tools{
        maven 'Maven'
        jdk 'JDK1.8'
    }
    stages{
        stage("Build"){
            steps{
                echo "Building the project..."
                bat "mvn clean install"
            }
        }
        
        stage("Deploy to QA"){
            steps{
                echo "Deploying to QA..."
                // Add actual deploy steps if needed
            }
        }
        
        stage("Regression Test"){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/anilchanges']],
                          userRemoteConfigs: [[url: 'https://github.com/Anilkumar2127/openKartApp.git']]])
                
                echo "Running Selenium tests..."
                catchError(buildResult:'SUCCESS',stageResult:'FAILURE'){
                    bat "mvn clean test"
                }
            }
        }
        
        stage('Publish ChainTest Report'){
            steps{
                publishHTML([allowMissing: true,
                             alwaysLinkToLastBuild: false,
                             keepAll: true,
                             reportDir: 'target/chaintest', 
                             reportFiles: 'Index.html', 
                             reportName: 'HTML Regression ChainTest Report'])
            }
        }
        
        stage("Production"){
            steps{
                echo "Deploying to production..."
                // Add production steps if required
            }
        }
    }
}