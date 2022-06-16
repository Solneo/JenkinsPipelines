node {
    stage("Checkout") {
        println("Checkout on dev")
        deleteDir()
        dir("repo-one-feature") {
            git url: "https://github.com/Solneo/Custom_View.git",
                    branch: 'master'
        }
    }

    stage("Build") {
        if (params.BUILD_CONFIG == 'release') {
            bat './gradlew clean assembleRelease'
        } else {
            bat './gradlew clean assembleDebug'
        }
    }
}