def call() {
    echo "Running Image lint"
    sh """
        docker run --rm \
        --add-host=docker-dind-daemon:172.18.0.3 \
        aquasec/trivy image --docker-host tcp://docker-dind-daemon:2375 ${env.PROJECT_NAME}:${BUILD_NUMBER}
    """
}

