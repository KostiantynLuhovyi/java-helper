import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayNumbers;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.models.matrixes.Matrix;
import com.lugowoy.helper.other.GeneratorRandomNumber;

import java.util.ArrayList;
import java.util.Arrays;

/** Created by Konstantin Lugowoy on 02.10.2018. */

public class Test {

    public static void main(String[] args) {

        Matrix<Double> matrix = new Matrix<>(10, 10);

        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                matrix.setElementMatrix(i, j, GeneratorRandomNumber.generateDouble(0, 50));
            }
        }

        System.out.println(matrix);

        Double[][] doubles = new Double[matrix.getRows()][matrix.getColumns()];

        matrix.toMatrix(doubles);

        System.out.println(Arrays.deepToString(doubles));

        System.out.println(matrix.getElementMatrix(3, 5));

        Array<Double> array = matrix.getColumnObjectArray(4);

        System.out.println(array);

    }



}
