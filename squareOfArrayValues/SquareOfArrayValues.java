/*
 2. Write a method.
Incoming parameter: a sorted array of int type that contains negative and positive values.
Return a sorted array that consists of the squares of the values.
Do not use the standard sort method.
Example:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
*/
public class SquareOfArrayValues {
    private int[] array;

    private boolean checkTheSortingOfArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPositiveAndNegativeNumbers(int[] array) {
        if (checkTheSortingOfArray(array)) {
            if (array[0] < 0 && array[array.length - 1] > 0) {
                return true;
            }
        }
        return false;
    }

    private int[] squareNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(array[i], 2);
        }
        return array;
    }

    private int[] sortingArray(int[] array) {
        int tempValue;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 2; j >= 0; j--) {
                if(array[j] > array[j+1]){
                    tempValue = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempValue;
                }
            }
        }
        return array;
    }
    public int[] getSquareOfArrayValues(int[] array) {
        if (!checkPositiveAndNegativeNumbers(array)) {
            System.out.println("Write sorted array with negative and positive numbers, please!");
            return array;
        }

        return sortingArray(squareNumbers(array));
    }
}
