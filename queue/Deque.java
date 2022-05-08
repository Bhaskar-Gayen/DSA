package queue;
/**
 * Design a data structure to implement deque of size ‘N’. It should support the following operations
 * */
public class Deque 
{
    private int[] queue=null;
	private int size=-1;
	private int front=-1;
	private int rear=-1;
    public Deque(int n) 
    {
        queue=new int[n];
		size=queue.length;
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushFront(int x) 
    {
		if(isFull())
			return false;
		if(front==-1)
			front=rear=0;
		else
			if(front==0)
				front=size-1;
			else
				front--;
		queue[front]=x;
		return true;
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushRear(int x) 
    {
        if(isFull())
			return false;
		if(front==-1)
			front=rear=0;
		else
			if(rear==size-1)
				rear=0;
			else
				rear++;
		queue[rear]=x;
		return true;
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popFront() 
    {
        if(isEmpty())
			return -1;
		int ans=queue[front];
		if(front==rear)
			front=rear=-1;
		else
			if(front==size-1)
				front=0;
			else
				front++;
		return ans;
    }

    // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popRear() 
    {
         if(isEmpty())
			return -1;
		int ans=queue[rear];
		if(front==rear)
			front=rear=-1;
		else
			if(rear==0)
				rear=size-1;
			else
				rear--;
		return ans;
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    public int getFront() 
    {
        if(isEmpty())
			return -1;
		return queue[front];
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    public int getRear() 
    {
        if(isEmpty())
			return -1;
		return queue[rear];
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty() 
    {
        if(front==-1)
			return true;
		return false;
    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull() 
    {
        if((front==0&&rear==size-1)||(rear==front-1))
			return true;
		return false;
    }
}
