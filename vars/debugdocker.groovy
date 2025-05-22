def call() {
    sh '''
        echo $DOCKER_HOST
        echo "--- whoami ---"
        whoami
        echo "--- id ---"
        id
        echo "--- groups ---"
        groups
        echo "--- ps aux | grep $$ ---"
        ps aux | grep $$
        echo "--- docker.sock perms ---"
        ls -l /var/run/docker.sock
        echo "--- getent group docker ---"
        getent group docker
        echo "--- docker ps ---"
        docker ps
    '''
}

