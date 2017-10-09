package com.lugowoy.helper.models.arrays;

import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfDoubleCoordinates;

import java.util.Arrays;

/** Created by Konstantin Lugowoy on 01.08.2017. */

public class ArrayOfDoubleCoordinatesPoints extends ArrayOfPoints<Double> {

    private ArrayOfDoubleCoordinatesPoints() {
        super.setArray(Arrays.stream(new PointOfDoubleCoordinates[DEFAULT_SIZE_ARRAY])
                             .map(pointOfDoubleCoordinates -> PointOfDoubleCoordinates.getInstancePointOfDoubleCoordinates())
                             .toArray(PointOfDoubleCoordinates[]::new));
    }

    private ArrayOfDoubleCoordinatesPoints(Point<Double>[] array) {
        super(array);
    }

    @Override
    public ArrayOfDoubleCoordinatesPoints clone() throws CloneNotSupportedException {
        ArrayOfDoubleCoordinatesPoints arrayOfDoubleCoordinatesPoints = (ArrayOfDoubleCoordinatesPoints) super.clone();
        arrayOfDoubleCoordinatesPoints.setArray(this.getArray());

        return arrayOfDoubleCoordinatesPoints;
    }

    @Override
    public Point<Double>[] getArray() {
        return super.getArray();
    }

    @Override
    public void setArray(Point<Double>[] array) {
        super.setArray(array);
    }

    @Override
    public void setArray(int lengthArray) {
        this.setArray(Arrays.stream(new PointOfDoubleCoordinates[lengthArray])
                            .map(pointOfDoubleCoordinates -> PointOfDoubleCoordinates.getInstancePointOfDoubleCoordinates())
                            .toArray(PointOfDoubleCoordinates[]::new));
    }

    public static Array<Point<Double>> getInstanceArrayOfDoubleCoordinatesPoints() {
        return new ArrayOfDoubleCoordinatesPoints();
    }

    public static Array<Point<Double>> getInstanceArrayOfDoubleCoordinatesPoints(Point<Double>[] pointsOfDoubleCoordinates) {
        return new ArrayOfDoubleCoordinatesPoints(pointsOfDoubleCoordinates);
    }

}
