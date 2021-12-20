

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n, k, i;
        List<Integer> c = new ArrayList<>();
        n = in.nextInt();
        k = in.nextInt();
        for(i = 0; i<n; i++){
            c.add(in.nextInt());
        }
        
        System.out.println(cloudJump(k, n, c));
    }
    public static int cloudJump(int k, int n, List<Integer> c){
        int i = 0, energy = 100;
        while(true){
            i = (i + k) % n;
            if(c.get(i) == 0){
                --energy;
            }else{
                energy -= 3;
            }
            
            if(i == 0){
                break;
            }
        }
        return energy;
    }
}
