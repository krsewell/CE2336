/*
 *   HW2/Salary.java
 *   Copyright 2018, Kristopher Sewell, All rights reserved.
 *
 *   Course:  CE2336  Section:  002   Project: HW2
 */

import java.io.File;
import java.util.Scanner;

public class Salary {

  public static void main(String[] args) {
    try {
      File salaryfile = new File("Salary.txt");
      Double assistSal = 0.0;
      Double assocSal = 0.0;
      Double fullSal = 0.0;

      if (salaryfile.exists()) {
        Scanner input = new Scanner(salaryfile);
        while (input.hasNext()) {
          String temp = input.nextLine();
          int POS = 0;

          for (int i = 0; i < 3; i++) {
            POS = temp.indexOf(' ', POS);
          }
          if (temp.substring(POS, temp.indexOf(' ', POS)) == "assistant") {
            POS = temp.indexOf(' ', POS);
            assistSal += Double.parseDouble(temp.substring(POS));
          } else if (temp.substring(POS, temp.indexOf(' ', POS)) == "associate") {
            POS = temp.indexOf(' ', POS);
            assocSal += Double.parseDouble(temp.substring(POS));
          } else if (temp.substring(POS, temp.indexOf(' ', POS)) == "full") {
            POS = temp.indexOf(' ', POS);
            fullSal += Double.parseDouble(temp.substring(POS));
          }
        }

        System.out.printf("Assistant: $%f\nAssociate: $%f\n Full: $%f\n", assistSal, assocSal, fullSal);
        //cleanup
        input.close();
        System.exit(0);

      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }
}
