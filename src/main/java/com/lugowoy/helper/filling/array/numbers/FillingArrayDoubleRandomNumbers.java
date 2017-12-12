package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.generator.GeneratorDataRandomDouble;

import java.util.Arrays;

import static com.lugowoy.helper.filling.array.Checker.*;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.3
 * @since 29.07.2017
 * <p>
 * A class encapsulating an implementation of an interface to filling an array the random double numeric data (values).
 * </p>
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 * @see com.lugowoy.helper.filling.Fillable
 * @see com.lugowoy.helper.filling.array.FillableArray
 * @see com.lugowoy.helper.filling.array.numbers.FillableArrayNumbers
 */
//todo Проверить документацию. Изменить реализацию добавив проверки на корректность аргументов. Рефакторинг.
public class FillingArrayDoubleRandomNumbers extends FillingArrayNumbers<Double> {

    /**
     * <p>
     * The method fills the array with random double numeric data (values).
     * </p>
     * @param array The array to fill with random double numeric data (values).
     * @return A reference to an array filled with random double numeric data (values).
     *          If an invalid array is passed for filling, we will return a reference to the array with the dimension
     *              of five elements filled with zeros.
     */
    @Override
    public Double[] fill(Double[] array) {
        //todo Реализовать массивы для избежания возникновения исключения ClassCastException связанного с контрвариантностью.
        Number[] resultArray = DEFAULT_ARRAY;
        try {
            if (checkNonNullArray(array)) {
                resultArray = Arrays.stream(array)
                        .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble())
                        .boxed()
                        .toArray(Double[]::new);
            }
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        //todo Избавится от исключения ClassCastException, вызванного контрвариантность типов массивов.
        return (Double[]) resultArray;
    }

    /**
     * <p>
     * The method fills the array with random double numeric data (values). The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling random double numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @return A reference to the array created and filled with random double numeric data (values).
     *           If an invalid array is passed for filling, we will return a reference to the array with the dimension
     *              of five elements filled with zeros.
     */
    @Override
    public Double[] fill(int lengthArray) {
        return checkValueOfLengthArray(lengthArray) ? Arrays.stream(new Double[lengthArray])
                                                            .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble())
                                                            .boxed()
                                                            .toArray(Double[]::new)
                                                    : (Double[]) DEFAULT_ARRAY;
    }

    /**
     * <p>
     * The method fills the array with random double numeric data (values) in the range from 0 to the "bound" parameter.
     * </p>
     * @param array The array to fill the random double numeric data (values).
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with random double numeric data (values).
     */
    @Override
    public Double[] fill(Double[] array, Double bound) {
        return checkNonNullArray(array) && checkBound(bound) ? Arrays.stream(array)
                                                                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(bound))
                                                                     .boxed()
                                                                     .toArray(Double[]::new)
                                                             : (Double[]) DEFAULT_ARRAY;
    }

    /**
     * <p>
     * The method fills array the random double numeric data (values) in the range from 0 to the "border".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling random double numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param bound The boundary is the maximum value, when filling the array.
     *                  The value must be a positive number, since the minimum value is 0.
     * @return A reference to an array filled with random double numeric data (values).
     */
    @Override
    public Double[] fill(int lengthArray, Double bound) {
        return Arrays.stream(new Double[lengthArray])
                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(bound))
                     .boxed()
                     .toArray(Double[]::new);
    }

    /**
     * <p>
     * The method fills an array the random double numeric data (values) in the range from "minBound" to the "maxBound" parameter.
     * </p>
     * @param array The array to fill the random double numeric data (values).
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an array filled with random double numeric data (values).
     */
    @Override
    public Double[] fill(Double[] array, Double minBound, Double maxBound) {
        return Arrays.stream(array)
                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(minBound, maxBound))
                     .boxed()
                     .toArray(Double[]::new);
    }

    /**
     * <p>
     * The method fills array the random double numeric data (values) in the range from "minBound" to the "maxBound".
     *  The array is created by the dimension "lengthArray".
     * </p>
     * @param lengthArray Length (size) of the creating array for filling random double numeric data (values).
     *                          The value of the parameter "lengthArray" must be a positive number.
     * @param minBound The boundary is the minimal value, when filling the array.
     * @param maxBound The boundary is the maximum value, when filling the array.
     * @return A reference to an array filled with random double numeric data (values).
     */
    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        return Arrays.stream(new Double[lengthArray])
                     .mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(minBound, maxBound))
                     .boxed()
                     .toArray(Double[]::new);
    }





}