/*
 *  Copyright (C) Kristopher Sewell - All Rights Reserved 
 *  Written by Kristopher Sewell, Feb 2018
 *  
 *  Name: Kristopher Sewell
 *  NETID: kjs170430
 *  Class: CE2336.002
 * 
 *  File: ./calculator/ComplexNumber.java
 */

package calculator;

public class ComplexNumber extends Number {
	protected double _imaginary_number;

	public ComplexNumber(double real, double imaginary) {
		super(real);
		this._imaginary_number = imaginary;
	}
	
	public double get_imaginary_number() {
		return _imaginary_number;
	}

	public void set_imaginary_number(double _imaginary_number) {
		this._imaginary_number = _imaginary_number;
	}
	
	@Override
	public String toString() { 	// Sloppy clean this up a bit.
		if (this.get_real_number() == 0.0) {
			return 	Double.toString(this._imaginary_number) + (this._imaginary_number == 0.0 ? "" : "i");
		} else if (this.get_imaginary_number() == 0.0) {
			return super.toString();
		} else {
			return 	super.toString() + (this._imaginary_number > 0.0 ? " + " : " - ") +
					Double.toString(Math.abs(this._imaginary_number)) + "i";
		}
	}
	
	@Override
	public boolean equals(ComplexNumber obj) {
		return (super.equals(obj) && this._imaginary_number == obj.get_imaginary_number());
	}
	
	//TODO : add arithmetic operator methods
	//TODO : add comparison operator methods
}
