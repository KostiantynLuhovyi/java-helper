package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The class implements the creation of class objects {@link Point}.
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.Creating
 *
 * @param <T> The type of coordinates encapsulated in the created class object {@link Point}.
 */

public class CreatorPoint<T extends Number> extends Creator<Point<T>> {

    /**
     * <p>
     * A constructor called to create a class object {@link Point} using its constructor without parameters {@link Point}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.Creator
     */
    public CreatorPoint() {
        this.create();
    }

    /**
     * <p>
     * A constructor with a parameter, the use of which creates a class object {@link Point} invoking its constructor {@link Point#Point(Number, Number)}
     *  into which an array of objects is transferred which will be encapsulated in the created object.
     * </p>
     * @since 1.0
     *
     * @param coordinateX The parameter initializing the X coordinate.
     * @param coordinateY The parameter initializing the Y coordinate.
     */
    public CreatorPoint(T coordinateX, T coordinateY) {
        this.create(coordinateX, coordinateY);
    }

    /**
     * <p>
     * The method creates an object of the {@link Point} type that calls the default constructor.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.points.Point
     *
     * @return The created object of type Point<T> .
     */
    public Point<T> create() {
        return new Point<>();
    }

    /**
     * <p>
     * The method creates an object of type {@link Point} calling the constructor with a parameters
     *  and passing it the parameters passed to the method.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.models.points.Point
     *
     * @param coordinateX The parameter initializing the X coordinate.
     * @param coordinateY The parameter initializing the Y coordinate.
     *
     * @return The created object of type {@link Point}.
     */
    public Point<T> create(T coordinateX, T coordinateY) {
        return new Point<>(coordinateX, coordinateY);
    }

}
