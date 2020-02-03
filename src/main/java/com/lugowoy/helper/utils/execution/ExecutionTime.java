package com.lugowoy.helper.utils.execution;

/**
 * Created by Konstantin Lugowoy on 13.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 1.7.8
 */
//todo write doc's
class ExecutionTime {

    private long startMillis;
    private long endMillis;

    void startExecutionTime() {
        this.startMillis = System.currentTimeMillis();
    }

    void endExecutionTime() {
        this.endMillis = System.currentTimeMillis();
    }

    long executionTime() {
        return this.endMillis - this.startMillis;
    }

}
