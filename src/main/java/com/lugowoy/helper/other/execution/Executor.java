package com.lugowoy.helper.other.execution;

import java.util.concurrent.Callable;

/**
 * Created by LugowoyKonstantin on 01.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.4
 * @since 1.7.4
 */
//todo add doc's (class, methods)
//todo refactoring this class
public interface Executor {

    static <T> void execute(Callable<T> callable) {
        long startMillis = System.currentTimeMillis();
        try {
            T result = callable.call();
            //todo check non null result
            OutputExecutorResult<T> outputExecutorResult = (t, msg) -> System.out.println(msg + t);
            outputExecutorResult.outputResult(result, "Result : ");
        } catch (Exception e) {
            //todo to refactoring if throw exception
            e.printStackTrace();
        }
        long endMillis = System.currentTimeMillis();
        long runtimeMillis = (endMillis - startMillis);
        OutputExecutorTime.outputExecutionTimeMillisOnConsole(runtimeMillis, OutputExecutorTime.MSG_MILLISECONDS);
    }

    static <T> void execute(Callable<T> callable, String msgExecutorResult, String msgExecutorTime,
                            OutputExecutorTime outputExecutorTime, OutputExecutorResult<T> outputExecutorResult) {
        long startMillis = System.currentTimeMillis();
        try {
            T result = callable.call();
            //todo check non null result
            outputExecutorResult.outputResult(result, msgExecutorResult);
        } catch (Exception e) {
            //todo to refactoring
            e.printStackTrace();
        }
        long endMillis = System.currentTimeMillis();
        long runtimeMillis = (endMillis - startMillis);
        outputExecutorTime.outputTimer(runtimeMillis, msgExecutorTime);
    }

}
