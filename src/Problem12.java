import static java.lang.Math.floor;

/**
 * What is the value of the first triangle number to have over five hundred divisors?
 *
 * Triangle number: Add all previous natural numbers, 7th triangle number = 1+..+7 = 28
 *
 * Created by Sophie on 18-7-2017.
 */
public class Problem12 {

    private static int[] findTriangleNumbers(int i) {
        int [] result = new int[i+1];
        for (int j=0; j<=i; j++) {
            for (int k=1; k<=j; k++) {
                result[j] +=k;
            }
        }
        return result;
    }

    private static int findNumDivisors(int i) {
        int res = 2;
        for (int j = 2; j*j<i; j++) {
            if ((i%j) == 0) {
                res+=2;
            }
        }
        if (Math.sqrt(i) == floor(Math.sqrt(i))) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = findTriangleNumbers(20000);
        for (int i=0; i<nums.length; i++) {
            if (findNumDivisors(nums[i]) > 500) {
                System.out.println(nums[i]);
            }
        }
        System.out.println(nums[nums.length-1]);
    }
}
