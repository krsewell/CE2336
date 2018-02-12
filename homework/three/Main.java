package homework.three;

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
     Savings s_acc = new Savings(3555,0.45);
     s_acc.deposit(6543);
     s_acc.withdraw(1234);
     //s_acc.monthlyProc();
     s_acc.display();
     System.exit(0);
   }
 }