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
     * The method creates an object of the {@link Point} type that calls the default constructor.
     * </p>
     *
     * @see com.lugowoy.helper.models.points.Point
     *
     * @return The created object of type Point<T> .
     *
     * @since 1.0
     */
    public Point<T> create() {
        return new Point<>();
    }

    /**
     * <p>
     * The method creates an object of type {@link Point} calling the constructor with a parameters
     *  and passing it the parameters passed to the method.
     * </p>
     *
     * @see com.lugowoy.helper.models.points.Point
     *
     * @param coordinateX The parameter initializing the X coordinate.
     * @param coordinateY The parameter initializing the Y coordinate.
     *
     * @return The created object of type {@link Point}.
     *
     * @since 1.0
     */
    public Point<T> create(T coordinateX, T coordinateY) {
        return new Point<>(coordinateX, coordinateY);
    }

}
