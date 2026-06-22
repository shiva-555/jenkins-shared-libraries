def call() {

    timeout(time: 5, unit: 'MINUTES') {

        def qualityGate = waitForQualityGate()

        if (qualityGate.status != 'OK') {
            error "Pipeline aborted due to Quality Gate failure: ${qualityGate.status}"
        }

        echo "Quality Gate Passed: ${qualityGate.status}"
    }
}
