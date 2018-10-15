import com.lugowoy.helper.models.Array;

/** Created by Konstantin Lugowoy on 02.10.2018. */

public class Test {

    public static void main(String[] args) {

        Array<Integer> array = Array.create();

        array.add(12);

        System.out.println(array);

        array.set(20, 50);

        System.out.println(array);

    }

}
