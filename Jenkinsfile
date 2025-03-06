pipeline {
    agent any

    environment {
        // Nombre de la imagen Docker que se creará
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
        stage('Docker Build') {
            steps {
                script {
                    // Construye la imagen Docker utilizando el Dockerfile ubicado en la raíz del repositorio
                    docker.build("${env.IMAGE_NAME}")
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Ejecuta el contenedor Docker; en este ejemplo se expone el puerto 8080
                    docker.image("${env.IMAGE_NAME}").run("-d -p 8080:8080")
                }
            }
        }
    }
}
