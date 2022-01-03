import java.util.*;

// Java program for implementation of Insertion Sort
class Solution {
    /*Function to sort array using insertion sort*/
    static int sort(int arr[])
    {
        int count = 0;
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                ++count;
            }
            arr[j + 1] = key;
        }
        return count;
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int i, n;
        n = in.nextInt();
        int arr[] = new int[n];
        for(i=0; i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(sort(arr));
    }
} /* This code is contributed by Rajat Mishra. */
