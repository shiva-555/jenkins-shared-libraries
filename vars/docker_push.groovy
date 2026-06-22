// vars/pushDockerImage.groovy

def call(String EcrRepoUri, String ImageTag, String AwsRegion) {

    sh """
        aws ecr get-login-password --region ${AwsRegion} | \
        docker login --username AWS --password-stdin ${EcrRepoUri.split('/')[0]}

        docker push ${EcrRepoUri}:${ImageTag}
    """
}
