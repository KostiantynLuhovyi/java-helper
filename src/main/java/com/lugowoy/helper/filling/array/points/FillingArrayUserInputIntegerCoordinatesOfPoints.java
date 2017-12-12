package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.creator.CreatorOfPointModels;
import com.lugowoy.helper.factory.models.points.FactoryOfPointsWithIntegerCoordinates;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfIntegerCoordinates;
import com.lugowoy.helper.reading.ReadingData;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 08-Dec-17.
 */
//todo Написать документацию. Провести полный рефакторинг.
public class FillingArrayUserInputIntegerCoordinatesOfPoints extends FillingArrayUserInputCoordinatesOfPoints<Integer> {

    public FillingArrayUserInputIntegerCoordinatesOfPoints(ReadingData readingData) {
        super(readingData);
        super.setCreatorOfPointModels(new CreatorOfPointModels<>(new FactoryOfPointsWithIntegerCoordinates()));
    }

    @Override
    public Point<Integer>[] fill(Point<Integer>[] points) {
        return Arrays.stream(CREATOR_OF_ARRAY_INTEGER_COORDINATES_OF_POINTS.create(points).getArray())
                     .map(point -> super.getCreatorOfPointModels().create(super.getReader().readInt(),
                                                                          super.getReader().readInt()))
                     .toArray(PointOfIntegerCoordinates[]::new);
    }

    @Override
    public Point<Integer>[] fill(int lengthArray) {
        return Arrays.stream(CREATOR_OF_ARRAY_INTEGER_COORDINATES_OF_POINTS.create(lengthArray).getArray())
                     .map(point -> super.getCreatorOfPointModels().create(super.getReader().readInt(),
                                                                          super.getReader().readInt()))
                     .toArray(PointOfIntegerCoordinates[]::new);
    }

}
