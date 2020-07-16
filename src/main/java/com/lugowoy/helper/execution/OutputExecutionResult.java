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
public interface OutputExecutionResult {

    /**
     * Outputs the result of the execution, formalizing its appearance as
     * a default string.
     *
     * @param <T> the type of the result.
     * @param tResult the result to output.
     */
    <T> void output(T resultValue);

    /**
     * Outputs the result of the execution, formalizing its appearance as
     * a {@code msgOutputResult} string.
     *
     * @param <T> the type of the result.
     * @param msgOutputResult the string for the appearance of the result.
     * @param tResult the result to output.
     */
    <T> void output(String patternResult, T... resultValues);

}
