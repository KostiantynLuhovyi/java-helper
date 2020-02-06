package com.lugowoy.helper.utils.execution;

/**
 * Created by Konstantin Lugowoy on 13.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.7.8
 */
//todo write doc's
class ExecutionTime {

    private long startMillis;
    private long endMillis;

    void startExecutionTime() {
        this.startMillis = System.currentTimeMillis();
    }

    void startExecutionTime(long milliseconds) {
        if (milliseconds >= 0) {
            this.startMillis = milliseconds;
        } else {
            throw new IllegalArgumentException("Negative value of the argument in milliseconds.");
        }
    }

    void endExecutionTime() {
        this.endMillis = System.currentTimeMillis();
    }

    void endExecutionTime(long milliseconds) {
        if (milliseconds >= 0) {
            this.endMillis = milliseconds;
        } else {
            throw new IllegalArgumentException("Negative value of the argument in milliseconds.");
        }
    }

    long executionTime() {
        return this.endMillis - this.startMillis;
    }

}
