import java.util.*;

/**
 * Find the largest prime factor of 600851475143
 * Created by sophie on 6/4/17.
 */
public class Problem3 {

    public static List<Long> getPrimeFactors(long n) {
        List<Long> resultFactors = new ArrayList<Long>();

        for (long i=2; i<=n; i++) {
            while (n%i == 0) {
                n /= i;
                resultFactors.add(i);
            }
        }

        return resultFactors;

    }


    public static long getLargest(List<Long> s) {
        long result = 0;
        for (int i=0; i<s.size(); i++){
            if (s.get(i) > result) {
                result = s.get(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            long n = 0;
            try {
                n = Long.parseLong(args[0]);
                System.out.println("Largest prime factor of "+args[0]+" is: "+getLargest(getPrimeFactors(n)));
            } catch (NumberFormatException e) {
                System.out.println("Argument "+args[0]+" must be an integer");
            }

            } else {
            System.out.println("Give the number of which to find the largest prime factor as an argument!");
        }

    }
}
