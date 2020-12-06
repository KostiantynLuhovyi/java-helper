package com.lugowoy.helper.execution;

/**
 * The interface declares a contract to output the result execution any task.
 * <p>
 * Created by Konstantin Lugowoy on 12.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 2.0
 * @since 1.7.8
 */
//TODO review documentation
public interface OutputExecutionResult {

    /**
     * Outputs the result of the execution, formalizing its appearance as a
     * default string.
     *
     * @param <T> the type of the result of the execution.
     * @param resultValue the result to output.
     */
    <T> void output(T resultValue);

    /**
     * Outputs the result values of the execution, formalizing its appearance as
     * a {@code patternResult} string.
     *
     * @param <T> the type of the result values of the execution.
     * @param patternResult the pattern appearance of the result.
     * @param resultValues the result values to output.
     */
    @SuppressWarnings("unchecked")
    //Possible heap pollution from parameterized vararg type
    <T> void output(String patternResult, T... resultValues);

}
