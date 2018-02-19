// Kristopher Sewell
// Amrita Barua
// CE2336.002 INCLASS 2

package homework.inclass2;

import homework.inclass2.*;

public class Main {
  public static void main(String[] args) {
    File file = new File("c\\files\\","1202LabReport4Diagrams.docx","This is a file.\n");
    EMail email = new EMail("Vicky","Me","Angry Letter","Good Morning, Your credit card has expired or will be expiring soon for your recurring payment for your Student Health Insurance.  You will need to update card information to avoid coverage cancellation.");
    Document doc = new Document("I'd like to try to figure out what data types are coming into and leaving my methods to verify that the program is acting as expected. Is there any way to find a field type in Java? In a perfect world, I could generate console output at every step that would give me the data value and whether it's a String, array list, or collection. Can that be done?");

    /*File: file Doc doc EMail email */

    //We have documents
    String key0 = "Supercalifragilisticexpialidocious",
      key1 = "type",
      key2 = "Me",
      key3 = "LabReport";
    
    System.out.printf("%s contains %s: %s",doc.getClass().getName(),key1,containsKeyword(doc, key1));
    System.out.println();
    System.out.printf("%s contains %s: %s",file.getClass().getName(),key3,containsKeyword(file, key3));
    System.out.println();
    System.out.printf("%s contains %s: %s",email.getClass().getName(),key2,containsKeyword(email, key2));
    System.out.println();
    System.out.printf("%s contains %s: %s",doc.getClass().getName(),key0,containsKeyword(doc, key0));
    System.out.println();
    System.out.printf("%s contains %s: %s",file.getClass().getName(),key0,containsKeyword(file, key0));
    System.out.println();
    System.out.printf("%s contains %s: %s",email.getClass().getName(),key0,containsKeyword(email, key0));
    System.out.println();

    System.exit(0);
  }

  public static boolean containsKeyword(final Document doc, String key) {
    return doc.toString().contains(key);
  }
}