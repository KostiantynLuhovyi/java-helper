package com.lugowoy.helper.calculating;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomInteger;
import com.lugowoy.helper.models.Array;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationOneParameterTest {

    @Test
    public void calculateOperationsWithOneParameters() {
        final BigDecimal res = new BigDecimal(0);
        CalculationOneParameter<Integer, Array<Integer>> calculationOneParameter = kVar -> {
            for (Integer i : kVar) {
                res.add(new BigDecimal(i).add(new BigDecimal(res.intValue())));
            }
            return res.intValue();
        };
        calculationOneParameter.calculate(new Array<>(new FillingArrayRandomInteger().fill(5, 0, 10)));
        /*Assert.assertTrue(res.intValue() <= 0);*/
    }

}