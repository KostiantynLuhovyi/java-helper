package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.creator.CreatorOfArrayModels;
import com.lugowoy.helper.factory.creator.CreatorOfPointModels;
import com.lugowoy.helper.factory.models.array.FactoryOfDoubleCoordinatesPointsOfArrayModels;
import com.lugowoy.helper.factory.models.array.FactoryOfIntegerCoordinatesPointsOfArrayModels;
import com.lugowoy.helper.filling.array.FillingArray;
import com.lugowoy.helper.models.points.Point;

/** Created by Konstantin Lugowoy on 08-Dec-17. */

public abstract class FillingArrayPoints<T extends Number> extends FillingArray<Point<T>> {

    public static final CreatorOfArrayModels<Point<Double>> CREATOR_OF_ARRAY_DOUBLE_COORDINATES_OF_POINTS =
                                                                            new CreatorOfArrayModels<>(
                                                                                    new FactoryOfDoubleCoordinatesPointsOfArrayModels());

    public static final CreatorOfArrayModels<Point<Integer>> CREATOR_OF_ARRAY_INTEGER_COORDINATES_OF_POINTS =
                                                                            new CreatorOfArrayModels<>(
                                                                                    new FactoryOfIntegerCoordinatesPointsOfArrayModels());

    private CreatorOfPointModels<T> creatorOfPointModels;

    @Override
    public abstract Point<T>[] fill(Point<T>[] points);

    @Override
    public abstract Point<T>[] fill(int lengthArray);

    public CreatorOfPointModels<T> getCreatorOfPointModels() {
        return creatorOfPointModels;
    }

    protected void setCreatorOfPointModels(CreatorOfPointModels<T> creatorOfPointModels) {
        this.creatorOfPointModels = creatorOfPointModels;
    }

}
