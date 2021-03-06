class Dequeue 
{
    static final int MAX = 100;
    int arr[];
    int front;
    int rear;
    int size;
    public Dequeue(int size)
    {
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }
    boolean isFull()
    {
        return ((front == 0 && rear == size-1) || front ==rear+1);
    }
    boolean isEmpty()
    {
        return (front == -1);
    }
    void insertfront(int key)
    {
        if(isFull())
        {
            System.out.println("Overflow");
            return;
        }
        if(front == -1)
        {
            front = 0;
            rear = 0;
        }
        else if(front == 0)
        {
            front = size-1;
        }
        else
        {
            front = front - 1;
        }
        arr[front] = key;
    }
    void insertrear(int key)
    {
        if(isFull())
        {
            System.out.println("Overflow");
            return;
        }
        if(front == -1)
        {
            front = 0;
            rear = 0;
        }
        else if(rear == size-1)
        {
            rear = 0;
        }
        else
        {
            rear = rear+1;
        }
        arr[rear] = key;
    }
    void deletefront()
    {
        if(isEmpty())
        {
            System.out.println("Underflow");
            return;
        }
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }
        else
        {
            if(front == size-1)
            {
                front = 0;
            }
            else
            {
                front = front+1;
            }
        }
    }
    void deleterear()
    {
        if(isEmpty())
        {
            System.out.println("Underflow");
            return;
        }
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }
        else if(rear == 0)
        {
            rear = size-1;
        }
        else
        {
            rear = rear - 1;
        }
    }
    int getfront()
    {
        if(isEmpty())
        {
            System.out.println("Underflow");
            return -1;
        }
        return arr[front];
    }
    int getrear()
    {
        if(isEmpty() || rear<0)
        {
            System.out.println("Underflow");
            return -1;
        }
        return arr[rear];
    }
    public static void main(String args[])
    {
        Dequeue dq = new Dequeue (5);
        System.out.println("Insert element at rear end : 5");
        dq.insertrear(5);
        System.out.println("Insert element at rear end : 10");
        dq.insertrear(10);
        System.out.println("Get rear element : "+dq.getrear());
        dq.deleterear();
        System.out.println("After delete rear element new rear become : "+dq.getrear());
        System.out.println("Inserting element at front end : 15");
        dq.insertfront(15);
        System.out.println("Get front element : "+dq.getfront());
        dq.deletefront();
        System.out.println("After deleting front element new front become : "+dq.getfront());
    }
}
        
 