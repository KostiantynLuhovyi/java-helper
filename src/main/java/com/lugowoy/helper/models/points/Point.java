package com.lugowoy.helper.models.points;

import com.lugowoy.helper.models.Model;

import java.util.Objects;

/**
 * The class implements the point model.
 * <p>Created by Konstantin Lugowoy on 02.07.2017.
 *
 * @param <T> The type of coordinates that initialize the coordinates of a point.
 * @author Konstantin Lugowoy
 * @version 1.3
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.0
 */
public abstract class Point<T extends Number> implements Model {

    private T x;

    public Point(final T x) {
        this.x = x;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        final Point<?> point = (Point<?>) o;
        return Objects.equals(this.x, point.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x);
    }

    /**
     * Get the X coordinate value.
     *
     * @return X coordinate value.
     */
    public T getX() {
        return x;
    }

    /**
     * Set the X coordinate value.
     *
     * @param x Value to set the X coordinate..
     */
    public void setX(final T x) {
        this.x = x;
    }

}