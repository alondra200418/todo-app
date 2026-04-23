pipeline {
    agent any

    environment {
        // Define your Docker image name
        DOCKER_IMAGE = "alondra/todo-app"
        IMAGE_TAG = "${env.BUILD_ID}" // Uses Jenkins Build Number as the version
    }

    stages {
        stage('Checkout') {
            steps {
                // Ensure we are pulling the latest from your repo
                git branch: 'master', url: 'https://github.com/alondra200418/todo-app.git'
            }
        }

        stage('Build') {
            steps {
                // Compile the Java app and package the JAR
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                // Run your JUnit tests
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                echo "Building Docker Image: ${DOCKER_IMAGE}:${IMAGE_TAG}"
                // Build the image using your Dockerfile
                sh "docker build -t ${DOCKER_IMAGE}:${IMAGE_TAG} ."
                sh "docker tag ${DOCKER_IMAGE}:${IMAGE_TAG} ${DOCKER_IMAGE}:latest"
            }
        }

        stage('Kubernetes Deploy - Staging') {
            steps {
                echo "Deploying to Kubernetes Staging Namespace..."
                // Apply your K8s manifest
                // Note: Ensure your deployment.yaml is in a folder named 'k8s'
                sh "kubectl apply -f k8s/deployment.yaml"
            }
        }

        stage('Approval for Production') {
            steps {
                // This creates a button in Jenkins you must click to continue
                // Perfect for demonstrating "Controlled Deployment" in your video
                input message: 'Deploy to Production?', ok: 'Proceed'
            }
        }

        stage('Kubernetes Deploy - Production') {
            steps {
                echo "Scaling up for Production..."
                // Example of a dynamic command to scale up for 'Production'
                sh "kubectl scale deployment todo-production --replicas=5"
            }
        }
    }

    post {
        success {
            echo 'Final Project Pipeline: Success! Application is live on Kubernetes.'
        }
        failure {
            echo 'Pipeline failed. Check the logs for Test or Docker build errors.'
        }
        always {
            // Good practice: Clean up workspace to save space on your ASUS Vivobook
            cleanWs()
        }
    }
}