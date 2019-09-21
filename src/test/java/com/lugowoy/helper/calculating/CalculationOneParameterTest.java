package com.lugowoy.helper.calculating;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationOneParameterTest {

    private static final int NUMBER_OBJECTS_TO_TEST = 100;
    private static final int UPPER_BOUND_TO_LENGTH_ARRAY = 20;

    @Test
    public void calculateSumArrayElementsWithExpectedResultGreaterThanZero() {
        for (int i = 0; i < NUMBER_OBJECTS_TO_TEST; i++) {
            int lengthArray = GeneratorRandomNumber.generateInt(UPPER_BOUND_TO_LENGTH_ARRAY);
            Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(lengthArray, 0, 100));
            int resultCalculationSumToTest = calculateSumArrayElementsOperation(array);
            if (array.getLength() == 0 || resultCalculationSumToTest == 0) {
                break;
            }
            Assert.assertTrue(resultCalculationSumToTest > 0);
        }
    }

    @Test
    public void calculateSumArrayElementsWithExpectedResultLessThanZero() {
        for (int i = 0; i < NUMBER_OBJECTS_TO_TEST; i++) {
            int lengthArray = GeneratorRandomNumber.generateInt(UPPER_BOUND_TO_LENGTH_ARRAY);
            Array<Integer> array = new Array<>(new Array<>(new FillingArrayRandomIntegers().fill(lengthArray, -100, 0)));
            int resultCalculationSumToTest = calculateSumArrayElementsOperation(array);
            if (array.getLength() == 0 || resultCalculationSumToTest == 0) {
                break;
            }
            Assert.assertTrue(resultCalculationSumToTest < 0);
        }

    }

    @Test
    public void calculateSumArrayElementsWithExpectedResultEqualZero() {
        for (int i = 0; i < NUMBER_OBJECTS_TO_TEST; i++) {
            int lengthArray = GeneratorRandomNumber.generateInt(UPPER_BOUND_TO_LENGTH_ARRAY);
            Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(lengthArray, 0, 0));
            int resultCalculationSumToTest = calculateSumArrayElementsOperation(array);
            Assert.assertEquals(0, resultCalculationSumToTest);
        }
    }

    @Test
    public void calculateSumArrayElementsWithExpectedResultEqualFive() {
        for (int i = 0; i < NUMBER_OBJECTS_TO_TEST; i++) {
            Array<Integer> array = new Array<>(new FillingArrayRandomIntegers().fill(5, 1, 1));
            int resultCalculationSumToTest = calculateSumArrayElementsOperation(array);
            Assert.assertEquals(5, resultCalculationSumToTest);
        }
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