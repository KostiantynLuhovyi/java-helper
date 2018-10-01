package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * The class implements the creation of class objects {@link Point}.
 *
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.Creating
 *
 * @param <T> The type of coordinates encapsulated in the created class object {@link Point}.
 */

public class CreatorPoint<T extends Number> extends Creator<Point<T>> {

    /**
     * The method creates an object of the {@link Point} type that calls the default constructor.
     *
     * @return The created object of type Point<T> .
     */
    public Point<T> create() {
        return new Point<>();
    }

    /**
     * The method creates an object of type {@link Point} calling the constructor with a parameters
     *  and passing it the parameters passed to the method.
     *
     * @param coordinateX The parameter initializing the X coordinate.
     * @param coordinateY The parameter initializing the Y coordinate.
     * @return The created object of type {@link Point}.
     */
    public Point<T> create(T coordinateX, T coordinateY) {
        return new Point<>(coordinateX, coordinateY);
    }

}
