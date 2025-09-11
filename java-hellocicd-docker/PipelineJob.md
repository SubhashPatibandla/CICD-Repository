**Java CI/CD with Jenkins + Docker Agent**

**1. Prerequisites**

Jenkins installed.

Docker installed on Jenkins host.

docker -v


Jenkins must have permission to run Docker (add jenkins user to docker group).

sudo usermod -aG docker jenkins

**2. Setup**

Extract java-hellocicd-docker from the ZIP.

Push to GitHub:

git init
git remote add origin https://github.com/yourusername/java-hellocicd-docker.git
git add .
git commit -m "Initial commit"
git push origin main

**3. Create Jenkins Pipeline**

Jenkins → New Item → Pipeline → Name: java-hellocicd-docker.

Pipeline from SCM → Git repo URL.

Branch = main.

Save and Build.

**4. Pipeline Stages**

Agent → uses Docker image maven:3.8.6-openjdk-11.

Checkout → pulls code from GitHub.

Build → compiles inside container.

Test → runs tests inside container.

Package → JAR generated inside container.

Archive → JAR stored as artifact in Jenkins.

✅ End result: JAR file is built inside a clean Docker container, not on the Jenkins master.
