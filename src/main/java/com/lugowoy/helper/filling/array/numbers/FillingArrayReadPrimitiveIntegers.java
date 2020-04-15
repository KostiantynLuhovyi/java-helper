package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.FillingReadValues;
import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsCompareException;
import com.lugowoy.helper.utils.LengthArrayOutOfRangeException;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;
import com.lugowoy.helper.utils.checking.CheckerValue;

/**
 * The class provides the functionality to fill the class objects {@link ArrayInts} and
 * arrays of the int type with the read numeric data of the int type.
 * <p> To see the functionality of read numeric data can in the class {@link Reader} and the interface {@link Reading}.
 * <p> Created by Konstantin Lugowoy on 23.03.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @since 3.0
 */
public class FillingArrayReadPrimitiveIntegers extends FillingReadValues {

    /**
     * Constructs a new object, initializing the implementation of reading numeric data of the int type to fill
     * the class objects {@link ArrayInts} and arrays of the int type.
     * The implementation of data reading provided by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    public FillingArrayReadPrimitiveIntegers(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object, initializing the implementation of reading numeric data of the int type to fill
     * the class objects {@link ArrayInts} and arrays of the int type.
     * The implementation of reading data provided by classes objects that implementation the {@link Reading} interface.
     *
     * @param reading the object implementation of reading data to fill.
     */
    public FillingArrayReadPrimitiveIntegers(Reading reading) {
        super(reading);
    }

    /**
     * Fills the {@code array} object with the read numeric data of the int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public void fill(ArrayInts array) {
        CheckerArray.checkLengthInArray(array);
        int[] ints = new int[array.size()];
        this.fillArray(ints);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with the read numeric data of the int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param ints the array to fill.
     *
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws LengthArrayOutOfRangeException if the {@code ints} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public void fill(int[] ints) {
        CheckerArray.checkLengthInArray(ints);
        this.fillArray(ints);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type and
     * fills it with the read numeric data of int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    public int[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        int[] ints = new int[lengthArray];
        this.fillArray(ints);
        return ints;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @param boundValue the positive upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    public void fill(ArrayInts array, int boundValue) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(boundValue, Integer.MAX_VALUE);
        int[] ints = new int[array.size()];
        this.fillArrayFromZeroToBound(ints, boundValue);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with the read numeric data of the int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     *
     * @param ints the array to fill.
     * @param boundValue the positive upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code ints} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    public void fill(int[] ints, int boundValue) {
        CheckerArray.checkLengthInArray(ints);
        CheckerBound.isCorrectBound(boundValue, Integer.MAX_VALUE);
        this.fillArrayFromZeroToBound(ints, boundValue);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type and
     * fills it with the read numeric data of int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param boundValue the positive upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    public int[] fill(int lengthArray, int boundValue) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(boundValue, Integer.MAX_VALUE);
        int[] ints = new int[lengthArray];
        this.fillArrayFromZeroToBound(ints, boundValue);
        return ints;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@code lowerBoundValue} to {@code upperBoundValue}.
     *
     * @param array the object of the {@link ArrayInts} class to fill.
     * @param lowerBoundValue the lower bound numeric value to fill.
     * @param upperBoundValue the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBoundValue} value greater or equal than {@code upperBoundValue} value.
     */
    public void fill(ArrayInts array, int lowerBoundValue, int upperBoundValue) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBoundValue, upperBoundValue);
        int[] ints = new int[array.size()];
        this.fillArrayFromLowerToUpper(ints, lowerBoundValue, upperBoundValue);
        array.setArray(ints);
    }

    /**
     * Fills the {@code ints} array with the read numeric data of the int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@code lowerBoundValue} to {@code upperBoundValue}.
     *
     * @param ints the array to fill.
     * @param lowerBoundValue the lower bound numeric value to fill.
     * @param upperBoundValue the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code ints} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code ints} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBoundValue} value greater or equal than {@code upperBoundValue} value.
     */
    public void fill(int[] ints, int lowerBoundValue, int upperBoundValue) {
        CheckerArray.checkLengthInArray(ints);
        CheckerBound.isCorrectBound(lowerBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBoundValue, upperBoundValue);
        this.fillArrayFromLowerToUpper(ints, lowerBoundValue, upperBoundValue);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the int type and
     * fills it with the read numeric data of int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@code lowerBoundValue} to {@code upperBoundValue}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBoundValue the lower bound numeric value to fill.
     * @param upperBoundValue the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBoundValue} value greater or equal than {@code upperBoundValue} value.
     */
    public int[] fill(int lengthArray, int lowerBoundValue, int upperBoundValue) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBoundValue, upperBoundValue);
        int[] ints = new int[lengthArray];
        this.fillArrayFromLowerToUpper(ints, lowerBoundValue, upperBoundValue);
        return ints;
    }

    private void fillArray(int[] ints) {
        this.fillArrayFromLowerToUpper(ints, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void fillArrayFromZeroToBound(int[] ints, int boundValue) {
        this.fillArrayFromLowerToUpper(ints, ValuesToFilling.INT_ZERO, boundValue);
    }

    private void fillArrayFromLowerToUpper(int[] ints, int lowerBoundValue, int upperBoundValue) {
        for (int i = 0; i < ints.length; i++) {
            int valueRead = super.getReader().readInt();
            CheckerValue.checkValue(valueRead, lowerBoundValue, upperBoundValue);
            ints[i] = valueRead;
        }
    }

}
