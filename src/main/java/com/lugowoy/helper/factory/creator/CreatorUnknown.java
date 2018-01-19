package com.lugowoy.helper.factory.creator;

/**
 * Created by Konstantin Lugowoy on 04-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * The class implements the creation of objects based on the class {@link Class}.
 * </p>
 *
 * @see com.lugowoy.helper.factory.creator.Creator
 * @see com.lugowoy.helper.factory.creator.Creating
 *
 * @param <T> Type of objects to create.
 */

public class CreatorUnknown<T> extends Creator<T> {

    private Class<T> clazz;

    /**
     * <p>
     * A constructor with a parameter is used to create an object based on a type parameter {@link Class}.
     * </p>
     *
     * @param clazz An object of the class Class<T> on the basis of which the object will be created.
     *
     * @since 1.0
     */
    public CreatorUnknown(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * <p>
     * The method creates an object using a class {@link Class} object encapsulated in this class.
     * </p>
     *
     * @return The created object an object using a class {@link Class}.
     *
     * @since 1.0
     */
    @Override
    public T create() {
        T t = null;
        try {
            t = this.clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

}
