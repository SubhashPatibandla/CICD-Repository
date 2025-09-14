In order to run Jenkins locally, instead of running on EC2 instance , please follow the below steps :

1. Install the Java JDK using the following link :

https://download.oracle.com/java/17/archive/jdk-17.0.12_windows-x64_bin.exe (sha256 )

2. After downloading the exe file, install it .

3. Open Command Prompt and check whether Java has been installed properly or not using the below command :

java -version

4. After installing Java, now download Jenkins WAR file :

Go to the Jenkins downloads page and get the "Generic Java package (.war)" file.

5. Start Jenkins :

Open a terminal/command prompt where you downloaded jenkins.war(C:\Downloads or E:\Downloads). Depends on where you have downloaded this jenkins.war file

Run this command:

java -jar jenkins.war --httpPort=8080

Jenkins will be available at http://localhost:8080

6. Unlock Jenkins (First Launch)

Open a browser and go to http://localhost:8080.

Jenkins will prompt for an admin password.

Find the password in the file:

Windows: C:\Users\<your_user>\.jenkins\secrets\initialAdminPassword

Linux/Mac: /home/<your_user>/.jenkins/secrets/initialAdminPassword

Paste the password to continue.

To download SonarQube, follow these steps:

Go to the official SonarQube website:

https://www.sonarqube.org/downloads/

Choose the edition you want:

For most users, the Community Edition (free) is sufficient.

Click the Download button for Community Edition.

Select platform and download:

The download will start as a ZIP or TAR archive depending on your OS.

Choose the version suitable for your operating system (Windows, Linux, macOS).

Extract the downloaded archive:

Unzip or untar the archive to a folder on your local machine.

After download:

Inside the extracted folder, you will find the SonarQube server files.

Start the SonarQube server by running the appropriate script in the bin directory:

On Windows: StartSonar.bat

On Linux/macOS: ./sonar.sh start

This will launch SonarQube on your machine, usually accessible at:
http://localhost:9000 

where you can access the SonarQube web dashboard.


Stop Jenkins :

If you started Jenkins using the WAR file with:

java -jar jenkins.war --httpPort=8080

Simply press Ctrl + C in the Command Prompt window running Jenkins to stop the server.

If Jenkins is installed as a service (Windows):

Open Command Prompt as Administrator and run:

net stop jenkins

Stop SonarQube :

If you started SonarQube using StartSonar.bat on Windows:

Open Command Prompt, navigate to the bin\windows-x86-64 directory in your SonarQube folder.

Run:

StopSonar.bat

If you started it via script on Linux/macOS:

./sonar.sh stop

If SonarQube was started as a service, stop it via your OS service manager.