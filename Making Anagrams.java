import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
    // Write your code here
        int n1 = s1.length(), n2 = s2.length(), count = 0, i;
        // String s1, s2;
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(i=0; i<n1; i++){
            ++f1[s1.charAt(i) - 'a'];
        }
        for(i=0; i<n2; i++){
            ++f2[s2.charAt(i) - 'a'];
        }        
        for(i=0; i<26; i++){
            count += Math.abs(f1[i] - f2[i]);
        }
        // System.out.println(s1+" "+s2);
        return count;
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
