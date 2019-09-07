package com.lugowoy.helper.calculating;

import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomInteger;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationThreeParametersTest {

    private static final int NUMBER_OBJECTS_TO_TEST = 100;
    private static final int UPPER_BOUND_TO_LENGTH_ARRAY = 20;

    @Test
    public void calculateOfArrayElementsWithExpectedResultGreaterThanZero() {
        for (int i = 0; i < NUMBER_OBJECTS_TO_TEST; i++) {
            int lengthArray = GeneratorRandomNumber.generateInt(UPPER_BOUND_TO_LENGTH_ARRAY);
            Array<Integer> array = new Array<>(new FillingArrayRandomInteger().fill(lengthArray, 0, 100));
            int value = GeneratorRandomNumber.generateInt(100);
            int resultCalculationSumToTest = calculateOfArrayElementsOperation(value, 0, array);
            if (array.getLength() == 0 || resultCalculationSumToTest == 0) {
                break;
            }
            Assert.assertTrue(resultCalculationSumToTest > 0);
        }
    }

    @Test
    public void calculateOfArrayElementsWithExpectedResultLessThanZero() {
        for (int i = 0; i < NUMBER_OBJECTS_TO_TEST; i++) {
            int lengthArray = GeneratorRandomNumber.generateInt(UPPER_BOUND_TO_LENGTH_ARRAY);
            Array<Integer> array = new Array<>(new Array<>(new FillingArrayRandomInteger().fill(lengthArray, -100, 0)));
            int value = GeneratorRandomNumber.generateInt(-200, -100);
            int resultCalculationSumToTest = calculateOfArrayElementsOperation(value, 0, array);
            if (array.getLength() == 0 || resultCalculationSumToTest == 0) {
                break;
            }
            Assert.assertTrue(resultCalculationSumToTest < 0);
        }

    }

    @Test
    public void calculateOfArrayElementsWithExpectedResultEqualZero() {
        for (int i = 0; i < NUMBER_OBJECTS_TO_TEST; i++) {
            int lengthArray = GeneratorRandomNumber.generateInt(UPPER_BOUND_TO_LENGTH_ARRAY);
            Array<Integer> array = new Array<>(new FillingArrayRandomInteger().fill(lengthArray, 0, 0));
            int resultCalculationSumToTest = calculateOfArrayElementsOperation(0, 0, array);
            Assert.assertEquals(0, resultCalculationSumToTest);
        }
    }

    @Test
    public void calculateOfArrayElementsWithExpectedResultEqualFive() {
        for (int i = 0; i < NUMBER_OBJECTS_TO_TEST; i++) {
            Array<Integer> array = new Array<>(new FillingArrayRandomInteger().fill(5, 0, 0));
            int value = 1;
            int resultCalculationSumToTest = calculateOfArrayElementsOperation(value, 0, array);
            Assert.assertEquals(5, resultCalculationSumToTest);
        }
    }

    private static Integer calculateOfArrayElementsOperation(int valueToAdd, int valueToSubtract, Array<Integer> array) {
        final int[] result = new int[1];
        CalculationThreeParameters<Integer, Integer, Integer, Array<Integer>> calculationThreeParameters = (tVar, kVar, vVar) -> {
            BigDecimal tmpRes = new BigDecimal(0);
            for (Integer i : vVar) {
                tmpRes = new BigDecimal(new BigDecimal(i).add(new BigDecimal(tmpRes.intValue())
                                                         .add(new BigDecimal(tVar))
                                                         .subtract(new BigDecimal(kVar))).intValue());
            }
            result[0] = tmpRes.intValue();
            return result[0];
        };
        return calculationThreeParameters.calculate(valueToAdd, valueToSubtract, array);
    }

}
