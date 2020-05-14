package com.lugowoy.helper.execution;

/**
 * Created by Konstantin Lugowoy on 06.02.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 2.7
 */
//todo write doc's
public class OutputExecutionResultToConsole {

    private String msgOutputResult;

    public OutputExecutionResultToConsole(final String msgOutputResult) {
        this.msgOutputResult = msgOutputResult;
    }

    public <T> void outputExecutionResult(final T t) {
        System.out.printf(this.msgOutputResult, t);
    }

    public void setMsgOutputResult(final String msgOutputResult) {
        this.msgOutputResult = msgOutputResult;
    }

}
