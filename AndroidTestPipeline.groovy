def stageIf(String name, Closure body) {
    if (params.firstStage <= name && params.lastStage >= name) {
        stage(name, body)
    } else {
        stage(name) {
            echo "Stage skipped: $name"
        }
    }
}

node {
    properties([
            parameters([
                    choiceParam(
                            name: 'firstStage',
                            choices: '1.Build\n' +
                                    '2.Docker\n' +
                                    '3.Deploy',
                            description: 'First stage to start',
                            defaultValue: '1.Build',
                    ),
                    choiceParam(
                            name: 'lastStage',
                            choices: '3.Deploy\n' +
                                    '2.Docker\n' +
                                    '1.Build',
                            description: 'Last stage to start',
                            defaultValue: '3.Deploy',
                    ),
            ])
    ])

    stageIf('1.Build') {
        // ...
    }
    stageIf('3.Deploy') {
        // ...
    }
}