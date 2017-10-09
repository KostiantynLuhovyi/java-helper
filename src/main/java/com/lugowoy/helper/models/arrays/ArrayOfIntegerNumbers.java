package com.lugowoy.helper.models.arrays;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 31.07.2017. */

public class ArrayOfIntegerNumbers extends ArrayOfNumbers<Integer> {

    private ArrayOfIntegerNumbers() {
        super.setArray(Arrays.stream(new Integer[DEFAULT_SIZE_ARRAY]).mapToInt(value -> 0).boxed().toArray(Integer[]::new));
    }

    private ArrayOfIntegerNumbers(Integer[] array) {
        super(array);
    }

    public ArrayOfIntegerNumbers clone() throws CloneNotSupportedException {
        ArrayOfIntegerNumbers arrayOfIntegerNumbers = (ArrayOfIntegerNumbers) super.clone();
        arrayOfIntegerNumbers.setArray(this.getArray());

        return arrayOfIntegerNumbers;
    }

    @Override
    public Integer[] getArray() {
        return super.getArray();
    }

    @Override
    public void setArray(Integer[] array) {
        super.setArray(array);
    }

    @Override
    public void setArray(int lengthArray) {
        this.setArray(Arrays.stream(new Integer[lengthArray]).mapToInt(value -> 0).boxed().toArray(Integer[]::new));
    }

    @Override
    public int[] getArrayOfIntegerPrimitiveNumbers() {
        return Arrays.stream(this.getArray()).mapToInt(Integer::intValue).toArray();
    }

    @Override
    public void setArrayOfIntegerPrimitiveNumbers(int[] array) {
        this.setArray(Arrays.stream(array).boxed().toArray(Integer[]::new));
    }

    @Override
    public double[] getArrayOfDoublePrimitiveNumbers() {
        return Arrays.stream(this.getArray()).mapToDouble(Integer::intValue).toArray();
    }

    @Override
    public void setArrayOfDoublePrimitiveNumbers(double[] array) {
        this.setArray(Arrays.stream(array).boxed().toArray(Integer[]::new));
    }

    public static ArrayOfIntegerNumbers getInstanceArrayOfIntegerNumbers() {
        return new ArrayOfIntegerNumbers();
    }

    public static ArrayOfIntegerNumbers getInstanceArrayOfIntegerNumbers(Integer[] array) {
        return new ArrayOfIntegerNumbers(array);
    }

}
