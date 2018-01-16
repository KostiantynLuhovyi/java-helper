package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 */

public class FillingArrayEnteredIntegerNumbers implements FillingArrayNumbers<Integer> {

    private static final int START_BOUND = 0;

    private Reader reader;

    public FillingArrayEnteredIntegerNumbers(Reader reader) {
        this.reader = reader;
    }

    public FillingArrayEnteredIntegerNumbers(Reading reading) {
        this.reader = Reader.getReader(reading);
    }


    @Override
    public Array<Integer> fill(final Array<Integer> array) {
        if (checkNonNullArrayObject(array)) {
            array.setArray(Arrays.stream(array.getArray())
                                 .map(value -> this.reader.readInt())
                                 .toArray(Integer[]::new));
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            integers = Arrays.stream(integers)
                             .map(value -> this.reader.readInt())
                             .toArray(Integer[]::new);
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = Arrays.stream(new Integer[lengthArray])
                             .map(value -> this.reader.readInt())
                             .toArray(Integer[]::new);
        } else {
            integers = this.fill(DEFAULT_LENGTH_ARRAY);
        }
        return integers;
    }

    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkBoundValueIsPositive(bound)) {
                this.enteringIntegerNumbers(array.getArray(), START_BOUND, bound, this.reader);
            } else {
                this.enteringIntegerNumbers(array.getArray(), START_BOUND, DEFAULT_INTEGER_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers, Integer bound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkBoundValueIsPositive(bound)) {
                this.enteringIntegerNumbers(integers, START_BOUND, bound, this.reader);
            } else {
                this.enteringIntegerNumbers(integers, START_BOUND, DEFAULT_INTEGER_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValueIsPositive(bound)) {
                integers = new Integer[lengthArray];
                this.enteringIntegerNumbers(integers, START_BOUND, bound, this.reader);
            } else {
                integers = new Integer[lengthArray];
                this.enteringIntegerNumbers(integers, START_BOUND, DEFAULT_INTEGER_BOUND, this.reader);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.enteringIntegerNumbers(integers, START_BOUND, DEFAULT_INTEGER_BOUND, this.reader);
        }
        return integers;
    }

    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                this.enteringIntegerNumbers(array.getArray(), minBound, maxBound, this.reader);
            } else {
                this.enteringIntegerNumbers(array.getArray(), DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                this.enteringIntegerNumbers(integers, minBound, maxBound, this.reader);
            } else {
                this.enteringIntegerNumbers(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    @Override
    public Integer[] fill(int lengthArray, Integer minBound, Integer maxBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                integers = new Integer[lengthArray];
                this.enteringIntegerNumbers(integers, minBound, maxBound, this.reader);
            } else {
                integers = new Integer[lengthArray];
                this.enteringIntegerNumbers(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND, this.reader);
            }
        } else {
            integers = new Integer[DEFAULT_LENGTH_ARRAY];
            this.enteringIntegerNumbers(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND, this.reader);
        }
        return integers;
    }

    private void enteringIntegerNumbers(final Integer[] integers, final int minBound, final int maxBound, final Reader reader) {
        for (int i = 0; i < integers.length; i++) {
            int value = reader.readInt();
            if ((value >= minBound) && (value <= maxBound)) {
                integers[i] = value;
            } else {
                //todo Обдумать, как сообщить вызывающему коду, что было введено не корректное значение и эта итерация будет повторена.
                i--;
            }
        }
    }

}
