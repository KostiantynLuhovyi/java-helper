package com.lugowoy.helper.models.points;

import java.util.Objects;

/**
 * The class implements the 2D point model.
 * <p>Created by Konstantin Lugowoy on 23.12.2018.
 *
 * @param <T> The type of coordinates that initialize the coordinates of a 2D point.
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.models.Model
 * @see com.lugowoy.helper.models.points.Point
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.6
 */
public class Point2D<T extends Number> extends Point<T> {

    private T y;

    /**
     * Constructs a new 2D point object.
     *
     * @param x Value to initialize X coordinate.
     * @param y Value to initialize Y coordinate.
     */
    public Point2D(T x, T y) {
        super.setX(x);
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;
        if (!super.equals(o)) return false;
        Point2D<?> point2D = (Point2D<?>) o;
        return Objects.equals(y, point2D.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), y);
    }

    @Override
    public String toString() {
        return "Point2D[" +
                "x=" + super.getX() +
                "y=" + y +
                ']';
    }

    /**
     * Get the Y coordinate value.
     *
     * @return Y coordinate value.
     */
    public T getY() {
        return y;
    }

    /**
     * Set the Y coordinate value.
     *
     * @param y Value to set the Y coordinate.
     */
    public void setY(T y) {
        this.y = y;
    }

}
