// Kristopher Sewell
// Spencer Rasor
// Inclass Assignment 3


package homework.inclass3;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static <T> ArrayList<T> removeDups(ArrayList<T> list) {
        ArrayList<T> rtn = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String item1 = rtn.toString();
            if (!item1.contains(""+list.get(i))) {
                rtn.add(list.get(i));
            }
        }
        return rtn;
    }

    public static ArrayList<Integer> getInput(File file) {
        Scanner sc = new Scanner(file);
        ArrayList list = new ArrayList();
        getInput(file,list);
        sc.close();
    }

    public static ArrayList<Integer> getInput(Scanner  sc, ArrayList<Integer> list) {
        if (sc.hasNext()) {
            String temp = sc.next();
            try {
                list.add(Integer.parseInt(temp));
            } catch (Exceptions e){
                throw new nonInteger(temp);
            } finally {
                getInput(sc, list);
            }
        }
    }


    public static void main(String[] args) {
        File input = new File("input.txt");

            if (input.exists() && input.canRead()) {
                try {
                    ArrayList<Integer> list = getInput(input);
                } catch (nonInteger ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println(list.toString());
                list = removeDups(list);
                System.out.println(list.toString());
            } else {
                System.out.println("No file.");
            }
        }

}