/**
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum
 * Created by sophie on 6/5/17.
 */
public class Problem6 {

    public static int getSumSquares(int n) {
        int result = 0;
        for (int i=1; i<=n; i++) {
            result += (i*i);
        }
        return result;
    }

    public static int getSquareSum(int n) {
        int result = 0;
        for (int i=1; i<=n; i++) {
            result += i;
        }

        return result*result;
    }

    public static void main(String[] args) {
        System.out.println("The difference is "+(getSquareSum(100) - getSumSquares(100)));
    }
}
