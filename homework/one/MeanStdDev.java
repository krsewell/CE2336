/*
 *   HW1/meanstddev.java
 *   Copyright 2018, Kristopher Sewell, All rights reserved.
 *
 *   Course:  CE2336  Section:  002   Project: HW1
 */

import java.util.Scanner;

 /*
  * Write a program that prompts the user to enter ten numbers, and displays
  * the mean and standard deviations of these numbers.
 */

 public class MeanStdDev {
  public static double stddev(double[] array) {
    double mean = mean(array);
    double[] intermediate = new double[array.length];

    for (int i = 0; i < array.length; i++) {
      intermediate[i] = array[i] - mean;
      intermediate[i] = intermediate[i] * intermediate[i];
    }
    return Math.sqrt(mean(intermediate));
  }

  public static double mean(double[] array) {
    double result = 0;
    for (int i = 0; i < array.length; i++) {
      result += array[i];
    }
    result = result / array.length;
    return result;
  }

  public static void main(String[] args) {
    double[] userinput = new double[10];
    Scanner input = new Scanner(System.in);

    for (int i = 0; i < userinput.length; i++) {
      System.out.print("Please enter an number: ");
      //no input validation enter correct values only.
      userinput[i] = input.nextDouble();
    }

    System.out.printf("The simple mean of the numbers is: %.2f\n", mean(userinput));
    System.out.printf("The standard deviation of the numbers is: %.2f\n", stddev(userinput));


    input.close();
    System.exit(0);
   }
 }
