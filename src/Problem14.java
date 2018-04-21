import java.util.Arrays;

/**
 * The following iterative sequence is defined for the set of positive integers.
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 *
 * Using the rules above, which starting number, under one million, produces the longest chain?
 *
 * Created by sophie on 4/21/18.
 */
public class Problem14 {
    public static boolean isEven(long n) {
        return (n%2) == 0;
    }

    public static long applyEvenRule(long n) {
        return n/2;
    }

    public static long applyOddRule(long n) {
        return (3*n + 1);
    }

    public static int findLengthChain(long n) {
        long num = n;
        int lenChain = 1;
        while (n != 1) {
            if (isEven(n)) {
                n = applyEvenRule(n);
                lenChain++;
            } else {
                n = applyOddRule(n);
                lenChain++;
            }
        }
        return lenChain;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // Numbers 13 and 10 from given example
        long[] res = {13, 10};
        int num = 0;
        for (long i=1000000; i>0; i--) {
            num = findLengthChain(i);
            //System.out.println("Number "+i+" has a chain with length "+num);
            if (num > res[1]) {
                res[0] = i;
                res[1] = num;
            }
        }
        System.out.println("Final result: "+ Arrays.toString(res));
        long end = System.currentTimeMillis();
        System.out.println("Calculation took "+(end-start)+" ms");
    }
}
