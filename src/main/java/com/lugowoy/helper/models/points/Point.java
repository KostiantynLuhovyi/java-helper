package com.lugowoy.helper.models.points;

import com.lugowoy.helper.models.Model;

/**
 * Created by Konstantin Lugowoy on 02.07.2017.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 20.12.2017
 * <p>
 *     A class representing an implementation for using a model of point.
 * </p>
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @param <T> The type of objects that initialize the coordinates of a point.
 */

public class Point<T extends Number> implements Model {

    private T coordinateX;
    private T coordinateY;

    /**
     * <p>
     *      The default constructor creates a point object without initializing the coordinates values.
     *      Value of coordinates is a null.
     * </p>
     */
    public Point() {
    }

    /**
     * <p>
     *     The constructor creates a point object that initializes coordinates values.
     *
     *     If both passed arguments have non null values, then these values initialize the coordinates of the point,
     *     otherwise the coordinates are null.
     * </p>
     */
    public Point(final T coordinateX, final T coordinateY) {
        if ((coordinateX != null) && (coordinateY != null)) {
            this.coordinateX = coordinateX;
            this.coordinateY = coordinateY;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point<?> point = (Point<?>) o;

        if (getCoordinateX() != null ? !getCoordinateX().equals(point.getCoordinateX()) : point.getCoordinateX() != null)
            return false;
        return getCoordinateY() != null ? getCoordinateY().equals(point.getCoordinateY()) : point.getCoordinateY() == null;
    }

    @Override
    public int hashCode() {
        int result = getCoordinateX() != null ? getCoordinateX().hashCode() : 0;
        result = 31 * result + (getCoordinateY() != null ? getCoordinateY().hashCode() : 0);
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Point<T> clone() throws CloneNotSupportedException {
        Point<T> point = (Point<T>) super.clone();
        point.setCoordinateX(this.getCoordinateY());
        point.setCoordinateY(this.getCoordinateY());
        return point;
    }

    @Override
    public String toString() {
        return "Point[" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                ']';
    }

    /**
     * <p>Returns the value of the X coordinate.</p>
     */
    public T getCoordinateX() {
        return coordinateX;
    }

    /**
     * <p>
     *     Set the coordinate value X.
     *
     *     If passed arguments have non null value, then these value initialize the coordinate of the point,
     *     otherwise the coordinate are null.
     * </p>
     * @param coordinateX The value to initialize the coordinate.
     */
    public void setCoordinateX(final T coordinateX) {
        this.coordinateX = coordinateX;
    }

    /**
     * <p>Returns the value of the Y coordinate.</p>
     */
    public T getCoordinateY() {
        return coordinateY;
    }

    /**
     * <p>
     *     Set the coordinate value Y.
     *
     *     If passed arguments have non null value, then these value initialize the coordinate of the point,
     *     otherwise the coordinate are null.
     * </p>
     * @param coordinateY The value to initialize the coordinate.
     */
    public void setCoordinateY(final T coordinateY) {
        this.coordinateY = coordinateY;
    }

}
