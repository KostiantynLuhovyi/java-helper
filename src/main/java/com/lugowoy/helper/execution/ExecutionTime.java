package com.lugowoy.helper.execution;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Konstantin Lugowoy on 13.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 1.7.8
 */
//todo write doc's
public class ExecutionTime {

    private long startMillis;
    private long endMillis;

    public void setStartTime() {
        this.startMillis = System.currentTimeMillis();
    }

    public void setStartTime(final long milliseconds) {
        if (milliseconds >= 0) {
            this.startMillis = milliseconds;
        } else {
            throw new IllegalArgumentException(
                    "Negative value of the argument in milliseconds.");
        }
    }

    public void setEndTime() {
        this.endMillis = System.currentTimeMillis();
    }

    public void setEndTime(final long milliseconds) {
        if (milliseconds >= 0) {
            this.endMillis = milliseconds;
        } else {
            throw new IllegalArgumentException(
                    "Negative value of the argument in milliseconds.");
        }
    }

    public long calculateExecutionTime() {
        return BigDecimal.valueOf(this.startMillis).subtract(
                BigDecimal.valueOf(this.endMillis), MathContext.DECIMAL64)
                         .longValue();
    }

}
