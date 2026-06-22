def call(String sonarServerName, String projectKey, String projectName) {

    withSonarQubeEnv(sonarServerName) {

        sh """
            sonar-scanner \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.projectName=${projectName} \
            -Dsonar.sources=. \
            -Dsonar.sourceEncoding=UTF-8
        """
    }
}
