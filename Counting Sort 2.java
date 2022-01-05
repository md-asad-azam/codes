import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int i, n;
        n = in.nextInt();
        int[] arr = new int[n];
        
        for(i=0; i<n; i++){
            arr[i]=in.nextInt();
        }
        
        int[] freq = new int[100];
        
        for(i=0; i<arr.length; i++){
            ++freq[arr[i]];
        }
        for(i=0; i<100; i++){
            while(freq[i] != 0){
                System.out.print(i + " ");
                --freq[i];
            }
        }        
    }
}
