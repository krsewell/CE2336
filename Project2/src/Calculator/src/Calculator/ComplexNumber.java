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

package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumber extends Number {
	private double _imaginary_number;

	public ComplexNumber(double real, double imaginary) {
		super(real);
		this.set_imaginary_number(imaginary);
	}

	public static ComplexNumber toComplex(String complex) {
	  if (isValid(complex)) { //we don't need to check if empty because isValid will return false.

	    // check for a '+' and record the position if exist else record the last position of a '-'
	    int pos = complex.indexOf('+') == -1 ? complex.lastIndexOf('-') : complex.indexOf('+');

	    // case no number
	    if (pos == -1 || pos == 0) {
        return new ComplexNumber(0.0,
                Double.parseDouble(complex.substring(0,complex.length()-2))); // -1 eos -2 removes i
      }
      // case other handles omittion of + with condition embedded
      return new ComplexNumber(
              Double.parseDouble(complex.substring(0, pos)),
              Double.parseDouble(complex.substring(
                      complex.charAt(pos) == '+' ? pos+1 : pos,
                      complex.length()-2))
      );
    }
    //if the complex is not valid return null
    return null;
  }

  public static boolean isValid(final String e) {
    final Pattern rgex = Pattern.compile("-?\\d*\\.?\\d+\\+?-?\\d*\\.?\\d+i$");
    Matcher m = rgex.matcher(e);
    return m.matches();
  }

  public double get_imaginary_number() {
		return _imaginary_number;
	}

	public void set_imaginary_number(double _imaginary_number) {
		this._imaginary_number = _imaginary_number;
	}
	
	@Override
	public String toString() { 	// Sloppy clean this up a bit.
		//use floor to evaluate doubles that should be 0, but may contain precision errors.
		if (Math.floor(this.get_real_number()*1000000.0) == 0.0) {
			return 	Double.toString(this._imaginary_number) + (this._imaginary_number == 0.0 ? "" : "i");
		} else if (this.get_imaginary_number() == 0.0) {
			return super.toString();
		} else {
			return 	super.toString() + (this._imaginary_number > 0.0 ? " + " : " - ") +
					Double.toString(Math.abs(this._imaginary_number)) + "i";
		}
	}
	
	@Override
	public boolean equals(Object obj) {
    if (obj instanceof ComplexNumber) {
      return (super.equals(obj) && this._imaginary_number == ((ComplexNumber) obj).get_imaginary_number());
    }

    return false;
  }

  public double getMagnitude() {
	  //defined as sqrt of x^2 + xi^2
    return Math.sqrt((this.get_real_number() * this.get_real_number()) +
            (this.get_imaginary_number() * this.get_imaginary_number() * -1.0));
  }

}