package com.lugowoy.helper.filling;

/**
 * Created by Konstantin Lugowoy on 08-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.1
 * @since 1.0
 *
 * <p>
 *
 * </p>
 *
 * @see com.lugowoy.helper.filling.Filling
 *
 * @param <T>
 */

//todo add documentation
public class Filler<T> implements Filling<T> {

    private Filling<T> filling;

    /**
     * <p></p>
     *
     * @since 1.0
     */
    protected Filler() {
    }

    /**
     * <p></p>
     *
     * @param filling
     *
     * @since 1.0
     */
    protected Filler(Filling<T> filling) {
        this.filling = filling;
    }

    /**
     * <p></p>
     *
     * @param t
     *
     * @return
     *
     * @since 1.0
     */
    public T fill(T t) {
        return this.filling.fill(t);
    }

    /**
     * <p></p>
     *
     * @return
     *
     * @since 1.0
     */
    protected Filling<T> getFilling() {
        return filling;
    }

    /**
     * <p></p>
     *
     * @param filling
     *
     * @return
     *
     * @since 1.1
     */
    public static <T> Filler<T> getFiller(Filling<T> filling) {
        return new Filler<>(filling);
    }

}
