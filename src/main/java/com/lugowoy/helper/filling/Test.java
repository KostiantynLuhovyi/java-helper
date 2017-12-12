package com.lugowoy.helper.filling;

import com.lugowoy.helper.filling.array.FillableArray;
import com.lugowoy.helper.filling.array.numbers.FillerArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayDoubleRandomNumbers;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 12-Dec-17.
 */

public class Test {

    public static void main(String[] args) {

        Double[] array = /*new Double[10]*/ null;

            array = new FillerArrayNumbers<>(new FillingArrayDoubleRandomNumbers()).fill(array);

        System.out.println(Arrays.toString(array));
    }

}
