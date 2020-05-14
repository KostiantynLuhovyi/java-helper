package com.lugowoy.helper.execution;

import java.util.concurrent.TimeUnit;

/**
 * Created by Konstantin Lugowoy on 06.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 2.7
 */
//todo write doc's
public final class OutputExecutionTimeToConsole {

    private static final String TIME_HOURS_AND_THEN =
            "\nRuntime: %d hours, %d minutes, %d seconds, %d milliseconds \n";
    private static final String TIME_MINUTES_AND_THEN =
            "\nRuntime: %d minutes, %d seconds, %d milliseconds \n";
    private static final String TIME_SECONDS_AND_THEN =
            "\nRuntime: %d seconds, %d milliseconds \n";
    private static final String TIME_MILLISECONDS =
            "\nRuntime: %d milliseconds \n";

    public static void outputExecutionTime(final long timeInMilliseconds) {
        long hours = calculateToHours(timeInMilliseconds);
        long minutes = calculateToMinutes(timeInMilliseconds);
        long seconds = calculateToSeconds(timeInMilliseconds);
        long milliseconds = calculateRemainingMilliseconds(timeInMilliseconds,
                                                           hours, minutes,
                                                           seconds);
        showExecutionTime(hours, minutes, seconds, milliseconds);
    }

    private static void showExecutionTime(final long hours, final long minutes,
                                          final long seconds,
                                          final long milliseconds) {
        if (hours >= 1) {
            System.out.printf(TIME_HOURS_AND_THEN, hours, minutes, seconds,
                              milliseconds);
        } else if (minutes >= 1) {
            System.out.printf(TIME_MINUTES_AND_THEN, minutes, seconds,
                              milliseconds);
        } else if (seconds >= 1) {
            System.out.printf(TIME_SECONDS_AND_THEN, seconds, milliseconds);
        } else {
            System.out.printf(TIME_MILLISECONDS, milliseconds);
        }
    }

    //TODO: Get rid of magic numbers

    private static long calculateToHours(final long timeInMilliseconds) {
        return ((timeInMilliseconds / (1000 * 60 * 60)) % 24);
    }

    private static long calculateToMinutes(final long timeInMilliseconds) {
        return ((timeInMilliseconds / (1000 * 60)) % 60);
    }

    private static long calculateToSeconds(final long timeInMilliseconds) {
        return (timeInMilliseconds / 1000) % 60;
    }

    private static long calculateRemainingMilliseconds(long milliseconds,
                                                       long hours, long minutes,
                                                       long seconds) {
        milliseconds -= TimeUnit.HOURS.toMillis(hours) + TimeUnit.MINUTES
                .toMillis(minutes) + TimeUnit.SECONDS.toMillis(seconds);
        return milliseconds;
    }

}
