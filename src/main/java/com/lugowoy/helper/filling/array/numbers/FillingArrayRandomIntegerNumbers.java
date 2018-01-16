package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 */

public class FillingArrayRandomIntegerNumbers implements FillingArrayNumbers<Integer> {

    @Override
    public Array<Integer> fill(final Array<Integer> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            array.setArray(Arrays.stream(array.getArray())
                                 .mapToInt(value -> GeneratorRandomNumber.generateInt())
                                 .boxed()
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
                             .mapToInt(value -> GeneratorRandomNumber.generateInt())
                             .boxed()
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
                             .mapToInt(value -> GeneratorRandomNumber.generateInt())
                             .boxed()
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
                array.setArray(Arrays.stream(array.getArray())
                                     .mapToInt(value -> GeneratorRandomNumber.generateInt(bound))
                                     .boxed()
                                     .toArray(Integer[]::new));
            } else {
                array.setArray(this.fill(array, DEFAULT_INTEGER_BOUND).getArray());
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers, Integer bound) {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkBoundValueIsPositive(bound)) {
                integers = Arrays.stream(integers)
                                 .mapToInt(value -> GeneratorRandomNumber.generateInt(bound))
                                 .boxed()
                                 .toArray(Integer[]::new);
            } else {
                integers = this.fill(integers, DEFAULT_INTEGER_BOUND);
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
                integers = Arrays.stream(new Integer[lengthArray])
                                 .mapToInt(value -> GeneratorRandomNumber.generateInt(bound))
                                 .boxed()
                                 .toArray(Integer[]::new);
            } else {
                integers = this.fill(lengthArray, DEFAULT_INTEGER_BOUND);
            }
        } else {
            integers = this.fill(DEFAULT_LENGTH_ARRAY, DEFAULT_INTEGER_BOUND);
        }
        return integers;
    }

    @Override
    public Array<Integer> fill(final Array<Integer> array, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                array.setArray(Arrays.stream(array.getArray())
                                     .mapToInt(value -> GeneratorRandomNumber.generateInt(minBound, maxBound))
                                     .boxed()
                                     .toArray(Integer[]::new));
            } else {
                array.setArray(this.fill(array, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND).getArray());
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Integer[] fill(Integer[] integers, Integer minBound, Integer maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(integers)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                integers = Arrays.stream(integers)
                                 .mapToInt(value -> GeneratorRandomNumber.generateInt(minBound, maxBound))
                                 .boxed()
                                 .toArray(Integer[]::new);
            } else {
                integers = this.fill(integers, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return integers;
    }

    @Override
    public Integer[] fill(int lengthArray, Integer minBound, Integer maxBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                integers = Arrays.stream(new Integer[lengthArray])
                                 .mapToInt(value -> GeneratorRandomNumber.generateInt(minBound, maxBound))
                                 .boxed()
                                 .toArray(Integer[]::new);
            } else {
                integers = this.fill(lengthArray, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
            }
        } else {
            integers = this.fill(DEFAULT_LENGTH_ARRAY, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
        }
        return integers;
    }

}
