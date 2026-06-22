def call(String ProjectName, String ImageTag, String AwsAccountId, String AwsRegion) {

    sh """
        docker build -t ${AwsAccountId}.dkr.ecr.${AwsRegion}.amazonaws.com/${ProjectName}:${ImageTag} .
    """
}
