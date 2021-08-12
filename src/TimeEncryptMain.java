package src;

import java.time.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class encrypting text using non fixed offset to encrypt messages.
 * Using ASCII table to dechipher every character in the massage.
 * The encryption depeneds on the time of the action, using it as start time.
 *
 * @author Jony Klein
 * @version 11.08.2021
 */
public class TimeEncryptMain {
    private static String msg = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            long et = System.currentTimeMillis(); //encryption time.
            int et1 = (int) (et % 255), te = 4, ev = et1 + 2; //+2 to avoid ceasar breaking.
            //et1 is the offset, evaluated from et. te is the time encryption value, ev is encryption value.
            String encryptionTime = String.valueOf(et), encrypted = "";

            System.out.println("please enter massage to encrypt:");
            msg = scan.nextLine();
            isExit = msg.equals("exit");
            if (isExit) {
                System.out.println("Goodbye...");
                break;
            }
            for (int i = 0; i < msg.length(); i++) {
                encrypted += (char) (msg.charAt(i) + ev);
                ev += 2;
            }

            for (int j = 0; j < encryptionTime.length(); j++) {
                encrypted += (char) (encryptionTime.charAt(j) + te);
                te += 2;
            }

            System.out.println(encrypted);
        }
    }
}
