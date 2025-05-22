def call(String msg) {
    withCredentials([
        string(credentialsId: 'TOKEN', variable: 'TOKEN'),
        string(credentialsId: 'CHAT_ID', variable: 'CHAT_ID')
    ]) {
        sh """
            curl -s -X POST https://api.telegram.org/bot${TOKEN}/sendMessage \\
            -d chat_id=${CHAT_ID} \\
            -d text="${msg}"
        """
    }
}

