/*
 *  Copyright (C) Kristopher Sewell - All Rights Reserved
 *  Written by Kristopher Sewell, 02 2018
 *
 *  Name: Kristopher Sewell
 *  NETID: kjs170430
 *  Class: CE2336.002
 * 
 *  File: /home/kris/Documents/CE2336/homework/three/Account.java
 */

package homework.three;

public class Account {
  /**
   * Account class
   * Balance represented by integer value. 10.00 is 1000.
   */
  private int _balance;
  private int _balance_beg;
  private int _numberOfDeposit;
  private int _numberOfWithdraw;
  private double _rateAnnualInterest;
  private int _serviceCharges;

  /////////////////////
  //SETTERS & GETTERS//
  /////////////////////
  protected void addServiceCharge(int value) {
    this._serviceCharges += value;
  }

  protected int getBalance() {
    return this._balance;
  }

  protected int getBeginBalance() {
    return this._balance_beg;
  }

  protected int getWithdraw() {
    return this._numberOfWithdraw;
  }

  ////////////////
  //CONSTRUCTORS//
  ////////////////
  public Account(int balance, double rate) {
    this._balance = balance;
    this._balance_beg = balance;
    this._rateAnnualInterest = rate;
  }

  ///////////////////
  //UTILITY METHODS//
  ///////////////////
  public void deposit(int value) {
    this._balance += value;
    this._numberOfDeposit++;
  }

  public void withdraw(int value) throws IllegalArgumentException {
    if(value > this._balance) {
      throw new IllegalArgumentException("Can not overdraw account.");
    }
    this._balance -= value;
    this._numberOfWithdraw++;
  }

  public void calcInt() { //floor's anything under a penny
    this._balance += (int)(this._balance * this._rateAnnualInterest / 12.0);
  }

  public void monthlyProc() {
    this._balance -= this._serviceCharges;
    calcInt();
    display();
    this._balance_beg = this._balance;
    this._numberOfDeposit = 0;
    this._numberOfWithdraw = 0;
    this._serviceCharges = 0;
  }

  public void overdraft() {
    this._balance -= 1500;
  }

  public void display() {
    System.out.printf("Balance:\t\t%d.%d\n", this._balance/100, this._balance%100);
    System.out.printf("Deposits:\t\t%d\n", this._numberOfDeposit);
    System.out.printf("Withdraws:\t\t%d\n", this._numberOfWithdraw);
    System.out.printf("APR:\t\t\t%.2f%%\n",this._rateAnnualInterest);
    System.out.println();
  }
}