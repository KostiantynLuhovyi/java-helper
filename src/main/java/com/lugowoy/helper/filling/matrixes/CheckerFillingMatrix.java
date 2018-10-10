package com.lugowoy.helper.filling.matrixes;

import com.lugowoy.helper.models.matrixes.Matrix;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 05.10.2018.
 */
//todo add doc's
public interface CheckerFillingMatrix {

    static <T> boolean checkNonNullMatrix(Matrix<T> matrix) {
        return matrix != null;
    }

    static boolean checkNonNullMatrix(Number[][] numbersMatrix) {
        return numbersMatrix != null;
    }

    static <T extends Number> boolean checkNonNullMatrix(Point<T>[][] pointsMatrix) {
        return pointsMatrix != null;
    }

    static boolean checkNonNullMatrix(String[][] stringsMatrix) {
        return stringsMatrix != null;
    }

    static boolean checkMatrixRows(int rows) {
        return rows >= 0 && rows < Integer.MAX_VALUE;
    }

    static boolean checkMatrixColumns(int columns) {
        return columns >= 0 && columns < Integer.MAX_VALUE;
    }

    static boolean isPositiveBoundValueAndNonNull(Number boundValue) {
        return (boundValue != null) && ((boundValue.intValue() >= 0) && (boundValue.intValue() < Integer.MAX_VALUE));
    }

    static boolean isNegativeBoundValueAndNonNull(Number boundValue) {
        return (boundValue != null) && (boundValue.intValue() < 0 && boundValue.intValue() > Integer.MIN_VALUE);
    }

    static boolean isCorrectRangeBoundValue(Number boundValue) {
        return boundValue.intValue() > Integer.MIN_VALUE && boundValue.intValue() < Integer.MAX_VALUE;
    }

    static boolean isStartBoundValueLessThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.intValue() < endBound.intValue();
    }

    static boolean isStartBoundValueGreatestThanEndBoundValue(Number startBound, Number endBound) {
        return startBound.intValue() > endBound.intValue();
    }

}
