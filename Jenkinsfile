pipeline{
	agent any
	tools{
		maven 'maven'
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
					bat "mvn clean test -Denv=dev -DsuiteXmlFile=SmokeTest"
				}
				
				echo("qa the project")
			}
		}
		stage("publish chainTest report"){
			steps{
					publishHTML([allowMissing:false,
					alwaysLinkToLastBuild:false,
					keepAll:true,
					reportDir:'target/chaintest',
					reportFiles:'Index.html'
					reportName:'HTML Smoke Test Report',
					])
				echo("test the project")
			}
		}
		stage("prod"){
			steps{
				echo("prod the project")
			}
		}
	}
}