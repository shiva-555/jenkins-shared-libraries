def call(String scanPath='.') {

    dependencyCheck(
        odcInstallation: 'OWASP-Dependency-Check',
        additionalArguments: """
            --scan ${scanPath}
            --format ALL
            --prettyPrint
        """
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
