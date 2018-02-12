/*
 *   HW2/Tender.java
 *   Copyright 2018, Kristopher Sewell, All rights reserved.
 *
 *   Course:  CE2336  Section:  002   Project: HW2
 */

import java.util.Scanner;

public class Tender {

  public static void printTender(String in) {

    int periodPOS = in.indexOf('.');
    int dollars = Integer.parseInt(in.substring(0,periodPOS));
    int change = Integer.parseInt(in.substring(periodPOS+1,in.length()));
    
    //
      System.out.printf("20: %d\n", dollars/20);
      dollars = dollars % 20;
      System.out.printf("10: %d\n", dollars/10);
      dollars = dollars % 10;
      System.out.printf("5: %d\n", dollars/5);
      dollars = dollars % 5;
      System.out.printf("1: %d\n", dollars);

      System.out.printf("Qtrs: %d\n", change/25);
      change = change % 25;
      System.out.printf("Dimes: %d\n", change/10);
      change = change % 10;
      System.out.printf("Nickels: %d\n", change/5);
      change = change % 5;
      System.out.printf("Pennies: %d\n", change);


  }


  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Please enter the amount to tender: ");
    if (input.hasNextLine()) {
      String userInput = input.nextLine();
      System.out.println();
      printTender(userInput);
    }
    






    //cleanup code
    input.close();
    System.exit(0);

  }

}