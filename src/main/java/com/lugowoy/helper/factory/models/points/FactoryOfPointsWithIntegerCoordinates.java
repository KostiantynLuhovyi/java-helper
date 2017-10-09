package com.lugowoy.helper.factory.models.points;

import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfIntegerCoordinates;

/**
 * Created by Konstantin Lugowoy on 01.08.2017.
 *
 * @author Konstantin Lugowoy
 * @see com.lugowoy.helper.factory.Factorable
 * @see com.lugowoy.helper.factory.FactorableOfModels
 * @see com.lugowoy.helper.factory.FactorableOfPointsModels
 * @see com.lugowoy.helper.factory.Factory
 * @see com.lugowoy.helper.factory.models.FactoryOfModels
 * @see com.lugowoy.helper.factory.models.points.FactoryOfPoints
 *
 * <p>
 * An abstract class that override the methods declared by the contract to implement the factory for creating objects of type Point<Integer>.
 * </p>
 */
public class FactoryOfPointsWithIntegerCoordinates extends FactoryOfPoints<Integer> {

    /**
     * <p>
     * Method that implements the creation of an object of type Point<Integer>.
     * </p>
     */
    @Override
    public Point<Integer> create() {
        return PointOfIntegerCoordinates.getInstancePointOfIntegerCoordinates();
    }

    /**
     * <p>
     * Method for implementing the creation of an objects of type Point<Integer>.
     * </p>
     *
     * @param coordinateX The value for the coordinates of a point on the axis X.
     * @param coordinateY The value for the coordinates of a point on the axis Y.
     */
    @Override
    public Point<Integer> create(Integer coordinateX, Integer coordinateY) {
        return PointOfIntegerCoordinates.getInstancePointOfIntegerCoordinates(coordinateX, coordinateY);
    }

}
