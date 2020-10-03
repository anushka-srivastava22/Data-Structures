public class Test3
{
    public static void main(String args[])
    {
        LQueue q = new LQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue Front "+q.front.key);
        System.out.println("Queue Rear "+q.rear.key);
    }
}
