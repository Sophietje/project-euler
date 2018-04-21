import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Work out the first ten digits of the sum of the one-hundred 50-digit numbers (see problem13-numbers.txt).
 *
 * Created by sophie on 4/21/18.
 */
public class Problem13 {


    public static void main(String[] args) {
        String line;
        long[] result = new long[10];
        int i = 1;
        long remainder = 0;
        try {
            for (int j = 0; j<50; j++) {
                BufferedReader r = new BufferedReader(new InputStreamReader(Problem13.class.getResourceAsStream("problem13-numbers.txt")));
                long res = remainder;
                while ((line = r.readLine()) != null) {
                    char c = line.charAt(line.length() - i);
                    int num = Integer.valueOf(Character.toString(c));
                    res += num;
                }
                if (i > 10) {
                    for (int l = result.length-1; l>0; l--) {
                        result[l] = result[l-1];
                    }
                    result[0] = (res % 10);
                } else {
                    result[result.length-i] = (res % 10);
                }
                remainder = (res / 10);
                res = 0;
                i++;
            }
        } catch (IOException e) {
            System.err.println("Unable to read from resource.");
        }
        String rem = Long.toString(remainder);
        for (int k=rem.length()-1; k>=0; k--) {
            for (int l = result.length-1; l>0; l--) {
                result[l] = result[l-1];
            }
            result[0] = Long.valueOf(Character.toString(rem.charAt(k)));
        }
        System.out.println(Arrays.toString(result));
    }
    // Read all last numbers

    // Save last digit on last place in results array

    // Read all one-but-last numbers

    // Save last digit on last-1 place in results array

    // Repeat above until array is full

    // Then each time a new sum is computed, shift all numbers in the array one place to the right (delete last number)
    // and insert new number at front
}
