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

package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Number {
	
	private double _real_number;

	
	public Number(double _real_number) {
		this.set_real_number(_real_number);
	}

	public static Number toNumber(String number) {
		if (isValid(number)) {
			return new Number(Double.parseDouble(number));
		}

		return null;
	}


	public static boolean isValid(final String e) {
    //tests for an integer/double
    final Pattern rgex = Pattern.compile("^-?\\d*\\.?\\d+$");
    Matcher m = rgex.matcher(e);
    return m.matches();
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
	
	public boolean equals(Object obj) {
		if (obj instanceof Number) {
			return this._real_number == obj.get_real_number();
		}
	}


}
