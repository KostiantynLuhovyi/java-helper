package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.FillingReadValues;
import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsCompareException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerValue;

/**
 * The class provides the functionality to fill the class objects {@link ArrayDoubles} and
 * arrays of the double type with the read numeric data of the double type.
 * Thereby the class implements the interface contract {@link FillingArrayNumbers}.
 * <p> To see the functionality of read numeric data can in the class {@link Reader} and the interface {@link Reading}.
 * <p> Created by Konstantin Lugowoy on 23.03.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @since 3.0
 */
public class FillingArrayReadPrimitiveDoubles extends FillingReadValues {

    /**
     * Constructs a new object, initializing the implementation of reading numeric data of the double type to fill
     * the class objects {@link ArrayDoubles} and arrays of the double type.
     * The implementation of data reading provided by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    public FillingArrayReadPrimitiveDoubles(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object, initializing the implementation of reading numeric data of the double type to fill
     * the class objects {@link ArrayDoubles} and arrays of the double type.
     * The implementation of reading data provided by classes objects that implementation the {@link Reading} interface.
     *
     * @param reading the object implementation of reading data to fill.
     */
    public FillingArrayReadPrimitiveDoubles(Reading reading) {
        super(reading);
    }

    /**
     * Fills the {@code array} object with the read numeric data of the double type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param array the object of the {@link ArrayDoubles} class to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public void fill(ArrayDoubles array) {
        CheckerArray.checkLengthInArray(array);
        double[] doubles = new double[array.size()];
        this.fillArray(doubles);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with the read numeric data of the double type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param doubles the array to fill.
     *
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public void fill(double[] doubles) {
        CheckerArray.checkLengthInArray(doubles);
        this.fillArray(doubles);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the double type and
     * fills it with the read numeric data of double type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public double[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        double[] doubles = new double[lengthArray];
        this.fillArray(doubles);
        return doubles;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the double type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@code boundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    public void fill(ArrayDoubles array, double boundValue) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(boundValue, Long.MAX_VALUE);
        double[] doubles = new double[array.size()];
        this.fillArrayFromZeroToBound(doubles, boundValue);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with the read numeric data of the double type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#DOUBLE_ZERO} to {@code bound}.
     *
     * @param doubles the array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@code boundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    public void fill(double[] doubles, double boundValue) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(boundValue, Long.MAX_VALUE);
        this.fillArrayFromZeroToBound(doubles, boundValue);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the double type and
     * fills it with the read numeric data of double type.
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
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@code boundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#DOUBLE_ZERO} to {@link Long#MAX_VALUE}.
     */
    public double[] fill(int lengthArray, double boundValue) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(boundValue, Long.MAX_VALUE);
        double[] doubles = new double[lengthArray];
        this.fillArrayFromZeroToBound(doubles, boundValue);
        return doubles;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the double type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link ArrayDoubles} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    public void fill(ArrayDoubles array, double lowerBoundValue, double upperBoundValue) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBoundValue, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        double[] doubles = new double[array.size()];
        this.fillArrayFromLowerToUpper(doubles, lowerBoundValue, upperBoundValue);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with the read numeric data of the double type.
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
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code doubles} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    public void fill(double[] doubles, double lowerBoundValue, double upperBoundValue) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(lowerBoundValue, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        this.fillArrayFromLowerToUpper(doubles, lowerBoundValue, upperBoundValue);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the double type and
     * fills it with the read numeric data of double type.
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
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Long#MIN_VALUE} to {@link Long#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    public double[] fill(int lengthArray, double lowerBoundValue, double upperBoundValue) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBoundValue, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        double[] doubles = new double[lengthArray];
        this.fillArrayFromLowerToUpper(doubles, lowerBoundValue, upperBoundValue);
        return doubles;
    }

    private void fillArray(double[] doubles) {
        this.fillArrayFromLowerToUpper(doubles, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private void fillArrayFromZeroToBound(double[] doubles, double boundValue) {
        this.fillArrayFromLowerToUpper(doubles, ValuesToFilling.DOUBLE_ZERO, boundValue);
    }

    private void fillArrayFromLowerToUpper(double[] doubles, double lowerBoundValue, double upperBoundValue) {
        for (int i = 0; i < doubles.length; i++) {
            double valueRead = super.getReader().readDouble();
            CheckerValue.checkValue(valueRead, lowerBoundValue, upperBoundValue);
            doubles[i] = valueRead;
        }
    }

}
