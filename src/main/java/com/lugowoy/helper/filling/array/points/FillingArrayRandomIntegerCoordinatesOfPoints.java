package com.lugowoy.helper.filling.array.points;

import com.lugowoy.helper.factory.creator.CreatorOfPointModels;
import com.lugowoy.helper.factory.models.points.FactoryOfPointsWithIntegerCoordinates;
import com.lugowoy.helper.generator.GeneratorDataRandomInteger;
import com.lugowoy.helper.models.points.Point;
import com.lugowoy.helper.models.points.PointOfIntegerCoordinates;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 08-Dec-17.
 */
//todo Написать документацию. Провести полный рефакторинг.
public class FillingArrayRandomIntegerCoordinatesOfPoints extends FillingArrayPoints<Integer> {

    private static final int MIN_BOUND = -200;
    private static final int MAX_BOUND = 200;

    public FillingArrayRandomIntegerCoordinatesOfPoints() {
        super();
        super.setCreatorOfPointModels(new CreatorOfPointModels<>(new FactoryOfPointsWithIntegerCoordinates()));
    }

    @Override
    public Point<Integer>[] fill(Point<Integer>[] points) {
        return Arrays.stream(CREATOR_OF_ARRAY_INTEGER_COORDINATES_OF_POINTS.create(points).getArray())
                     .map(point -> super.getCreatorOfPointModels().create(GeneratorDataRandomInteger.generateInt(MIN_BOUND, MAX_BOUND),
                                                                          GeneratorDataRandomInteger.generateInt(MIN_BOUND, MAX_BOUND)))
                     .toArray(PointOfIntegerCoordinates[]::new);
    }

    @Override
    public Point<Integer>[] fill(int lengthArray) {
        return Arrays.stream(CREATOR_OF_ARRAY_INTEGER_COORDINATES_OF_POINTS.create(lengthArray).getArray())
                     .map(point -> super.getCreatorOfPointModels().create(GeneratorDataRandomInteger.generateInt(MIN_BOUND, MAX_BOUND),
                                                                          GeneratorDataRandomInteger.generateInt(MIN_BOUND, MAX_BOUND)))
                     .toArray(PointOfIntegerCoordinates[]::new);
    }

}
