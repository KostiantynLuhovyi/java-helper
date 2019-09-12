package com.lugowoy.helper.other.execution;

/**
 * Created by LugowoyKonstantin on 11.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.1
 * @since 1.7.6
 */
//todo add doc's
@FunctionalInterface
public interface OutputExecutorTime {

    String MSG_MINUTES_AND_SECONDS = "\nRuntime : %d minutes, %d seconds\n";
    String MSG_MILLISECONDS = "\nRuntime : %d milliseconds\n";

    void outputTimer(long milliseconds, String msg);

    static void outputExecutionTimeMillisOnConsole(long milliseconds, String msg) {
        System.out.printf(msg, milliseconds);
    }

    static void outputExecutionTimeOnConsole(long milliseconds, String msg) {
        if (milliseconds >= 1000) {
            long minutes = (milliseconds / 1000) / 60;
            long seconds = (milliseconds / 1000);
            System.out.printf(msg, minutes, seconds);
        } else {
            System.out.printf(MSG_MILLISECONDS, milliseconds);
        }
    }

}
