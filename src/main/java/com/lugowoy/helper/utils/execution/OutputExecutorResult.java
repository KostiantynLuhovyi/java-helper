package com.lugowoy.helper.utils.execution;

/**
 * Created by Konstantin Lugowoy on 12.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 1.7.8
 */
//todo write doc's
@FunctionalInterface
public interface OutputExecutorResult<T> {

    String MSG_STRING_RESULT = "Result : %s";
    String MSG_INTEGER_RESULT = "Result : %d";
    String MSG_DOUBLE_RESULT = "Result : %.3f";
    String MSG_BOOLEAN_RESULT = "Result : %b";

    void outputResult(T t, String msgOutputResult);

    static <T> void outputExecutionResultOnConsole(T t, String msgOutputResult) {
        System.out.printf(msgOutputResult, t);
    }

}
