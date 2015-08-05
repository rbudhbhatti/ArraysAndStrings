import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String s = "abc xyz";
        System.out.println("String has unique char? :"+ hasUniqueChar(s));

        System.out.println("Reverse String: " + reverseString(s));
    }

    private static String reverseString(String s) {
        int p1 = 0;
        int p2 = s.length();
        char temp;
        char[] charArray = s.toCharArray();
        if(s.isEmpty() || s.length()==1){
            return s;
        }
        else {
            while (p1 < p2) {
                temp = charArray[p1];
                charArray[p1] = charArray[p2];
                charArray[p2] = temp;
                p1++;
                p2--;
            }
            return charArray.toString();
        }
    }

    private static boolean hasUniqueChar(String str) {
        if (str.length() > 256) {
            return false;
        }
        BigInteger checker = new BigInteger(String.valueOf(0));
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (checker.testBit(val)) return false;
            checker = checker.setBit(val);
        }
        // none of the characters has been seen more than once.
        return true;
    }
}
