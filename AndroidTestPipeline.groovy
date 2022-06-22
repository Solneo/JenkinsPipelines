node {
    withDockerContainer(args: '-u root --privileged', image: "eb7a3488f1c0") {
        stage("Checkout") {
            println("Checkout on dev")
            git url: "https://github.com/Solneo/testAppForCi.git",
                    branch: 'master'

        }

        stage("Build") {
            sh 'chmod +x gradlew'
            if (params.BUILD_CONFIG == 'release') {
                sh './gradlew clean assembleRelease -d'
            } else {
                sh './gradlew clean assembleDebug -d'
            }
        }
    }
}