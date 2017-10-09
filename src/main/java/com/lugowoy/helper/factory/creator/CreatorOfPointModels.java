package com.lugowoy.helper.factory.creator;

import com.lugowoy.helper.factory.FactorableOfPointsModels;
import com.lugowoy.helper.factory.models.points.FactoryOfPoints;
import com.lugowoy.helper.models.points.Point;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.CreatorOfModels
 * @see com.lugowoy.helper.factory.Factorable
 * @see com.lugowoy.helper.factory.FactorableOfModels
 * @see com.lugowoy.helper.factory.FactorableOfPointsModels
 *
 * <p>
 * A class that uses the factory implements the creation of objects of type Point<T>.
 * </p>
 *
 * @param <T> The type of numerical values with which the coordinates of the point will be initialized.
 */
public class CreatorOfPointModels<T extends Number> extends CreatorOfModels<Point<T>> implements FactorableOfPointsModels<T> {

    /**
     * <p>
     * An attribute of an object that encapsulates a concrete factory.
     * </p>
     */
    public CreatorOfPointModels(FactoryOfPoints<T> factory) {
        super(factory);
    }

    /**
     * <p>
     * Method that implements the creation of an object of type Point<T>.
     * </p>
     */
    @Override
    public Point<T> create() {
        return super.getFactory().create();
    }

    /**
     * <p>
     * Method for implementing the creation of an objects of type Point<T>.
     * </p>
     *
     * @param coordinateX The value for the coordinates of a point on the axis X.
     * @param coordinateY The value for the coordinates of a point on the axis Y.
     */
    @Override
    public Point<T> create(T coordinateX, T coordinateY) {
        return ((FactoryOfPoints<T>)super.getFactory()).create(coordinateX, coordinateY);
    }

}
