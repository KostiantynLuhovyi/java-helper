package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 */

public class FillingArrayEnteredDoubleNumbers implements FillingArrayNumbers<Double> {

    private Reader reader;

    public FillingArrayEnteredDoubleNumbers(Reader reader) {
        this.reader = reader;
    }

    public FillingArrayEnteredDoubleNumbers(Reading reading) {
        this.reader = Reader.getReader(reading);
    }

    @Override
    public Array<Double> fill(final Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            //todo Перезаписывает массив инкапсулированный в объекте класса Array на новый заполненный. См. NotesOfCoding (OneNote).
            array.setArray(Arrays.stream(array.getArray())
                                 .map(value -> this.reader.readDouble())
                                 .toArray(Double[]::new));
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array passed by the argument is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            doubles = Arrays.stream(doubles)
                            .map(value -> this.reader.readDouble())
                            .toArray(Double[]::new);
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The array passed by the argument is null."));
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
    public Array<Double> fill(final Array<Double> array, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkBoundValueIsPositive(endBound)) {
                this.initializeArrayElementsDoubleNumbersEntered(array.getArray(), DefaultValuesOfArray.DEFAULT_START_BOUND, endBound, this.reader);
            } else {
                this.initializeArrayElementsDoubleNumbersEntered(array.getArray(), DefaultValuesOfArray.DEFAULT_START_BOUND, DefaultValuesOfArray.DEFAULT_DOUBLE_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(
                    new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return array;
    }

    @Override
    public Double[] fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsDoubleNumbersEntered(doubles, DefaultValuesOfArray.DEFAULT_START_BOUND, bound, this.reader);
            } else {
                this.initializeArrayElementsDoubleNumbersEntered(doubles, DefaultValuesOfArray.DEFAULT_START_BOUND, DefaultValuesOfArray.DEFAULT_DOUBLE_BOUND, this.reader);
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
            if (checkBoundValueIsPositive(bound)) {
                doubles = new Double[lengthArray];
                this.initializeArrayElementsDoubleNumbersEntered(doubles, DefaultValuesOfArray.DEFAULT_START_BOUND, bound, this.reader);
            } else {
                doubles = new Double[lengthArray];
                this.initializeArrayElementsDoubleNumbersEntered(doubles, DefaultValuesOfArray.DEFAULT_START_BOUND, DefaultValuesOfArray.DEFAULT_DOUBLE_BOUND, this.reader);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsDoubleNumbersEntered(doubles, DefaultValuesOfArray.DEFAULT_START_BOUND, DefaultValuesOfArray.DEFAULT_DOUBLE_BOUND, this.reader);
        }
        return doubles;
    }

    @Override
    public Array<Double> fill(final Array<Double> array, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                this.initializeArrayElementsDoubleNumbersEntered(array.getArray(), minBound, maxBound, this.reader);
            } else {
                this.initializeArrayElementsDoubleNumbersEntered(array.getArray(), DefaultValuesOfArray.DEFAULT_DOUBLE_MIN_BOUND, DefaultValuesOfArray.DEFAULT_DOUBLE_MAX_BOUND, this.reader);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The object of the class Array<T> passed by the parameter is null."));
        }
        return null;
    }

    @Override
    public Double[] fill(Double[] doubles, Double minBound, Double maxBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                this.initializeArrayElementsDoubleNumbersEntered(doubles, minBound, maxBound, this.reader);
            } else {
                this.initializeArrayElementsDoubleNumbersEntered(doubles, DefaultValuesOfArray.DEFAULT_DOUBLE_MIN_BOUND, DefaultValuesOfArray.DEFAULT_DOUBLE_MAX_BOUND, this.reader);
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
            if (checkStartBoundValueLessThanEndBoundValue(minBound, maxBound)) {
                doubles = new Double[lengthArray];
                this.initializeArrayElementsDoubleNumbersEntered(doubles, minBound, maxBound, this.reader);
            } else {
                doubles = new Double[lengthArray];
                this.initializeArrayElementsDoubleNumbersEntered(doubles, DefaultValuesOfArray.DEFAULT_DOUBLE_MIN_BOUND, DefaultValuesOfArray.DEFAULT_DOUBLE_MAX_BOUND, this.reader);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsDoubleNumbersEntered(doubles, DefaultValuesOfArray.DEFAULT_DOUBLE_MIN_BOUND, DefaultValuesOfArray.DEFAULT_DOUBLE_MAX_BOUND, this.reader);
        }
        return doubles;
    }

    private void initializeArrayElementsDoubleNumbersEntered(final Double[] doubles, final double minBound, final double maxBound, final Reader reader) {
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
