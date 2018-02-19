/*
 *  Copyright (C) Kristopher Sewell - All Rights Reserved 
 *  Written by Kristopher Sewell, Feb 2018
 *  
 *  Name: Kristopher Sewell
 *  NETID: kjs170430
 *  Class: CE2336.002
 * 
 *  File: ./calculator/Main.java
 */

package Calculator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Main {

	public static void main(String[] args) {
    final Path output = FileSystems.getDefault().getPath("results.txt");
    final Path input = FileSystems.getDefault().getPath("expressions.txt");

	  try (Stream<String> stream_in = Files.lines(input);
         BufferedWriter bw = Files.newBufferedWriter(output)) {

      // We will hold our data in a list. Later we can parallelize for large workingSets with BlockingQueues
      List<Object[]> workingSet = stream_in
                        .map(String::trim)
                        .filter(Main::checkToken)
                        .map(Main::convertToken)
                        .map(Main::compute)
                        .collect(toList());

      //Format, then Output to file
      workingSet.stream()
                .filter(e -> e != null)
                .map(Main::format)
                .forEach(bw::write);

    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println("Can not access file.");
      System.exit(1);

    } catch (InvalidPathException e) {
      System.out.println(e.getMessage());
      System.out.println("Please check the filename and Try Again.");
      System.exit(1);

    }
  } // main

  private static String format(final Object[] objects) {

  }

  private static Object[] compute(Object[] objects) {
    /*
     *  Function actually just selects the corect operator function
     *  to compute the result. see subfuctions for computations.
     */

	  if ("+" == objects[0]) {
      objects[3] = add(objects);
    }else if ("-" == objects[0]) {
      objects[3] = subtract(objects);
    }else if ("*" == objects[0]) {
      objects[3] = multiply(objects);
    }else if ("/" == objects[0]) {
      objects[3] = divide(objects);
    }else if ("=" == objects[0]) {
      objects[3] = equal(objects);
    }else if (">" == objects[0]) {
      objects[3] = greaterThan(objects);
    }else if ("<" == objects[0]) {
      objects[3] = lessThan(objects);
    }else if ("/=" == objects[0]) {
      objects[3] = notEqual(objects);
    }
    return objects;
  }

  private static Object[] convertToken(final String s) {
    /*
     *   Each array will be of form {<Operator>,<first>,<second>,<result>}
     *   We will not fill result with a value until it passes compute.
     */

    String[] parts = s.split(" ");

	  return new Object[]{parts[1],
            Number.isValid(parts[0]) ? Number.toNumber(parts[0]):ComplexNumber.toComplex(parts[0]),
            Number.isValid(parts[2]) ? Number.toNumber(parts[2]):ComplexNumber.toComplex(parts[2]),
            null};
	}

  private static boolean checkToken(final String token) {
	  //is the expression of type <number><operator><number>?
    if (wordCount(token) != 3) {
      return false;
    }
    //is the <operator> & <number> expressions valid

    final Tuple pos = getSpaces(token);

    return  isNumber(token,0,pos.first) &&
            isNumber(token,pos.second+1) &&
            isOperator(token.substring(pos.first+1,pos.second));
  }

  // wastes some resources to find word count.
  private static int wordCount(final String e) {
	  if (e.isEmpty()) { return 0;}
	  return e.split(" ").length;
  }

  private static Tuple getSpaces(final String e) {
	  return new Tuple(e.indexOf(' '),e.lastIndexOf(' '));
  }

  private static boolean isOperator(final String e) {
	  //expression contains the ascii hex codes for +,-,*,/,=,<,>
    final Pattern rgex = Pattern.compile("^[\\x2a\\x2b\\x2d\\x2f\\x3c\\x3d\\x3e]|\\x2f\\x3d");
    Matcher m = rgex.matcher(e);
    return m.matches();
  }

  private static boolean isNumber(final String e, final int f, final int s) {
	  return Number.isValid(e.substring(f,s)) || ComplexNumber.isValid(e.substring(f,s));
  }

  private static boolean isNumber(final String e, final int p) {
	  return Number.isValid(e.substring(p)) || ComplexNumber.isValid(e.substring(p));
  }


	public static Object[] add(Object[] obj){
	  Double[] components = getComponents(obj[1],obj[2]);

    if (obj[1] instanceof ComplexNumber && obj[2] instanceof ComplexNumber) {

      obj[3] = new ComplexNumber(components[0]+components[2],components[1]+components[3]);

    } else if (obj[1] instanceof Number && obj[2] instanceof Number) {

		    obj[3] = new Number(components[0]+components[2]);
		}

		if (obj[3] == null) {return null;}
    return obj;
	}

	public static Object[] subtract(Object[] obj) {
    //subtracting is just the addition of x and negative y so negate y and add.

	  if (obj[2] instanceof ComplexNumber) {
      obj[2] = new ComplexNumber(((ComplexNumber)obj[2]).get_real_number()*-1,
              ((ComplexNumber)obj[2]).get_imaginary_number()*-1);

    }else if (obj[2] instanceof Number) {
      obj[2] = new Number(((Number) obj[2]).get_real_number() * -1);
    }
    return add(obj);
  }

	public static Object[] multiply(Object[] obj){
	  // For the sake of readability and sanity we will put the values
    // from the objects into temp variables to do the calculations
    // x - [0] xi - [1] y - [2] yi - [3]
    Double[] components = getComponents(obj[1],obj[2]);

	  if (obj[1] instanceof ComplexNumber || obj[2] instanceof ComplexNumber) {
      // because the of the zero values and if one object is a number this will cancel terms nicely
      // and will serve as the default case. Even if bad objects are passed in.

      obj[3] = new ComplexNumber((components[0]*components[2])+(components[1]*components[3]*-1),
              (components[0]*components[3])+(components[1]*components[2]));

    } else {
      obj[3] = new Number(components[0]*components[2]);

    }
    return obj;
	}

	public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
	  double x = a.get_real_number();
	  double xi = a.get_imaginary_number();
	  double y = b.get_real_number();
	  double yi = b.get_imaginary_number();

	  return new ComplexNumber((x*y)+(xi*yi*-1),(x*yi)+(xi*y));
  }

	public static Object[] divide(Object[] obj) {
    // For the sake of readability and sanity we will put the values
    // from the objects into temp variables to do the calculations
    // x - [0] xi - [1] y - [2] yi - [3]
    Double[] components = getComponents(obj[1],obj[2]);

    if (components[3] == 0.0 && components[1] == 0.0 && components[2] != 0.0) {
      //only case for number
      obj[3] = new Number(components[0]/components[2]);

    // if we have division by 0 return null. do not print output.
    } else if (components[2] == 0.0 && components[3] == 0.0) {
      return null;

    } else {
    // we need to times both complex numbers by the conjugate to take care of the denominator's
    // imaginary value. we should never get 0 unless both y & yi are 0.

      ComplexNumber conjugate = new ComplexNumber(components[2],components[3] * -1);
      ComplexNumber num = multiply((ComplexNumber) obj[1], conjugate);
      ComplexNumber den = multiply((ComplexNumber) obj[2], conjugate);

      obj[3] = new ComplexNumber(num.get_real_number()/den.get_real_number(), num.get_imaginary_number()/den.get_real_number());
    }

    return obj;

	}


	private static Double[] getComponents(Object a, Object b) {
	  // {x, xi , y , yi}
    Double[] comp = new Double[4];

    if (a instanceof ComplexNumber){
      comp[0] = ((ComplexNumber)a).get_real_number();
      comp[1] = ((ComplexNumber)a).get_imaginary_number();
    } else if (a instanceof Number) {
       comp[0] = ((Number) a).get_real_number();
       comp[1] = 0.0;
    }

    if (b instanceof ComplexNumber) {
      comp[2] = ((ComplexNumber)b).get_real_number();
      comp[3] = ((ComplexNumber)b).get_imaginary_number();
    } else if (b instanceof Number) {
       comp[2] = ((Number) b).get_real_number();
       comp[3] = 0.0;
    }

    return comp;
  }


	public static Object[] equal(Object[] obj) {
    obj[3] = obj[1].equals(obj[2]);
    return obj;
  }

  public static Object[] greaterThan(Object[] obj) {
	  if (obj[1] instanceof ComplexNumber || obj[2] instanceof ComplexNumber) {
	    if (obj[1] instanceof ComplexNumber) {
	      if (obj[2] instanceof ComplexNumber) { //both are complex
	        obj[3] = ((ComplexNumber)obj[1]).getMagnitude() > ((ComplexNumber)obj[2]).getMagnitude();
        } else { // 1 is complex, 2 is not
          obj[3] = ((ComplexNumber)obj[1]).getMagnitude() > ((Number)obj[2]).get_real_number();
        }
      } else {  //if 1 is not complex & 1 or 2 is complex = 2 is complex
        obj[3] = ((Number)obj[1]).get_real_number() > ((ComplexNumber)obj[2]).getMagnitude();
      }
    } else {
      obj[3] = ((Number)obj[1]).get_real_number() > ((Number)obj[2]).get_real_number();
    }
    if (obj[3] == null) {return null;}
    return obj;
  }

  public static Object[] lessThan(Object[] obj) {
    if (obj[1] instanceof ComplexNumber || obj[2] instanceof ComplexNumber) {
      if (obj[1] instanceof ComplexNumber) {
        if (obj[2] instanceof ComplexNumber) { //both are complex
          obj[3] = ((ComplexNumber)obj[1]).getMagnitude() < ((ComplexNumber)obj[2]).getMagnitude();
        } else { // 1 is complex, 2 is not
          obj[3] = ((ComplexNumber)obj[1]).getMagnitude() < ((Number)obj[2]).get_real_number();
        }
      } else {  //if 1 is not complex & 1 or 2 is complex = 2 is complex
        obj[3] = ((Number)obj[1]).get_real_number() < ((ComplexNumber)obj[2]).getMagnitude();
      }
    } else {
      obj[3] = ((Number)obj[1]).get_real_number() < ((Number)obj[2]).get_real_number();
    }
    if (obj[3] == null) {return null;}
    return obj;
  }

  public static Object[] notEqual(Object[] obj) {
	  obj[3] = !obj[1].equals(obj[2]);
	  return obj;
  }


}


