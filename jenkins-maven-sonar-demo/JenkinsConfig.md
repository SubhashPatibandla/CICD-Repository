**Install Required Jenkins Plugins:

Go to Manage Jenkins → Manage Plugins → Available and install the following plugins:

Git Plugin (for Git SCM checkout).

Pipeline (enables Jenkins Pipeline jobs)

Pipeline Utility Steps (for JSON processing in pipeline)

Maven Integration Plugin (for running Maven builds)

SonarQube Scanner Plugin (for SonarQube integration)

GitHub Integration Plugin (for webhooks and GitHub triggers)

After installation, restart Jenkins if prompted.

**Install and Configure Tools in Jenkins:

Go to Manage Jenkins → Global Tool Configuration and configure:

JDK

Add JDK (if Jenkins doesn’t detect automatically)

Specify name (e.g., jdk11) and path to JDK installation (Java 11 or later).

Maven

Add Maven installation

Specify name (e.g., maven-3.6.3)

You can either install automatically or specify the path.

SonarQube Scanner

Add SonarQube Scanner installation

Give it a name (e.g., SonarQubeScanner)

Optionally install automatically or specify the path if installed manually.

4. Configure SonarQube Server in Jenkins
Log in to Jenkins.

From the Jenkins dashboard, click on Manage Jenkins (left-hand menu).

Click on Configure System.

Scroll down to the SonarQube servers section.

Click Add SonarQube.

Fill in the following:

Name: Enter the exact name used in your Jenkinsfile environment block, e.g., SonarQubeServer.

Server URL: Enter your SonarQube server URL, e.g., http://localhost:9000.

Under Server authentication token (recommended), click Add → Jenkins and select Secret text.

Enter your SonarQube authentication token (you get this token from SonarQube user account → My Account → Security → Generate Tokens).

Give the credential an ID (optional, for recognition) and click Add.

IMP :: Back in the SonarQube section, select this credential from the dropdown(should be the same ID which you have configured in credentials).

Click Save at the bottom of the page.

5. Configure Global Credentials in Jenkins (for GitHub or SonarQube)
Go to the Jenkins dashboard and click Manage Jenkins.

Click Manage Credentials.

Select the appropriate domain (usually (global)).

Click Add Credentials (on the left).

In the popup, select the Kind:

Choose Username with password for GitHub credentials (your GitHub username and password or personal access token).

Choose Secret text for tokens like SonarQube or GitHub personal access tokens.

Fill in the required fields:

For Username with password: enter username and password/token.

For Secret text: enter the token.

Optionally add an ID and description to identify the credential.

Click OK to save.
