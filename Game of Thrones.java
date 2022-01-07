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
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    

    public static String gameOfThrones(String s) {
    // Write your code here
        int i, oddCount=0;
        char ch;
        boolean odd =false;
        int [] f = new int[26];
        s.toLowerCase();
        if(s.length() % 2 != 0)
            odd = true;
            
        for(i=0; i<s.length(); i++){
            ch = s.charAt(i);
            ++f[ch - 'a'];
        }
        for(i=0; i<26; i++){
            if(!odd && f[i] % 2 != 0)
                return "NO";
            else if(odd && f[i] % 2 != 0)
                ++oddCount;
        }
        if(odd && oddCount != 1)
            return "NO";
        else
            return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
