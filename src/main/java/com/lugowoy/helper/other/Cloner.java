package com.lugowoy.helper.other;

/**
 *  Created by Konstantin Lugowoy on 02.03.2017
 *
 *  @author Konstantin Lugowoy
 *  @version 1.0
 *  @since 1.0
 *
 *  Provides a constant performing deep copying.
 *  <p> Delegates execution to a class {@link com.rits.cloning.Cloner} from the library deep-cloning-1.9.0.jar
 *      See : <a href="https://code.google.com/archive/p/cloning/">cloning</a>
 *      See on GitHub : <a href="https://github.com/kostaskougios/cloning">cloning on GitHub</a>
 */

public interface Cloner {

    /**
     * Constant performing deep copying.
     */
    com.rits.cloning.Cloner CLONER = new com.rits.cloning.Cloner();

}
