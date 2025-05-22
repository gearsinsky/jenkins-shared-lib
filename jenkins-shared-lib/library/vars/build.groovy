def call() {
    echo "Building image: ${env.PROJECT_NAME}"
    sh """
        docker build --platform linux/amd64 -t ${env.PROJECT_NAME}:${BUILD_NUMBER} .
    """
    echo "image ready to use"
    sh 'docker images'
}

