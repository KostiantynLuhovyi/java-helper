package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.filling.Filling;
import com.lugowoy.helper.filling.ValuesToFilling;
import com.lugowoy.helper.filling.array.FillingArrayReadValues;
import com.lugowoy.helper.io.reading.Reader;
import com.lugowoy.helper.io.reading.Reading;
import com.lugowoy.helper.models.storages.arrays.ArrayDoubles;
import com.lugowoy.helper.utils.ValueOutOfRangeException;
import com.lugowoy.helper.utils.checking.CheckerArray;
import com.lugowoy.helper.utils.checking.CheckerBound;

/**
 * Created by Konstantin Lugowoy on 23.03.2020.
 */
public class FillingArrayReadPrimitiveDoubles implements Filling<ArrayDoubles> {

    private FillingArrayReadValues<Double> fillingArray;

    public FillingArrayReadPrimitiveDoubles(Reader reader) {
        this.fillingArray = new FillingArrayReadDoubles(reader);
    }

    public FillingArrayReadPrimitiveDoubles(Reading reading) {
        this.fillingArray = new FillingArrayReadDoubles(reading);
    }

    /**
     * Fills the {@code t} object with data.
     *
     * @param arrayDoubles the object or storage(data structure) to fill.
     */
    @Override
    public void fill(ArrayDoubles arrayDoubles) {
        CheckerArray.checkLengthInArray(arrayDoubles);
        double[] doubles = new double[arrayDoubles.size()];
        this.fillArrayReadDoubles(doubles);
        arrayDoubles.setArray(doubles);
    }

    public void fill(double[] doubles) {
        CheckerArray.checkLengthInArray(doubles);
        this.fillArrayReadDoubles(doubles);
    }

    public double[] fill(int lengthArray) {
        CheckerArray.checkLengthArray(lengthArray);
        double[] doubles = new double[lengthArray];
        this.fillArrayReadDoubles(doubles);
        return doubles;
    }

    public void fill(ArrayDoubles array, double bound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        double[] doubles = new double[array.size()];
        this.fillArrayReadDoublesFromZeroToPositiveBound(doubles, bound);
        array.setArray(doubles);
    }

    public void fill(double[] doubles, double bound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        this.fillArrayReadDoublesFromZeroToPositiveBound(doubles, bound);
    }

    public double[] fill(int lengthArray, double bound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(bound, Long.MAX_VALUE);
        double[] doubles = new double[lengthArray];
        this.fillArrayReadDoublesFromZeroToPositiveBound(doubles, bound);
        return doubles;
    }

    public void fill(ArrayDoubles array, double lowerBound, double upperBound) {
        CheckerArray.checkLengthInArray(array);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        double[] doubles = new double[array.size()];
        this.fillArrayReadDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
        array.setArray(doubles);
    }

    public void fill(double[] doubles, double lowerBound, double upperBound) {
        CheckerArray.checkLengthInArray(doubles);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        this.fillArrayReadDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
    }

    public double[] fill(int lengthArray, double lowerBound, double upperBound) {
        CheckerArray.checkLengthArray(lengthArray);
        CheckerBound.isCorrectBound(lowerBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isCorrectBound(upperBound, Long.MIN_VALUE, Long.MAX_VALUE);
        CheckerBound.isLowerBoundLessOrEqualUpperBound(lowerBound, upperBound);
        double[] doubles = new double[lengthArray];
        this.fillArrayReadDoublesFromLowerBoundToUpperBound(doubles, lowerBound, upperBound);
        return doubles;
    }

    private void fillArrayReadDoubles(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            double valueRead = this.fillingArray.getReader().readDouble();
            doubles[i] = valueRead;
        }
    }

    private void fillArrayReadDoublesFromZeroToPositiveBound(double[] doubles, double bound) {
        this.fillArrayReadDoublesFromLowerBoundToUpperBound(doubles, ValuesToFilling.DOUBLE_ZERO, bound);
    }

    private void fillArrayReadDoublesFromLowerBoundToUpperBound(double[] doubles, double lowerBound, double upperBound) {
        for (int i = 0; i < doubles.length; i++) {
            double valueRead = this.fillingArray.getReader().readDouble();
            if (valueRead < lowerBound || valueRead > upperBound) {
                String msgEx = "Value out of range (" + lowerBound + " - " + upperBound + ").";
                throw new ValueOutOfRangeException(msgEx);
            } else {
                doubles[i] = valueRead;
            }
        }
    }

}
