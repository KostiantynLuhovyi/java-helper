package com.lugowoy.helper.generating;

/** Created by Konstantin Lugowoy on 24.07.2017. */

public interface GeneratorDataRandomInteger extends GeneratorDataRandom {

    static int generateInt() {
        return RANDOM.nextInt();
    }

    static int generateInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    static int generateInt(int minBound, int maxBound) {
        return (minBound + (RANDOM.nextInt((maxBound - minBound) + 1)));
    }

}
