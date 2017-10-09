package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfIntegerCoordinates;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 01.08.2017. */

public class ArrayOfIntegerCoordinatesPoints extends ArrayOfPoints<Integer> {

    private ArrayOfIntegerCoordinatesPoints() {
        super.setArray(Arrays.stream(new PointOfIntegerCoordinates[DEFAULT_SIZE_ARRAY])
                             .map(pointOfIntegerCoordinates -> PointOfIntegerCoordinates.getInstancePointOfIntegerCoordinates())
                             .toArray(PointOfIntegerCoordinates[]::new));
    }

    private ArrayOfIntegerCoordinatesPoints(Point<Integer>[] array) {
        super(array);
    }

    @Override
    public ArrayOfIntegerCoordinatesPoints clone() throws CloneNotSupportedException {
        ArrayOfIntegerCoordinatesPoints arrayOfIntegerCoordinatesPoints = (ArrayOfIntegerCoordinatesPoints) super.clone();
        arrayOfIntegerCoordinatesPoints.setArray(this.getArray());

        return arrayOfIntegerCoordinatesPoints;
    }

    @Override
    public Point<Integer>[] getArray() {
        return super.getArray();
    }

    @Override
    public void setArray(Point<Integer>[] array) {
        super.setArray(array);
    }

    @Override
    public void setArray(int lengthArray) {
        this.setArray(Arrays.stream(new PointOfIntegerCoordinates[lengthArray])
                            .map(pointOfIntegerCoordinates -> PointOfIntegerCoordinates.getInstancePointOfIntegerCoordinates())
                            .toArray(PointOfIntegerCoordinates[]::new));
    }

    public static Array<Point<Integer>> getInstanceArrayOfIntegerCoordinatesPoints() {
        return new ArrayOfIntegerCoordinatesPoints();
    }

    public static Array<Point<Integer>> getInstanceArrayOfIntegerCoordinatesPoints(Point<Integer>[] pointsOfIntegerCoordinates) {
        return new ArrayOfIntegerCoordinatesPoints(pointsOfIntegerCoordinates);
    }

}
