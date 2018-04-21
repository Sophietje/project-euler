/**
 * Calculate the number of letters (excluding spaces and hyphens) needed to write out the numbers from 1 to 1000
 *
 * Created by sophie on 4/21/18.
 */
public class Problem17 {
    static String[] singles = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] exceptions = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static String hundred = "hundred";
    static String thousand = "thousand";
    static String and = "and";

    private static int index = 0;


    public static void main(String[] args) {
        // Start by making a list containing all written out numbers
        String[] nums = new String[1000];
        // Add 1-9 to list
        nums = addToList(nums, singles);
        // Add 10-19 to list
        nums = addToList(nums, exceptions);
        // Add 20, 30, ..., 90 to list
        nums = addToList(nums, tens);
        // Add numbers 21-99 (without tens)
        String[] twens = new String[79];
        for (int i=0; i<tens.length; i++) {
            for (int j=0; j<singles.length; j++) {
                nums[index] = ""+tens[i]+singles[j];
                twens[10*i+j] = nums[index];
                index++;
            }
        }
        // Add hundreds (100, 200, 300,..., 900) to list
        String[] hundreds = new String[9];
        for (int i=0; i<singles.length; i++) {
            nums[index] = ""+singles[i]+hundred;
            hundreds[i] = nums[index];
            index++;
        }
        // Add hundreds with singles (101, 102, ..., 109) to list
        for (int i=0; i<hundreds.length; i++) {
            for (int j=0; j<singles.length; j++) {
                nums[index] = ""+hundreds[i]+and+singles[j];
                index++;
            }
        }
        // Add hundreds with exceptions (110, 111, ..., 119) to list
        for (int i=0; i<hundreds.length; i++) {
            for (int j=0; j<exceptions.length; j++) {
                nums[index] = ""+hundreds[i]+and+exceptions[j];
                index++;
            }
        }
        // Add hundreds with tens (120, 130, ..., 190) to list
        for (int i=0; i<hundreds.length; i++) {
            for (int j=0; j<tens.length; j++) {
                nums[index] = ""+hundreds[i]+and+tens[j];
                index++;
            }
        }
        // Add hundreds with "twens" (121, 122, ..., 999) (without 120, 130, ..., 190) to list
        for (int i=0; i<hundreds.length; i++) {
            for (int j=0; j<twens.length; j++) {
                if (twens[j] != null) {
                    nums[index] = "" + hundreds[i] + and + twens[j];
                    index++;
                }
            }
        }
        // Add one thousand to list
        nums[index] = "one"+thousand;
        index++;

        // Count how many characters are in the array with all words written out
        long numChars = 0;
        for (String s : nums) {
            numChars += s.length();
        }
        System.out.println("You would need "+numChars+" characters");

    }

    public static String[] addToList(String[] list, String[] toAdd) {
        for (String s : toAdd) {
            list[index] = s;
            index++;
        }
        return list;
    }
}
