import java.io.*;
import java.util.*;

public class Main {

    public static void main (String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int count = countPath(n,new int[n+1]);
        System.out.println(count);
    }
    public static int countPath(int n, int qb[])
    {
        if(n==0 )
        {
            return 1;
        }
        else if(n < 0)
        {
            return 0;
        }
        if(qb[n] > 0)
        {
            return qb[n];
        }
        
        int nm1 = countPath(n-1,qb);
        int nm2 = countPath(n-2,qb);
        int nm3 = countPath(n-3,qb);
        int cp = nm1 + nm2 + nm3;
        
        qb[n] = cp;
        return cp;
    }

}
