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
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
        int i, j, k, count = 0, count2 = 0, max = 0; 
        String t1, t2;
        List<Integer> arr = new ArrayList<>();
        List<Integer> tcount = new ArrayList<>();
        for(i = 0; i< topic.size(); i++){
            for(j = i + 1; j<topic.size(); j++){
                t1 = topic.get(i); t2 = topic.get(j);
                k = 0;
                while(k < t1.length()){
                    if(t1.charAt(k) == '1' || t2.charAt(k) == '1')
                        ++count;
                    // System.out.println(t1.charAt(k)+" "+t2.charAt(k)); 
                    ++k;   
                    // System.out.println(count);
                }
                if(count>max)
                    max = count;
                tcount.add(count);
                count = 0;
            }
        }
        for(i = 0; i<tcount.size(); i++){
            if(tcount.get(i) == max)    ++count2;
        }
        arr.add(max);
        arr.add(count2);
        return arr;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
