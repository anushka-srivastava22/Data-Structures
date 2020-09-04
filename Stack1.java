class Stack1
{
    int ar[]=new int[3];
    int i=-1;

    public void push(int n)
    {
        if(i<3)
        {
            i++;
            ar[i]=n;
            
        }
        else
        {
            System.out.println("Stack Overflow");
        }
    }

    public void pop()
    {
        if(i>=0)
        {
            
            System.out.println(ar[i]);
            i--;
        }
        else
        {
            System.out.println("Stack Underflow");
        }
    }

    public static void main(String args[])
    {
        Stack1 s=new Stack1();
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        s.pop();
        s.pop();
    }

    /*public static void main(String args[])
    {
    Stack1 s=new Stack1(3);
    s.push(2);
    s.push(3);
    s.push(4);
    s.pop();
    }*/
}