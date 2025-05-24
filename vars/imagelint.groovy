def call() {
    echo "Running Image lint"
    sh """
        export DOCKER_HOST=tcp://docker-dind-daemon:2375
        echo $DOCKER_HOST
        docker run --rm \
        --add-host=docker-dind-daemon:172.18.0.5 \
        aquasec/trivy image --docker-host tcp://docker-dind-daemon:2375 ${env.PROJECT_NAME}:${BUILD_NUMBER}
    """
}

