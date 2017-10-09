package com.lugowoy.helper.factory.models.points;

import com.lugowoy.helper.factory.FactorableOfPointsModels;
import com.lugowoy.helper.factory.models.FactoryOfModels;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.Factorable
 * @see com.lugowoy.helper.factory.FactorableOfModels
 * @see com.lugowoy.helper.factory.FactorableOfPointsModels
 * @see com.lugowoy.helper.factory.Factory
 * @see com.lugowoy.helper.factory.models.FactoryOfModels
 *
 * <p>
 * An abstract class that override the methods declared by the contract to implement the factory for creating objects of type Point<T>.
 * </p>
 *
 * @param <T> The type of numerical values with which the coordinates of the point will be initialized.
 */
public abstract class FactoryOfPoints<T extends Number> extends FactoryOfModels<Point<T>> implements FactorableOfPointsModels<T> {

    /**
     * <p>
     * Method that implements the creation of an object of type Point<T>.
     * </p>
     */
    @Override
    public abstract Point<T> create();

    /**
     * <p>
     * Method for implementing the creation of an objects of type Point<T>.
     * </p>
     *
     * @param coordinateX The value for the coordinates of a point on the axis X.
     * @param coordinateY The value for the coordinates of a point on the axis Y.
     */
    @Override
    public abstract Point<T> create(T coordinateX, T coordinateY);

}
