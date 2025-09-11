Steps to Run Maven in a Freestyle Job
1. Make sure prerequisites are ready

Maven Integration plugin is installed
(Manage Jenkins → Plugins → Installed → check for Maven Integration)

A Maven installation is configured in Jenkins
(sudo apt install maven)

2. Create a Freestyle Job

Go to Jenkins Dashboard → New Item

Enter a name (e.g., maven-build-job)

Select Freestyle project → Click OK

3. Configure Source Code

In the job config page:

Scroll to Source Code Management

Choose Git (or other SCM)

Enter your repo URL (where pom.xml exists)

In Branch Specifier (blank for 'any'), change:

*/master


to

*/main

4. Add "Build with Maven" Step

Scroll to Build section

Click Add build step → Invoke top-level Maven targets
(this option only appears if Maven Integration plugin is installed ✅)

Configure:

Maven Version → select the one you configured earlier (Maven-3.9.9)

Goals → type goals like:

clean install


(Optional) POM → if pom.xml is not in repo root, give relative path (e.g., subproject/pom.xml)

Example:

If your pom.xml is in:

java-hellocicd-master/pom.xml


then in Jenkins POM field, just write:

java-hellocicd-master/pom.xml


If it’s in repo root → leave POM field empty (Jenkins will look for pom.xml in root).

5. (Optional) Add Post-build Actions

Publish JUnit test result report

Pattern: **/target/surefire-reports/*.xml

Example : java-hellocicd-master/target/surefire-reports/*.xml

Archive artifacts

Pattern: target/*.jar

Ex: java-hellocicd-master/target/*.jar

6. Save & Build

Click Save

Then Build Now

Jenkins will:

Checkout code

Run Maven with the goals you set

Parse test results & archive artifacts (if configured)
