package com.lugowoy.helper.filling.array.numbers;

import static java.util.Objects.nonNull;

/** Created by Konstantin Lugowoy on 06.11.2017. */

public class FillingArraySequentialAscendingDoubleNumbers extends FillingArrayNumbers<Double> {

    @Override
    public Double[] fill(Double[] array) {
        if (nonNull(array)) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (double) i;
            }
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
            for (int i = 0; i < array.length; i++) {
                array[i] = startNumber;
                startNumber++;
            }
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
            int integerNumbersOfElements = (int)(double)numberOfElements;
            if ((integerNumbersOfElements > 0) && (integerNumbersOfElements <= array.length)) {
                for (int i = 0; i < integerNumbersOfElements; i++) {
                    array[i] = startNumber;
                    startNumber++;
                }
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

}
