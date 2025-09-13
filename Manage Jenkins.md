**Top-level navigation (left pane)**

**Dashboard / New Item / People / Build History — quick view of jobs, recent builds, and users.**

Blue Ocean (if installed) — visual pipeline editor and run view.

Manage Jenkins (main admin page)

Click Manage Jenkins → this is the central admin console. Key sections below:

**A. Configure System**

Path: Manage Jenkins → Configure System

Steps: set Jenkins URL, system message, global environment variables, default SSH host key verification, and global hooks.

Actionable: set SMTP email server for email notifications.

**B. Global Tool Configuration**

Path: Manage Jenkins → Global Tool Configuration

Steps: configure JDK installations, Git, Maven, Gradle, NodeJS, Docker Tool, etc.

Actionable: provide automatic installer or path to tools on agents.

**C. Manage Plugins**

Path: Manage Jenkins → Manage Plugins

Tabs: Updates / Available / Installed / Advanced.

Steps to install plugin: Search on Available → check → Install without restart (or download & restart later).

Actionable: keep plugins up to date, but test before upgrading in production.

**D. Manage Nodes and Clouds (add agents)**

Path: Manage Jenkins → Manage Nodes and Clouds

Add Node: New Node → give name → choose Permanent Agent → configure:

Remote root directory, labels, number of executors, usage (exclusive/any), launch method (SSH or JNLP).

Save → click node → Launch agent or test connection.

For cloud agents (Kubernetes/EC2) configure cloud plugin in same page.

**E. Credentials**

Path: Credentials (left nav) → System → Global

Steps: Add Credentials → choose kind (Username/Password, Secret text, SSH Username with private key) → give ID & description → Save.

Actionable: reference credentials by credentialsId in Jenkinsfile.

**F. Security (Configure Global Security)**

Path: Manage Jenkins → Configure Global Security

Steps: choose security realm (Jenkins, LDAP, SSO), set authorization strategy (Matrix-based recommended for fine control).

Actionable: remove anonymous admin rights; create roles and restrict admin & script console.

**G. System Log & Script Console**

System Log: view runtime logs.

Script Console: Manage Jenkins → Script Console — execute Groovy on server (dangerous). Only admins should have access.

**H. Reload / Restart / Quiet Down**

Reload from Disk: reload config.xml changes.

Safe Restart / Quiet Down: stop new builds and allow running builds to finish (useful for maintenance).

**I. Manage Users**

Path: Manage Jenkins → Manage Users (or use security realm). Add/edit user accounts and their details.

J. Backup & Logs

Install backup plugin (ThinBackup or use system backup). Export job configs in JENKINS_HOME. Regularly back up JENKINS_HOME.
