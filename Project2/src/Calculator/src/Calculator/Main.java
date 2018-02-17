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
import java.lang.reflect.Type;
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
                .map(Main::format)
                .forEachOrdered(bw::write);

    } catch (InvalidPathException e) {
      System.out.println(e.getMessage());
      System.out.println("Please check the filename and Try Again.");
      System.exit(1);

    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.out.println("Can not access file.");
      System.exit(1);

    }


  } // main

  private static String format(final Object[] objects) {
  }

  private static Object[] compute(Object[] objects) {

  }

  private static Object[] convertToken(final String s) {
    /*
     *   Each array will be of form {<Operator>,<first>,<second>,<result>}
     *   We will not fill result with a value until it passes compute.
     */


	  return new Object[4] = {new String(s.substring(begin,end),new T(), new T(), null)}
	}

  private static boolean checkToken(final String token) {
	  //is the expression of type <number><operator><number>?
    if (wordCount(token) != 3) {
      return false;
    }
    //is the <operator> & <number> expressions valid
    final int fpos = token.indexOf(' ');
    final int spos = token.lastIndexOf(' ');

    return  isNumber(token,0,fpos) &&
            isNumber(token,spos+1) &&
            isOperator(token.substring(fpos+1,spos));
  }

  // wastes some resources to find word count.
  private static int wordCount(final String e) {
	  if (e.isEmpty()) { return 0;}
	  return e.split(" ").length;
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

  //TODO : add over/underflow protection, convert static
	public void add(Number obj) {
		return new Number(this._real_number+obj.get_real_number());
	}
	public void subtract(Number obj) {
		return new Number(this._real_number-obj.get_real_number());
	}
	public void multiply(Number obj) {
		return new Number(this._real_number*obj.get_real_number());
	}
	public void divide(Number obj) {
		return new Number(this._real_number/obj.get_real_number());
	}

	//TODO : comparson operations
}
