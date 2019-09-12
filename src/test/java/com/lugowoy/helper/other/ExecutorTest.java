package com.lugowoy.helper.other;

import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.execution.Executor;
import org.junit.Test;

import java.util.concurrent.Callable;

public class ExecutorTest {

    @Test
    public void executeTest() {
        Executor.execute((Callable<Array<Integer>>) Array::new);
    }

}