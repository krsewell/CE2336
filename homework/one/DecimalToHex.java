/*
 *   HW1/DecimalToHex.java
 *   Copyright 2018, Kristopher Sewell, All rights reserved.
 *
 *   Course:  CE2336  Section:  002   Project: HW1
 */

import java.util.Scanner;

/*
 * Write a recursive method that converts an integer to hexadecimal.  The function
 * should print out the hexadecimal character instead of returning the character.
 * Write a test program that prompts the user to enter an integer and displays its
 * hexadecimal equivalent.
 */
public class DecimalToHex {

  public static void itoh(long input) {
    long rem = input % 16;

    // Character code conversion
    if (rem > 9) {
      rem = 'A' + rem - 10;
    } else {
      rem = '0' + rem;
    }

    long divide = input / 16;
    if (divide != 0) {
      itoh(divide);
    }
    System.out.print((char)rem);
  }


  public static void main(String[] args) {
    //driver for DecimalToHex conversion.
    System.out.print("The integer \'3,131,961,357\' is 0x");
    itoh(3131961357l);
    System.out.println(" in hexadecimal.");

    System.out.print("Please enter a decimal to convert to hex: ");
    Scanner input = new Scanner(System.in);

    //no input checking enter a valid unsigned integer/long
    long lin = input.nextLong();
    input.close();

    System.out.printf("The integer \'%d\' is 0x", lin);
    itoh(lin);
    System.out.println();

    System.exit(0);
  }
}
