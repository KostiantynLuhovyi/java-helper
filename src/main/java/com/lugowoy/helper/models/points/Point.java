package com.lugowoy.helper.models.points;

import com.lugowoy.helper.models.Model;
import com.lugowoy.helper.other.DeepCloning;

import java.util.Objects;

/**
 * The class representing an implementation for using a model of point.
 * <p>Created by Konstantin Lugowoy on 02.07.2017.
 *
 * @param <T> The type of objects that initialize the coordinates of a point.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.0
 */
public class Point<T extends Number> implements Model {

    private T coordinateX;
    private T coordinateY;

    /**
     * The default constructor creates a point object without initializing the coordinates values.
     * Value of coordinates is a null.
     *
     * @since 1.0
     */
    public Point() {
        super();
    }

    /**
     * The constructor creates a point object that initializes coordinates values.
     * <p> If both passed by parameter have non null values, then these values initialize the coordinates of the point,
     *  otherwise the coordinates are null.
     *
     * @since 1.0
     */
    public Point(T coordinateX, T coordinateY) {
        if ((coordinateX != null) && (coordinateY != null)) {
            this.coordinateX = coordinateX;
            this.coordinateY = coordinateY;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point<?> point = (Point<?>) o;
        return Objects.equals(getCoordinateX(), point.getCoordinateX()) &&
                Objects.equals(getCoordinateY(), point.getCoordinateY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinateX(), getCoordinateY());
    }

    @Override
    public String toString() {
        return "Point[" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                ']';
    }

    @SuppressWarnings("unchecked") // Type safety. Unchecked cast Object[] to T[].
    @Override
    public Point<T> clone() {
        Point<T> point = new Point<>();
        try {
            point = (Point<T>) super.clone();
            point.setCoordinateX(DeepCloning.CLONER.deepClone(this.getCoordinateX()));
            point.setCoordinateY(DeepCloning.CLONER.deepClone(this.getCoordinateY()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return point;
    }

    /**
     * Returns the value of the X coordinate of the point.
     *
     * @return Returns the value of the X coordinate.
     *
     * @since 1.0
     */
    public T getCoordinateX() {
        return coordinateX;
    }

    /**
     * Set the coordinate value X of the point.
     * <p> If passed by parameter have non null value, then these value initialize the coordinate of the point,
     *  otherwise the coordinate are null.
     *
     * @param coordinateX The value to initialize the coordinate X.
     *
     * @since 1.0
     */
    public void setCoordinateX(T coordinateX) {
        if (coordinateX != null) {
            this.coordinateX = coordinateX;
        }
    }

    /**
     * Returns the value of the Y coordinate of the point.
     *
     * @return Returns the value of the Y coordinate.
     *
     * @since 1.0
     */
    public T getCoordinateY() {
        return coordinateY;
    }

    /**
     * Set the coordinate value X of the point.
     * <p> If passed by parameter have non null value, then these value initialize the coordinate of the point,
     *  otherwise the coordinate are null.
     *
     * @param coordinateY The value to initialize the coordinate Y.
     *
     * @since 1.0
     */
    public void setCoordinateY(T coordinateY) {
        this.coordinateY = coordinateY;
    }

}
