node {
    stage("Checkout") {
        println("Checkout on dev")
        git url: "https://github.com/Solneo/SpotyTimer.git",
                branch: 'master'

    }

    stage("Build") {
        if (params.BUILD_CONFIG == 'release') {
            sh './gradlew clean assembleRelease'
        } else {
            sh './gradlew clean assembleDebug'
        }
    }
}