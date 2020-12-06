package com.lugowoy.helper.filling;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * This class is a container that encapsulates the functionality for filling
 * objects or storages (data structures) with data. The execution of
 * functionality delegated through classes objects implementing the {@link
 * Filling} interface.
 * <p> Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> the data type to fill objects or storage(data structure).
 * @author Konstantin Lugowoy
 * @version 1.6
 */
//TODO review documentation
public class Filler<T> {

    private Filling<T> filling;

    /**
     * Constructs a new object, initializing the implementation of the
     * functionality to fill. The implementation of functionality provided by
     * class objects that implement the {@link Filling} interface.
     *
     * @param filling the object that implementation of functionality to fill.
     */
    public Filler(@NotNull final Filling<T> filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }

    /**
     * Fills the {@code t} object with data. The functionality execution
     * delegated through an object encapsulated in an object of this class.
     *
     * @param t the object or storage(data structure) to fill.
     */
    public void fill(@NotNull final T t) {
        this.filling.fill(t);
    }

    /**
     * Gets the object encapsulated in this class and implements the {@link
     * Filling} interface to fill the object or storages(data structure) with
     * data.
     *
     * @return the object that implements of functionality to fill.
     */
    public Filling<T> getFilling() {
        return this.filling;
    }

    /**
     * Sets the implementation of functionality for filling objects or
     * storages(data structures) with data. The implementation of functionality
     * provided by the object of the classes that implement the {@link Filling}
     * interface.
     *
     * @param filling the object that implementation of functionality to fill.
     */
    public void setFilling(@NotNull final Filling<T> filling) {
        Objects.requireNonNull(filling, "Filling is null");
        this.filling = filling;
    }

}
