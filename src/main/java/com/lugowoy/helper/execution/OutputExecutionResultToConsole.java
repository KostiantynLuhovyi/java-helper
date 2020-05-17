package com.lugowoy.helper.execution;

/**
 * The class provides an implementation of the output of the execution result to
 * the console, thereby implementing the contract declared in the interface
 * {@link OutputExecutionResult}
 * <p>
 * Created by Konstantin Lugowoy on 06.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.execution.OutputExecutionResult
 * @since 2.7
 */
public class OutputExecutionResultToConsole implements OutputExecutionResult {

    /**
     * The string of the formatting appearance of the output if the result of
     * execution a string.
     */
    public static final String RESULT_STRING = "Result : %s";
    /**
     * The string of the formatting appearance of the output if the result of
     * execution an integer.
     */
    public static final String RESULT_INTEGER = "Result : %d";
    /**
     * The string of the formatting appearance of the output if the result of
     * execution a double.
     */
    public static final String RESULT_DOUBLE = "Result : %.3f";
    /**
     * The string of the formatting appearance of the output if the result of
     * execution a boolean.
     */
    public static final String RESULT_BOOLEAN = "Result : %b";

    private String msgOutputResult;

    /**
     * Constructs an object of this class.
     */
    public OutputExecutionResultToConsole() {
    }

    /**
     * Constructs an object of this class by initializing it with a string
     * {@code msgOutputResult} to formatting the appearance of the result.
     */
    public OutputExecutionResultToConsole(final String msgOutputResult) {
        this.msgOutputResult = msgOutputResult;
    }

    /**
     * Outputs the result {@code tResult} of execution, formatting its
     * appearance as a default string.
     *
     * @param tResult the result to output.
     */
    @Override
    public <T> void output(final T tResult) {
        System.out.printf(RESULT_STRING, tResult);
    }

    /**
     * Outputs the result {@code tResult} of execution, formatting its
     * appearance as a {@code msgOutputResult} string.
     *
     * @param msgOutputResult the string for the formatting appearance of the
     * result.
     * @param tResult the result to output.
     */
    @Override
    public <T> void output(final String msgOutputResult, final T tResult) {
        System.out.printf(msgOutputResult, tResult);
    }

    /**
     * Sets the string for the formatting appearance of the output result.
     *
     * @param msgOutputResult the string for the formatting appearance of the
     * output result.
     */
    public void setMsgOutputResult(final String msgOutputResult) {
        this.msgOutputResult = msgOutputResult;
    }

}
