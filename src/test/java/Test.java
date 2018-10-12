import com.lugowoy.helper.factory.FactoryMatrix;
import com.lugowoy.helper.factory.creator.matrixes.CreatorMatrix;
import com.lugowoy.helper.filling.matrixes.FillerMatrix;
import com.lugowoy.helper.filling.matrixes.numbers.FillerMatrixNumbers;
import com.lugowoy.helper.filling.matrixes.numbers.FillingMatrixReadDoubleNumbers;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Matrix;

/** Created by Konstantin Lugowoy on 02.10.2018. */

public class Test {

    public static void main(String[] args) {

        Matrix<Double> matrix = FactoryMatrix.getFactoryMatrix(new CreatorMatrix<Double>()).create(3, 3);

        System.out.println(matrix);

        FillerMatrix<Double> fillerMatrix = new FillerMatrixNumbers<>(new FillingMatrixReadDoubleNumbers(new ReadingConsole()));

        fillerMatrix.fill(matrix);

        System.out.println(matrix);


    }

}
