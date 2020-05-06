package com.lugowoy.helper.execution;

/**
 * Created by Konstantin Lugowoy on 13.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @since 1.7.8
 */
//todo write doc's
public class ExecutionTime {

    private long startMillis;
    private long endMillis;

    public void startExecutionTime() {
        this.startMillis = System.currentTimeMillis();
    }

    public void startExecutionTime(long milliseconds) {
        if (milliseconds >= 0) {
            this.startMillis = milliseconds;
        } else {
            throw new IllegalArgumentException("Negative value of the argument in milliseconds.");
        }
    }

    public void endExecutionTime() {
        this.endMillis = System.currentTimeMillis();
    }

    public void endExecutionTime(long milliseconds) {
        if (milliseconds >= 0) {
            this.endMillis = milliseconds;
        } else {
            throw new IllegalArgumentException("Negative value of the argument in milliseconds.");
        }
    }

    public long executionTime() {
        return Math.subtractExact(this.startMillis, this.endMillis);
    }

}
