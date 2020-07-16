package com.lugowoy.helper.execution;

/**
 * The class provides an implementation of the output of the execution result to
 * the console, thereby implementing the contract declared in the interface
 * {@link OutputExecutionResult}
 * <p>
 * Created by Konstantin Lugowoy on 06.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.4
 * @see com.lugowoy.helper.execution.OutputExecutionResult
 * @since 2.7
 */
public class OutputExecutionResultToConsole implements OutputExecutionResult {

    /**
     * The string of the formatting appearance of the output if the result of
     * execution a string.
     */
    public static final String PATTERN_RESULT_STRING = "Result : %s";

    /**
     * The string of the formatting appearance of the output if the result of
     * execution an integer.
     */
    public static final String PATTERN_RESULT_INTEGER = "Result : %d";

    /**
     * The string of the formatting appearance of the output if the result of
     * execution a double.
     */
    public static final String PATTERN_RESULT_DOUBLE = "Result : %f";

    /**
     * The string of the formatting appearance of the output if the result of
     * execution a boolean.
     */
    public static final String PATTERN_RESULT_BOOLEAN = "Result : %b";

    /**
     * Constructs an object of this class.
     */
    public OutputExecutionResultToConsole() {
    }

    /**
     * Outputs the result {@code tResult} of execution, formatting its
     * appearance as a default string.
     *
     * @param tResult the result to output.
     */
    @Override
    public <T> void output(final T resultValue) {
        System.out.printf(PATTERN_RESULT_STRING, resultValue);
    }

    /**
     * Outputs the result {@code tResult} of execution, formatting its
     * appearance as a {@code msgOutputResult} string.
     *
     * @param msgOutputResult the string for the formatting appearance of the
     * result.
     * @param tResult the result to output.
     */
    @SuppressWarnings("unchecked")
    //Possible heap pollution from parameterized vararg type
    @Override
    public <T> void output(final String patternResult,
                           final T... resultValues) {
        System.out.printf(patternResult, resultValues);
    }

}
