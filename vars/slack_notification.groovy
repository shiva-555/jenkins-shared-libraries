def call(String status,
         String backendTag,
         String frontendTag,
         String buildUrl,
         String jobName,
         String buildNumber) {

    withCredentials([string(credentialsId: 'slack-webhook', variable: 'SLACK_URL')]) {

        def emoji = status == "SUCCESS" ? "✅" : "❌"

        sh """
        curl -X POST -H 'Content-type: application/json' \
        --data '{
          "text":"${emoji} *CI/CD PIPELINE ${status}*\\n\
Job: ${jobName}\\n\
Build Number: #${buildNumber}\\n\
Backend Image: backend:${backendTag}\\n\
Frontend Image: frontendeks:${frontendTag}\\n\
Build URL: ${buildUrl}"
        }' \$SLACK_URL
        """
    }
}
