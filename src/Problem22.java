import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
    Given a list of names, sort this list into alphabetical order.
    Then per name, calculate the alphabetical value and multiply this value by the alphabetical position.
    What is the total of all name scores in the file?
 */
public class Problem22 {
    static ArrayList<Character> alphabetValues;

    public static int getAlphabeticalValueOfName(String name) {
        int alphabeticalValue = 0;
        name = name.toLowerCase();
        for (char s : name.toCharArray()) {
            alphabeticalValue += alphabetValues.indexOf(s)+1;
        }
        return alphabeticalValue;
    }


    public static void main(String[] args) {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        alphabetValues = new ArrayList<>();
        for (int i = 0; i < alphabet.length; i++) {
            alphabetValues.add(alphabet[i]);
        }

        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(Problem22.class.getResourceAsStream("problem22-names.txt")));
            String fileContents = r.readLine();
            String[] nameList = fileContents.split(",");
            Arrays.sort(nameList);
            int sum = 0;
            for (int i = 0; i < nameList.length; i++) {
                nameList[i] = nameList[i].replace("\"", "");
                int alphabeticalValueOfName = getAlphabeticalValueOfName(nameList[i]);
                sum += alphabeticalValueOfName * (i+1);
            }
            System.out.println("Sum of all name scores: "+sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
