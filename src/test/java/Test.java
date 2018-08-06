import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayUnknown;
import com.lugowoy.helper.filling.array.strings.FillingArrayRandomLengthStrings;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.GeneratorRandomNumber;

/** Created by Konstantin Lugowoy on 02.08.2018 */

public class Test {

    public static void main(String[] args) {

        System.out.println("Byte : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateByte() + " ");
        }
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateByte((byte) 20) + " ");
        }
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateByte((byte) -128, (byte) 127) + " ");
        }
        System.out.println();
        System.out.println("Short : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateShort() + " ");
            System.out.print(GeneratorRandomNumber.generateShort((short) 32000) + " ");
            System.out.print(GeneratorRandomNumber.generateShort((short) -32000, (short) 32000) + " ");
        }
        System.out.println();
        System.out.println("Int : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateInt() + " ");
            System.out.print(GeneratorRandomNumber.generateInt(200000000) + " ");
            System.out.print(GeneratorRandomNumber.generateInt(-200000000, 200000000) + " ");
        }
        System.out.println();
        System.out.println("Long : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateLong() + " ");
            System.out.print(GeneratorRandomNumber.generateLong(2000000000) + " ");
            System.out.print(GeneratorRandomNumber.generateLong(-2000000000, 2000000000) + " ");
        }
        System.out.println();
        System.out.println("Double : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateDouble() + " ");
        }
        System.out.println();
        System.out.print("Float : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateFloat() + " ");
        }

        System.out.println();
        System.out.println(GeneratorRandomNumber.generateInt(10));

        Array<String> stringArray = FactoryArray.getFactoryArray(new CreatorArrayUnknown<String>()).create(new FillingArrayRandomLengthStrings("english").fill(10, 30));

        System.out.println(stringArray);

    }

}
