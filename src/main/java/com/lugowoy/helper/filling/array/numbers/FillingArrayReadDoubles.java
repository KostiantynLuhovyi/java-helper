package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.checkers.CheckerBoundNumber;
import com.lugowoy.helper.checkers.CheckerNumber;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.utils.BoundOutOfRangeException;
import com.lugowoy.helper.utils.BoundsComparisonException;
import com.lugowoy.helper.utils.Capacity;
import com.lugowoy.helper.utils.LengthOutOfRangeException;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;
import java.math.BigDecimal;


/**
 * The class provides the functionality to fill the class objects {@link Array}
 * and arrays of the type {@link Double} with the read numeric data of the type
 * {@link Double}. Thereby the class implements the interface contract {@link
 * FillingArrayNumbers}.
 * <p>To see the functionality of read numeric data can in the class {@link
 * Reader}.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 2.3
 * @see com.lugowoy.helper.filling.FillingReadValues
 * @see com.lugowoy.helper.filling.array.FillingArrayReadValues
 * @see com.lugowoy.helper.filling.Filling
 * @see com.lugowoy.helper.filling.array.FillingArray
 * @see com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers
 */
//TODO review documentation
public class FillingArrayReadDoubles extends FillingArrayReadValues
        implements FillingArrayNumbers<Double> {

    /**
     * Constructs a new object, initializing the implementation of reading
     * numeric data of the type {@link Double} to fill the class objects {@link
     * Array} and arrays of the type {@link Double}. The implementation of data
     * reading provided by class objects {@link Reader} or its subclasses.
     *
     * @param reader the object implementation of reading data to fill.
     */
    public FillingArrayReadDoubles(@NotNull final Reader reader) {
        super(reader);
    }

    /**
     * Fills the {@code array} object with the read numeric data of the type
     * {@link Double}.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    @Override
    public void fill(@NotNull final Array<Double> array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        Double[] doubles = new Double[array.size()];
        this.fillArray(doubles);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with the read numeric data of the type
     * {@link Double}.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     *
     * @param array the array to fill.
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    @Override
    public void fill(@NotNull final Double[] array) {
        CheckerArray.check(array, Capacity.UPPER.get());
        this.fillArray(array);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type
     * {@link Double} and fills it with the read numeric data of type {@link
     * Double}.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @return the array created and filled with data.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     */
    @Override
    public Double[] fill(final int lengthArray) {
        CheckerArray.check(lengthArray);
        Double[] doubles = new Double[lengthArray];
        this.fillArray(doubles);
        return doubles;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the type
     * {@link Double}.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link BigDecimal#ZERO} to {@code boundValue}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link BigDecimal#ZERO} to {@code boundValue}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of
     * range from {@link BigDecimal#ZERO} to {@link Double#MAX_VALUE}.
     */
    @Override
    public void fill(@NotNull final Array<Double> array,
                     @NotNull final Double bound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        Double[] doubles = new Double[array.size()];
        this.fillArrayFromZeroToBound(doubles, bound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with the read numeric data of the type
     * {@link Double}.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link BigDecimal#ZERO} to {@code boundValue}.
     *
     * @param array the array to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @throws NullPointerException if the {@code doubles} array is null.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link BigDecimal#ZERO} to {@code boundValue}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of
     * range from {@link BigDecimal#ZERO} to {@link Double#MAX_VALUE}.
     */
    @Override
    public void fill(@NotNull final Double[] array,
                     @NotNull final Double bound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        this.fillArrayFromZeroToBound(array, bound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type
     * {@link Double} and fills it with the read numeric data of type {@link
     * Double}.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@link BigDecimal#ZERO} to {@code boundValue}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param bound the positive upper bound numeric value to fill.
     * @return the array created and filled with data.
     * @throws NullPointerException if the {@code boundValue} value is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@link BigDecimal#ZERO} to {@code boundValue}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if the {@code boundValue} value out of
     * range from {@link BigDecimal#ZERO} to {@link Double#MAX_VALUE}.
     */
    @Override
    public Double[] fill(final int lengthArray, @NotNull final Double bound) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(bound, Double.MAX_VALUE);
        Double[] doubles = new Double[lengthArray];
        this.fillArrayFromZeroToBound(doubles, bound);
        return doubles;
    }

    /**
     * Fills the {@code array} object with the read numeric data of the type
     * {@link Double}.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@code lowerBound} to {@code upperBound}.
     *
     * @param array the object of the {@link Array} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code array} object is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBound} to {@code upperBound}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    @Override
    public void fill(@NotNull final Array<Double> array,
                     @NotNull final Double lowerBound,
                     @NotNull final Double upperBound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Double[] doubles = new Double[array.size()];
        this.fillArrayFromLowerToUpper(doubles, lowerBound, upperBound);
        array.setArray(doubles);
    }

    /**
     * Fills the {@code doubles} array with the read numeric data of the type
     * {@link Double}.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@code lowerBound} to {@code upperBound}.
     *
     * @param array the array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @throws NullPointerException if the {@code doubles} is null.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBound} to {@code upperBound}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    @Override
    public void fill(@NotNull final Double[] array,
                     @NotNull final Double lowerBound,
                     @NotNull final Double upperBound) {
        CheckerArray.check(array, Capacity.UPPER.get());
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        this.fillArrayFromLowerToUpper(array, lowerBound, upperBound);
    }

    /**
     * Creates an array of the {@code lengthArray} length(size) of the type
     * {@link Double} and fills it with the read numeric data of type {@link
     * Double}.
     * <p>For reading the data used to fill the functional encapsulated in the
     * class. The functionality for reading data provided by objects of the
     * {@link Reader} class. The read numeric values must in the range from
     * {@code lowerBound} to {@code upperBound}.
     *
     * @param lengthArray the length(size) of the created array to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     * @return the array created and filled with data.
     * @throws NullPointerException if any of the boundary values is null.
     * @throws ValueOutOfRangeException if the read {@code value} out of range
     * from {@code lowerBound} to {@code upperBound}.
     * @throws LengthOutOfRangeException if the {@code array} object attribute
     * length(size) out of range ​from {@link Capacity#LOWER} to {@link
     * Capacity#UPPER}.
     * @throws BoundOutOfRangeException if any of the boundary values out of
     * range from {@link Double#MIN_VALUE} to {@link Double#MAX_VALUE}.
     * @throws BoundsComparisonException if {@code lowerBound} value greater or
     * equal than {@code upperBound} value.
     */
    @Override
    public Double[] fill(final int lengthArray,
                         @NotNull final Double lowerBound,
                         @NotNull final Double upperBound) {
        CheckerArray.check(lengthArray);
        CheckerBoundNumber.checkInRange(lowerBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkInRange(upperBound, Double.MIN_VALUE,
                                        Double.MAX_VALUE);
        CheckerBoundNumber.checkLowerLessOrEqualUpper(lowerBound, upperBound);
        Double[] doubles = new Double[lengthArray];
        this.fillArrayFromLowerToUpper(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillArray(final Double[] array) {
        this.fillArrayFromLowerToUpper(array, Double.MIN_VALUE,
                                       Double.MAX_VALUE);
    }

    private void fillArrayFromZeroToBound(final Double[] array,
                                          final double bound) {
        this.fillArrayFromLowerToUpper(array, BigDecimal.ZERO.doubleValue(),
                                       bound);
    }

    private void fillArrayFromLowerToUpper(final Double[] array,
                                           final double lowerBound,
                                           final double upperBound) {
        double valueRead = 0;
        for (int i = 0; i < array.length; i++) {
            while (super.getReader().hasNextDouble()) {
                valueRead = super.getReader().nextDouble();
                CheckerNumber.check(valueRead, lowerBound, upperBound);
            }
            array[i] = valueRead;
        }
    }

}
