package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.DefaultNumericValues;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.BoundOutOfRangeException;
import com.lugowoy.helper.other.IncorrectBoundCompareException;
import com.lugowoy.helper.other.LengthValueOutOfRangeException;
import com.lugowoy.helper.other.ValueOutOfRangeException;

import static com.lugowoy.helper.filling.DefaultNumericValues.INT_ZERO;
import static com.lugowoy.helper.filling.array.CheckerFillingArray.*;

/**
 * The class is an inheritor of the {@link FillingArrayReadValues} class and implements the contract declared
 * by the {@link FillingArrayNumbers} interface to fills a classic array and an object of the {@link Array} class
 * with read numerical data of the {@link Integer} type.
 * <p>The functionality of reading data of the {@link Integer} type from a specific source to fill the array is provided
 * when creating an object of this class with an object of the class as a successor of the {@link Reader} class (implementing the contract
 * of the {@link Reading} interface) or as an object of the class implementing the contract declared in the {@link Reading} interface.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.7
 * @see com.lugowoy.helper.filling.array.FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayReadIntegers extends FillingArrayReadValues<Integer> implements FillingArrayNumbers<Integer> {

    /**
     * Constructs a new object of this class, initializing it with an object of the {@link Reader} class
     * to read numerical data of the {@link Integer} type to fill an array.
     *
     * @param reader The object of {@link Reader} class to read numeric data of the {@link Integer} type to fill an array.
     * @throws NullPointerException If the {@code reader} argument is null.
     */
    public FillingArrayReadIntegers(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object of this class, initializing it with an object of the concrete implementation of the contract declared
     * in the interface {@link Reading} to read numerical data of the {@link Integer} type to fill an array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to read numerical data of the {@link Integer} type to fill array.
     * @throws NullPointerException If the {@code reading} argument is null;
     */
    public FillingArrayReadIntegers(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of the {@link Array} class with read data of the {@link Integer} type.
     * <p>Read data of the type {@link Integer} must be in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * If the read value is not correct {@link Integer} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with read data of the {@link Integer} type.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws ValueOutOfRangeException If read value is not correct {@link Integer} value or out of the valid range values.
     */
    @Override
    public void fill(Array<Integer> array) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            this.fillArrayReadIntegers(integers);
            array.setArray(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with read data of the {@link Integer} type.
     * <p>Read data of the type {@link Integer} must be in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * If the read value is not correct {@link Integer} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with read data of the {@link Integer} type.
     * @throws NullPointerException If {@code integers} argument is null.
     * @throws ValueOutOfRangeException If read value is not correct {@link Integer} value or out of the valid range values.
     */
    @Override
    public void fill(Integer[] integers) {
        if (isNonNullArray(integers)) {
            this.fillArrayReadIntegers(integers);
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with read data of the {@link Integer} type.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>Read data of the type {@link Integer} must be in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * If the read value is not correct {@link Integer} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with read data of the {@link Integer} type.
     * @return Created and filled an array with data of the {@link Integer} type.
     * @throws LengthValueOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws ValueOutOfRangeException If read value is not correct {@link Integer} value or out of the valid range values.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            this.fillArrayReadIntegers(integers);
        } else {
            throw new LengthValueOutOfRangeException("Array length value is out of range." + " (" + lengthArray
                                                                                           + " : valid 0 - " + Integer.MAX_VALUE + ")");
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with read data of the {@link Integer} type.
     * <p>Read data of the type {@link Integer} must be in the range from {@link DefaultNumericValues#INT_ZERO}
     * to {@code bound}. If the read value is not correct {@link Integer} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown. The value of the {@code bound} argument must be
     * in the range from 0 to {@link Integer#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with data of the {@link Integer} type.
     * @param bound The upper bound for reading value to fill.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isCorrectBounds(bound, INT_ZERO, Integer.MAX_VALUE)) {
                this.fillArrayReadIntegersFromZeroToPositiveBound(integers, bound);
                array.setArray(integers);
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with read data of the {@link Integer} type.
     * <p>Read data of the type {@link Integer} must be in the range from {@link DefaultNumericValues#INT_ZERO}
     * to {@code bound}. If the read value is not correct {@link Integer} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     * The value of the {@code bound} argument must be in the range from 0 to {@link Integer#MAX_VALUE},
     * otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with read data of the {@link Integer} type.
     * @param bound The upper bound for reading value to fill.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) {
        if (isNonNullArray(integers)) {
            if (isCorrectBounds(bound, INT_ZERO, Integer.MAX_VALUE)) {
                this.fillArrayReadIntegersFromZeroToPositiveBound(integers, bound);
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with read data of the {@link Integer} type.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>Read data of the type {@link Integer} must be in the range from {@link DefaultNumericValues#INT_ZERO}
     * to {@code bound}. If the read value is not correct {@link Integer} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown. The value of the {@code bound} argument must be
     * in the range from 0 to {@link Integer#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with read data of the {@link Integer} type.
     * @param bound The upper bound for reading value to fill.
     * @throws LengthValueOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(bound, INT_ZERO, Integer.MAX_VALUE)) {
                this.fillArrayReadIntegersFromZeroToPositiveBound(integers, bound);
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new LengthValueOutOfRangeException("Array length value is out of range." + " (" + lengthArray
                                                                                           + " : valid 0 - " + Integer.MAX_VALUE + ")");
        }
        return integers;
    }

    /**
     * Fills an object of the {@link Array} class with read data of the {@link Integer} type.
     * <p>Read data of the type {@link Integer} must be in the range from {@code lowerBound} to {@code upperBound}.
     * If the read value is not correct {@link Integer} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     * The value of the {@code lowerBound} and {@code upperBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array      The object of the {@link Array} class to fill with read data of the {@link Integer} type.
     * @param lowerBound The lower bound for reading to fill.
     * @param upperBound The upper bound for reading to fill.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws IncorrectBoundCompareException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        if (isNonNullArray(array)) {
            Integer[] integers = new Integer[array.getLength()];
            if (isCorrectBounds(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && isCorrectBounds(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayReadIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                    array.setArray(integers);
                } else {
                    throw new IncorrectBoundCompareException("Lower bound is greatest or not equal than upper bound.");
                }
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with read data of the {@link Integer} type.
     * <p>Read data of the type {@link Integer} must be in the range from {@code lowerBound} to {@code upperBound}.
     * If the read value is not correct {@link Integer} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     * The value of the {@code lowerBound} and {@code upperBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param integers The array to fill with read data of the {@link Integer} type.
     * @param lowerBound The lower bound for reading value to fill.
     * @param upperBound The upper bound for reading value to fill.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        if (isNonNullArray(integers)) {
            if (isCorrectBounds(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && isCorrectBounds(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (isLowerBoundLessThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayReadIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                } else {
                    throw new IncorrectBoundCompareException("Lower bound is greatest or not equal than upper bound.");
                }
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new IllegalArgumentException(new NullPointerException("Array argument is null."));
        }
    }

    /**
     * Fills an array with read data of the {@link Integer} type.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthValueOutOfRangeException} exception will be thrown.
     * <p>Read data of the type {@link Integer} must be in the range from {@code lowerBound} to {@code upperBound}.
     * If the read value is not correct {@link Integer} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     * The value of the {@code lowerBound} and {@code upperBound} arguments must be in the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with read data of the {@link Integer} type.
     * @param lowerBound The lower bound for reading value to fill.
     * @param upperBound The upper bound for reading value to fill.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws LengthValueOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        Integer[] integers;
        if (checkLengthArray(lengthArray)) {
            integers = new Integer[lengthArray];
            if (isCorrectBounds(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE)
                    && isCorrectBounds(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                if (isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayReadIntegersFromLowerBoundToUpperBound(integers, lowerBound, upperBound);
                } else {
                    throw new IncorrectBoundCompareException("Lower bound is greatest or not equal than upper bound.");
                }
            } else {
                throw new BoundOutOfRangeException("Bound value is out of range.");
            }
        } else {
            throw new LengthValueOutOfRangeException("Array length value is out of range." + " (" + lengthArray
                                                                                           + " : valid 0 - " + Integer.MAX_VALUE + ")");
        }
        return integers;
    }

    private void fillArrayReadIntegers(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            int valueRead = super.getReader().readInt();
            integers[i] = valueRead;
        }
    }

    private void fillArrayReadIntegersFromZeroToPositiveBound(Integer[] integers, int bound) {
        for (int i = 0; i < integers.length; i++) {
            int valueRead = super.getReader().readInt();
            if (valueRead >= INT_ZERO && valueRead <= bound) {
                integers[i] = valueRead;
            } else {
                String msgEx = "Value is not a int number or is out of range (from 0 to " + bound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

    private void fillArrayReadIntegersFromLowerBoundToUpperBound(Integer[] integers, int lowerBound, int upperBound) {
        for (int i = 0; i < integers.length; i++) {
            int valueRead = super.getReader().readInt();
            if (valueRead >= lowerBound && valueRead <= upperBound) {
                integers[i] = valueRead;
            } else {
                String msgEx = "Value is not a int number or is out of range (from " + lowerBound + " to " + upperBound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

}
