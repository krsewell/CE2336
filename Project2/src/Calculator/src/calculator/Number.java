/*
 *  Copyright (C) Kristopher Sewell - All Rights Reserved 
 *  Written by Kristopher Sewell, Feb 2018
 *  
 *  Name: Kristopher Sewell
 *  NETID: kjs170430
 *  Class: CE2336.002
 * 
 *  File: ./calculator/Number.java
 */

package calculator;

public class Number {
	
	protected double _real_number;

	
	public Number(double _real_number) {
		this._real_number = _real_number;
	}
	
	public double get_real_number() {
		return _real_number;
	}

	public void set_real_number(double _real_number) {
		this._real_number = _real_number;
	}
	
	public String toString() {
		return Double.toString(this._real_number);
	}
	
	public boolean equals(Number obj) {
		return this._real_number == obj.get_real_number();
	}
	
	//TODO : add over/underflow protection, convert static
	public Number add(Number obj) {
		return new Number(this._real_number+obj.get_real_number());
	}
	public Number subtract(Number obj) {
		return new Number(this._real_number-obj.get_real_number());
	}
	public Number multiply(Number obj) {
		return new Number(this._real_number*obj.get_real_number());
	}
	public Number divide(Number obj) {
		return new Number(this._real_number/obj.get_real_number());
	}
	//TODO : add comparison operator methods

}
