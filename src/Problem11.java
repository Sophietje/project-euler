import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

/**
 * In a given 20x20 grid, find four adjacent numbers
 * in the same direction (up, down, left, right) with the greatest product.
 * Created by Sophie on 18-7-2017.
 */
public class Problem11 {
    private static int[][] grid;
    private static int gridLength;

    private static int findProductVertical() {
        int max = 0;
        for (int i=0; i<gridLength-3; i++) {
            for (int j=0; j<gridLength; j++) {
                int product = grid[i][j]*grid[i+1][j]*grid[i+2][j]*grid[i+3][j];
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    private static int findProductHorizontal() {
        int max = 0;
        for (int i=0; i<gridLength; i++) {
            for (int j=0; j<gridLength-3; j++) {
                int product = grid[i][j]*grid[i][j+1]*grid[i][j+2]*grid[i][j+3];
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    private static int findProductDiagonalRight() {
        int max = 0;
        for (int i=0; i<gridLength-3; i++) {
            for (int j=0; j<gridLength-3; j++) {
                int product = grid[i][j]*grid[i+1][j+1]*grid[i+2][j+2]*grid[i+3][j+3];
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    private static int findProductDiagonalLeft() {
        int max = 0;
        for (int i=3; i<gridLength; i++) {
            for (int j=0; j<gridLength-3; j++) {
                int product = grid[i][j]*grid[i-1][j+1]*grid[i-2][j+2]*grid[i-3][j+3];
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    private static int max(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (nums[i] < nums[j]) {
                    break;
                }
                if (j == nums.length-1) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void findGreatestProduct() {
        // read file with numbers to fill grid
        // NOTE: GRID SHOULD BE A SQUARE
        try {
            boolean initialized = false;
            String line;
            int i = -1;
            BufferedReader r = new BufferedReader(new InputStreamReader(Problem11.class.getResourceAsStream("grid.txt")));
            while ((line = r.readLine()) != null) {
                i++;
                String[] strNums = line.split(" ");
                if (!initialized) {
                    grid = new int[strNums.length][strNums.length];
                    gridLength = strNums.length;
                    initialized = true;
                }
                for (int j = 0; j<strNums.length; j++) {
                    grid[i][j] = Integer.parseInt(strNums[j]);
                }
            }

            int a = findProductVertical();
            int b = findProductHorizontal();
            int c = findProductDiagonalRight();
            int d = findProductDiagonalLeft();
            System.out.println(""+a+","+b+","+c+","+d);

            System.out.println("The maximum product is "+max(new int[]{a,b,c,d}));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }


    }

    public static void main(String[] args) {
        findGreatestProduct();
    }
}
