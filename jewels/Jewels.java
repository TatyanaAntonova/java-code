/* 1.Write a method numJewelsInStones with 2 parameters:
- String jewels: a string, each character of which symbolizes a gem, the characters are unique,
- String stones: a string, each character of which symbolizes a gem.
Strings can only consist of characters a..zA..Z
The method should return the number of other gems in the string stones.
Example:
jewels = "aAb" stones = "caсAcA"
Output: 3
Explanation: there are 3 gems in string stones: a,A,A */
package homeTask1;

import java.util.ArrayList;

public class Jewels {
    private String jewels;
    private String stones;
    private int count = 0;

    private char[] stringToArray(String string) {
        char[] arr = new char[string.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = jewels.charAt(i);
        }

        return arr;
    }

    private char[] sortArray(char[] array) {
        char temporaryVar;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 2; j >= i; j--) {
                if (array[j] > array[j + 1]) {
                    temporaryVar = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporaryVar;
                }
            }
        }

        return array;
    }

    private Character[] uniqueJewels() {
        char[] array = sortArray(stringToArray(jewels));
        ArrayList<Character> charList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            charList.add(array[i]);
        }
        for (int i = 0; i < charList.size() - 1; i++) {
            if (charList.get(i) == charList.get(i + 1)) {
                charList.remove(i);
                i--;
            }
        }

        Character[] newArray = charList.toArray(new Character[charList.size()]);

        return newArray;
    }

    private boolean checkSymbols(){
        char[] charArray = jewels.toCharArray();
        //ASCII DEC a-z - 97-122 & A-Z - 65-90
        for (int i = 0; i < charArray.length; i++) {
            if ((int) charArray[i] < 65 || (int) charArray[i] > 122 || ((int) charArray[i] > 90 && (int) charArray[i] < 97)) {
                return false;
            }
        }
        return true;
    }

    public int numJewelsInStones(String jewels, String stones) {
        this.jewels = jewels;
        this.stones = stones;

        if(!checkSymbols()){
            return  count;
        }

        Character[] uniqueJewelsArray = uniqueJewels();
        char letterJewels, letterStone;

        for (int i = 0; i < uniqueJewelsArray.length; i++) {
            letterJewels = uniqueJewelsArray[i];
            for (int j = 0; j < stones.length(); j++) {
                letterStone = stones.charAt(j);
                if (letterJewels == letterStone) {
                    count++;
                }
            }
        }

        return count;
    }
}
