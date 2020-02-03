package com.lugowoy.helper.filling;

/**
 * The class is the root of the hierarchy providing a container for storing and using (delegates the execution)
 * the implementation of the functionality declared in the {@link Filling} interface
 * for filling an object or storage (data structure) with data.
 * <p>The implementation of filling an object or storage (data structure) will be obtained
 * from a specific object that will be transferred when creating an object of this class.
 * <p>Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @param <T> Type of data to fill storage(data structure) or the object.
 * @author Konstantin Lugowoy
 * @version 1.4
 */
public abstract class Filler<T> {

    private Filling<T> filling;

    protected Filler() {
    }

    /**
     * Constructs a new object of this class by initializing it with a concrete implementation of the contract declared
     * in the {@link Filling} interface.
     *
     * @param filling The object implements the contract declared in the {@link Filling} interface.
     */
    protected Filler(Filling<T> filling) {
        this.filling = filling;
    }

    /**
     * Fills an object or data structure from argument {@code t} with data.
     *
     * @param t The object or storage(data structure) to fill with data.
     */
    public void fill(T t) {
        this.filling.fill(t);
    }

    /**
     * Gets the object provides functionality and implementation of the contract declared in the {@link Filling} interface
     * to fill an object or data structure with data.
     *
     * @return The object provides functionality to fill an object or data structure with data.
     */
    protected Filling<T> getFilling() {
        return this.filling;
    }

    public void setFilling(Filling<T> filling) {
        this.filling = filling;
    }

}
