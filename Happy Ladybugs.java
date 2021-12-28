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
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    // Write your code here
        int[] arr = new int[256];
        int i;
        char ch;
        boolean noBlank = true, alreadyHappy = true;
        for(i=0; i<256; i++)    arr[i] = 0;
        
        for(i=0; i<b.length(); i++){
            ch = b.charAt(i);
            ++arr[(int)ch];
            if(ch == '_')
                noBlank = false;
            if((i>0 && i<b.length()-1) && ch != b.charAt(i-1) && ch != b.charAt(i+1))
                alreadyHappy = false;
        }
        for(i=0; i<256; i++){
            if((arr[i] == 1 && i != (int)'_') || (noBlank && !alreadyHappy)){
                return "NO";
            }
        }
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
