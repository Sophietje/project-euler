import java.math.BigInteger;

public class Problem20 {

    public static void main(String[] args) {
        BigInteger digit = new BigInteger("1");
        for (int i = 1; i <= 100; i++) {
            digit = digit.multiply(new BigInteger(Integer.toString(i)));
        }

        System.out.println(digit);

        int index = 0;
        String num = digit.toString();
        int sumDigits = 0;
        while (index < num.length()) {
            sumDigits += Integer.parseInt(num.charAt(index)+"");
            index++;
        }
        System.out.println(sumDigits);
    }
}
