import java.util.*;

class Solution{
    public static void main(String Args[]){
        Scanner in = new Scanner(System.in);
        int n, d, i, j, k, count = 0;
        List<Integer> arr = new ArrayList<>();
        n = in.nextInt();
        d = in.nextInt();    
        for(i=0; i<n; i++){
            arr.add(in.nextInt());
        }
        for(i=0; i<n; i++){
            for(j = i+1; j<n; j++){
                if(arr.get(j) - arr.get(i) == d)
                for(k=j+1; k<n; k++){
                    if(isBeautiful(arr.get(i), arr.get(j), arr.get(k), d))
                        ++count;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean isBeautiful(int a, int b, int c, int d){
        if(b - a == d && c - b == d)
            return true;
        else
            return false;
    }
}
