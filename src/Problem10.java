/**
 * Find the sum of all the primes below two million
 * Created by sophie on 6/5/17.
 */
public class Problem10 {

    public static void main(String[] args) {
        long result = 0;
        for (int i=2; i<(2*Math.pow(10, 6)); i++) {
            if (isPrime(i)) {
                System.out.println("New prime: "+i);
                result += i;
            }
        }

        System.out.println("The sum of all primes below 2,000,000 is "+result);

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
