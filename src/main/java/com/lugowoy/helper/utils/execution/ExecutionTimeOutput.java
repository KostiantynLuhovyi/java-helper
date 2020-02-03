package com.lugowoy.helper.utils.execution;

/**
 * Created by Konstantin Lugowoy on 11.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.5
 * @since 1.7.6
 */
//todo write doc's
@FunctionalInterface
public interface ExecutionTimeOutput {

    String MSG_MINUTES_AND_SECONDS = "\nRuntime : %d minutes, %d seconds\n";
    String MSG_MILLISECONDS = "\nRuntime : %d milliseconds\n";

    void outputTimer(long milliseconds, String msg);

    static void outputExecutionTimeMillisToConsole(long milliseconds, String msgOutputTime) {
        System.out.printf(msgOutputTime, milliseconds);
    }

    static void outputExecutionTimeToConsole(long milliseconds, String msgOutputTime) {
        if (milliseconds >= 1000) {
            long minutes = (milliseconds / 1000) / 60;
            long seconds = (milliseconds / 1000);
            System.out.printf(msgOutputTime, minutes, seconds);
        } else {
            System.out.printf(MSG_MILLISECONDS, milliseconds);
        }
    }

}
