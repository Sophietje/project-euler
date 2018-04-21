import java.math.BigInteger;

/**
 * Compute number of paths possible from top left to bottom right on a 20x20 grid when you may only move down or right.
 *
 * Created by sophie on 4/21/18.
 */
public class Problem15 {
    public static BigInteger combinations(int n, int m) {
        BigInteger res = BigInteger.ONE;
        for (int i=n; i>=n-m+1; i--) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public static void main(String[] args) {
        // Use combination formula which counts the number of possible combinations
        // of r objects from a set of n objects : C(n, r) = C(40, 20)
        // Can view this has text problem: In how many ways can you order 20 d's and 20 r's
        // Where d's would denote a downward movement and r's denote a movement to the right
        // Formula: n! / (r!(n-r)!)

        BigInteger res = combinations(40, 20).divide(combinations(20, 20));

        System.out.println("Result: (40 ncr 20) = "+res);
    }
}
