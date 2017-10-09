package com.lugowoy.helper.filling;

import com.lugowoy.helper.generating.GeneratorDataRandomInteger;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 29.07.2017. */

public class FillingArrayIntegerRandomNumbers extends FillingArrayNumbers<Integer> {

    @Override
    public Integer[] fill(Integer[] array) {
        return Arrays.stream(array).mapToInt(value -> GeneratorDataRandomInteger.generateInt()).boxed().toArray(Integer[]::new);
    }

    @Override
    public Integer[] fill(int lengthArray) {
        return Arrays.stream(new Integer[lengthArray]).mapToInt(value -> GeneratorDataRandomInteger.generateInt()).boxed().toArray(Integer[]::new);
    }

    @Override
    public Integer[] fill(Integer[] array, Integer bound) {
        return Arrays.stream(array).mapToInt(value -> GeneratorDataRandomInteger.generateInt(bound)).boxed().toArray(Integer[]::new);
    }

    @Override
    public Integer[] fill(int lengthArray, Integer bound) {
        return Arrays.stream(new Integer[lengthArray]).mapToInt(value -> GeneratorDataRandomInteger.generateInt(bound)).boxed().toArray(Integer[]::new);
    }

    @Override
    public Integer[] fill(Integer[] array, Integer minBound, Integer maxBound) {
        return Arrays.stream(array).mapToInt(value -> GeneratorDataRandomInteger.generateInt(minBound, maxBound)).boxed().toArray(Integer[]::new);
    }

    @Override
    public Integer[] fill(int lengthArray, Integer minBound, Integer maxBound) {
        return Arrays.stream(new Integer[lengthArray]).mapToInt(value -> GeneratorDataRandomInteger.generateInt(minBound, maxBound)).boxed().toArray(Integer[]::new);
    }

}
