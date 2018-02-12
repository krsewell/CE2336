
import java.util.Scanner;

public class StringISBN {

  private static int checksum(String ISBN, int index) {
    int num = Integer.parseInt(ISBN.substring(index, index+1));
    if (index % 2 != 0) {
      return 3 * num + (index==11?0:checksum(ISBN,index+1));
    } else {
      return num + checksum(ISBN, index+1);
    }
  }

  public static int checksum(String ISBN) {
    return 10 - checksum(ISBN,0) % 10;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Please enter the first 12 digits of the ISBN: ");
    String isbn = input.next();
    System.out.println();

    int digit;

    System.out.println("The ISBN-13 number is " + isbn);
  }

}
