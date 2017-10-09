package com.lugowoy.helper.models.arrays;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 31.07.2017. */

public class ArrayOfDoubleNumbers extends ArrayOfNumbers<Double> {

    private ArrayOfDoubleNumbers() {
        super.setArray(Arrays.stream(new Double[DEFAULT_SIZE_ARRAY]).mapToDouble(value -> 0).boxed().toArray(Double[]::new));
    }

    private ArrayOfDoubleNumbers(Double[] array) {
        super(array);
    }

    @Override
    public ArrayOfDoubleNumbers clone() throws CloneNotSupportedException {
        ArrayOfDoubleNumbers arrayOfDoubleNumbers = (ArrayOfDoubleNumbers) super.clone();
        arrayOfDoubleNumbers.setArray(this.getArray());

        return arrayOfDoubleNumbers;
    }

    @Override
    public Double[] getArray() {
        return super.getArray();
    }

    @Override
    public void setArray(Double[] array) {
        super.setArray(array);
    }

    @Override
    public void setArray(int lengthArray) {
        this.setArray(Arrays.stream(new Double[lengthArray]).mapToDouble(value -> 0.0).boxed().toArray(Double[]::new));
    }

    @Override
    public int[] getArrayOfIntegerPrimitiveNumbers() {
        return Arrays.stream(this.getArray()).mapToInt(Double::intValue).toArray();
    }

    @Override
    public void setArrayOfIntegerPrimitiveNumbers(int[] array) {
        this.setArray(Arrays.stream(array).boxed().toArray(Double[]::new));
    }

    @Override
    public double[] getArrayOfDoublePrimitiveNumbers() {
        return Arrays.stream(this.getArray()).mapToDouble(Double::intValue).toArray();
    }

    @Override
    public void setArrayOfDoublePrimitiveNumbers(double[] array) {
        this.setArray(Arrays.stream(array).boxed().toArray(Double[]::new));
    }

    public static ArrayOfDoubleNumbers getInstanceArrayOfDoubleNumbers() {
        return new ArrayOfDoubleNumbers();
    }

    public static ArrayOfDoubleNumbers getInstanceArrayOfDoubleNumbers(Double[] array) {
        return new ArrayOfDoubleNumbers(array);
    }

}
