package com.lugowoy.helper.factory;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 */

@FunctionalInterface
public interface CreatorUnknown<T> {

    T create(Class<T> clazz);

    static <T> T createUnknown(Class<T> clazz) {
        T resultT = null;
        try {
            resultT = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return resultT;
    }

}
