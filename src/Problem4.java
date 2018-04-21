/**
 * Find the largest palindrome made from the product of two 3-digit numbers
 * Created by sophie on 6/4/17.
 */
public class Problem4 {

    public static void main(String[] args) {
        int result = 0;
        for (int i=999; i>=100; i--) {
            for (int j=999; j>=100; j--) {
                if (isPalindrome(i * j) && i*j>result) {
                    System.out.println("i="+i+" and j="+j);
                    result = i * j;
                }
            }
        }

        System.out.println("The largest palindrome, made from the product of two 3-digit numbers, is "+result);
    }

    private static boolean isPalindrome(int p) {
        String s = Integer.toString(p);
        boolean result = true;
        for (int i=0; i<(s.length()/2)+1; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                result = false;
            }
        }
        return result;
    }
}
