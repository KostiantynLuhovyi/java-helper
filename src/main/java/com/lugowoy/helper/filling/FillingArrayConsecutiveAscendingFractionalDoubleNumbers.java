package com.lugowoy.helper.filling;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

/** Created by Konstantin Lugowoy on 06.11.2017. */

public class FillingArrayConsecutiveAscendingFractionalDoubleNumbers extends FillingArrayConsecutiveAscendingDoubleNumbers {

    private static final int SCALE = 2;
    private static final double DEFAULT_INCREMENT_STEP = 0.1;

    @Override
    public Double[] fill(Double[] array) {
        if (nonNull(array)) {
            double value = 0.0;
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

    public Double[] fillArrayConsecutiveAscendingFractionalDoubleNumbers(Double[] array, Double startNumber, Double incrementStep) {
        if (nonNull(array)) {
            executionOfFilling(array, startNumber, incrementStep, array.length);
        } else {
            throw new IllegalArgumentException("Argument array passed in the method is equal to \"null\".");
        }
        return array;
    }

    public Double[] fillArrayConsecutiveAscendingFractionalDoubleNumbers(int lengthArray, Double startNumber, Double incrementStep) {
        return this.fillArrayConsecutiveAscendingFractionalDoubleNumbers(new Double[lengthArray], startNumber, incrementStep);
    }

    public Double[] fillArrayConsecutiveAscendingFractionalDoubleNumbers(Double[] array, Double startNumber, Double incrementStep, Double numberOfElements) {
        if (nonNull(array)) {
            int integerNumbersOfElements = (int)(double)numberOfElements;
            if ((integerNumbersOfElements > 0) && (integerNumbersOfElements <= array.length)) {
                executionOfFilling(array, startNumber, incrementStep, integerNumbersOfElements);
            } else {
                throw new IllegalArgumentException("The number of elements to fill an array can not be negative or should not exceed the size of an array.");
            }
        } else {
            throw new IllegalArgumentException("Argument array passed in the method is equal to \"null\".");
        }
        return array;
    }

    public Double[] fillArrayConsecutiveAscendingFractionalDoubleNumbers(int length, Double startNumber, Double incrementStep, Double numberOfElements) {
        return this.fillArrayConsecutiveAscendingFractionalDoubleNumbers(new Double[length], startNumber, incrementStep, numberOfElements);
    }

    private void executionOfFilling(Double[] array, Double startNumber, Double incrementStep, int integerNumbersOfElements) {
        for (int i = 0; i < integerNumbersOfElements; i++) {
            array[i] = startNumber;
            startNumber = new BigDecimal(new BigDecimal(startNumber).add(new BigDecimal(incrementStep)).doubleValue())
                    .setScale(SCALE, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
    }

}
