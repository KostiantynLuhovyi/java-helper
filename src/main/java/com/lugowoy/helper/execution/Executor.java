package com.lugowoy.helper.execution;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * The class provides the ability to wrap (as a stream) the execution of the
 * functional for calculating the execution time and decor of the output
 * result.<p>The class contains two overloaded methods. Their difference that the
 * execution of the functionality wrapped in different stream objects ({@link
 * Callable} and {@link Runnable}). In the method where the parameter an object
 * of type {@link Callable}, output of the execution result makes out the
 * appearance using the class object that implements the contract interface
 * {@link OutputExecutionResult}. In a method that declares a parameter of the
 * type {@link Runnable}, output of the execution result makes out the
 * appearance in the implementation itself, which will passed to the thread for
 * execution.
 * <p>
 * Created by Konstantin Lugowoy on 01.09.2019.
 *
 * @author Konstantin Lugowoy
 * @version 2.2
 * @since 1.7.4
 */
//TODO review documentation
public class Executor {

    /**
     * Constructs an object of this class.
     */
    public Executor() {
    }

    /**
     * Executes functionality by wrapping it as an implementation of the {@link
     * Callable} interface. It determines the appearance of the output of the
     * result using a class object that implements the contract interface {@link
     * OutputExecutionResult}. It also calculated and output execution time
     * by using a class object that implements the interface {@link
     * OutputExecutionTime} contract.
     *
     * @param <T> the type of the execution result.
     * @param callable the stream object that executes the functional.
     * @param outputResult the object to output execution result.
     * @param outputTime the object to output execution time.
     *
     * @throws NullPointerException if the {@code callable} is {@code null}.
     * @throws NullPointerException if the {@code outputResult} is {@code
     * null}.
     * @throws NullPointerException if the {@code outputTime} is {@code null}.
     * @throws RuntimeException if could not get the result of execution.
     */
    public <T> void execute(@NotNull final Callable<T> callable,
                            @NotNull final OutputExecutionResult outputResult,
                            @NotNull final OutputExecutionTime outputTime) {
        Objects.requireNonNull(callable, "The thread to execute is null");
        Objects.requireNonNull(outputResult, "The output of the result is null");
        Objects.requireNonNull(outputTime, "The output of the time is null");
        ExecutionTime executionTime = new ExecutionTime();
        executionTime.setStartTime();
        T result;
        try {
            result = callable.call();
        } catch (Exception e) {
            throw new RuntimeException("Could not get the execution result");
        }
        executionTime.setEndTime();
        outputResult.output(result);
        outputTime.output(executionTime.calculateExecutionTime());
    }

    /**
     * Executes functionality by wrapping it as an implementation of the {@link
     * Runnable} interface. It also calculated and output execution time
     * by using a class object that implements the interface {@link
     * OutputExecutionTime} contract.
     *
     * @param runnable the stream object that executes the functional.
     * @param outputTime the object to output execution time.
     *
     * @throws NullPointerException if the {@code runnable} is {@code null}.
     * @throws NullPointerException if the {@code outputTime} is null.
     * @throws IllegalThreadStateException if the thread was already started.
     * @throws ArithmeticException if the result time is inexact but the
     * rounding mode is UNNECESSARY.
     */
    public void execute(@NotNull final Runnable runnable,
                        @NotNull final OutputExecutionTime outputTime) {
        Objects.requireNonNull(runnable, "The thread to execute is null");
        Objects.requireNonNull(outputTime, "The output of the time is null");
        ExecutionTime executionTime = new ExecutionTime();
        executionTime.setStartTime();
        Thread execution = new Thread(runnable, "Execution");
        execution.start();
        executionTime.setEndTime();
        outputTime.output(executionTime.calculateExecutionTime());
    }

}
