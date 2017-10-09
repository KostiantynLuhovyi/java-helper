package com.lugowoy.helper.models.points;

/** Created by Konstantin Lugowoy on 31.07.2017. */

public class PointOfDoubleCoordinates extends Point<Double> {

    private static final double DEFAULT_VALUE_DOUBLE_COORDINATES = 0.0;

    private PointOfDoubleCoordinates() {
        super();
        super.setCoordinateX(DEFAULT_VALUE_DOUBLE_COORDINATES);
        super.setCoordinateY(DEFAULT_VALUE_DOUBLE_COORDINATES);
    }

    private PointOfDoubleCoordinates(Double coordinateX, Double coordinateY) {
        super(coordinateX, coordinateY);
    }

    @Override
    public PointOfDoubleCoordinates clone() throws CloneNotSupportedException {
        Point<Double> point = (PointOfDoubleCoordinates) super.clone();
        point.setCoordinateX(this.getCoordinateX());
        point.setCoordinateY(this.getCoordinateY());

        return (PointOfDoubleCoordinates) point;
    }


    public static PointOfDoubleCoordinates getInstancePointOfDoubleCoordinates() {
        return new PointOfDoubleCoordinates();
    }

    public static PointOfDoubleCoordinates getInstancePointOfDoubleCoordinates(Double coordinateX, Double coordinateY) {
        return new PointOfDoubleCoordinates(coordinateX, coordinateY);
    }

}
