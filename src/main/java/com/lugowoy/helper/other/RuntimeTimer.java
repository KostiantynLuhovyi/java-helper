package com.lugowoy.helper.other;

/**
 * Created by LugowoyKonstantin on 03.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.1
 * @since 1.7.4
 */
//todo add doc's (class, methods)
public class RuntimeTimer {

    private long start;
    private long end;

    public static long startMillis() {
        return System.currentTimeMillis();
    }

    public void setStart(long startMillis) {
        this.start = startMillis;
    }

    public static long endMillis() {
        return System.currentTimeMillis();
    }

    public void setEnd(long endMillis) {
        this.end = endMillis;
    }

    public void timeMillisToConsole() {
        System.out.printf("Start time : %d millis", this.start);
        System.out.printf("End time : %d millis", this.end);
        System.out.printf("Result time : %d millis", this.end - this.start);
    }

}
