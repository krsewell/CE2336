
package homework.four;

class BinaryToDec {
    public static int binToDec(String s) throws BinaryFormatException {
        //check for valid string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0' || c == '1') {
                continue;
            }
            throw new BinaryFormatException(c + " is not a valid binary digit.");
        }
        //the last binary digit is least significant. reverse the string so we can process it with an index value
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb = sb.reverse();

        //process the result and return
        int result = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                result += Math.pow(2,i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] test = {
                "00110100110",
                "1111",
                "asdf",
                "11110000"
        };
        for (String s : test) {
            try {
                System.out.println(s + " = " + binToDec(s));
            } catch (BinaryFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Done.");
        System.exit(0);
    }
}

class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}
