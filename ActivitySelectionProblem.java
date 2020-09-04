class ActivitySelectionProblem
{
    public static void printActivity(int s[] , int f[]  , int n)
    {
        int i,j;
        i=0;
        System.out.print(i+" ");
        for( j=1; j<n; j++)
        {
            if(s[j] >=f[i])
            {
                System.out.print(j+" ");
                i=j;
            }
        }
    }
    public static void main(String args[])
    {
        int s[]={1,3,0};
        int f[]={2,4,6};
        int n=s.length;
        printActivity(s,f,n);
    }
}
        