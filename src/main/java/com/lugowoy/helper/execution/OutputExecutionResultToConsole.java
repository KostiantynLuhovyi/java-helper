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
//TODO review documentation
public class OutputExecutionResultToConsole implements OutputExecutionResult {

    /**
     * The pattern appearance of the output if the result of execution a
     * string.
     */
    public static final String PATTERN_RESULT_STRING = "Result : %s";

    /**
     * The pattern appearance of the output if the result of execution an
     * integer.
     */
    public static final String PATTERN_RESULT_INTEGER = "Result : %d";

    /**
     * The pattern appearance of the output if the result of execution a
     * double.
     */
    public static final String PATTERN_RESULT_DOUBLE = "Result : %f";

    /**
     * The pattern appearance of the output if the result of execution a
     * boolean.
     */
    public static final String PATTERN_RESULT_BOOLEAN = "Result : %b";

    /**
     * The pattern appearance of the output if the result of execution a matrix.
     */
    public static final String RESULT_MATRIX = "Result matrix : \n%s";

    /**
     * The pattern appearance of the output if the result of execution a array.
     */
    public static final String RESULT_ARRAY = "Result array : \n%s";

    /**
     * The pattern appearance of the output if the result of execution a sequence.
     */
    public static final String RESULT_SEQUENCE = "Result sequence : \n%s";

    /**
     * Constructs an object of this class.
     */
    public OutputExecutionResultToConsole() {
    }

    /**
     * Outputs the result {@code resultValue} of the execution, formatting its
     * appearance as a default string. The output uses the {@link
     * OutputExecutionResultToConsole#PATTERN_RESULT_STRING} appearance
     * pattern.
     *
     * @param <T> the type of the result of the execution.
     * @param resultValue the result to output.
     */
    @Override
    public <T> void output(final T resultValue) {
        System.out.printf(PATTERN_RESULT_STRING, resultValue);
    }

    /**
     * Outputs the result values of execution, formatting its appearance as a
     * {@code patternResult} string.
     *
     * @param <T> the type of the result values of the execution.
     * @param patternResult the pattern appearance of the result.
     * @param resultValues the result values to output.
     */
    @SuppressWarnings("unchecked")
    //Possible heap pollution from parameterized vararg type
    @Override
    public <T> void output(final String patternResult,
                           final T... resultValues) {
        System.out.printf(patternResult, resultValues);
    }

}
