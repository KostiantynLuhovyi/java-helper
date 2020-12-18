package com.lugowoy.helper.filling.array.numbers.primitives;

import com.lugowoy.helper.models.arrays.ArrayDoubles;
import org.jetbrains.annotations.NotNull;

/**
 * <p>Created by Konstantin Lugowoy on 18.12.2020.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 3.0.5
 */
//TODO write documentation
public interface FillingArrayDoublePrimitives {

    void fill(@NotNull ArrayDoubles array);

    void fill(@NotNull double[] doubles);

    double[] fill(int lengthArray);

    void fill(@NotNull ArrayDoubles array, double bound);

    void fill(@NotNull double[] doubles, double bound);

    double[] fill(int lengthArray, double bound);

    void fill(@NotNull ArrayDoubles array, double lowerBound,
              double upperBound);

    void fill(@NotNull double[] doubles, double lowerBound, double upperBound);

    double[] fill(int lengthArray, double lowerBound, double upperBound);

}
