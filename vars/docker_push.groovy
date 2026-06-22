def call(String imageName, String imageTag, String region) {

    withCredentials([
        [$class: 'AmazonWebServicesCredentialsBinding',
         credentialsId: 'aws-cred']
    ]) {

        sh """
            aws ecr get-login-password --region ${region} | \
            docker login --username AWS --password-stdin ${imageName.split('/')[0]}

            docker push ${imageName}:${imageTag}
        """
    }
}
