package com.lugowoy.helper.models.arrays;

/** Created by Konstantin Lugowoy on 31.07.2017. */

public abstract class ArrayOfNumbers<T extends Number> extends Array<T> implements ArrayOfPrimitiveNumbers {

    public ArrayOfNumbers() {
        super();
    }

    public ArrayOfNumbers(T[] array) {
        super(array);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public T[] getArray() {
        return super.getArray();
    }

    @Override
    public void setArray(T[] array) {
        super.setArray(array);
    }

    @Override
    public abstract void setArray(int lengthArray);

    @Override
    public abstract int[] getArrayOfIntegerPrimitiveNumbers();

    @Override
    public abstract void setArrayOfIntegerPrimitiveNumbers(int[] array);

    @Override
    public abstract double[] getArrayOfDoublePrimitiveNumbers();

    @Override
    public abstract void setArrayOfDoublePrimitiveNumbers(double[] array);

}
