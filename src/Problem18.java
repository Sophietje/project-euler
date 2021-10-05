import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Find the maximum total (maximum path sum) in the triangle (see problem18-triangle.txt)
 *
 * Created by sophie on 4/21/18.
 */
public class Problem18 {

    /**
     * The approach is from bottom to top.
     * Start in the last but one row, the first number.
     * Assume this looks as follows a, b, c where a is the parent, b is the left child and c is the right child
     * Then calculate the maximum path that can be taken from there
     * This is equal to the maximum of (a+b, a+c).
     * Replace a by the maximum.
     * Repeat this process for all other numbers in the row.
     * When finished, remove the last row and go one level up (repeat the process for the row above it).
     * Repeat until you're left with one number.
     * @param args
     */
    public static void main(String[] args) {
        String prev = null;
        String curr = null;
        String next = null;
        boolean lastLine = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(Problem13.class.getResourceAsStream("problem67-triangle.txt")));

            List lines = new ArrayList<String>();
            while (!lastLine) {
                next = br.readLine();
                lastLine = next == null;
                if (!lastLine) {
                    lines.add(next);
                }
            }
            getMaximumPath(lines);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not find file");
        } catch (IOException e) {
            System.out.println("Error: Could not read from file");
        }

    }

    private static String arrayToString(Object[] object) {
        String string = "[";
        for (int i=0; i<object.length-1; i++) {
            string += object[i] + ", ";
        }
        string += object[object.length-1] + "]";
        return string;
    }

    private static void getMaximumPath(List<String> lines) {
        if (!lines.isEmpty() && lines.size()>2) {
            String[] prevLine = lines.get(lines.size() - 2).trim().split(" ");
            String[] currLine = lines.get(lines.size() - 1).trim().split(" ");

            int[] newLine = new int[prevLine.length];

            for (int i = 0; i < prevLine.length; i++) {
                int left = Integer.valueOf(currLine[i]);
                int right = Integer.valueOf(currLine[i + 1]);
                int parent = Integer.valueOf(prevLine[i]);

                if (left >= right) {
                    newLine[i] = parent + left;
                } else {
                    newLine[i] = parent + right;
                }
            }

            List<String> triangle = new ArrayList<>(lines.subList(0, lines.size()-2));
            String lastLine = "";
            for (int i=0; i<newLine.length; i++) {
                lastLine += newLine[i] + " ";
            }
            lastLine.trim();
            triangle.add(lastLine);
            getMaximumPath(triangle);
        } else if (!lines.isEmpty() && lines.size() == 2) {
            // There are only 2 lines
            String[] parent = lines.get(lines.size() - 2).split(" ");
            String[] children = lines.get(lines.size()-1).split(" ");
            int par = Integer.valueOf(parent[0]);
            int left = Integer.valueOf(children[0]);
            int right = Integer.valueOf(children[1]);

            int maxPath = Math.max(left+par, right+par);

            System.out.println("The maximum path sum is "+maxPath);
        } else {
            if (!lines.isEmpty()) {
                // There is only one line so the shortest path is the single number
                System.out.println("The maximum path sum is "+Integer.valueOf(lines.get(0)));
            } else {
                System.out.println("Error: The triangle is empty. Cannot calculate the maximum path sum in an empty triangle");
            }
        }
    }


}
