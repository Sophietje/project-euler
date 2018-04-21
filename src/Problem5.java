/**
 * Find the smallest positive number that is evenly divisible by all of the numbers from 1 to 20
 * Created by sophie on 6/5/17.
 */
public class Problem5 {

    public static void main(String[] args) {
        boolean found = false;
        int i=210;
        while(!found) {
            boolean div = true;
            for (int j=1; j<=20; j++) {
                if (i%j != 0) {
                    div = false;
                    i++;
                    break;
                }
            }
            if (div) {
                found = div;
            }
        }
        System.out.println("Smallest positive number, evenly divisble by 1..20, is "+i);
    }
}
