

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
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
    // Write your code here
    
        // int i, count = 0; double freq = 0.0;
        // if(s.length() == 1 && s.charAt(0) == 'a')
        //     return n;
        // for(i = 0; i < s.length(); i++){
        //     if(s.charAt(i) == 'a'){
        //         ++count;
        //     }
        // }
        // freq = (double) count / s.length();
        // System.out.println(freq + " " + count + " " + count / s.length());
        // count = (int) Math.round(freq * n);
        // return count;
        
        
        long ans, rem, count = 0;
        int i;
        ans = n / s.length(); //no of times to append the string to reach the nth place
        rem = n % s.length(); // no of digit remains to reach nth index
        
        for(i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                ++count;
            }
        }
        ans *= count;
        for(i = 0; i < rem; i++) {
            if(s.charAt(i) == 'a')   ++ans;
        }
        
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
