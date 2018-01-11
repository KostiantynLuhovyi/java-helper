package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.filling.array.FillingArrayChecker;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_DOUBLE_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_DOUBLE_MAX_BOUND;
import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.DEFAULT_DOUBLE_MIN_BOUND;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 */

public class FillingArrayEnteredDoubleNumbers implements FillingArray<Double>, FillingArrayNumbers<Double> {

    private static final int START_BOUND = 0;

    private Reader reader;

    public FillingArrayEnteredDoubleNumbers(Reader reader) {
        this.reader = reader;
    }

    public FillingArrayEnteredDoubleNumbers(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    @Override
    public Array<Double> fill(final Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            array.setArray(Arrays.stream(array.getArray())
                                 .map(value -> this.reader.readDouble())
                                 .toArray(Double[]::new));
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArray(doubles)) {
            doubles = Arrays.stream(doubles)
                            .map(value -> this.reader.readDouble())
                            .toArray(Double[]::new);
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = Arrays.stream(new Double[lengthArray])
                            .map(value -> this.reader.readDouble())
                            .toArray(Double[]::new);
        } else {
            doubles = this.fill(DEFAULT_LENGTH_ARRAY);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            if (checkBoundValue(bound)) {
                enteringDoubleNumbers(array.getArray(), START_BOUND, bound, this.reader);
            } else {
                enteringDoubleNumbers(array.getArray(), START_BOUND, DEFAULT_DOUBLE_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        if (checkNonNullArray(doubles)) {
            if (checkBoundValue(bound)) {
                enteringDoubleNumbers(doubles, START_BOUND, bound, this.reader);
            } else {
                enteringDoubleNumbers(doubles, START_BOUND, DEFAULT_DOUBLE_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkBoundValue(bound)) {
                doubles = new Double[lengthArray];
                enteringDoubleNumbers(doubles, START_BOUND, bound, this.reader);
            } else {
                doubles = new Double[lengthArray];
                enteringDoubleNumbers(doubles, START_BOUND, DEFAULT_DOUBLE_BOUND, this.reader);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            enteringDoubleNumbers(doubles, START_BOUND, DEFAULT_DOUBLE_BOUND, this.reader);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObj(array)) {
            if (checkMinBoundLessThanMaxBound(minBound, maxBound)) {
                enteringDoubleNumbers(array.getArray(), minBound, maxBound, this.reader);
            } else {
                enteringDoubleNumbers(array.getArray(), DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return null;
    }

    @Override
    public Double[] fill(Double[] doubles, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArray(doubles)) {
            if (checkMinBoundLessThanMaxBound(minBound, maxBound)) {
                enteringDoubleNumbers(doubles, minBound, maxBound, this.reader);
            } else {
                enteringDoubleNumbers(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the parameter is null."));
        }
        return doubles;
    }

    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            if (checkMinBoundLessThanMaxBound(minBound, maxBound)) {
                doubles = new Double[lengthArray];
                enteringDoubleNumbers(doubles, minBound, maxBound, this.reader);
            } else {
                doubles = new Double[lengthArray];
                enteringDoubleNumbers(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND, this.reader);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            enteringDoubleNumbers(doubles, DEFAULT_DOUBLE_MIN_BOUND, DEFAULT_DOUBLE_MAX_BOUND, this.reader);
        }
        return doubles;
    }

    private static void enteringDoubleNumbers(final Double[] doubles, final double minBound, final double maxBound, final Reader reader) {
        for (int i = 0; i < doubles.length; i++) {
            double value = reader.readDouble();
            if ((value >= minBound) && (value <= maxBound)) {
                doubles[i] = value;
            } else {
                //todo Обдумать, как сообщить вызывающему коду, что было введено не корректное значение и эта итерация будет повторена.
                i--;
            }
        }
    }

}
