node {
    stage("Checkout") {
        println("Checkout on dev")
        git url: "https://github.com/Solneo/Custom_View.git",
                    branch: 'master'

    }

    stage("Build") {
        if (params.BUILD_CONFIG == 'release') {
            sh './AndroidTest/gradlew clean assembleRelease'
        } else {
            sh './AndroidTest/gradlew clean assembleDebug'
        }
    }
}