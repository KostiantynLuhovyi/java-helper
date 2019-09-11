package com.lugowoy.helper.other;

import java.util.concurrent.Callable;

/**
 * Created by LugowoyKonstantin on 01.09.2019.
 *
 * @author LugowoyKonstantin
 * @version 1.2
 * @since 1.7.4
 */
//todo add doc's (class, methods)
//todo refactoring this class
public interface Executor {

    public static <T> T execute(Callable<T> callable) {
        long startMillis = System.currentTimeMillis();
        T result = null;
        try {
            result = callable.call();
            Thread.sleep(12000);
        } catch (Exception e) {
            //todo to refactoring if throw exception
            e.printStackTrace();
        }
        long endMillis = System.currentTimeMillis();
        long runtimeMillis = (endMillis - startMillis);
        System.out.println(runtimeMillis);
        OutputTimer.showTimerMillisOnConsole(runtimeMillis, OutputTimer.MSG_MILLISECONDS);
        OutputTimer.showTimerOnConsole(runtimeMillis, OutputTimer.MSG_MINUTES_AND_SECONDS);
        //todo check non null result
        return result;
    }

    public static <T> T execute(Callable<T> callable, OutputTimer outputTimer, String msg) {
        long startMillis = System.currentTimeMillis();
        T result = null;
        try {
            result = callable.call();
        } catch (Exception e) {
            //todo to refactoring
            e.printStackTrace();
        }
        long endMillis = System.currentTimeMillis();
        long runtimeMillis = (endMillis - startMillis);
        outputTimer.showTimer(runtimeMillis, msg);
        //todo check non null result
        return result;
    }

}
