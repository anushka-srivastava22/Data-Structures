import java.util.*;
public class Main 
{
    public static void main (String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int fibn = fibonamem(n,new int[n+1]);
        System.out.println(fibn);
    }
    public static int fibonamem(int n, int qb[])
    {
        if(n==0 || n==1)
        {
            return n;
        }
        
        if(qb[n] !=0)
        {
            return qb[n];
        }
        
        int fib1 = fibonamem(n-1,qb);
        int fib2 = fibonamem(n-2,qb);
        int fibn = fib1 + fib2;
        
        qb[n] = fibn;
        return fibn;
    }
}
