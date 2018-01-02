package com.lugowoy.helper.factory;

import com.lugowoy.helper.models.Model;

/**
 * Created by Konstantin Lugowoy on 02-Jan-18.
 */

public abstract class CreatorModel extends Creator<Model> {

    @Override
    public abstract Model create();

}
