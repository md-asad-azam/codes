import java.io.*;
import java.util.*;
public class Solution
{
public static void main(String[] args)
{
int m;
long b,w,x,y,z;
long v1,v2,v3,v4,s;
Scanner in = new Scanner(System.in);
m = in.nextInt();
while(m!=0)
{
b = in.nextLong();
w = in.nextLong();
x = in.nextLong();
y = in.nextLong();
z = in.nextLong();
v1=0L;v2=0L;v3=0L;v4=0L;s=0L;
v1 = (b*x)+(w*y);
v2 = (b*z)+(b*y) + (w*z)+(w*x);
if(v1<=v2)
s=v1;
else
s=v2;
v3 = (b*x) + (w*z)+(w*x);
if(v3<=s)
s=v3;
v4 = (b*z)+(b*y) + (w*y);;
if(v4<=s)
s=v4;
System.out.println(s);
m--;
}
}
}
