package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.storages.arrays.Array;
import com.lugowoy.helper.models.storages.arrays.ArrayInts;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

import static com.lugowoy.helper.filling.ValuesToFilling.INT_ZERO;

/**
 * Created by Konstantin Lugowoy on 23.03.2020.
 */
public class FillingArrayReadPrimitiveIntegers implements Filling<ArrayInts> {

    private FillingArrayReadValues<Integer> fillingArray;

    public FillingArrayReadPrimitiveIntegers(Reader reader) {
        this.fillingArray = new FillingArrayReadIntegers(reader);
    }

    public FillingArrayReadPrimitiveIntegers(Reading reading) {
        this.fillingArray = new FillingArrayReadIntegers(reading);
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
    @Override
    public void fill(ArrayInts array) {
        CheckerArray.checkLengthInArray(array);
        int[] ints = new int[array.size()];
        this.fillArrayReadPrimitiveInts(ints);
        array.setArray(ints);
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

    public void fill(ArrayInts array, int bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Integer.MAX_VALUE);
        int[] ints = new int[array.size()];
        this.fillArrayReadPrimitiveIntsFromZeroToPositiveBound(ints, bound);
        array.setArray(ints);
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

    public void fill(ArrayInts array, int lowerBound, int upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Integer.MIN_VALUE, Integer.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        int[] ints = new int[array.size()];
        this.fillArrayReadPrimitiveIntsFromLowerToUpperBounds(ints, lowerBound, upperBound);
        array.setArray(ints);
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
            int valueRead = this.fillingArray.getReader().readInt();
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
