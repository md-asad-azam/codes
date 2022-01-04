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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here
        String str = s.toLowerCase();
        int i;
        char ch;
        int freq[] = new int[26];
        
        for(i=0; i<26; i++)
            freq[i] = 0;
            
        for(i=0; i<s.length(); i++){
            ch = str.charAt(i);
            if(ch == ' ')   continue;
            else{
                ++freq[(ch - 'a')];
            }
        }
        for(i=0; i<26; i++){
            if(freq[i] == 0){
                return "not pangram";
            }
        }
        return  "pangram";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
