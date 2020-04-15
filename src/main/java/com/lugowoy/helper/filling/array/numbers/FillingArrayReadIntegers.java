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

/**
 * The class provides the functionality to fill the class objects {@link Array} and
 * arrays of the type {@link Integer} with the read numeric data of the type {@link Integer}.
 * Thereby the class implements the interface contract {@link FillingArrayNumbers}.
 * <p> To see the functionality of read numeric data can in the class {@link Reader} and the interface {@link Reading}.
 * <p> Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 2.2
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.array.FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
public class FillingArrayReadIntegers extends FillingArrayReadValues<Integer> implements FillingArrayNumbers<Integer> {

    /**
     * Constructs a new object, initializing the implementation of reading numeric data of the type {@link Integer} to fill
     * the class objects {@link Array} and arrays of the type {@link Integer}.
     * The implementation of data reading provided by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    public FillingArrayReadIntegers(Reader reader) {
        super(reader);
    }

    /**
     * Constructs a new object, initializing the implementation of reading numeric data of the type {@link Integer} to fill
     * the class objects {@link Array} and arrays of the type {@link Integer}.
     * The implementation of reading data provided by classes objects that implementation the {@link Reading} interface.
     *
     * @param reading the object implementation of reading data to fill.
     */
    public FillingArrayReadIntegers(Reading reading) {
        super(reading);
    }

    /**
     * Fills the {@code array} object with the read numeric data of the type {@link Integer}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array the object of the {@link Array} class to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Array<Integer> array) {
        CheckerArray.checkLengthInArray(array);
        Integer[] integers = new Integer[array.size()];
        this.fillArray(integers);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with the read numeric data of the type {@link Integer}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param integers the array to fill.
     *
     * @throws NullPointerException if the {@code integers} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Integer[] integers) {
        CheckerArray.checkLengthInArray(integers);
        this.fillArray(integers);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Integer} and
     * fills it with the read numeric data of type {@link Integer}.
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
    @Override
    public Integer[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        Integer[] integers = new Integer[lengthArray];
        this.fillArray(integers);
        return integers;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the type {@link Integer}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(Array<Integer> array, Integer boundValue) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(boundValue, Integer.MAX_VALUE);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayFromZeroToBound(integers, boundValue);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with the read numeric data of the type {@link Integer}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     *
     * @param integers the array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code integers} array is null.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(Integer[] integers, Integer boundValue) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(boundValue, Integer.MAX_VALUE);
        this.fillArrayFromZeroToBound(integers, boundValue);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Integer} and
     * fills it with the read numeric data of type {@link Integer}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @return the array created and filled with data.
     *
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@code boundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} value out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer boundValue) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(boundValue, Integer.MAX_VALUE);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayFromZeroToBound(integers, boundValue);
        return integers;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the type {@link Integer}.
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
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code array} object attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBoundValue, Integer upperBoundValue) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayFromLowerToUpper(integers, lowerBoundValue, upperBoundValue);
        array.setArray(integers);
    }

    /**
     * Fills the {@code integers} array with the read numeric data of the type {@link Integer}.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param integers the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code integers} is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBoundValue, Integer upperBoundValue) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(lowerBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        this.fillArrayFromLowerToUpper(integers, lowerBoundValue, upperBoundValue);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type {@link Integer} and
     * fills it with the read numeric data of type {@link Integer}.
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
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBoundValue} to {@code upperBoundValue}.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} value greater or equal than {@code upperBound} value.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBoundValue, Integer upperBoundValue) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBoundValue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBoundValue, upperBoundValue);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayFromLowerToUpper(integers, lowerBoundValue, upperBoundValue);
        return integers;
    }

    private void fillArray(Integer[] integers) {
        this.fillArrayFromLowerToUpper(integers, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void fillArrayFromZeroToBound(Integer[] integers, int bound) {
        this.fillArrayFromLowerToUpper(integers, ValuesToFilling.INT_ZERO, bound);
    }

    private void fillArrayFromLowerToUpper(Integer[] integers, int lowerBound, int upperBound) {
        for (int i = 0; i < integers.length; i++) {
            int valueRead = super.getReader().readInt();
            CheckerValue.checkValue(valueRead, lowerBound, upperBound);
            integers[i] = valueRead;
        }
    }

}
