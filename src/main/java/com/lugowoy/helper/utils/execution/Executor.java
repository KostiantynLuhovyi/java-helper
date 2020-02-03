package com.lugowoy.helper.utils.execution;

import java.util.concurrent.Callable;

import static com.lugowoy.helper.utils.execution.ExecutionResultOutput.MSG_DEFAULT_RESULT;
import static com.lugowoy.helper.utils.execution.ExecutionTimeOutput.MSG_MILLISECONDS;

/**
 * Created by Konstantin Lugowoy on 01.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.9
 * @since 1.7.4
 */
//todo write doc's
public interface Executor {

    ExecutionTime EXECUTION_TIMER = new ExecutionTime();

    static <T> void execute(Callable<T> callable) throws Exception {
        EXECUTION_TIMER.startExecutionTime();
        T result = callable.call();
        EXECUTION_TIMER.endExecutionTime();
        ExecutionResultOutput.outputExecutionResultToConsole(MSG_DEFAULT_RESULT, result);
        ExecutionTimeOutput.outputExecutionTimeMillisToConsole(EXECUTION_TIMER.executionTime(), MSG_MILLISECONDS);
    }

    static <T> void execute(Callable<T> callable, String msgOutputResult, String msgOutputTime) throws Exception {
        EXECUTION_TIMER.startExecutionTime();
        T result = callable.call();
        EXECUTION_TIMER.endExecutionTime();
        ExecutionResultOutput.outputExecutionResultToConsole(msgOutputResult, result);
        ExecutionTimeOutput.outputExecutionTimeToConsole(EXECUTION_TIMER.executionTime(), msgOutputTime);
    }

    static <T> void execute(Callable<T> callable, String msgOutputResult, String msgOutputTime,
                            ExecutionResultOutput<T> executionResultOutput, ExecutionTimeOutput executionTimeOutput) throws Exception {
        EXECUTION_TIMER.startExecutionTime();
        T result = callable.call();
        EXECUTION_TIMER.endExecutionTime();
        executionResultOutput.outputResult(msgOutputResult, result);
        executionTimeOutput.outputTimer(EXECUTION_TIMER.executionTime(), msgOutputTime);
    }

}
