import java.math.BigInteger;

/**
 * Calculate the sum of the digits of the number 2^1000
 *
 * Created by sophie on 4/21/18.
 */
public class Problem16 {

    public static void main(String[] args) {
        // First calculate 2^1000
        BigInteger base = BigInteger.ONE.add(BigInteger.ONE);
        BigInteger res = base.pow(1000);

        // Calculate sum of digits of 2^1000
        String s = res.toString();
        int sum = 0;
        for (int i=0; i<s.length(); i++) {
            sum+=Character.getNumericValue(s.charAt(i));
        }
        System.out.println(sum);
    }


}
