Goal: create a pipeline file in repo and run it in Jenkins.

Declarative Language: simpler, structured, easier to read/validate. Use this unless you need complex Groovy logic.

Create Jenkinsfile at repo root

Filename must be Jenkinsfile (capital J, no extension). Commit to the branch Jenkins will build.

Minimal declarative skeleton

pipeline {
  agent any
  stages {
    stage('Checkout') { steps { checkout scm } }
    stage('Build')    { steps { sh 'echo build' } }
    stage('Test')     { steps { sh 'echo test' } }
  }
  post { success { echo 'done' } failure { echo 'failed' } }
}


Define the agent

agent any → run on any available node.

agent { label 'linux && docker' } → run on node with label.

agent { docker { image 'node:18' } } → run whole pipeline in Docker container.

Add stages for logical steps

Checkout, Install, Build, Test, Package, Publish / Deploy. Keep stages atomic and repeatable.

Use steps to run commands

Shell commands: sh 'npm install' (Linux agents) or bat for Windows agents.

Handle credentials securely

withCredentials([usernamePassword(credentialsId: 'docker-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
  sh 'docker login -u $USER -p $PASS'
}


Archive artifacts & publish reports

archiveArtifacts artifacts: 'build/*.zip', allowEmptyArchive: true

junit 'reports/*.xml' to publish unit test results.

Add post section for notifications

post {
  success { mail to: 'you@company', subject: 'Build success', body: '...' }
  failure { slackSend channel:'#ci', message: "Build failed" }
}


Use parameters for manual/controlled runs

parameters {
  string(name:'VERSION', defaultValue: '1.0', description: 'Release version')
}


Parallel & matrix builds

stage('Tests') {
  parallel {
    unit { steps { sh 'npm test' } }
    lint { steps { sh 'npm run lint' } }
  }
}


Shared libraries & reusable steps

Move common logic to a Shared Library and call myLib.doBuild() to keep Jenkinsfiles small.

Multibranch & PR builds

Use Multibranch Pipeline job — Jenkins discovers branches and PRs and uses each branch’s Jenkinsfile.

Validate and lint

Use Jenkins Declarative Linter (Jenkins → Pipeline Syntax / Blue Ocean) or VS Code Jenkins extension to catch syntax errors before pushing.

Commit → create Pipeline job → run

Commit Jenkinsfile → In Jenkins create pipeline (or Multibranch pipeline) pointing to repo → trigger build / push webhook.

Debugging tips

Read Console Output for each stage.

If sh commands fail locally but succeed in CI, check PATH, user permissions, and agent tooling.

Use echo and env to inspect environment variables.

For parse errors, check Groovy syntax and indentation in Jenkinsfile.