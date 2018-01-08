package com.lugowoy.helper.factory;

import com.lugowoy.helper.factory.creator.CreatorPoint;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The class provides the functionality of the factory to create {@link Point} class objects.
 * The functionality for creating objects is implemented in the package classes com.lugowoy.helper.factory.creating .
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator
 */

public class FactoryPoint extends Factory {

    /**
     * <p>
     * The method that creates the object by delegating the execution of the object creation
     *  to the object of the class {@link CreatorPoint} passed by the parameter,
     *  which encapsulates the implementation to create the object class {@link Point}.
     * </p>
     * @since 1.0
     *
     * @see com.lugowoy.helper.factory.creator.CreatorPoint
     *
     * @param <T> The type of coordinates encapsulated in the object of the {@link Point} class.
     *
     * @param creatorPoint An encapsulating implementation object for creating a {@link CreatorPoint} type of objects.
     * @param coordinateX The parameter initializing the X coordinate.
     * @param coordinateY The parameter initializing the Y coordinate.
     *
     * @return Created {@link Point} class object.
     * */
    public <T extends Number> Point<T> create(CreatorPoint<T> creatorPoint, T coordinateX, T coordinateY) {
        return creatorPoint.create(coordinateX, coordinateY);
    }

    /**
     * <p>
     * A class method that creates and returns a new instance of the {@link FactoryPoint}.
     * </p>
     * @since 1.0
     *
     * @return Object type {@link FactoryPoint}
     */
    public static FactoryPoint getFactoryPoint() {
        return new FactoryPoint();
    }

}
