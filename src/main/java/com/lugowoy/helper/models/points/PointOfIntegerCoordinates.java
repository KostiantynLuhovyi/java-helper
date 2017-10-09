package com.lugowoy.helper.models.points;

/** Created by Konstantin Lugowoy on 31.07.2017. */

public class PointOfIntegerCoordinates extends Point<Integer> {

    private static final int DEFAULT_VALUE_INTEGER_COORDINATES = 0;

    private PointOfIntegerCoordinates() {
        super();
        super.setCoordinateX(DEFAULT_VALUE_INTEGER_COORDINATES);
        super.setCoordinateY(DEFAULT_VALUE_INTEGER_COORDINATES);
    }

    private PointOfIntegerCoordinates(Integer coordinateX, Integer coordinateY) {
        super(coordinateX, coordinateY);
    }

    @Override
    public PointOfIntegerCoordinates clone() throws CloneNotSupportedException {
        Point<Integer> point = (PointOfIntegerCoordinates) super.clone();
        point.setCoordinateX(this.getCoordinateX());
        point.setCoordinateY(this.getCoordinateY());

        return (PointOfIntegerCoordinates) point;
    }

    public static PointOfIntegerCoordinates getInstancePointOfIntegerCoordinates() {
        return new PointOfIntegerCoordinates();
    }

    public static PointOfIntegerCoordinates getInstancePointOfIntegerCoordinates(Integer coordinateX, Integer coordinateY) {
        return new PointOfIntegerCoordinates(coordinateX, coordinateY);
    }

}
