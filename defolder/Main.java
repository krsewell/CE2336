import java.util.*;
import java.nio.file.*;

public class Main {

    public static void moveFile(Files var) {

    }

    public static void main(String[] args) {
        Files.stream()
            .walk(Path.get("").normalize().toAbsolutePath())
            .filter(Files::isRegularFile)
            .forEach(System.out::println);
        
            //myFile.renameTo(new File("/the/new/place/newName.file"));
        system.exit(0);
    }

    public static void lambda() {
        //www.agiledeveloper.com

        //Creates an anonymous interclass. could create gc problems.
        Thread th = new Thread(new Runnable() {
            public void run() {
                System.out.println("In another thread, no lambda.");
            }
        });
        th.start();

        // Name becomes anonymous, and return is inferred. Lambda
        Thread t1 = new Thread(() -> System.out.println("In another thread, lambda."));
        t1.start();

        // iterations

        List<Integer> numbers = Array.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.forEach((value)->System.out.println(value));
        //parenthesis is optional for a single argument.
        numbers.forEach(System.out::println);
        //replace lambda with function reference. it passes each item from forEach to the function.
        //lambda should be one line. glue code.. logic goes into functions.
        System.out.println(
            numbers.stream()
               .map(String::valueOf)
               //.reduce("", (carry, str)-> carry.concat(str))
               .reduce("", String::concat);
        );
        System.out.println("In Main");
    }

}