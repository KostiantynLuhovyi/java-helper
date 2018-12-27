package com.lugowoy.helper.models.points;

import com.lugowoy.helper.models.IncorrectIndexesAvailableException;
import com.lugowoy.helper.models.IncorrectLengthAvailableException;
import com.lugowoy.helper.models.Model;

import java.util.Arrays;
import java.util.Objects;
//todo Add and edit doc's.
/**
 * The class representing an implementation for using a model of point.
 * <p>Created by Konstantin Lugowoy on 02.07.2017.
 *
 * @param <T> The type of coordinates that initialize the coordinates of a point.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @see com.lugowoy.helper.models.Model
 * @see java.io.Serializable
 * @see java.lang.Cloneable
 * @since 1.0
 */
public class Point<T extends Number> implements Model {

    private int dimension;
    private Object[] coordinates;

    public Point(int dimension) {
        if (dimension > 0) {
            this.dimension = dimension;
            this.coordinates = new Object[dimension];
        } else {
            throw new IllegalArgumentException("Argument 'dimension' is not valid.");
        }
    }

    public Point(T... coordinates) {
        if (coordinates != null) {
            this.dimension = coordinates.length;
            this.coordinates = coordinates;
        } else {
            throw new NullPointerException("Argument 'coordinates' is null.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point<?> point = (Point<?>) o;
        return dimension == point.dimension &&
                Arrays.equals(coordinates, point.coordinates);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dimension);
        result = 31 * result + Arrays.hashCode(coordinates);
        return result;
    }

    @Override
    public String toString() {
        return "Point[" +
                "dimension=" + dimension +
                ", coordinates=" + Arrays.toString(coordinates) +
                ']';
    }

    public int getDimension() {
        return dimension;
    }

    public Object[] getCoordinates() {
        return coordinates;
    }

    public T[] getCoordinates(T[] coordinates) {
        if (coordinates != null) {
            if (coordinates.length >= this.dimension) {
                coordinates = (T[]) Arrays.copyOfRange(this.coordinates, 0, this.dimension);
            } else {
                throw new IncorrectLengthAvailableException("Length attribute of 'coordinates' is not valid.");
            }
        } else {
            throw new NullPointerException("Argument 'coordinates' is null.");
        }
        return coordinates;
    }

    public void setCoordinates(T... coordinates) {
        this.coordinates = coordinates;
    }

    public T getCoordinate(int index) {
        T result;
        if (isCorrectIndex(index)) {
            result = (T) this.coordinates[index];
        } else {
            throw new IncorrectIndexesAvailableException("Argument 'index' is not valid.");
        }
        return result;
    }

    public void setCoordinate(T coordinate, int index) {
        if (isCorrectIndex(index)) {
            this.coordinates[index] = coordinate;
        } else {
            throw new IncorrectIndexesAvailableException("Argument 'index' is not valid.");
        }
    }

    private boolean isCorrectIndex(int index) {
        return index >= 0 && index <= this.dimension;
    }

}