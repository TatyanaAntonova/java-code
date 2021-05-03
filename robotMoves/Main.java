//Есть поле из клеток по средине которого находится робот. Робот умеет выполнять 4 команды: двигаться на 1 клетку в сторону: 
//R (right), L (left), U (up), and D (down).
//Задана строка из движений робота например "UUDLDR".
//Написать метод который вернет true если робот вернется в ту же клетку с которой начал.
//Input: "UD"
//Output: true
//Input: "LL"
//Output: false

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
