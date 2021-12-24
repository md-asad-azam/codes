import java.util.*;

class Solution{
    public static void main(String Args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // List<Integer> a = new ArrayList<>();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        System.out.print(minimumDistances(a));
    }
    public static int minimumDistances(int[] a) {
    // Write your code here
        int i, j, min = Integer.MAX_VALUE, temp;
        for(i=0; i<a.length; i++){
            for(j=i+1; j<a.length; j++){
                if(a[i] == a[j]){
                    temp = j - i;
                    if(temp < min)
                        min = temp;
                }
            }
        }
        if(min == Integer.MAX_VALUE)  return -1;
        else    return min;
    }
}
