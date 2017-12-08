package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.array.FillableArray;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingData;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 29.07.2017
 * <p>
 * The class encapsulates the implementation of array filling with integer values entered by the user.
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see FillingArray
 * @see FillingArrayNumbers
 * @see com.lugowoy.helper.filling.Fillable
 * @see FillableArray
 * @see FillableArrayNumbers
 */

public class FillingArrayIntegerUserInputNumbers extends FillingArrayNumbers<Integer> {

    private Reader reader;

    /**
     * <p>
     * The default constructor of the class.
     * Creating an instance of a class by calling this constructor implies that reading the user entered data (integer number values)
     *                                                   for fill the array will be implemented in the default manner.
     * Reading will be done from the console.
     * </p>
     * @see com.lugowoy.helper.reading.Reader
     * @see com.lugowoy.helper.reading.ReadingDataUserInputInConsole;
     */
    public FillingArrayIntegerUserInputNumbers() {
        this.reader = new Reader(new ReadingDataUserInputInConsole());
    }

    /**
     * <p>
     * Constructor with parameter.
     * Creating a class instance by calling this constructor implies that the implementation of reading the data of the user input (integer number values)
     * to fill the array will be implemented using a data reading method whose implementation is encapsulated in the object
     *                                                                      that is passed to the constructor by the argument.
     * </p>
     * @see com.lugowoy.helper.reading.Reader
     * @see com.lugowoy.helper.reading.ReadingData
     * @param readingData Object encapsulating the implementation of reading data entered by the user.
     * */
    public FillingArrayIntegerUserInputNumbers(ReadingData readingData) {
        this.reader = new Reader(readingData);
    }

    /**
     * <p>
     * Method fills an array the integer values entered by the user.
     * </p>
     * @param array The array to fill it with random integer values.
     * @return A reference to the array filled with random integer values.
     */
    @Override
    public Integer[] fill(Integer[] array) {
        return Arrays.stream(array).mapToInt(value -> this.reader.readInt()).boxed().toArray(Integer[]::new);
    }

    /**
     * <p>
     * A method fills an array the random integer values, which is created based on the variable of the length of the array.
     * </p>
     * @param lengthArray The length of the array to create and fill random integer values.
     *                          The value of the length of the array to fill in the random integer values must be a positive number.
     * @return A reference to the array created and filled with random integer values.
     */
    @Override
    public Integer[] fill(int lengthArray) {
        return this.fill(new Integer[lengthArray]);
    }

    @Override
    public Integer[] fill(Integer[] array, Integer bound) {
        return Arrays.stream(array).mapToInt(value -> {
            int resultValue;
            while (true) {
                resultValue = this.reader.readInt();
                if ((resultValue >= 0) && (resultValue <= bound)) {
                    break;
                } else {
                    System.out.println("Incorrect data entered.");
                    System.out.println("Re-enter : ");
                }
            }
            return resultValue;

        }).boxed().toArray(Integer[]::new);
    }

    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        return this.fill(new Integer[lengthArray], bound);
    }

    @Override
    public Integer[] fill(Integer[] array, Integer minBound, Integer maxBound) {
        return Arrays.stream(array).mapToInt(value -> {
            int resultValue;
            while (true) {
                resultValue = this.reader.readInt();
                if ((resultValue >= minBound) && (resultValue <= maxBound)) {
                    break;
                } else {
                    System.out.println("Incorrect data entered.");
                    System.out.println("Re-enter : ");
                }
            }
            return resultValue;

        }).boxed().toArray(Integer[]::new);
    }

    @Override
    public Integer[] fill(int lengthArray, Integer minBound, Integer maxBound) {
        return this.fill(new Integer[lengthArray], minBound, maxBound);
    }

}
