package com.lugowoy.helper.other.execution;

/**
 * Created by LugowoyKonstantin on 13.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.7.8
 */

//todo refactoring code
//todo edit doc's

class ExecutionTimer {

    private static final ExecutionTimer EXECUTION_TIMER = new ExecutionTimer();

    private long startMillis;

    void startExecutionTimer() {
        this.startMillis = System.currentTimeMillis();
    }

    long endExecutionTimer() {
        long endMillis = System.currentTimeMillis();
        return endMillis - this.startMillis;
    }

    static ExecutionTimer getExecutionTimer() {
        return EXECUTION_TIMER;
    }

}
