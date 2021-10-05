import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Find the sum of all amicable numbers under 10.000

A pair of amicable numbers are numbers of which the sum of the proper divisors is equal to each other (d(a) = b and d(b) = a where a != b)
 */
public class Problem21 {

    // Returns the sum of all divisors for a given number n (n > 0);
    public static int sieve(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= Math.floor(n/2); i++) {
            result.add(i);
        }
        for (int i = 2; i <= Math.floor(n/2); i++) {
            if (n % i != 0) {
                // i is not a proper divisor so remove from the list as well as all its multiples
                int div = i;
                result.removeIf(j -> (j % div == 0));
            }
        }
        return result.stream().mapToInt(k -> k).sum();
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> divisorMap = new HashMap<>();
        for (int i = 1; i < 10000; i++) {
            divisorMap.put(i, sieve(i));
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : divisorMap.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v.compareTo(k) != 0 && divisorMap.get(v) != null && divisorMap.get(v).compareTo(k) == 0) {
                result += k;
            }
        }

        System.out.println("Sum of all amicable numbers: "+result);
    }

}
