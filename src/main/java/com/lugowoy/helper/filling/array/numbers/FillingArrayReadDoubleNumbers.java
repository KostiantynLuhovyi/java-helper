package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.DefaultValuesOfArray;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.arrays.Array;

import static com.lugowoy.helper.filling.array.DefaultValuesOfArray.*;
import static com.lugowoy.helper.filling.array.FillingArrayChecker.*;
import static com.lugowoy.helper.models.arrays.Array.DEFAULT_LENGTH_ARRAY;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 *
 * The class provides functionality to fill an object of the {@link Array} class and classical arrays
 * with data of the {@link Double} type with read by the {@link Reader} class object
 * encapsulated in the parent class {@link FillingArrayReadValues}.
 * The class is the heir of the {@link FillingArrayReadValues} class and implements it's contract.
 * Also implements the contract declared by the {@link FillingArrayNumbers} interface.
 *
 * @see FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */

public class FillingArrayReadDoubleNumbers extends FillingArrayReadValues<Double> implements FillingArrayNumbers<Double> {

    /**
     * Constructs a new object of {@link FillingArrayReadDoubleNumbers} class,
     *  initializing an object of {@link Reader} class
     *  encapsulated in the parent class to read data of the {@link Double} type to be fill array.
     *
     * @param reader The object of {@link Reader} class for initializing an object {@link Reader} class
     *               encapsulated in the parent class to read data of the {@link Double} type to fill the array.
     */
    public FillingArrayReadDoubleNumbers(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object of {@link FillingArrayReadDoubleNumbers} class,
     *  initializing an object of {@link Reader} class
     *  encapsulated in the parent class of the concrete implementation of the contract declared in the interface {@link Reading}
     *  to read data of the {@link Double} type to be fill array.
     *
     * @param reading The object of class that implements the {@link Reading} interface
     *                to initialize an object of the {@link Reader} class encapsulated in the parent class
     *                to read data of the {@link Double} type to be fill array.
     */
    public FillingArrayReadDoubleNumbers(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of the {@link Array} class with data of the {@link Double} type
     * with read by the {@link Reader} class object.
     *
     * @param array The object of the {@link Array} class to be filled with data of the {@link Double} type
     *              with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If object argument is null.
     */
    @Override
    public void fill(Array<Double> array) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            Double[] doubles = new Double[array.getLength()];
            this.initializeArrayElementsEnteredDoubleNumbers(doubles);
            array.setArray(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     *
     * @param doubles The array to be filled with data of the {@link Double} type
     *                with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            this.initializeArrayElementsEnteredDoubleNumbers(doubles);
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the {@link Double} type
     *                    with read by the {@link Reader} class object.
     * @return Created and filled array with data of the {@link Double} type with read by the {@link Reader} class object.
     */
    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            this.initializeArrayElementsEnteredDoubleNumbers(doubles);
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsEnteredDoubleNumbers(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The object of the {@link Array} class is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND}
     *
     * @param array The object of the {@link Array} class to be filled with data of the {@link Double} type
     *              with read by the {@link Reader} class object.
     * @param bound The value of the bound for filling an object of the {@link Array} class with data of the {@link Double} type
     *              with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, bound);
                array.setArray(doubles);
            } else {
                this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
                array.setArray(doubles);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     *  then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param doubles The array to be filled with data of the {@link Double} type with read by the {@link Reader} class object.
     * @param bound The value of the end bound for filling an array with data of the {@link Double} type
     *              with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double bound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter "lengthArray" determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767",
     * created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data from "0" to the value of the "bound" parameter.
     * If the value of the "bound" argument is a negative number,
     * then the range value for filling the array from "0" to {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND}.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the {@link Double} type
     *                    with read by the {@link Reader} class object.
     * @param bound The value of the border for filling the array with data of the {@link Double} type
     *              with read by the {@link Reader} class object.
     * @return Created and filled an array with data of the {@link Double} type with read by the {@link Reader} class object.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (checkBoundValueIsPositive(bound)) {
                this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, bound);
            } else {
                this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(doubles, DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The object of the {@link Array} class is filled with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768,
     *  then the values {@link DefaultValuesOfArray#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     *  and {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param array The object of the {@link Array} class that must be filled with data of the {@link Double} type
     *              with read by the {@link Reader} class object.
     * @param startBound The value of the start bound for filling an object of the {@link Array} class
     *                   with data of the {@link Double} type with read by the {@link Reader} class object.
     * @param endBound The value of the end bound for filling an object of the {@link Array} class with
     *                 data of the {@link Double} type with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the object argument is null.
     */
    @Override
    public void fill(Array<Double> array, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayObject(array)) {
            Double[] doubles = new Double[array.getLength()];
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                        && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
                array.setArray(doubles);
            } else {
                this.initializeArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                         DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                         DEFAULT_DOUBLE_POSITIVE_BOUND);
                array.setArray(doubles);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument object is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is filled with numeric data from "startBound" to the value of the "endBound" parameter.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768,
     *  then the values {@link DefaultValuesOfArray#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     *  and {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param doubles The array to be filled with data of the {@link Double} type with read by the {@link Reader} class object.
     * @param startBound The value of the start bound for filling an array with data of the {@link Double} type
     *                   with read by the {@link Reader} class object.
     * @param endBound The value of the end bound for filling an array with data of the {@link Double} type
     *                 with read by the {@link Reader} class object.
     * @throws IllegalArgumentException If the array argument is null.
     */
    @Override
    public void fill(Double[] doubles, Double startBound, Double endBound) throws IllegalArgumentException {
        if (checkNonNullArrayNumbers(doubles)) {
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.initializeArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                         DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                         DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("The argument array is null."));
        }
    }

    /**
     * Fills an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * <p>The array is created based on the "lengthArray" parameter.
     * The parameter determines the length(size) of the created array.
     * If the value of "lengthArray" is less than "0" or is greatest than "32767", created array of length {@link Array#DEFAULT_LENGTH_ARRAY}.
     * <p>The array is filled with numeric data from the value "startBound" to the value of the "endBound" parameters.
     * If the value of the argument "startBound" is greater than the value of "endBound"
     *  or if one of the arguments is in the range from -32768 to 32768, then the values {@link DefaultValuesOfArray#DEFAULT_DOUBLE_NEGATIVE_BOUND}
     *  and {@link DefaultValuesOfArray#DEFAULT_DOUBLE_POSITIVE_BOUND} respectively.
     *
     * @param lengthArray The length(size) of the array to be filled with data of the {@link Double} type
     *                    with read by the {@link Reader} class object.
     * @param startBound The value of the start bound for filling an array with data of the {@link Double} type
     *                   with read by the {@link Reader} class object.
     * @param endBound The value of the end bound for filling an array with data of the {@link Double} type
     *                 with read by the {@link Reader} class object.
     * @return Created and filled an array with data of the {@link Double} type with read by the {@link Reader} class object.
     * */
    @Override
    public Double[] fill(int lengthArray, Double startBound, Double endBound) {
        Double[] doubles;
        if (checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (checkStartBoundValueLessThanEndBoundValue(startBound, endBound)
                    && (checkBoundValueIsInCorrectRange(startBound) && checkBoundValueIsInCorrectRange(endBound))) {
                this.initializeArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles, startBound, endBound);
            } else {
                this.initializeArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                         DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                         DEFAULT_DOUBLE_POSITIVE_BOUND);
            }
        } else {
            doubles = new Double[DEFAULT_LENGTH_ARRAY];
            this.initializeArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(doubles,
                                                                                     DEFAULT_DOUBLE_NEGATIVE_BOUND,
                                                                                     DEFAULT_DOUBLE_POSITIVE_BOUND);
        }
        return doubles;
    }

    private void initializeArrayElementsEnteredDoubleNumbers(Double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = super.getReader().readDouble();
        }
    }

    private void initializeArrayElementsEnteredDoubleNumbersFromZeroToPositiveBound(Double[] doubles, double bound) {
        double value;
        for (int i = 0; i < doubles.length; i++) {
            value = super.getReader().readDouble();
            if ((value >= DEFAULT_START_BOUND) && (value <= bound)) {
                doubles[i] = value;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

    private void initializeArrayElementsEnteredDoubleNumbersFromStartBoundToEndBound(Double[] doubles,
                                                                                     double startBound,
                                                                                     double endBound) {
        double value;
        for (int i = 0; i < doubles.length; i++) {
            value = super.getReader().readDouble();
            if ((value >= startBound) && (value <= endBound)) {
                doubles[i] = value;
            } else {
                doubles[i] = DEFAULT_DOUBLE_VALUE;
            }
        }
    }

}
