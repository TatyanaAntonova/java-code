/*3*. Дана строка, состоящая из любых символов.
Не используя стандартный метод String.toLowerCase() перевести все большие латинские буквы в маленькие.
Пример:
Input: "#1AmC"
Output: "#1amc"
*/
package homeTask3;

public class ToLowerCase {

    public String outputLowerCase(String input) {
        char[] charArray = input.toCharArray();
        int decAscii;

        for (int i = 0; i < charArray.length; i++) {
            if ((int) charArray[i] >= 65 && (int) charArray[i] <= 90) {
                decAscii = 32 + (int) charArray[i];
                charArray[i] = (char) decAscii;
            }
        }

        StringBuilder charToString = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            charToString.append(charArray[i]);
        }

        return charToString.toString();
    }
}
