package com.lugowoy.helper.execution;

import java.util.concurrent.Callable;

/**
 * Created by Konstantin Lugowoy on 01.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 2.0
 * @since 1.7.4
 */
//todo write doc's
public interface Executor {

    ExecutionTime EXECUTION_TIME = new ExecutionTime();

    static <T> void execute(Callable<T> callable, ExecutionResultOutput executionResultOutput, String outputResult,
                                                        ExecutionTimeOutput executionTimeOutput) throws Exception {
        EXECUTION_TIME.startExecutionTime();
        T result = callable.call();
        EXECUTION_TIME.endExecutionTime();
        executionResultOutput.outputExecutionResult(result, outputResult);
        executionTimeOutput.outputExecutionTime(EXECUTION_TIME.executionTime());
    }

    static void execute(Runnable runnable, ExecutionTimeOutput executionTimeOutput) {
        EXECUTION_TIME.startExecutionTime();
        runnable.run();
        EXECUTION_TIME.endExecutionTime();
        executionTimeOutput.outputExecutionTime(EXECUTION_TIME.executionTime());
    }

}
