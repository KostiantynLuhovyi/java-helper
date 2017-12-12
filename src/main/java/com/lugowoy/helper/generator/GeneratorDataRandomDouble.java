package com.lugowoy.helper.generator;

/** Created by Konstantin Lugowoy on 24.07.2017. */

public interface GeneratorDataRandomDouble extends GeneratorDataRandom {

    static double generateDouble() {
        return RANDOM.nextDouble();
    }

    static double generateDouble(double bound) {
        return (0 + (RANDOM.nextDouble() * (bound - 0)));
    }

    static double generateDouble(double minBound, double maxBound) {
        return (minBound + (RANDOM.nextDouble() * (maxBound - minBound)));
    }

}
