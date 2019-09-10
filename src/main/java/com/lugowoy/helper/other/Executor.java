package com.lugowoy.helper.other;

import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by LugowoyKonstantin on 01.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.1
 * @since 1.7.4
 */
//todo add doc's (class, methods)
//todo refactoring this class
public class Executor {

    public static <T> T execute(Callable<T> callable) {
        long startExecuteTime, endExecuteTime;
        startExecuteTime = System.currentTimeMillis();
        T result = null;
        try {
            result = callable.call();
        } catch (Exception e) {
            //todo to refactoring
            e.printStackTrace();
        }
        endExecuteTime = System.currentTimeMillis();
        long runtime = (endExecuteTime - startExecuteTime);
        System.out.printf("Runtime : %d,%d .", convertMillisecondsToMinutes(runtime), convertMillisecondsToSeconds(runtime));
        //todo check non null result
        return result;
    }

    public static <T> T execute(Callable<T> callable, OutputStream outputStreamMsg, String resultMsg) {
        long startExecuteTime, endExecuteTime;
        startExecuteTime = System.currentTimeMillis();
        T result = null;
        try {
            result = callable.call();
            outputStreamMsg.write(resultMsg.getBytes());
        } catch (Exception e) {
            //todo to refactoring
            e.printStackTrace();
        }
        endExecuteTime = System.currentTimeMillis();
        long runtime = (endExecuteTime - startExecuteTime);
        System.out.printf("Runtime : %d,%d .", convertMillisecondsToMinutes(runtime), convertMillisecondsToSeconds(runtime));
        //todo check non null result
        return result;
    }

    private static long convertMillisecondsToMinutes(long milliseconds) {
        return TimeUnit.MILLISECONDS.toMinutes(milliseconds);
    }

    private static long convertMillisecondsToSeconds(long milliseconds) {
        return TimeUnit.MILLISECONDS.toSeconds(milliseconds);
    }

}
