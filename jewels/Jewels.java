/* 1. Написать метод numJewelsInStones который принимает 2 параметра:
- String jewels: строка, каждый символ который символизирует драгоценный камень, символы уникальны
- String stones: строка, каждый символ который символизирует камень.
Строки могут состоять только из символов a..zA..Z
Метод должне вернуть количество другоценных камней в строке stones.
Пример:
jewels = "aAb" stones = "caсAcA"
Output: 3
Explanation: в строке stones есть 3 драг. камня: a,A,A */
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

    private Character[] uniqueJewels(String jewels) {
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

    public int numJewelsInStones(String jewels, String stones) {
        this.jewels = jewels;
        this.stones = stones;

        Character[] uniqueJewelsArray = uniqueJewels(jewels);
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
