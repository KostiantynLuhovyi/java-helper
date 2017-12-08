package com.lugowoy.helper.filling.array.numbers;

import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 29.07.2017.
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 29.07.2017
 * <p>
 *
 * </p>
 */

public class FillingArrayDoubleUserInputNumbers extends FillingArrayNumbers<Double> {

    private Reader reader = new Reader(new ReadingDataUserInputInConsole());

    @Override
    public Double[] fill(Double[] array) {
        return Arrays.stream(array).mapToDouble(value -> this.reader.readDouble()).boxed().toArray(Double[]::new);
    }

    @Override
    public Double[] fill(int lengthArray) {
        return this.fill(new Double[lengthArray]);
    }

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

    @Override
    public Double[] fill(int lengthArray, Double bound) {
        return this.fill(new Double[lengthArray], bound);
    }

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

    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        return this.fill(new Double[lengthArray], minBound, maxBound);
    }

}
