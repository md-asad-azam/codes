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
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */
    public static void extraLongFactorials(int n) {
    // Write your code here
        // System.out.println(fact(n));
        int[] fact = new int[10000];
        int i, j, carry = 0, mul = 0, len;
        fact[0] = 1;
        len = 1;
        for(i=2; i<=n; i++){
            for(j=0; j<len; j++){
                mul = carry + fact[j] * i;
                carry = mul / 10;
                fact[j] = mul % 10;
            }
            while(carry>0){
                fact[len++] = carry % 10;
                carry /= 10;
            }
        }
        for(i=len-1;i>=0; i--){
            System.out.print(fact[i]);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
