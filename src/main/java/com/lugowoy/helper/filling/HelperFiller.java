package com.lugowoy.helper.filling;

import com.lugowoy.helper.filling.array.numbers.FillerArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveDoubles;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomPrimitiveIntegers;
import com.lugowoy.helper.filling.array.points.FillerArrayPoints;
import com.lugowoy.helper.filling.array.points.FillingArrayPoints;
import com.lugowoy.helper.filling.array.strings.FillerArrayStrings;
import com.lugowoy.helper.filling.array.strings.FillingArrayStrings;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 30.11.2019.
 */
//todo write doc's
public class HelperFiller {

    public static final FillingArrayRandomPrimitiveIntegers FILLER_ARRAY_RANDOM_INT = new FillingArrayRandomPrimitiveIntegers();

    public static final FillingArrayRandomPrimitiveDoubles FILLER_ARRAY_RANDOM_DOUBLE = new FillingArrayRandomPrimitiveDoubles();

    public static <T extends Number> FillerArrayNumbers<T> FILLER_ARRAY_NUMBERS(FillingArrayNumbers<T> fillingArrayNumbers) {
        return new FillerArrayNumbers<>(fillingArrayNumbers);
    }

    public static <T extends Point, V extends Number> FillerArrayPoints <T, V> FILLER_ARRAY_POINTS(FillingArrayPoints<T, V> fillingArrayPoints) {
        return new FillerArrayPoints<>(fillingArrayPoints);
    }

    public static FillerArrayStrings FILLER_ARRAY_STRINGS(FillingArrayStrings fillingArrayStrings) {
        return new FillerArrayStrings(fillingArrayStrings);
    }

}
