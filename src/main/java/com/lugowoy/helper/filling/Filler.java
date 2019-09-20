package com.lugowoy.helper.filling;

/**
 * The class is the root of the hierarchy providing a container for storing and using (delegates the execution)
 * the implementation of the functionality declared in the {@link Filling} interface
 * for filling an object or storage (data structure) with data.
 * <p>The implementation of filling an object or storage (data structure) will be taken (received)
 * from a specific object that will be transferred when creating an object of this class.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of data elements and storage(data structure) or the object to fill.
 * @author Konstantin Lugowoy
 * @version 1.3
 */
public class Filler<T> {

    private Filling<T> filling;

    /**
     * Constructs a new object by initializing it with a concrete implementation of the contract declared
     * in the {@link Filling} interface to fill.
     *
     * @param filling The object implements the contract declared in the {@link Filling} interface to fill.
     */
    protected Filler(Filling<T> filling) {
        this.filling = filling;
    }

    /**
     * Fills the object or storage(data storage) with data.
     *
     * @param t The object or storage(data structure) to fill with data.
     */
    public void fill(T t) {
        this.filling.fill(t);
    }

    /**
     * Gets the object provides functionality and implementation
     * of the contract declared in the {@link Filling} interface to fill with data.
     *
     * @return The object provides functionality and implementation to fill with data.
     */
    protected Filling<T> getFilling() {
        return this.filling;
    }

    /**
     * Creates a new object of the {@link Filler} class.
     *
     * @param filling The object implementation of the contract declared in the {@link Filling} interface to fill with data.
     * @return Created object of this class.
     */
    public static <T> Filler<T> getFiller(Filling<T> filling) {
        return new Filler<>(filling);
    }

}
