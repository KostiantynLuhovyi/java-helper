package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingData;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.2
 * @since 29.07.2017
 * <p>
 * A class encapsulating an implementation of an interface to filling an array with the user input double numeric data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @see com.lugowoy.helper.filling.array.numbers.FillableArrayNumbers
 */
//todo Проверить документацию. Изменить реализацию добавив проверки на корректность аргументов. Рефакторинг.
public class FillingArrayDoubleUserInputNumbers extends FillingArrayNumbers<Double> {

    private Reader reader;

    //TODO Add documentation
    public FillingArrayDoubleUserInputNumbers(Reader reader) {
        this.reader = reader;
    }

    /**
     * <p>
     * Constructor with parameter.
     * Initializes the created instance with a reference to the implementation of the user input to filling the array.
     * </p>
     * @see com.lugowoy.helper.reading.Reader
     * @see com.lugowoy.helper.reading.ReadingData
     * @param readingData A reference to the implementation of the user input to filling the array.
     */
    public FillingArrayDoubleUserInputNumbers(ReadingData readingData) {
        this.reader = new Reader(readingData);
    }

    /**
     * <p>
     * The method fills the array with the user input double numeric data (values).
     * </p>
     * @param array The array to fill with the user input double numeric data (values).
     * @return A reference to an array filled with the user input double numeric data (values).
     */
    @Override
    public Double[] fill(Double[] array) {
        return Arrays.stream(array).mapToDouble(value -> this.reader.readDouble()).boxed().toArray(Double[]::new);
    }

    /**
     * <p>
     * The method fills the array with the user input double numeric data (values). The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling the user input double numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @return A reference to the array created and filled with the user input double numeric data (values).
     */
    @Override
    public Double[] fill(int lengthArray) {
        return this.fill(new Double[lengthArray]);
    }

    /**
     * <p>
     * The method fills the array with the user input double numeric data (values) in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill the user input double numeric data (values).
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with the user input double numeric data (values).
     */
    @Override
    public Double[] fill(Double[] array, Double bound) {
        return Arrays.stream(array).mapToDouble(value -> {
            double resultValue;
            while (true) {
                resultValue = this.reader.readDouble();
                if ((resultValue >= 0) && (resultValue <= bound)) {
                    break;
                } else {
                    System.out.println("Incorrect data entered.");
                    System.out.println("Re-enter : ");
                }
            }
            return resultValue;

        }).boxed().toArray(Double[]::new);
    }

    /**
     * <p>
     * The method fills array the user input double numeric data (values) in the range from 0 to the "border".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling the user input double numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with the user input double numeric data (values).
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        return this.fill(new Double[lengthArray], bound);
    }

    /**
     * <p>
     * The method fills an array the user input double numeric data (values) in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill the user input double numeric data (values).
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an array filled with the user input double numeric data (values).
     */
    @Override
    public Double[] fill(Double[] array, Double minBound, Double maxBound) {
        return Arrays.stream(array).mapToDouble(value -> {
            double resultValue;
            while (true) {
                resultValue = this.reader.readDouble();
                if ((resultValue >= minBound) && (resultValue <= maxBound)) {
                    break;
                } else {
                    System.out.println("Incorrect data entered.");
                    System.out.println("Re-enter : ");
                }
            }
            return resultValue;

        }).boxed().toArray(Double[]::new);
    }

    /**
     * <p>
     * The method fills array the user input double numeric data (values) in the range from "minBound" to the "maxBound".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling the user input double numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an array filled with the user input double numeric data (values).
     */
    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        return this.fill(new Double[lengthArray], minBound, maxBound);
    }

}