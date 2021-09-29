import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc=new Scanner(System.in);
    int n = sc.nextInt();
    int dp0[] = new int[n+1];
    int dp1[] = new int[n+1];
    dp0[1] = 1;
    dp1[1] = 1;
    for(int i=2;i<=n;i++)
    {
        dp1[i] = dp1[i-1] + dp0[i-1];
        dp0[i] = dp1[i-1];
    }
    System.out.println(dp1[n] + dp0[n]);
 }

}
