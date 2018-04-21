import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Need to find the sum of all multiples of 3 and 5 below 1000
 * Created by sophie on 6/4/17.
 */
public class Problem1 {

    public static List<Integer> getMultiples(int n, int range) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i=n; i<range; i+=n) {
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        List mult3 = getMultiples(3, 1000);
        List mult5 = getMultiples(5, 1000);
        Set<Integer> multiples = new HashSet<Integer>();
        multiples.addAll(mult3);
        multiples.addAll(mult5);
        int result = 0;
        for (Integer i:multiples) {
            result += i;
        }
        System.out.println("Result: "+result);
    }

}
