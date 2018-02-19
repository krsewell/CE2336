package homework.three;

import homework.three.Account;

/*
 *  Copyright (C) Kristopher Sewell - All Rights Reserved
 *  Written by Kristopher Sewell, 02 2018
 *
 *  Name: Kristopher Sewell
 *  NETID: kjs170430
 *  Class: CE2336.002
 * 
 *  File: /home/kris/Documents/CE2336/homework/three/Checking.java
 */

public class Checking extends Account {

  public Checking(int balance, double rate) {
    super(balance,rate);

  }

  @Override
  public void withdraw(int value) {
    try {
      super.withdraw(value); //this is kind of built into the base class function
    } catch (IllegalArgumentException e) {
      super.overdraft();
    } 
  }
  
  @Override
  public void monthlyProc() {
    this.addServiceCharge(500 + (this.getWithdraw()*10));
    super.monthlyProc();
  }

}
