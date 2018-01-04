package com.lugowoy.helper.factory;

/**
 * Created by Konstantin Lugowoy on 04-Jan-18.
 *
 * @author Konstantin Lugowoy
 * @version 1.0
 * @since 1.0
 *
 * <p>
 * A class that implements a contract for a functional that creates objects for a functional based on the Class<T> class.
 * </p>
 *
 * @see com.lugowoy.helper.factory.Creator
 *
 * @param <T> Type of objects to create.
 */

public class CreatorUnknown<T> extends Creator<T> {

    private Class<T> clazz;

    /**
     * <p>
     * A constructor that takes an object parameter of the class Class<T> to create an object based on it.
     * </p>
     * @since 1.0
     *
     * @param clazz An object of the class Class<T> on the basis of which the object will be created.
     * */
    public CreatorUnknown(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * <p>
     * The method creates an object using a class Class<T> object encapsulated in this class.
     * </p>
     * @since 1.0
     *
     * @return The created object an object using a class Class<T> .
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
