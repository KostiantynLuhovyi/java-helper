import com.lugowoy.helper.other.GeneratorRandomNumber;

/** Created by Konstantin Lugowoy on 02.08.2018 */

public class Test {

    public static void main(String[] args) {

        System.out.print("Byte : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateByte() + " ");
        }
        System.out.println();
        System.out.print("Short : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateShort() + " ");
        }
        System.out.println();
        System.out.print("Int : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateInt() + " ");
        }
        System.out.println();
        System.out.print("Long : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateLong() + " ");
        }
        System.out.println();
        System.out.print("Double : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateDouble() + " ");
        }
        System.out.println();
        System.out.print("Float : ");
        for (int i = 0; i < 20; i++) {
            System.out.print(GeneratorRandomNumber.generateFloat() + " ");
        }

    }

}
