./gradlew build && docker-compose up -d
k3d cluster create meucluster --servers 3 --agents 3 -p "30000:30000@loadbalancer"
