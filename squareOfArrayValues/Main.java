import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Write 5 numbers for array.");

        final int ARRAY_LENGTH = 5;
        int[] myArray = new int[ARRAY_LENGTH];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = s.nextInt();
        }

        SquareOfArrayValues myObject = new SquareOfArrayValues();
        myArray = myObject.getSquareOfArrayValues(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}
