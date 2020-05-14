package com.lugowoy.helper.execution;

/**
 * Created by Konstantin Lugowoy on 12.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.8
 * @since 1.7.8
 */
public interface OutputExecutionResult {

    String RESULT_STRING = "Result : %s";
    String RESULT_INTEGER = "Result : %d";
    String RESULT_DOUBLE = "Result : %.3f";
    String RESULT_BOOLEAN = "Result : %b";

    <T> void outputExecutionResult(T t);

}
