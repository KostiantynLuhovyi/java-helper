package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingData;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.numbers.DefaultValuesForArrays.*;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 29.07.2017
 * <p>
 * A class that encapsulates the implementation of the interface to filling the array with integer numeric data (values) entered by the user.
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayWithNumbers
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @see com.lugowoy.helper.filling.array.numbers.FillableArrayWithNumbers
 */

public class FillingArrayWithIntegerUserInputNumbers extends FillingArrayWithNumbers<Integer> {

    private Reader reader;

    /**
     * <p>
     * Creation of an object initialized by a specific implementation to the read integer numeric user data.
     * </p>
     * @param readingData An object encapsulating a specific implementation of reading user data.
     */
    public FillingArrayWithIntegerUserInputNumbers(ReadingData readingData) {
        this.reader = new Reader(readingData);
    }


    /**
     * <p>
     * The method fills the array to the integer numeric user data (values).
     * </p>
     * @param array The array to fill the integer numeric user data (values).
     * @return An array filled to the integer numeric user data (values).
     */
    @Override
    public Integer[] fill(Integer[] array) {
        return (array != null) ? Arrays.stream(array)
                                       .mapToInt(value -> this.reader.readInt())
                                       .boxed()
                                       .toArray(Integer[]::new)
                               : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS);
    }

    /**
     * <p>
     * The method fills the array to the integer numeric user data (values). The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling to the integer numeric user data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @return An array created and filled to the integer numeric user data (values).
     */
    @Override
    public Integer[] fill(int lengthArray) {
        return (lengthArray > 0) ? Arrays.stream(new Integer[lengthArray])
                                         .mapToInt(value -> this.reader.readInt())
                                         .boxed()
                                         .toArray(Integer[]::new)
                                 : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS);
    }

    /**
     * <p>
     * The method fills the array to the integer numeric user data (values) in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill to the integer numeric user data (values).
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return An array filled to the integer numeric user data (values).
     */
    @Override
    public Integer[] fill(Integer[] array, Integer bound) {
        return ((array != null) && (bound > 0)) ? Arrays.stream(array)
                                                        .mapToInt(value -> this.getValueFromZeroToBoundOfInputUser(bound))
                                                        .boxed()
                                                        .toArray(Integer[]::new)
                                                : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS, DEFAULT_INTEGER_BOUND);
    }

    /**
     * <p>
     * The method fills array to the integer numeric user data (values) in the range from 0 to the "border".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling to the integer numeric user data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return An array filled to the integer numeric user data (values).
     */
    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        return ((lengthArray > 0) && (bound > 0)) ? Arrays.stream(new Integer[lengthArray])
                                                          .mapToInt(value -> this.getValueFromZeroToBoundOfInputUser(bound))
                                                          .boxed()
                                                          .toArray(Integer[]::new)
                                                  : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS, DEFAULT_INTEGER_BOUND);
    }

    /**
     * <p>
     * The method fills an array to the integer numeric user data (values) in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill to the integer numeric user data (values).
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return An array filled to the integer numeric user data (values).
     */
    @Override
    public Integer[] fill(Integer[] array, Integer minBound, Integer maxBound) {
        return ((array != null) && (minBound < maxBound)) ? Arrays.stream(array)
                                                                  .mapToInt(value -> this.getValueFromMinBoundToMaxBoundOfInputUser(minBound, maxBound))
                                                                  .boxed()
                                                                  .toArray(Integer[]::new)
                                                          : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
    }

    /**
     * <p>
     * The method fills array to the integer numeric user data (values) in the range from "minBound" to the "maxBound".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling to the integer numeric user data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return An array filled to the integer numeric user data (values).
     */
    @Override
    public Integer[] fill(int lengthArray, Integer minBound, Integer maxBound) {
        return ((lengthArray > 0) && (minBound < maxBound)) ? Arrays.stream(new Integer[lengthArray])
                                                                    .mapToInt(value -> this.getValueFromMinBoundToMaxBoundOfInputUser(minBound, maxBound))
                                                                    .boxed()
                                                                    .toArray(Integer[]::new)
                                                            : this.fill(DEFAULT_ARRAY_OF_INTEGER_NUMBERS, DEFAULT_INTEGER_MIN_BOUND, DEFAULT_INTEGER_MAX_BOUND);
    }

    private int getValueFromZeroToBoundOfInputUser(Integer bound) {
        int resultValue = this.reader.readInt();
        if ((resultValue >= 0) && (resultValue <= bound)) {
            return resultValue;
        } else {
            return DEFAULT_INTEGER_VALUE;
        }
    }

    private int getValueFromMinBoundToMaxBoundOfInputUser(Integer minBound, Integer maxBound) {
        int resultValue = this.reader.readInt();
        if ((resultValue >= minBound) && (resultValue <= maxBound)) {
            return resultValue;
        } else {
            return DEFAULT_INTEGER_VALUE;
        }
    }

}
