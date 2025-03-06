pipeline {
    agent any

    environment {
        IMAGE_NAME = "nick1309/fashionMap:latest"
    }

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio; ajusta la URL y la rama según corresponda
                git branch: 'master', url: 'https://github.com/nick130920/fashion-map-back.git'
            }
        }
        stage('Build') {
            steps {
                // Compila la aplicación con Maven (asegúrate de que Maven esté configurado en Jenkins)
                sh 'mvn clean package'
            }
        }
        stage('Docker Compose Build and Deploy') {
            steps {
                // Baja cualquier contenedor anterior (opcional)
                sh 'docker-compose down || true'
                // Construye la imagen de la aplicación (la sección "build" en el docker-compose.yml se usará)
                sh 'docker-compose build'
                sh 'docker-compose up -d'
            }
        }
    }
}
