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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
        boolean uCase, lCase, num, special, len;
        uCase = lCase = num = special = len = false;
        int i, count = 5;
        char ch;
        
        for(i=0; i<n; i++){
            ch = password.charAt(i);
            if(!uCase && ch >= (int)'A' && ch <= (int)'Z'){
                uCase=true; 
                --count;
            }
            if(!lCase && ch >= (int)'a' && ch <= (int)'z'){
                lCase=true;
                --count;
                System.out.println("+");
            }
            if(!special && (ch=='!' || ch=='@' || ch=='#' || ch=='$' || ch=='%' || 
            ch=='^' || ch=='&' || ch=='*' || ch=='(' || ch==')' || ch=='-' || ch=='+')){
                special=true;
                --count;
            }
            if(!num && ch >= (int)'0' && ch <= (int)'9'){
                num=true;
                --count;
            }
        }
        if(n < 6 && (6-n) >= count){
            return (6 - n);
        }else{
            len=true;
            return --count;
        }
        
        
        // n = n + count;
    
        // if(n < 6)
        //     count = count + 6 - n;
        // return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
