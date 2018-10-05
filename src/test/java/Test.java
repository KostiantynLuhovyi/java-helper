import com.lugowoy.helper.filling.matrixes.FillerMatrix;
import com.lugowoy.helper.filling.matrixes.numbers.FillerMatrixNumbers;
import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixRandomDoubleNumbers;
import com.lugowoy.helper.models.matrixes.Matrix;

/** Created by Konstantin Lugowoy on 02.10.2018. */

public class Test {

    public static void main(String[] args) {

        Matrix<Double> matrix = null;

        FillerMatrix<Double> fillerMatrix = new FillerMatrixNumbers<>(new FillingMatrixRandomDoubleNumbers());

        fillerMatrix.fill(matrix);

        System.out.println(matrix);

    }

}
