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
		stage("deploy to QA"){
			steps{
				echo("deployed to QA the project")
			}
		}
		stage("Regression test "){
			steps{
				catchError(buildResult:'SUCCESS',stageResult:'FAILURE'){
					git 'https://github.com/Anilkumar2127/openKartApp.git'
					bat "mvn clean test -Dqa=dev -DXmlFile=SmokeTest"
				}
			}
		}
		stage('Publish ChainTest Report'){
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
		stage("prod"){
			steps{
				echo("prod the project")
			}
		}
	}
}