package com.lugowoy.helper.filling.array.numbers;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

/** Created by Konstantin Lugowoy on 06.11.2017. */

public class FillingArraySequentialDescendingFractionalDoubleNumbers extends FillingArrayNumbers<Double> {

    private static final double DEFAULT_INCREMENT_STEP = 0.1;
    public static final int SCALE = 2;

    @Override
    public Double[] fill(Double[] array) {
        if (nonNull(array)) {
            double value = array.length;
           executionOfFilling(array, value, DEFAULT_INCREMENT_STEP, array.length);
        } else {
            throw new IllegalArgumentException("Argument array passed in the method is equal to \"null\".");
        }
        return array;
    }

    @Override
    public Double[] fill(int lengthArray) {
        return this.fill(new Double[lengthArray]);
    }

    @Override
    public Double[] fill(Double[] array, Double startNumber) {
        if (nonNull(array)) {
            executionOfFilling(array, startNumber, DEFAULT_INCREMENT_STEP, array.length);
        } else {
            throw new IllegalArgumentException("Argument array passed in the method is equal to \"null\".");
        }
        return array;
    }

    @Override
    public Double[] fill(int lengthArray, Double startNumber) {
        return this.fill(new Double[lengthArray], startNumber);
    }

    @Override
    public Double[] fill(Double[] array, Double startNumber, Double numberOfElements) {
        if (nonNull(array)) {
            int integerNumberOfElements = (int)(double)numberOfElements;
            if ((integerNumberOfElements > 0) && (integerNumberOfElements <= array.length)) {
                executionOfFilling(array, startNumber, DEFAULT_INCREMENT_STEP, integerNumberOfElements);
            } else {
                throw new IllegalArgumentException("The number of elements to fill an array can not be negative or should not exceed the size of an array.");
            }
        } else {
            throw new IllegalArgumentException("Argument array passed in the method is equal to \"null\".");
        }
        return array;
    }

    @Override
    public Double[] fill(int lengthArray, Double startNumber, Double numberOfElements) {
        return this.fill(new Double[lengthArray], startNumber, numberOfElements);
    }

    public Double[] fillingArrayConsecutiveFractionalDoubleNumbers(Double[] array, Double startNumber, Double incrementStep) {
        if (nonNull(array)) {
            executionOfFilling(array, startNumber, incrementStep, array.length);
        } else {
            throw new IllegalArgumentException("Argument array passed in the method is equal to \"null\".");
        }
        return array;
    }

    public Double[] fillingArrayConsecutiveFractionalDoubleNumbers(Double[] array, Double startNumber, Double incrementStep, Double numberOfElements) {
        if (nonNull(array)) {
            int integerNumberOfElements = (int)(double)numberOfElements;
            if ((integerNumberOfElements > 0) && (integerNumberOfElements <= array.length)) {
                executionOfFilling(array, startNumber, incrementStep, integerNumberOfElements);
            } else {
                throw new IllegalArgumentException("The number of elements to fill an array can not be negative or should not exceed the size of an array.");
            }
        } else {
            throw new IllegalArgumentException("Argument array passed in the method is equal to \"null\".");
        }
        return array;
    }

    public Double[] fillingArrayConsecutiveFractionalDoubleNumbers(int lengthArray, Double startNumber, Double incrementStep, Double numberOfElements) {
        return this.fillingArrayConsecutiveFractionalDoubleNumbers(new Double[lengthArray], startNumber, incrementStep, numberOfElements);
    }

    private void executionOfFilling(Double[] array, Double startNumber, Double incrementStep, int integerNumberOfElements) {
        for (int i = 0; i < integerNumberOfElements; i++) {
            array[i] = startNumber;
            startNumber = new BigDecimal(new BigDecimal(startNumber).subtract(new BigDecimal(incrementStep)).doubleValue()).setScale(SCALE, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
    }

}
