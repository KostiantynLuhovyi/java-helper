package com.lugowoy.helper.filling;

/**
 * The class is the root of the hierarchy of container classes for encapsulating functionality for filling objects or
 * storages (data structures) with data.
 * Objects of this class delegate the execution of functionality to objects whose classes implement the {@link Filling} interface.
 * <p> Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> the type data to fill storage(data structure) or the object.
 * @author Konstantin Lugowoy
 * @version 1.5
 */
public abstract class Filler<T> {

    private Filling<T> filling;

    /**
     * Constructs a new object, without initializing the functionality to fill.
     */
    protected Filler() {
    }

    /**
     * Constructs a new object, initializing by the implementation of the functionality to fill.
     * The implementation of functionality provided by the object of the classes that implement the {@link Filling} interface.
     *
     * @param filling the object that implementation of functionality to fill.
     */
    protected Filler(Filling<T> filling) {
        this.filling = filling;
    }

    /**
     * Fills {@code t} with data.
     *
     * @param t the object or storage(data structure) to fill.
     */
    public void fill(T t) {
        this.filling.fill(t);
    }

    /**
     * Gets the object encapsulated in this class and implements the {@link Filling} interface to fill the object
     * or data structure with data.
     *
     * @return the object that implements of functionality to fill.
     */
    protected Filling<T> getFilling() {
        return this.filling;
    }

    /**
     * Sets the implementation of functionality for filling objects or data structures with data.
     * The implementation of functionality provided by the object of the classes that implement the {@link Filling} interface.
     *
     * @param filling the object that implementation of functionality to fill.
     */
    protected void setFilling(Filling<T> filling) {
        this.filling = filling;
    }

}
