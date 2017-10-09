package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.Factorable
 * @see com.lugowoy.helper.factory.FactorableOfModels
 *
 * <p>
 * An interface that declares the methods of the contract that must be implemented for the factory to create objects of type Point.
 * </p>
 *
 * @param <T> The parameter whose type will be the coordinates of the point.
 */
public interface FactorableOfPointsModels<T extends Number> extends FactorableOfModels<Point<T>> {

    /**
     * <p>
     * Method for implementing the creation of objects of type Point.
     * </p>
     *
     * @param coordinateX The value for the coordinates of a point on the axis X.
     * @param coordinateY The value for the coordinates of a point on the axis Y.
     */
    Point<T> create(T coordinateX, T coordinateY);

}
