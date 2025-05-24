def call(String projectname = 'python-project', String dockerRepo = 'owen0522/jenkins_dind') {
    echo "Pushing image to DockerHub"
    echo "Deploying tag: ${env.GIT_TAG_NAME ?: 'no-tag'}"

    withCredentials([usernamePassword(
        credentialsId: 'docker-repo',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASWD'
    )]) {
        sh """
            echo "\$DOCKER_PASWD" | docker login -u "\$DOCKER_USER" --password-stdin
            docker tag ${projectname}:${env.BUILD_NUMBER} ${dockerRepo}:${env.BUILD_NUMBER}
            docker tag ${projectname}:${env.BUILD_NUMBER} ${dockerRepo}:latest
            docker push ${dockerRepo}:${env.BUILD_NUMBER}
            docker push ${dockerRepo}:latest
        """
    }
}
