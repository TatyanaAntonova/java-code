//There is a robot in the middle of the field with cells.
//The robot can execute 4 commands (move 1 square to the side): 
//R (right), L (left), U (up), and D (down).
//You have some String, for example "UUDLDR".
//You have to write a method, which return true, if the robot will come back to the first cell. 
//Example 
//Input: "UD"  Output: true
//Input: "LL"  Output: false

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Write robot path, please! Use just 'U', 'D', 'L', 'R' letters.");
        Scanner s = new Scanner(System.in);

        RobotMoves myRobot = new RobotMoves();
        System.out.println(myRobot.comeBack(s.nextLine()));
        System.out.println(myRobot.outputMatrix());
    }
}
