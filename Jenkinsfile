pipeline{
	agent any
	tools{
		maven 'Maven'
	}
	stages{
		stage("build"){
			steps{
				echo("Build the project")
			}
		}
		
		stage("Unit Test"){
			steps{
				echo("Performing unit testing")
			}
		}
		
		stage("deploy to Dev"){
			steps{
				echo("deployed to dev the project")
			}
		}
		
		stage("Sanity test "){
			steps{
				catchError(buildResult:'SUCCESS',stageResult:'FAILURE'){
					git 'https://github.com/Anilkumar2127/openKartApp.git'
					bat "mvn clean test -Denv=qa -DXmlFile=Sanity"
				}
			}
		}
        
		stage("deploy to QA"){
			steps{
				echo("deployed to QA the project")
			}
		}
		stage("Regression test "){
			steps{
				catchError(buildResult:'SUCCESS',stageResult:'FAILURE'){
					git 'https://github.com/Anilkumar2127/openKartApp.git'
					bat "mvn clean test -Denv=qa -DXmlFile=Regression"
				}
			}
		}
		stage('Publish ChainTest Report for Regression'){
            steps{
                     publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false, 
                                  keepAll: true, 
                                  reportDir: 'target/chaintest', 
                                  reportFiles: 'Index.html', 
                                  reportName: 'HTML Regression ChainTest Report', 
                                  reportTitles: ''])
            }
        }
        
		stage("deploy to uat "){
			steps{
				echo("deployed to uat the project")
			}
		}
		stage("Smoke test "){
			steps{
				catchError(buildResult:'SUCCESS',stageResult:'FAILURE'){
					git 'https://github.com/Anilkumar2127/openKartApp.git'
					bat "mvn clean test -Denv=uat -DXmlFile=SmokeTest"
				}
			}
		}
		stage("prod"){
			steps{
				echo("prod the project")
			}
		}
	}
}