package com.lugowoy.helper.utils.execution;

import java.util.concurrent.Callable;

import static com.lugowoy.helper.utils.execution.OutputExecutorResult.MSG_DEFAULT_RESULT;
import static com.lugowoy.helper.utils.execution.OutputExecutorTimer.MSG_MILLISECONDS;

/**
 * Created by Konstantin Lugowoy on 01.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @since 1.7.4
 */
//todo write doc's
public interface Executor {

    static <T> void execute(Callable<T> callable) {
        ExecutorTimer executorTimer = new ExecutorTimer();
        executorTimer.startExecutionTimer();
        T result = callExecution(callable);
        OutputExecutorResult.outputExecutionResultToConsole(result, MSG_DEFAULT_RESULT);
        OutputExecutorTimer.outputExecutionTimeMillisToConsole(executorTimer.endExecutionTimer(), MSG_MILLISECONDS);
    }

    static <T> void execute(Callable<T> callable, String msgOutputTime, String msgOutputResult) {
        ExecutorTimer executorTimer = new ExecutorTimer();
        executorTimer.startExecutionTimer();
        T result = callExecution(callable);
        OutputExecutorResult.outputExecutionResultToConsole(result, msgOutputResult);
        OutputExecutorTimer.outputExecutionTimeToConsole(executorTimer.endExecutionTimer(), msgOutputTime);
    }

    static <T> void execute(Callable<T> callable, String msgOutputResult, String msgOutputTime,
                            OutputExecutorResult<T> outputExecutorResult, OutputExecutorTimer outputExecutorTimer) {
        ExecutorTimer executorTimer = new ExecutorTimer();
        executorTimer.startExecutionTimer();
        T result = callExecution(callable);
        outputExecutorResult.outputResult(result, msgOutputResult);
        outputExecutorTimer.outputTimer(executorTimer.endExecutionTimer(), msgOutputTime);
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
