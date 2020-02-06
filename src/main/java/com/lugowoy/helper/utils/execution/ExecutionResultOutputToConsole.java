package com.lugowoy.helper.utils.execution;

/**
 * Created by Konstantin Lugowoy on 06.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 2.7
 */
//todo write doc's
public class ExecutionResultOutputToConsole {

    String RESULT_STRING = "Result : %s";
    String RESULT_INTEGER = "Result : %d";
    String RESULT_DOUBLE = "Result : %.3f";
    String RESULT_BOOLEAN = "Result : %b";

    static <T> void outputExecutionResultToConsole(T t, String outputResult) {
        System.out.printf(outputResult, t);
    }

}
