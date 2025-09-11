**🔹 Step 1: Create a Pipeline Job in Jenkins**

Go to Jenkins Dashboard → New Item.

Enter a name (e.g., Maven-Pipeline).

Select Pipeline and click OK.

**🔹 Step 2: Configure the Pipeline Script**

In the Pipeline section, paste your script:

pipeline {
  agent any
  tools {
    // Must match the name from "Global Tool Configuration"
    maven 'Maven-3.9.9' ##provide latest version
  }
  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/SubhashPatibandla/CICD-Repository'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -f java-hellocicd-master/pom.xml clean install'
      }
    }
    stage('Archive') {
      steps {
        archiveArtifacts artifacts: 'java-hellocicd-master/target/*.jar', fingerprint: true
      }
    }
    stage('Test Reports') {
      steps {
        junit java-hellocicd-master/target/surefire-reports/*.xml'
      }
    }
  }
}

**🔹 Step 3: Things to Note**

The maven 'Maven-3.9.9' must exactly match the name you configured in
Manage Jenkins → Global Tool Configuration → Maven.

git step will clone your repo (main branch).

sh 'mvn clean install' builds & tests your project.

archiveArtifacts saves your JAR into Jenkins build history.

junit parses Surefire XML test reports (generated during Maven test phase).

**🔹 Step 4: Run the Job**

Save the pipeline.

Click Build Now.

After success:

You’ll see your .jar under Archived Artifacts.

Test results will be visible under Test Result Trend.
