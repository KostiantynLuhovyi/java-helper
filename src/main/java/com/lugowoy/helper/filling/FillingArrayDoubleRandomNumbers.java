package com.lugowoy.helper.filling;

import com.lugowoy.helper.generating.GeneratorDataRandomDouble;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 29.07.2017. */

public class FillingArrayDoubleRandomNumbers extends FillingArrayNumbers<Double> {

    @Override
    public Double[] fill(Double[] array) {
        return Arrays.stream(array).mapToDouble(value -> GeneratorDataRandomDouble.generateDouble()).boxed().toArray(Double[]::new);
    }

    @Override
    public Double[] fill(int lengthArray) {
        return Arrays.stream(new Double[lengthArray]).mapToDouble(value -> GeneratorDataRandomDouble.generateDouble()).boxed().toArray(Double[]::new);
    }

    @Override
    public Double[] fill(Double[] array, Double bound) {
        return Arrays.stream(array).mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(bound)).boxed().toArray(Double[]::new);
    }

    @Override
    public Double[] fill(int lengthArray, Double bound) {
        return Arrays.stream(new Double[lengthArray]).mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(bound)).boxed().toArray(Double[]::new);
    }

    @Override
    public Double[] fill(Double[] array, Double minBound, Double maxBound) {
        return Arrays.stream(array).mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(minBound, maxBound)).boxed().toArray(Double[]::new);
    }

    @Override
    public Double[] fill(int lengthArray, Double minBound, Double maxBound) {
        return Arrays.stream(new Double[lengthArray]).mapToDouble(value -> GeneratorDataRandomDouble.generateDouble(minBound, maxBound)).boxed().toArray(Double[]::new);
    }

}
