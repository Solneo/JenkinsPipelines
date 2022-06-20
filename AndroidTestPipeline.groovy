node {
    stage("Checkout") {
        println("Checkout on dev")
        git url: "https://github.com/Solneo/Custom_View.git",
                    branch: 'master'

    }

    stage("Build") {
        cd '${JENKINS_HOME}/AndroidTest'
        if (params.BUILD_CONFIG == 'release') {
            sh './gradlew clean assembleRelease'
        } else {
            sh './gradlew clean assembleDebug'
        }
    }
}