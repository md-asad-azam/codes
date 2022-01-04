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
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
    // Write your code here
        long num;
        String s2="";
        int k = 0, i;
        boolean beautiful = false;
        
        if(s.charAt(0) == '0' || s.length() == 1){
            System.out.println("NO");
            return;
        }
        for(i=0; i<s.length()/2; i++){
            num = Long.parseLong(s.substring(0, i+1));
            k=0;
            while(s2.length()<s.length()){
                s2 += String.valueOf(num+k);
                ++k;
            }
            if(s2.equalsIgnoreCase(s)){
                System.out.println("YES " + num);
                beautiful = true;
                break;
            }
            s2="";
        }
        if(!beautiful)
            System.out.println("NO");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
