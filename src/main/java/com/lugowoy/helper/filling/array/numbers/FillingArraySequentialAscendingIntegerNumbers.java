package com.lugowoy.helper.filling.array.numbers;

import static java.util.Objects.nonNull;

/** Created by Konstantin Lugowoy on 06.11.2017. */

public class FillingArraySequentialAscendingIntegerNumbers extends FillingArrayNumbers<Integer> {

    @Override
    public Integer[] fill(Integer[] array) {
        if (nonNull(array)) {
            for (int i = 0; i < array.length; i++) {
                array[i] = i;
            }
        } else {
            throw new IllegalArgumentException("Argument array passed in the method is equal to \"null\".");
        }
        return array;
    }

    @Override
    public Integer[] fill(int lengthArray) {
        return this.fill(new Integer[lengthArray]);
    }

    @Override
    public Integer[] fill(Integer[] array, Integer startNumber) {
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
    public Integer[] fill(int lengthArray, Integer startNumber) {
        return this.fill(new Integer[lengthArray], startNumber);
    }

    @Override
    public Integer[] fill(Integer[] array, Integer startNumber, Integer numberOfElements) {
        if (nonNull(array)) {
            if ((numberOfElements > 0) && (numberOfElements <= array.length)) {
                for (int i = 0; i < numberOfElements; startNumber++, i++) {
                    array[i] = startNumber;
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
    public Integer[] fill(int lengthArray, Integer startNumber, Integer numberOfElements) {
        return this.fill(new Integer[lengthArray], startNumber, numberOfElements);
    }

}
