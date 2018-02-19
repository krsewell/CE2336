package homework.three;

import java.util.InputMismatchException;
import java.util.Scanner;

import homework.three.*;

/*
 *  Copyright (C) Kristopher Sewell - All Rights Reserved
 *  Written by Kristopher Sewell, 02 2018
 *
 *  Name: Kristopher Sewell
 *  NETID: kjs170430
 *  Class: CE2336.002
 * 
 *  File: /home/kris/Documents/CE2336/homework/three/Main.java
 */

public class Main {
  public static void main(String[] args) {

    /* Because do you really want to crash your opening account. Did no validation on this.. 
    Be careful what you enter if you throw an exception the program will restart. */
    boolean done = false;
    while (!done) {
      Account temp = start();
      Checking c_acc = (Checking)temp;
      temp = start();
      Savings s_acc = (Savings)temp;

      int option;
      double amount;

      //For Checking
      System.out.println("For Checking");
      transaction(c_acc);
      System.out.println("\nChecking Account\n------------------");
      
      //For Savings
      System.out.println("For Savings");
      transaction(s_acc);
      System.out.println("\nSavings Account\n------------------");
      c_acc.monthlyProc();
      s_acc.monthlyProc();

      done = more();
    }

    System.exit(0);
  }

  public static void transaction(Account acc) {
    boolean more = true;
    while (more) {
      int option = -1;
      double amount = Double.NaN;
      getinput(option, amount);
      if (option == 1) {
        acc.withdraw((int) amount * 100);
        more = more();
      } else if (option == 2) {
        acc.deposit((int) amount * 100);
        more = more();
      }
    }

  }

  public static void getinput(int o, double a) throws InputMismatchException {
    Scanner input = new Scanner(System.in);

    while (true) {
      try {
        System.out.println("Please enter a transaction:\n\t(1) Withdrawal\n\t(2) Deposit\n");
        o = input.nextInt();
        System.out.print("Please enter the amount: ");
        a = input.nextDouble();
        System.out.println();
        input.close();
      } catch (InputMismatchException e) {
      }
    }
  }

  public static Account start() {
    Scanner input = new Scanner(System.in);
    
    while (true) {
      try {
      System.out.print("Please enter an opening balance: ");
      double b = input.nextDouble();
      System.out.println();
      System.out.print("Please enter APR: ");
      double r = input.nextDouble();
      input.close();
      return new Account((int)b*100,r);
      
      } catch (InputMismatchException e) {}
 
    }
  }

  
   public static boolean more() {
    System.out.println("Would you like to enter another transaction?\n(Y) or (N)");
    Scanner in = new Scanner(System.in);
    while (true) {
      String c;
      c = in.next();
      if (c.charAt(0) == 'Y') {
        in.close();
        return true;
      } else if (c.charAt(0) == 'N') {
        in.close();
        return false;
      }
    }

  }

}
