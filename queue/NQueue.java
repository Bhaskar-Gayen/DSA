package queue;

/**
 * CodingNinja: N Queue Using Array(efficiently implement N Queues in a single array)
 * */

public class NQueue {
	private int[] arr=null;
	private int[] next=null;
	private int[] front=null;
	private int[] rear=null;
	private int free=-1;
	public NQueue(int n, int s) {
		arr=new int[s];
		next=new int[s];
		front=new int[n];
		rear=new int[n];
		free=0;
		for(int i=0;i<n;i++){
			front[i]=-1;
			rear[i]=-1;
		}
		for(int i=0;i<s;i++)
			next[i]=i+1;
		next[s-1]=-1;
	}
	boolean isFull(){
		return free==-1;
	}
	boolean isEmpty(int qn){
		return front[qn-1]==-1;
	}

	// Enqueues 'X' into the Mth queue. Returns true if it gets pushed into the queue, and false otherwise.
	public boolean enqueue(int x, int m) {
		if(isFull())
			return false;
		int index=free;
		free=next[index];
		//for firstelement
		if(isEmpty(m))
			front[m-1]=rear[m-1]=index;
		else
			next[rear[m-1]]=index;
		rear[m-1]=index;
		next[index]=-1;
		arr[index]=x;
		return true;
	}

	// Dequeues top element from Mth queue. Returns -1 if the queue is empty, otherwise returns the popped element.
	public int dequeue(int m) {
		if(isEmpty(m))
			return -1;
		int val = arr[front[m-1]];
		int index=front[m-1];
		front[m-1]=next[index];
		next[index]=free;
		free=index;
		return val;
	}
}