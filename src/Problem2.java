import java.util.HashSet;
import java.util.Set;

/**
 * Find the sum of the even-valued Fibonacci terms below 4 million
 * Created by sophie on 6/4/17.
 */
public class Problem2 {

    public static Set<Integer> getEvenFibonacciBelow(int bound) {
        Set<Integer> result = new HashSet<Integer>();
        int i = 0;
        int j = 1;
        while (j<bound) {
            int k = i+j;
            if (k < bound && k%2==0) {
                result.add(k);
            }
            i = j;
            j = k;
        }
        return result;
    }

    public static int getSum(Set<Integer> set) {
        int result = 0;
        for (Integer i: set) {
            result +=i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Result: "+getSum(getEvenFibonacciBelow((int) (4*Math.pow(10, 6)))));
    }

}
