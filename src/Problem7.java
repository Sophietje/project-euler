import java.util.HashSet;
import java.util.Set;

/**
 * Find the 10 001st prime number
 * Created by sophie on 6/5/17.
 */
public class Problem7 {

    public static void main(String[] args) {
        Set<Integer> s = new HashSet<Integer>();
        int i=2;
        int result = -1;
        while (s.size() < 10001) {
            if (isPrime(i)) {
                s.add(i);
                result = i;
            }
            i++;
        }
        System.out.println("The 10,001st prime is "+result);
    }

    public static boolean isPrime(int n) {
        boolean result = true;
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
