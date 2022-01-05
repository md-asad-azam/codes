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
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */
     public static boolean doContain(String s, char ch){
         for(int i=0; i<s.length(); i++){
             if(s.charAt(i) == ch)  return true;
         }
         return false;
     }

    public static int gemstones(List<String> arr) {
    // Write your code here
        int i, j, k, count=26;
        String str;
        char c;
        boolean present = false;
        char[] ch = new char[26];
        for(i='a'; i<='z'; i++){
            // ch[i-'a'] = (char)i;
            for(j=0; j<arr.size(); j++){
                str=arr.get(j);
                present = false;
                for(k=0; k<str.length(); k++){
                    c = str.charAt(k);
                    if(c == (char)i){
                        present = true;
                        break;
                    }
                }
                if(!present)
                    ch[i-'a'] = 'f';
            }
        }
        for(i=0; i<26; i++){
            if(ch[i] == 'f'){
                --count;
            }
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
