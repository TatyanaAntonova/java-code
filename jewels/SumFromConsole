/*
Let's write a program, in which you need to enter the keyboard of numbers and calculate their sum,
until the user enters the word "ENTER".
Display the received amount and terminate the program.
*/
import java.util.Scanner;

public class SumFromConsole {
        public static void toInt(){
            boolean isExit = false;
            int x, sum = 0;

            Scanner s = new Scanner(System.in);
            while (!isExit){
                String str = s.next();
                isExit = str.equals("ENTER");
                if (!isExit) {
                    try {
                        x = Integer.parseInt(str);
                        sum += x;
                    } catch (NumberFormatException e) {
                        System.out.println("Caught " + e);
                        System.out.println("Write number or word 'ENTER', please!");
                    }
                } else {
                    System.out.println("sum = " + sum);
                }
            }
        }

        public static void main(String[] args) {
            System.out.println("Write number or word 'ENTER', please!");
            toInt();
        }
}

