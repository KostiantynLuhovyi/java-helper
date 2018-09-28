import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayUnknown;
import com.lugowoy.helper.filling.array.strings.FillingArrayRandomValueStrings;
import com.lugowoy.helper.models.arrays.Array;

/** Created by Konstantin Lugowoy on 02.08.2018 */

public class Test {

    public static void main(String[] args) {

        Array<String> stringArray = FactoryArray.getFactoryArray(new CreatorArrayUnknown<String>()).create(new FillingArrayRandomValueStrings("russian").fill(10));

        for (String aStringArray : stringArray) {
            System.out.print(aStringArray + " ");
        }

    }

}
