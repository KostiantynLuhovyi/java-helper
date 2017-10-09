package com.lugowoy.helper.models.points;

import com.lugowoy.helper.models.Model;

/**
 * Created by Konstantin Lugowoy on 02.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.1
 *
 * @see java.io.Serializable
 * @see Cloneable
 * @see com.lugowoy.helper.models.Model
 *
 * <p>
 *
 * </p>
 * */

public abstract class Point<T extends Number> extends Model {

    private T coordinateX;
    private T coordinateY;

    public Point() {
    }

    public Point(T coordinateX, T coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        if (!super.equals(o)) return false;

        Point<?> point = (Point<?>) o;

        if (coordinateX != null ? !coordinateX.equals(point.coordinateX) : point.coordinateX != null) return false;
        return coordinateY != null ? coordinateY.equals(point.coordinateY) : point.coordinateY == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (coordinateX != null ? coordinateX.hashCode() : 0);
        result = 31 * result + (coordinateY != null ? coordinateY.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Point[" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                ']';
    }

    /**
     * <p>
     *
     * </p>
     * */
    public T getCoordinateX() {
        return coordinateX;
    }

    /**
     * <p>
     *
     * </p>
     * */
    public void setCoordinateX(T coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * <p>
     *
     * </p>
     * */
    public T getCoordinateY() {
        return coordinateY;
    }

    /**
     * <p>
     *
     * </p>
     * */
    public void setCoordinateY(T coordinateY) {
        this.coordinateY = coordinateY;
    }

}

