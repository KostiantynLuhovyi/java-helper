package com.lugowoy.helper.execution;

/**
 * Created by Konstantin Lugowoy on 12.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @since 1.7.8
 */
//todo write doc's
@FunctionalInterface
public interface ExecutionResultOutput {

    <T> void outputExecutionResult(T t, String outputResult);

}
