class Stack2
{
    int ar[];
    int i;
    public Stack2(int size)
    {
        int ar[]=new int[size];
        i=-1;
    }
    public void push(int n)
    {
        if(i<ar.length-1)
        {
            i++;
            ar[i]=n;
        }
        else
        {
           System.out.println("Stack Overflow");
        }
    }
    public int pop()
    {
        if(i>=0)
        {
            return ar[i--];
        }
        else
        {
            return -9999;
        }
    }
}