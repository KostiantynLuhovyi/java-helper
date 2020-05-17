package com.lugowoy.helper.execution;

import com.lugowoy.helper.checkers.CheckerNumber;

import java.util.concurrent.TimeUnit;

/**
 * The class provides an implementation of the output of the execution time on
 * the console, thereby implementing the contract declares in the interface
 * {@link OutputExecutionTime}.
 * <p>
 * Created by Konstantin Lugowoy on 06.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 2.7
 */
public final class OutputExecutionTimeToConsole implements OutputExecutionTime {

    private static final String TIME_HOURS_AND_THEN =
            "\nRuntime: %d hours, %d minutes, %d seconds, %d milliseconds \n";
    private static final String TIME_MINUTES_AND_THEN =
            "\nRuntime: %d minutes, %d seconds, %d milliseconds \n";
    private static final String TIME_SECONDS_AND_THEN =
            "\nRuntime: %d seconds, %d milliseconds \n";
    private static final String TIME_MILLISECONDS =
            "\nRuntime: %d milliseconds \n";

    private boolean isOnlyMilliseconds = true;

    /**
     * Constructs an object of this class.<br>The attribute characterizing the
     * formatting appearance of the execution time has {@code true} value, mean
     * the time of the execution will in the format - only milliseconds. This
     * field can changed by calling the corresponding setter of this attribute.
     */
    public OutputExecutionTimeToConsole() {
    }

    /**
     * Constructs an object of this class by initializing its attribute to
     * select a formatting option for the appearance of the execution time.<br>
     * The formatting of the appearance of the runtime depends on several
     * factors. The {@code isOnlyMilliseconds} argument in the object of this
     * class {@code false}, then the time of the execution outputs only in
     * milliseconds. If this attribute {@code true}, then the time in
     * milliseconds calculated in hours, seconds, milliseconds and output.
     *
     * @param isOnlyMilliseconds the value that determines of the formatting
     * appearance of the execution time.
     */
    public OutputExecutionTimeToConsole(final boolean isOnlyMilliseconds) {
        this.isOnlyMilliseconds = isOnlyMilliseconds;
    }

    /**
     * Outputs the time {@code milliseconds} of execution.<br>The appearance for
     * outputting the time value implemented in a class that implements an
     * interface contract.<br>The output to the console using by calling the
     * {@link java.io.PrintStream#printf(String, Object...)} method. The
     * formatting of the appearance of the time of the execution depends on
     * several factors. The encapsulated field in the object of this class
     * {@code false}, then the time output only in milliseconds. If this
     * attribute {@code true}, then the time in milliseconds passed by the
     * argument {@code milliseconds} calculated in hours, seconds, milliseconds
     * and outputs.
     *
     * @param milliseconds the time to output.
     *
     * @throws IllegalArgumentException if the {@code milliseconds} argument
     * value is negative.
     */
    @Override
    public void output(final long milliseconds) {
        if (CheckerNumber.isPositive(milliseconds) || CheckerNumber.isZero(
                milliseconds)) {
            if (this.isOnlyMilliseconds()) {
                System.out.printf(TIME_MILLISECONDS, milliseconds);
            } else {
                long hours = this.calculateHours(milliseconds);
                long minutes = this.calculateMinutes(milliseconds);
                long seconds = this.calculateSeconds(milliseconds);
                long remainingMillis = this.calculateRemainingMilliseconds(
                                        milliseconds, hours, minutes, seconds);
                this.showExecutionTime(hours, minutes, seconds, remainingMillis);
            }
        } else {
            throw new IllegalArgumentException(
                            "Negative value of the argument in milliseconds");
        }
    }

    /**
     * Gets the value of the attribute that determines the formatting appearance
     * of the execution time.
     *
     * @return the value that determines of the frmatting appearance of the
     * execution time.
     */
    public boolean isOnlyMilliseconds() {
        return isOnlyMilliseconds;
    }

    /**
     * Sets the value of the attribute that determines the appearance of the
     * execution time. A value of true indicates that the execution time will
     * output in milliseconds, and a value of false indicates a more detailed
     * appearance of the execution time.
     *
     * @param isOnlyMilliseconds the value that determines of the formatting
     * appearance of the execution time.
     */
    public void setOnlyMilliseconds(final boolean isOnlyMilliseconds) {
        this.isOnlyMilliseconds = isOnlyMilliseconds;
    }

    //TODO: Get rid of magic numbers.

    private long calculateHours(final long milliseconds) {
        return ((milliseconds / (1000 * 60 * 60)) % 24);
    }

    private long calculateMinutes(final long milliseconds) {
        return ((milliseconds / (1000 * 60)) % 60);
    }

    private long calculateSeconds(final long milliseconds) {
        return (milliseconds / 1000) % 60;
    }

    private long calculateRemainingMilliseconds(final long milliseconds,
                                                final long hours,
                                                final long minutes,
                                                final long seconds) {
        return milliseconds - (TimeUnit.HOURS.toMillis(hours)
                                    + TimeUnit.MINUTES.toMillis(minutes)
                                        + TimeUnit.SECONDS.toMillis(seconds));
    }

    private void showExecutionTime(final long hours, final long minutes,
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

}
