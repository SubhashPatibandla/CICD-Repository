🏗️ Jenkins Architecture – Notes
📌 What is Jenkins?

Jenkins is an open-source automation server widely used for Continuous Integration (CI) and Continuous Delivery/Deployment (CD).
It automates building, testing, and deploying applications, reducing manual effort and increasing reliability.

⚙️ Jenkins Architecture Overview

Jenkins follows a master-agent (controller-agent) architecture.

🔹 1. Jenkins Master (Controller)

The brain of Jenkins.

Responsibilities:

Provides the web UI for users.

Stores pipeline configurations (Jenkinsfiles, jobs, plugins).

Distributes tasks to agents.

Monitors agents and job execution status.

Runs the Scheduler, Build Queue, and Plugin Manager.

🔹 2. Jenkins Agent (Worker/Slave Node)

Executes the actual tasks (build, test, deploy).

Can run on the same machine as master or on different servers.

Connected to the master via:

SSH

JNLP (Java Web Start)

Kubernetes/Docker agents

Benefits:

Distributes workload across multiple nodes.

Runs builds in parallel.

Supports different environments (Linux, Windows, Docker).

🔹 3. Communication

Master → Agent:

Sends instructions (e.g., “run this pipeline stage”).

Agent → Master:

Sends job results, logs, test reports.

🔹 4. Plugins

Jenkins is plugin-driven.

Plugins extend capabilities:

Git, Maven, Docker, Kubernetes, Slack, SonarQube, etc.

🖼️ High-Level Flow

Developer pushes code → GitHub/GitLab.

Jenkins Master triggers a job (via webhook or polling).

Master assigns the job to an Agent.

Agent runs:

Build (Maven/Gradle/npm).

Test (JUnit, Selenium, etc.).

Package/Deploy.

Results sent back to Master → displayed in Jenkins Dashboard.

📊 Jenkins Architecture Diagram (Text Version)
          +----------------------+
          |   Jenkins Master     |
          |----------------------|
          | - Web UI             |
          | - Job Scheduler      |
          | - Build Queue        |
          | - Plugin Manager     |
          +----------+-----------+
                     |
     -----------------------------------
     |               |                 |
+-----------+   +-----------+    +-----------+
|  Agent 1  |   |  Agent 2  |    |  Agent 3  |
|-----------|   |-----------|    |-----------|
| Linux     |   | Windows   |    | Docker    |
| Build+Test|   | Deploy    |    | Kubernetes|
+-----------+   +-----------+    +-----------+

🚀 Key Benefits of Jenkins Architecture

Scalability – Add more agents to handle load.

Flexibility – Run builds on different OS/tools.

High Availability – Workload distributed across nodes.

Extensibility – 1800+ plugins available.