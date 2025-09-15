1️⃣ Install Docker & Docker Compose (if not already)
sudo apt update
sudo apt install -y docker.io docker-compose
sudo systemctl enable --now docker
sudo usermod -aG docker $USER   # so you can run docker without sudo
newgrp docker                   # re-login or run this to activate group

2️⃣ Run SonarQube Community Edition (embedded DB) with Docker

The official image already bundles the embedded database for testing / evaluation:

docker run -d --name sonarqube \
  -p 9000:9000 \
  sonarqube:community


It’ll download the image from Docker Hub (sonarqube:community)..

Exposes web UI on http://your-server-ip:9000
.

Default credentials: admin / admin.