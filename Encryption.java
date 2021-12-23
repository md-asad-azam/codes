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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
    int i, j, k=0, row, col;
    boolean space = true;
    String str = "";
        for(i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ')  continue;
            else str += s.charAt(i);
        }
        row = (int)Math.floor(Math.sqrt(str.length()));
        col = (int)Math.ceil(Math.sqrt(str.length()));
        if(row * col < str.length()){
            row += 1;
        }
        char [][] arr = new char[row][col];
        
        
        for(i = 0; i<row; i++){
            for(j=0; j<col; j++){
                arr[i][j] = '*';
                // System.out.print(arr[i][j]);
            }
            // System.out.println();
        }
        
        for(i = 0; i<row; i++){
            if(k == str.length())   break;
            for(j=0; j<col; j++){
                if(k == str.length())   break;                
                arr[i][j] = str.charAt(k);
                ++k;
            }
        }
        
        
        
        str="";
        for(i = 0; i<col; i++){
            for(j=0; j<row; j++){
                if(arr[j][i] == '*'){
                //     space = false;
                // System.out.println("=");                    
                    continue;
                }    
                str += arr[j][i];
            }   
            // if(space){
            //     System.out.println("+");
                str += ' ';
            // }        
            // space = true;
        }
        return str.substring(0, str.length() - 1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
