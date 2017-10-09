package com.lugowoy.helper.filling;

import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 29.07.2017. */

public class FillingArrayIntegerUserInputNumbers extends FillingArrayNumbers<Integer> {

    private Reader reader = new Reader(new ReadingDataUserInputInConsole());

    @Override
    public Integer[] fill(Integer[] array) {
        return Arrays.stream(array).mapToInt(value -> this.reader.readInt()).boxed().toArray(Integer[]::new);
    }

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
