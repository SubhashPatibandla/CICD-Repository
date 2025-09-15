# Jenkins + Maven + SonarQube Demo

This is a simple Java Maven app to demonstrate a CI pipeline in Jenkins with SonarQube code analysis.

**Pipeline Stages:**
- Checkout from GitHub
- Build & run unit tests with Maven
- Run SonarQube analysis
- Archive build artifact

## How to run locally ##
```bash
mvn clean install
java -cp target/jenkins-maven-sonar-demo-1.0-SNAPSHOT.jar com.example.App
```