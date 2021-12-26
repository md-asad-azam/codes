import java.util.*;

class Solution{
    public static void main(String[] Args){
        Scanner in = new Scanner(System.in);
        
        int i, j, n, t;
        ArrayList<Integer>arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> cases = new ArrayList<ArrayList<Integer>>();
        n = in.nextInt();
        t = in.nextInt();
        for(i = 0; i<n; i++){
            arr.add(in.nextInt());
        }
        for(i=0; i<t; i++){
            cases.add(new ArrayList<Integer>());
            for(j=0; j<2; j++){
                cases.get(i).add(j, in.nextInt());
            }
        }
        maxWidth(cases, arr);
    }
    
    public static void maxWidth(List<ArrayList<Integer>> cases, List<Integer>width){
        int i, j, enter, exit, min = 9999;
        for(i=0; i<cases.size(); i++){
            
            min = 9999;
            enter = cases.get(i).get(0);
            exit = cases.get(i).get(1);
            
            for(j=enter; j<= exit; j++){
                if(width.get(j) < min){
                    min = width.get(j);
                }
            }
            System.out.println(min);
            
        }
    }
}


