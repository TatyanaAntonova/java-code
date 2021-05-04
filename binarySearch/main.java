//Write a method with parameters sorted array and number.
//The method will return true, if there is the number in the array. Use binary search.
public class Main {
    private boolean binarySearch(int[] array, int number) {
        int first = 0;
        int last = array.length - 1;
        while (first <= last) {
            int middle = (last + first) / 2;
            if (array[middle] == number) {
                return true;
            } else if (array[middle] > number) {
                last = middle - 1;
            } else if (array[middle] < number) {
                first = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 3, 3, 4, 5, 6};
        int number = 10;
        System.out.println(binarySearch(array, number));
    }
}

