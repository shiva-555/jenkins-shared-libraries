def call(String sonarName, String projectKey, String projectName) {

    def scannerHome = tool 'Sonar'

    withSonarQubeEnv(sonarName) {
        sh """
            ${scannerHome}/bin/sonar-scanner \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.projectName=${projectName} \
            -Dsonar.sources=. \
            -Dsonar.sourceEncoding=UTF-8
        """
    }
}
