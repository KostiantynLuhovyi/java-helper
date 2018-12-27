package com.lugowoy.helper.models.points;

/**
 * Created by Konstantin Lugowoy on 27.12.2018.
 */
//todo Add doc's.
public class Point3D<T extends Number> extends Point2D<T> {

    public static final int DIMENSION_3 = 3;

    public static final int INDEX_COORDINATE_Z = 2;

    public Point3D(int dimension) {
        super(dimension);
    }

    public Point3D(T... coordinates) {
        super(coordinates);
    }

    public Point3D(T coordinateX, T coordinateY, T coordinateZ) {
        super((T[]) new Object[]{coordinateX, coordinateY, coordinateZ});
    }

    public T getZ() {
        return super.getCoordinate(INDEX_COORDINATE_Z);
    }

    public void setZ(T coordinate, int index) {
        super.setCoordinate(coordinate, index);
    }

}
