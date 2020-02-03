import com.lugowoy.helper.filling.array.numbers.FillerArrayNumbers;
import com.lugowoy.helper.filling.array.numbers.FillingArrayRandomIntegers;
import com.lugowoy.helper.filling.matrix.FillerMatrix;
import com.lugowoy.helper.filling.matrix.numbers.FillingMatrixRandomIntegers;

import java.util.Arrays;

/**
 * Created by Konstantin Lugowoy on 02.10.2018.
 */
public class Test {

    public static void main(String[] args) {

        FillerArrayNumbers<Integer> fillerArrayNumbers = new FillerArrayNumbers<>();
        fillerArrayNumbers.setFilling(new FillingArrayRandomIntegers());

        System.out.println(Arrays.toString(fillerArrayNumbers.fill(10, 10)));

        FillerMatrix<Integer> fillerMatrix = new FillerMatrix<>();
        fillerMatrix.setFilling(new FillingMatrixRandomIntegers());

        System.out.println(Arrays.deepToString(fillerMatrix.fill(5, 5)));

    }

}
