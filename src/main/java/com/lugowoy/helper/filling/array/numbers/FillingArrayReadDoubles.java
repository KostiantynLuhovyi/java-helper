package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsCompareException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerValue;

import static com.lugowoy.helper.filling.ValuesToFilling.DOUBLE_ZERO;

/**
 * The class provides the functionality to fill the class objects {@link Array} and
 * arrays of the type {@link Double} with the read numeric data of the type {@link Double}.
 * Thereby the class implements the interface contract {@link FillingArrayNumbers}.
 * <p> To see the functionality of read numeric data can in the class {@link Reader} and the interface {@link Reading}.
 * <p> Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 2.1
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.array.FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayReadDoubles extends FillingArrayReadValues<Double> implements FillingArrayNumbers<Double> {

    /**
     * Constructs a new object, initializing the implementation of reading numeric data of the type {@link Double} to fill
     * the class objects {@link Array} and arrays of the type {@link Double}.
     * The implementation of data reading provided by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    public FillingArrayReadDoubles(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object, initializing the implementation of reading numeric data of the type {@link Double} to fill
     * the class objects {@link Array} and arrays of the type {@link Double}.
     * The implementation of reading data provided by classes objects that implementation the {@link Reading} interface.
     *
     * @param reading the object implementation of reading data to fill.
     */
    public FillingArrayReadDoubles(Reading reading) {
        super(reading);
    }

    /**
     * Fills the {@code array} object with the read numeric data of the type {@link Double}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param array the object of the {@link Array} class to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Array<Double> array) {
        CheckerArray.checkLengthInArray(array);
        Double[] doubles = new Double[array.size()];
        this.fillArrayReadDoubles(doubles);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with the read numeric data of the type {@link Double}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param doubles the array to fill.
     *
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Double[] doubles) {
        CheckerArray.checkLengthInArray(doubles);
        this.fillArrayReadDoubles(doubles);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Double} and
     * fills it with the read numeric data of type {@link Double}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public Double[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        Double[] doubles = new Double[lengthArray];
        this.fillArrayReadDoubles(doubles);
        return doubles;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the type {@link Double}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    @Override
    public void fill(Array<Double> array, Double bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Double[] doubles = new Double[array.size()];
        this.fillArrayReadDoublesFromZeroToPositiveBound(doubles, bound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with the read numeric data of the type {@link Double}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param doubles the array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    @Override
    public void fill(Double[] doubles, Double bound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        this.fillArrayReadDoublesFromZeroToPositiveBound(doubles, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Double} and
     * fills it with the read numeric data of type {@link Double}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        Double[] doubles = new Double[lengthArray];
        this.fillArrayReadDoublesFromZeroToPositiveBound(doubles, bound);
        return doubles;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the type {@link Double}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    @Override
    public void fill(Array<Double> array, Double lowerBound, Double upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Double[] doubles = new Double[array.size()];
        this.fillArrayReadDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with the read numeric data of the type {@link Double}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param doubles the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code doubles} is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    @Override
    public void fill(Double[] doubles, Double lowerBound, Double upperBound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillArrayReadDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Double} and
     * fills it with the read numeric data of type {@link Double}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws NullPointerException if any of the boundary values is null.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    @Override
    public Double[] fill(int lengthArray, Double lowerBound, Double upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Double[] doubles = new Double[lengthArray];
        this.fillArrayReadDoublesFromLowerToUpperBounds(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillArrayReadDoubles(Double[] doubles) {
        this.fillArrayReadDoublesFromLowerToUpperBounds(doubles, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private void fillArrayReadDoublesFromZeroToPositiveBound(Double[] doubles, double bound) {
        this.fillArrayReadDoublesFromLowerToUpperBounds(doubles, DOUBLE_ZERO, bound);
    }

    private void fillArrayReadDoublesFromLowerToUpperBounds(Double[] doubles, double lowerBound, double upperBound) {
        for (int i = 0; i < doubles.length; i++) {
            double valueRead = super.getReader().readDouble();
            CheckerValue.checkValue(valueRead, lowerBoundValue, upperBoundValue);
            doubles[i] = valueRead;
        }
    }

}
