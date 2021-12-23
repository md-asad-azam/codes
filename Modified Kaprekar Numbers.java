import java.util.Scanner;
public class Kaprekar {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int p = cin.nextInt();
        int q = cin.nextInt();
        
        boolean one = false;
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                if (one) {
                    System.out.print(" ");
                }
                System.out.print(i);
                one = true;
            }
        }
        if (!one) {
            System.out.println("INVALID RANGE");
        }
    }
    
    static boolean isKaprekar(long n) {
        long t = n;
        int d = 0; // Digits
        long div = 1;
        while (t > 0) {
            t = t / 10;
            d++;
            div *= 10;
        }
        
        long sq = n * n;
        long left = sq / div;
        long right = sq % div;
        
        //System.out.println(n + " " + left + " " + right);
        
        return left + right == n;
    }
}
