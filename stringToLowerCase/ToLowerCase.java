/*
3.3. There is a string, which consists of any characters.
Without using the standard String.toLowerCase () method, convert all uppercase Latin letters to lowercase.
Example:
Input: "#1AmC"
Output: "#1amc"
*/
public class ToLowerCase {

    public String outputLowerCase(String input) {
        char[] charArray = input.toCharArray();
        int decAscii;
        int diff = 'a' - 'A';
        for (int i = 0; i < charArray.length; i++) {
            if ((int) charArray[i] >= 'A' && (int) charArray[i] <= 'Z') {
                decAscii = diff + (int) charArray[i];
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
