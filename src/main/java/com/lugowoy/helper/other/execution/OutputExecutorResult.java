package com.lugowoy.helper.other.execution;

/**
 * Created by LugowoyKonstantin on 12.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.2
 * @since 1.7.8
 */
//todo add doc's
@FunctionalInterface
public interface OutputExecutorResult<T> {

    String MSG_STRING_RESULT = "Result : %s";
    String MSG_INTEGER_RESULT = "Result : %d";
    String MSG_DOUBLE_RESULT = "Result : %.3f";

    void outputResult(T t, String msgOutputResult);

    static <T> void outputExecutionResultOnConsole(T t, String msgOutputResult) {
        System.out.printf(msgOutputResult, t);
    }

}
