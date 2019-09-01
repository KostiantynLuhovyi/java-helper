package com.lugowoy.helper.other;

import java.util.concurrent.Callable;

/**
 * Created by LugowoyKonstantin on 01.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.0
 * @since 1.7.4
 */
//todo add doc's (class, methods)
public class Executor<T> {

    T execute(Callable<T> callable) {
        //todo the functionality of initializing the start and end time of a task should be taken out into another method
        long startExecuteTime, endExecuteTime;
        startExecuteTime = System.currentTimeMillis();

        T result = null;
        try {
            result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        endExecuteTime = System.currentTimeMillis();
        System.out.println("Task time in milliseconds : " + (endExecuteTime - startExecuteTime));

        //todo check non null result
        return result;
    }

}
