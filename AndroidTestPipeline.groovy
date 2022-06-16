node("android") {
    stage("Checkout") {
        checkout scm
    }

    stage("Build"){
        if (params.BUILD_CONFIG == 'release') {
            sh './gradlew clean assembleRelease'
        } else {
            sh './gradlew clean assembleDebug'
        }
    }
}