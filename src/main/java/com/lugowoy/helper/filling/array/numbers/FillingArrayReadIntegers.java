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

import static com.lugowoy.helper.filling.ValuesToFilling.INT_ZERO;

/**
 * The class implements the functionality to fill the class objects {@link Array} and
 * arrays of the type {@link Integer} with the read numeric data of the type {@link Integer}.
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
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Array<Integer> array) {
        CheckerArray.checkLengthInArray(array);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayReadIntegers(integers);
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
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public void fill(Integer[] integers) {
        CheckerArray.checkLengthInArray(integers);
        this.fillArrayReadIntegers(integers);
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
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayReadIntegers(integers);
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
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(Array<Integer> array, Integer bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayReadIntegersFromZeroToPositiveBound(integers, bound);
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
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public void fill(Integer[] integers, Integer bound) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        this.fillArrayReadIntegersFromZeroToPositiveBound(integers, bound);
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
     * @throws NullPointerException if the {@code bound} value is null.
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@link Integer#MAX_VALUE}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayReadIntegersFromZeroToPositiveBound(integers, bound);
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
     * @throws LengthArrayOutOfRangeException if the {@code array} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    @Override
    public void fill(Array<Integer> array, Integer lowerBound, Integer upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Integer[] integers = new Integer[array.size()];
        this.fillArrayReadIntegersFromLowerToUpperBounds(integers, lowerBound, upperBound);
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
     * @throws LengthArrayOutOfRangeException if the {@code integers} array attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    @Override
    public void fill(Integer[] integers, Integer lowerBound, Integer upperBound) {
        CheckerArray.checkLengthInArray(integers);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        this.fillArrayReadIntegersFromLowerToUpperBounds(integers, lowerBound, upperBound);
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
     * @throws LengthArrayOutOfRangeException if the {@code lengthArray} value out of range
     * ​​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    @Override
    public Integer[] fill(int lengthArray, Integer lowerBound, Integer upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessUpperBound(lowerBound, upperBound);
        Integer[] integers = new Integer[lengthArray];
        this.fillArrayReadIntegersFromLowerToUpperBounds(integers, lowerBound, upperBound);
        return integers;
    }

    private void fillArrayReadIntegers(Integer[] integers) {
        this.fillArrayReadIntegersFromLowerToUpperBounds(integers, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void fillArrayReadIntegersFromZeroToPositiveBound(Integer[] integers, int bound) {
        this.fillArrayReadIntegersFromLowerToUpperBounds(integers, INT_ZERO, bound);
    }

    private void fillArrayReadIntegersFromLowerToUpperBounds(Integer[] integers, int lowerBound, int upperBound) {
        for (int i = 0; i < integers.length; i++) {
            int valueRead = super.getReader().readInt();
            checkReadIntValue(valueRead, lowerBound, upperBound);
            integers[i] = valueRead;
        }
    }

    private static void checkReadIntValue(int value, int lowerValue, int upperValue) {
        if (value < lowerValue || value > upperValue) {
            String msgEx = "Value out of range (" + lowerValue + " - " + upperValue + ")";
            throw new ValueOutOfRangeException(msgEx);
        }
    }

}
