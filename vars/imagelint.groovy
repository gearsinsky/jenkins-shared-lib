def call() {
    echo "Running Image lint"
    sh """
        docker run --rm \
        aquasec/trivy image --docker-host tcp://docker-dind-daemon:2375 ${env.PROJECT_NAME}:${BUILD_NUMBER}
    """
}

