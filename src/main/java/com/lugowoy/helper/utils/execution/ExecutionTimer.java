package com.lugowoy.helper.utils.execution;

/**
 * Created by Konstantin Lugowoy on 13.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.7.8
 */
//todo write doc's
class ExecutionTimer {

    private long startMillis;
    private long endMillis;

    void startExecutionTimer() {
        this.startMillis = System.currentTimeMillis();
    }

    long endExecutionTimer() {
        this.endMillis = System.currentTimeMillis();
        return endMillis - this.startMillis;
    }

}
