package com.lugowoy.helper.execution;

/**
 * The interface declares a contract to output the time execution any task.
 * <p>
 * Created by Konstantin Lugowoy on 11.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 1.9
 * @since 1.7.6
 */
public interface OutputExecutionTime {

    /**
     * Outputs the time of the execution. The appearance for outputting the time
     * value implemented in a class that implements an interface contract.
     *
     * @param milliseconds the time of the execution to output.
     */
    void output(long milliseconds);

}
