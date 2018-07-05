package com.lugowoy.helper.other;

import com.rits.cloning.Cloner;

/**
 *  Created by Konstantin Lugowoy on 02.03.2017
 *
 *  @author Konstantin Lugowoy
 *  @version 1.0
 *  @since 1.0
 *
 *  Provides a constant performing deep cloning.
 *  <p> Delegates execution to a class {@link Cloner}.
 *      See: <a href="https://mvnrepository.com/artifact/uk.com.robust-it/cloning/1.9.9">cloning</a>
 *      See on GitHub: <a href="https://github.com/kostaskougios/cloning">cloning on GitHub</a>
 */

public interface DeepCloning {

    /**
     * Constant performing deep copying.
     */
    Cloner CLONER = new Cloner();

}
