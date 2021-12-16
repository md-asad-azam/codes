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
         * Complete the 'climbingLeaderboard' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY ranked
         *  2. INTEGER_ARRAY player
         */

        public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
            // Write your code here
            int rank = 0, player_rank, i, j;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            List<Integer> p_rank = new ArrayList<>();

            for(i = 0; i < ranked.size(); i++){
                if(i == 0 || ranked.get(i) != ranked.get(i - 1))
                {
                    map.put(ranked.get(i), ++rank);
                }
                else{
                    map.put(ranked.get(i), rank);
                }
            }

            for(i = 0; i < player.size(); i++){
                player_rank = player.get(i);
                int last_ele = ranked.get(ranked.size() - 1);
                if(player_rank < last_ele){
                    p_rank.add(map.get(last_ele) + 1);
                }
                else{
                    for(j = 0; j < ranked.size(); j++){
                        if(player_rank >= ranked.get(j)){
                            p_rank.add(map.get(ranked.get(j)));
                            break;
                        }
                    }
                }
            }

            return p_rank;
        }
    }

    public class climbing_the_leaderboard {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = Result.climbingLeaderboard(ranked, player);

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