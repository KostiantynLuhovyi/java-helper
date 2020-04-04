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

import static com.lugowoy.helper.filling.ValuesToFilling.INT_ZERO;

/**
 * Created by Konstantin Lugowoy on 23.03.2020.
 */
public class FillingArrayReadPrimitiveIntegers extends FillingReadValues {

    private FillingArrayReadValues<Integer> fillingArray;

    public FillingArrayReadPrimitiveIntegers(Reader reader) {
        super(reader);
    }

    public FillingArrayReadPrimitiveIntegers(Reading reading) {
        super(reading);
    }

    /**
     * Fills an object of the {@link Array} class with pseudo-random numeric data of the type {@link int}.
     * <p>The numerical pseudo-random values for filling are generated in the range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     *
     * @param array The object of the {@link Array} class to fill with pseudo-random numeric data of the type {@link int}.
     *
     * @throws NullPointerException If the object {@code array} of the {@link Array} class argument is null.
     */
    public void fill(ArrayInts arrayInts) {
        CheckerArray.checkLengthInArray(arrayInts);
        int[] ints = new int[arrayInts.size()];
        this.fillArrayReadPrimitiveInts(ints);
        arrayInts.setArray(ints);
    }

    public void fill(int[] ints) {
        CheckerArray.checkLengthInArray(ints);
        this.fillArrayReadPrimitiveInts(ints);
    }

    public int[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        int[] ints = new int[lengthArray];
        this.fillArrayReadPrimitiveInts(ints);
        return ints;
    }

    /**
     * Fills the {@code arrayInts} object with the read numeric data of the int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     *
     * @param arrayInts the object of the {@link ArrayInts} class to fill.
     * @param bound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code arrayInts} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code arrayInts} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if the {@code bound} out of range
     * from {@link ValuesToFilling#INT_ZERO} to {@code bound}.
     */
    public void fill(ArrayInts arrayInts, int bound) {
        CheckerArray.checkLengthInArray(arrayInts);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        int[] ints = new int[arrayInts.size()];
        this.fillArrayReadPrimitiveIntsFromZeroToPositiveBound(ints, bound);
        arrayInts.setArray(ints);
    }

    public void fill(int[] ints, int bound) {
        CheckerArray.checkLengthInArray(ints);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        this.fillArrayReadPrimitiveIntsFromZeroToPositiveBound(ints, bound);
    }

    public int[] fill(int lengthArray, int bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        int[] ints = new int[lengthArray];
        this.fillArrayReadPrimitiveIntsFromZeroToPositiveBound(ints, bound);
        return ints;
    }

    /**
     * Fills the {@code arrayInts} object with the read numeric data of the int type.
     * <p> For reading the data used to fill the functional encapsulated in the class.
     * The functionality for reading data provided by objects of the {@link Reader} class or
     * by objects of classes implementing the {@link Reading} interface.
     * The read numeric values must in the range from {@code lowerBound} to {@code upperBound}.
     *
     * @param arrayInts the object of the {@link ArrayInts} class to fill.
     * @param lowerBound the lower bound numeric value to fill.
     * @param upperBound the upper bound numeric value to fill.
     *
     * @throws NullPointerException if the {@code arrayInts} object is null.
     * @throws LengthArrayOutOfRangeException if the {@code arrayInts} attribute length(size) out of range
     * ​from {@link CheckerArray#LOWER_BOUND_LENGTH_ARRAY} to {@link CheckerArray#UPPER_BOUND_LENGTH_ARRAY}.
     * @throws BoundOutOfRangeException if any of the boundary values out of range
     * from {@link Integer#MIN_VALUE} to {@link Integer#MAX_VALUE}.
     * @throws BoundsCompareException if {@code lowerBound} greater or equal than {@code upperBound}.
     */
    public void fill(ArrayInts arrayInts, int lowerBound, int upperBound) {
        CheckerArray.checkLengthInArray(arrayInts);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        int[] ints = new int[arrayInts.size()];
        this.fillArrayReadPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
        arrayInts.setArray(ints);
    }

    public void fill(int[] ints, int lowerBound, int upperBound) {
        CheckerArray.checkLengthInArray(ints);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        this.fillArrayReadPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
    }

    public int[] fill(int lengthArray, int lowerBound, int upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        int[] ints = new int[lengthArray];
        this.fillArrayReadPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
        return ints;
    }

    private void fillArrayReadPrimitiveInts(int[] ints) {
        this.fillArrayReadPrimitiveIntsFromLowerToUpperBounds(ints, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void fillArrayReadPrimitiveIntsFromZeroToPositiveBound(int[] ints, int bound) {
        this.fillArrayReadPrimitiveIntsFromLowerToUpperBounds(ints, INT_ZERO, bound);
    }

    private void fillArrayReadPrimitiveIntsFromLowerToUpperBounds(int[] ints, int lowerBound, int upperBound) {
        for (int i = 0; i < ints.length; i++) {
            int valueRead = super.getReader().readInt();
            checkReadPrimitiveIntValue(valueRead, lowerBound, upperBound);
            ints[i] = valueRead;
        }
    }

    private static void checkReadPrimitiveIntValue(int value, int lowerValue, int upperValue) {
        if (value < lowerValue || value > upperValue) {
            String msgEx = "Value out of range (" + lowerValue + " - " + upperValue + ")";
            throw new ValueOutOfRangeException(msgEx);
        }
    }

}
