import java.util.*;

public class Solution
{
    public static String hackerrankInString(String s) {
    // Write your code here
        int i, k = 0;
        char ch, c;
        String t = "hackerrank", nstr = "";
        for(i=0; i<s.length(); i++){
            ch=s.charAt(i);
            c=t.charAt(k);
            if(ch == c){
                ++k;
                nstr += ch;
            }
                if(k == t.length()) break;            
        }
        if(nstr.equalsIgnoreCase("hackerrank"))
            return "YES";
        else 
            return "NO";
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int t;
        t = in.nextInt();
        String s;
        while(--t >= 0){
            s = in.next();
            System.out.println(hackerrankInString(s));
        }
    }
}
