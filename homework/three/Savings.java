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
 *  File: /home/kris/Documents/CE2336/homework/three/Savings.java
 */



public class Savings extends Account {
  private boolean _status;

  public Savings(int balance, double rate) {
    super(balance,rate);
    this._status = balance > 2500;
  }

  @Override
  public void withdraw(int value) {
    if (this._status) {
      super.withdraw(value);
    } else {
      return; // no reason to set to false again.
    }
    if (super.getBalance()<2500) {
      this._status = false;
    }
  }

  @Override
  public void deposit(int value) {
    if (this._status) {
      super.deposit(value);
    } else {
      super.deposit(value); //so we shouldnt add twice, add the value before the check.
      this._status = super.getBalance() >= 2500;
    }
  }

  @Override
  public void monthlyProc() {
    if (super.getWithdraw() > 4) {
      super.addServiceCharge((super.getWithdraw() - 4)*100);
    }
    super.monthlyProc();
    this._status = super.getBalance() >= 2500;
  }

  @Override
  public void display() {
    System.out.println("Active:\t\t\t" + Boolean.toString(this._status));
    super.display();
  }



}