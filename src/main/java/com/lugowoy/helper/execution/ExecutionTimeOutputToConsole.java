package com.lugowoy.helper.execution;

import java.util.concurrent.TimeUnit;

/**
 * Created by Konstantin Lugowoy on 06.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 2.7
 */
//todo write doc's
public final class ExecutionTimeOutputToConsole {

    private static final String TIME_HOURS_AND_THEN = "\nRuntime: %d hours, %d minutes, %d seconds, %d milliseconds \n";
    private static final String TIME_MINUTES_AND_THEN = "\nRuntime: %d minutes, %d seconds, %d milliseconds \n";
    private static final String TIME_SECONDS_AND_THEN = "\nRuntime: %d seconds, %d milliseconds \n";
    private static final String TIME_MILLISECONDS = "\nRuntime: %d milliseconds \n";

    private ExecutionTimeOutputToConsole() {
    }

    public static void outputExecutionTime(long milliseconds) {
        long hours = calculateMillisecondsToHours(milliseconds);
        long minutes = calculateMillisecondsToMinutes(milliseconds);
        long seconds = calculateMillisecondsToSeconds(milliseconds);
        long remainingMilliseconds = calculateRemainingMilliseconds(milliseconds, hours, minutes, seconds);
        determineOutputOfExecutionTime(hours, minutes, seconds, remainingMilliseconds);
    }

    private static void determineOutputOfExecutionTime(long hours, long minutes, long seconds, long remainingMilliseconds) {
        if (hours >= 1) {
            System.out.printf(TIME_HOURS_AND_THEN, hours, minutes, seconds, remainingMilliseconds);
        } else if (minutes >= 1) {
            System.out.printf(TIME_MINUTES_AND_THEN, minutes, seconds, remainingMilliseconds);
        } else if (seconds >= 1) {
            System.out.printf(TIME_SECONDS_AND_THEN, seconds, remainingMilliseconds);
        } else {
            System.out.printf(TIME_MILLISECONDS, remainingMilliseconds);
        }
    }

    private static long calculateMillisecondsToHours(long milliseconds) {
        return ((milliseconds / (1000 * 60 * 60)) % 24);
    }

    private static long calculateMillisecondsToMinutes(long milliseconds) {
        return ((milliseconds / (1000 * 60)) % 60);
    }

    private static long calculateMillisecondsToSeconds(long milliseconds) {
        return (milliseconds / 1000) % 60;
    }

    private static long calculateRemainingMilliseconds(long milliseconds, long hours, long minutes, long seconds) {
        milliseconds -= TimeUnit.HOURS.toMillis(hours) + TimeUnit.MINUTES.toMillis(minutes) + TimeUnit.SECONDS.toMillis(seconds);
        return milliseconds;
    }

}
