package com.lugowoy.helper.models.points;

/**
 * Created by Konstantin Lugowoy on 23.12.2018.
 */
//todo Add doc's.
public class Point2D<T extends Number> extends Point<T> {

    public static final int DIMENSION_2 = 2;

    public static final int INDEX_COORDINATE_X = 0;
    public static final int INDEX_COORDINATE_Y = 1;

    public Point2D(int dimension) {
        super(dimension);
    }

    @SafeVarargs
    public Point2D(T... coordinates) {
        super(coordinates);
    }

    public Point2D(T coordinateX, T coordinateY) {
        super((T[]) new Object[]{coordinateX, coordinateY});
    }

    public T getX() {
        return super.getCoordinate(INDEX_COORDINATE_X);
    }

    public void setX(T coordinate) {
        super.setCoordinate(coordinate, INDEX_COORDINATE_X);
    }

    public T getY() {
        return super.getCoordinate(INDEX_COORDINATE_Y);
    }

    public void setY(T coordinate) {
        super.setCoordinate(coordinate, INDEX_COORDINATE_Y);
    }

}
