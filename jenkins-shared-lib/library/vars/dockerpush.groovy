def call() {
    echo "Pushing image to DockerHub"
    echo "Deploying tag ${env.GIT_TAG_NAME}"

    withCredentials([usernamePassword(credentialsId: 'docker-repo', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASWD')]) {
        sh """
            echo "$DOCKER_PASWD" | docker login -u "$DOCKER_USER" --password-stdin
            docker tag ${PROJECT_NAME}:${BUILD_NUMBER} ${DOCKER_REPO}:${BUILD_NUMBER}
            docker tag ${PROJECT_NAME}:${BUILD_NUMBER} ${DOCKER_REPO}:latest
            docker push ${DOCKER_REPO}:${BUILD_NUMBER}
            docker push ${DOCKER_REPO}:latest
        """
    }
}

