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
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here
        int i, j, n = container.size();
        boolean flag = false;
        int box[] = new int[n];
        int type[] = new int[n];
        for(i = 0; i < n; ++i){
            for(j = 0; j < n; ++j){
                box[i] += container.get(i).get(j);//size of each box calculated
                type[i] += container.get(j).get(i);//no of each type of ball calculated
            }
        }
        // now each type of ball must fit in perfectly wih some or the other box
        // i.e.  size_of_box(a) = type_of_ball(z) and this must hold true for each for result to be possible
        
        for(i = 0; i < n; ++i){
            for(j = 0; j < n; ++j){
                if(box[i] == type[j]){
                    flag = true;//if we get a perfect fit we make the values -1
                    box[i] = type[j] = -1;//to mark that the ball-type pair is found
                    break;
                }
                else{
                    flag = false;
                }
            }
            if(flag == false)//if the above loop breaks with false flag then we have a                  got a type of ball that will not fit in any of the container #impossible
                break;
        }
        if(flag == false) return "Impossible";
        else    return "Possible";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

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
