package com.lugowoy.helper.calculating;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomInteger;
import com.lugowoy.helper.models.Array;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationOneParameterTest {

    @Test
    public void calculateSumOperationsAndObtainingResultGreaterThanZero() {
        Array<Integer> array = new Array<>(new FillingArrayRandomInteger().fill(5, 0, 10));
        int resultToTest = calculateSumArrayElementsOperation(array);
        Assert.assertTrue(resultToTest > 0);
    }

    @Test
    public void calculateSumOperationsAndObtainingResultLessThanZero() {
        Array<Integer> array = new Array<>(new Array<>(new FillingArrayRandomInteger().fill(5, -20, -1)));
        int resultToTest = calculateSumArrayElementsOperation(array);
        Assert.assertTrue(resultToTest < 0);
    }

    @Test
    public void calculateSumOperationsAndObtainingResultEqualZero() {
        Array<Integer> array = new Array<>(new FillingArrayRandomInteger().fill(5, 0, 0));
        int resultToTest = calculateSumArrayElementsOperation(array);
        Assert.assertEquals(0, resultToTest);
    }

    @Test
    public void calculateSumOperationsAndObtainingResultEqualFive() {
        Array<Integer> array = new Array<>(new Array<>(new FillingArrayRandomInteger().fill(5, 1, 1)));
        int resultToTest = calculateSumArrayElementsOperation(array);
        Assert.assertEquals(5, resultToTest);
    }

    private static Integer calculateSumArrayElementsOperation(Array<Integer> array) {
        final int[] result = new int[1];
        CalculationOneParameter<Integer, Array<Integer>> calculationOneParameter = kVar -> {
            BigDecimal tmpRes = new BigDecimal(0);
            for (Integer i : kVar) {
                tmpRes = new BigDecimal(new BigDecimal(i).add(new BigDecimal(tmpRes.intValue())).intValue());
            }
            result[0] = tmpRes.intValue();
            return result[0];
        };
        return calculationOneParameter.calculate(array);
    }

}