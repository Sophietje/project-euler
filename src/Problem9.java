/**
 * Find a Pythagorean triplet for which a+b+c=1000
 * Find the product abc
 * Created by sophie on 6/5/17.
 */
public class Problem9 {

    public static void main(String[] args) {
        for (int a=1; a<999; a++) {
            for (int b=1; b<999; b++) {
                for (int c=1; c<999; c++) {
                    if (a+b+c == 1000) {
                        int aSquared = (int) Math.pow(a, 2);
                        int bSquared = (int) Math.pow(b, 2);
                        int cSquared = (int) Math.pow(c,2);
                        if ((aSquared + bSquared) == cSquared) {
                            System.out.println("The pythagorean triplet is a="+a+", b="+b+", c="+c);
                            System.out.println("The product abc is "+a*b*c);
                        }
                    }
                }
            }
        }
    }
}
