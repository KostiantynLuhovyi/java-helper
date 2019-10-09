package com.lugowoy.helper.other.execution;

import java.util.concurrent.Callable;

import static com.lugowoy.helper.other.execution.OutputExecutorTime.MSG_MILLISECONDS;

/**
 * Created by LugowoyKonstantin on 01.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.5
 * @since 1.7.4
 */

//todo refactoring code
//todo edit doc's

public interface Executor {

    static <T> void execute(Callable<T> callable) {
        ExecutionTimer executionTimer = ExecutionTimer.getExecutionTimer();
        executionTimer.startExecutionTimer();
        T result = callExecution(callable);
        OutputExecutorResult.outputExecutionResultOnConsole(result, "Result : ");
        OutputExecutorTime.outputExecutionTimeMillisOnConsole(executionTimer.endExecutionTimer(), MSG_MILLISECONDS);
    }

    static <T> void execute(Callable<T> callable, String msgOutputTime, String msgOutputResult) {
        ExecutionTimer executionTimer = ExecutionTimer.getExecutionTimer();
        executionTimer.startExecutionTimer();
        T result = callExecution(callable);
        OutputExecutorResult.outputExecutionResultOnConsole(result, msgOutputResult);
        OutputExecutorTime.outputExecutionTimeOnConsole(executionTimer.endExecutionTimer(), msgOutputTime);
    }

    static <T> void execute(Callable<T> callable, String msgOutputResult, String msgOutputTime,
                            OutputExecutorResult<T> outputExecutorResult, OutputExecutorTime outputExecutorTime) {
        ExecutionTimer executionTimer = ExecutionTimer.getExecutionTimer();
        executionTimer.startExecutionTimer();
        T result = callExecution(callable);
        outputExecutorResult.outputResult(result, msgOutputResult);
        outputExecutorTime.outputTimer(executionTimer.endExecutionTimer(), msgOutputTime);
    }

    private static <T> T callExecution(Callable<T> callable) {
        T resultExecution = null;
        try {
            resultExecution = callable.call();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultExecution;
    }

}
