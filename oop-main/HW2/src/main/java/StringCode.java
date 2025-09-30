// CS108 HW1 -- String static methods
import java.util.HashSet;

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A run is a series of adajcent chars that are the same.
     * @param str aa
     * @return max run length
     */
    public static int maxRun(String str) {
        str += "/";
        int max = 0;
        int count = 1;
        char compair = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == compair) {
                count++;
            } else {
                max = Math.max(max, count);
                compair = str.charAt(i);
                count = 1;
            }
        }
        return max;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * @param str aa
     * @return blown up string
     */
    public static String blowup(String str) {
        if ( str.equals("") ) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) > '0' && str.charAt(i) <= '9') {
                int numberOfChar =  str.charAt(i) - '0';
                ans.append((str.charAt(i + 1) + "").repeat(numberOfChar));
            } else if (str.charAt(i) != '0'){
//                System.out.println(str.charAt(i));
                ans.append(str.charAt(i));
            }
        }
//        System.out.println(ans.toString());
        if (str.charAt(str.length() - 1) < '0' ||  str.charAt(str.length() - 1) > '9') {
            ans.append(str.charAt(str.length() - 1));
        }

        return ans.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        if (a.length() < 2 || b.length() < len) {
            return false;
        }

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < a.length() - len; i++) {
            String s = a.substring(i, i + len);
            hashSet.add(s);
        }

        for (int i = 0; i < b.length() - len; i++) {
            String s = b.substring(i, i + len);
            if (hashSet.contains(s)) {
                return true;
            }
        }

        return false; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        StringCode s =  new StringCode();
        System.out.println(s.blowup("AB&&,- ab"));
        System.out.println(stringIntersect("abcdef", "zabxy", 2)); // true ("ab")
        System.out.println(stringIntersect("hello", "world", 3));

    }
}
