package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_ZERO;

/**
 * The class is an inheritor of the {@link FillingArrayReadValues} class and implements the contract declared
 * by the {@link FillingArrayNumbers} interface to fills a classic array and an object of the {@link Array} class
 * with read numerical data of the {@link Double} type.
 * <p>The functionality of reading data of the {@link Double} type from a specific source to fill the array is provided
 * when creating an object of this class with an object of the class as a successor of the {@link Reader} class (implementing the contract
 * of the {@link Reading} interface) or as an object of the class implementing the contract declared in the {@link Reading} interface.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.9
 * @see com.lugowoy.helper.filling.array.FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayReadDoubles extends FillingArrayReadValues<Double> implements FillingArrayNumbers<Double> {

    /**
     * Constructs a new object of this class, initializing it with an object of the {@link Reader} class
     * to read numerical data of the {@link Double} type to fill an array.
     *
     * @param reader The object of {@link Reader} class to read numeric data of the {@link Double} type to fill an array.
     * @throws NullPointerException If the {@code reader} argument is null.
     */
    public FillingArrayReadDoubles(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object of this class, initializing it with an object of the concrete implementation of the contract declared
     * in the interface {@link Reading} to read numerical data of the {@link Double} type to fill an array.
     *
     * @param reading The object of class that implements the {@link Reading} interface to read numerical data of the {@link Double} type to fill array.
     * @throws NullPointerException If the {@code reading} argument is null;
     */
    public FillingArrayReadDoubles(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of the {@link Array} class with read data of the {@link Double} type.
     * <p>Read data of the type {@link Double} must be in the range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * If the read value is not correct {@link Double} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with read data of the {@link Double} type.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws ValueOutOfRangeException If read value is not correct {@link Double} value or out of the valid range values.
     */
    @Override
    public void fill(Array<Double> array) {
        if (CheckerArray.checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            this.fillArrayReadDoubles(doubles);
            array.setArray(doubles);
        }
    }

    /**
     * Fills an array with read data of the {@link Double} type.
     * <p>Read data of the type {@link Double} must be in the range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * If the read value is not correct {@link Double} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     *
     * @param doubles The array to fill with read data of the {@link Double} type.
     * @throws NullPointerException If {@code doubles} argument is null.
     * @throws ValueOutOfRangeException If read value is not correct {@link Double} value or out of the valid range values.
     */
    @Override
    public void fill(Double[] doubles) {
        if (CheckerArray.checkLengthInArray(doubles)) {
            this.fillArrayReadDoubles(doubles);
        }
    }

    /**
     * Fills an array with read data of the {@link Double} type.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     * <p>Read data of the type {@link Double} must be in the range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * If the read value is not correct {@link Double} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with read data of the {@link Double} type.
     * @return Created and filled an array with data of the {@link Double} type.
     * @throws LengthArrayOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws ValueOutOfRangeException If read value is not correct {@link Double} value or out of the valid range values.
     */
    @Override
    public Double[] fill(int lengthArray) {
        Double[] doubles = new Double[0];
        if (CheckerArray.checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            this.fillArrayReadDoubles(doubles);
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with read data of the {@link Double} type.
     * <p>Read data of the type {@link Double} must be in the range from {@link ValuesToFilling#DOUBLE_ZERO}
     * to {@code bound}. If the read value is not correct {@link Double} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown. The value of the {@code bound} argument must be
     * in the range from 0 to {@link Double#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array The object of the {@link Array} class to fill with data of the {@link Double} type.
     * @param bound The upper bound for reading value to fill.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Array<Double> array, Double bound) {
        if (CheckerArray.checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            if (CheckerBound.isCorrectBound(bound, Long.MAX_VALUE)) {
                this.fillArrayReadDoublesFromZeroToPositiveBound(doubles, bound);
                array.setArray(doubles);
            }
        }
    }

    /**
     * Fills an array with read data of the {@link Double} type.
     * <p>Read data of the type {@link Double} must be in the range from {@link ValuesToFilling#DOUBLE_ZERO}
     * to {@code bound}. If the read value is not correct {@link Double} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     * The value of the {@code bound} argument must be in the range from 0 to {@link Double#MAX_VALUE},
     * otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param doubles The array to fill with read data of the {@link Double} type.
     * @param bound The upper bound for reading value to fill.
     * @throws NullPointerException If the {@code doubles} argument is null.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public void fill(Double[] doubles, Double bound) {
        if (CheckerArray.checkLengthInArray(doubles)) {
            if (CheckerBound.isCorrectBound(bound,Long.MAX_VALUE)) {
                this.fillArrayReadDoublesFromZeroToPositiveBound(doubles, bound);
            }
        }
    }

    /**
     * Fills an array with read data of the {@link Double} type.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     * <p>Read data of the type {@link Double} must be in the range from {@link ValuesToFilling#DOUBLE_ZERO}
     * to {@code bound}. If the read value is not correct {@link Double} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown. The value of the {@code bound} argument must be
     * in the range from 0 to {@link Double#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with read data of the {@link Double} type.
     * @param bound The upper bound for reading value to fill.
     * @throws LengthArrayOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        Double[] doubles = new Double[0];
        if (CheckerArray.checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (CheckerBound.isCorrectBound(bound, Long.MAX_VALUE)) {
                this.fillArrayReadDoublesFromZeroToPositiveBound(doubles, bound);
            }
        }
        return doubles;
    }

    /**
     * Fills an object of the {@link Array} class with read data of the {@link Double} type.
     * <p>Read data of the type {@link Double} must be in the range from {@code lowerBound} to {@code upperBound}.
     * If the read value is not correct {@link Double} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     * The value of the {@code lowerBound} and {@code upperBound} arguments must be in the range from {@link Double#MIN_VALUE}
     * to {@link Double#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param array      The object of the {@link Array} class to fill with read data of the {@link Double} type.
     * @param lowerBound The lower bound for reading to fill.
     * @param upperBound The upper bound for reading to fill.
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     * @throws BoundOutOfRangeException If the {@code lowerBound} or {@code upperBound} argument values is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Array<Double> array, Double lowerBound, Double upperBound) {
        if (CheckerArray.checkLengthInArray(array)) {
            Double[] doubles = new Double[array.size()];
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayReadDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                    array.setArray(doubles);
                }
            }
        }
    }

    /**
     * Fills an array with read data of the {@link Double} type.
     * <p>Read data of the type {@link Double} must be in the range from {@code lowerBound} to {@code upperBound}.
     * If the read value is not correct {@link Double} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     * The value of the {@code lowerBound} and {@code upperBound} arguments must be in the range from {@link Double#MIN_VALUE}
     * to {@link Double#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param doubles The array to fill with read data of the {@link Double} type.
     * @param lowerBound The lower bound for reading value to fill.
     * @param upperBound The upper bound for reading value to fill.
     * @throws NullPointerException If the {@code doubles} argument is null.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public void fill(Double[] doubles, Double lowerBound, Double upperBound) {
        if (CheckerArray.checkLengthInArray(doubles)) {
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayReadDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
    }

    /**
     * Fills an array with read data of the {@link Double} type.
     * <p>The array is created based on the {@code lengthArray} argument.
     * If the value of {@code lengthArray} is less than 0 or is greatest than {@link Integer#MAX_VALUE}(inclusive),
     * then a {@link LengthArrayOutOfRangeException} exception will be thrown.
     * <p>Read data of the type {@link Double} must be in the range from {@code lowerBound} to {@code upperBound}.
     * If the read value is not correct {@link Double} value or out of the valid range of values,
     * then a {@link ValueOutOfRangeException} exception will be thrown.
     * The value of the {@code lowerBound} and {@code upperBound} arguments must be in the range from {@link Double#MIN_VALUE}
     * to {@link Double#MAX_VALUE}, otherwise a {@link BoundOutOfRangeException} exception will be thrown.
     *
     * @param lengthArray The length(size) of the array to fill with read data of the {@link Double} type.
     * @param lowerBound The lower bound for reading value to fill.
     * @param upperBound The upper bound for reading value to fill.
     * @throws LengthArrayOutOfRangeException If {@code lengthArray} argument value is out of valid range.
     * @throws ValueOutOfRangeException If the read value is not correct or out of the valid range.
     * @throws BoundOutOfRangeException If the {@code bound} argument value is out of valid range.
     * @throws BoundOutOfRangeException If the {@code lowerBound} value is greater or not equal than to the {@code upperBound} value.
     */
    @Override
    public Double[] fill(int lengthArray, Double lowerBound, Double upperBound) {
        Double[] doubles = new Double[0];
        if (CheckerArray.checkLengthArray(lengthArray)) {
            doubles = new Double[lengthArray];
            if (CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE)
                    && CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE)) {
                if (CheckerBound.isLowerBoundLessOrEqualThanUpperBound(lowerBound, upperBound)) {
                    this.fillArrayReadDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
                }
            }
        }
        return doubles;
    }

    private void fillArrayReadDoubles(Double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = super.getReader().readDouble();
        }
    }

    private void fillArrayReadDoublesFromZeroToPositiveBound(Double[] doubles, double bound) {
        for (int i = 0; i < doubles.length; i++) {
            double valueRead = super.getReader().readDouble();
            if (valueRead >= DOUBLE_ZERO && valueRead <= bound) {
                doubles[i] = valueRead;
            } else {
                String msgEx = "Value is not a double number or is out of range (from 0.0 to " + bound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

    private void fillArrayReadDoublesFromLowerBoundToUpperBound(Double[] doubles, double lowerBound, double upperBound) {
        for (int i = 0; i < doubles.length; i++) {
            double valueRead = super.getReader().readDouble();
            if (valueRead >= lowerBound && valueRead <= upperBound) {
                doubles[i] = valueRead;
            } else {
                String msgEx = "Value is not a double number or is out of range (from " + lowerBound +" to " + upperBound + ").";
                throw new ValueOutOfRangeException(msgEx);
            }
        }
    }

}
