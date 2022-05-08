package stack;

public class NStack {
	private int[] arr=null;
	private int[] next=null;
	private int[] top=null;
	private int free=-1;
	
	public NStack(int N, int S) {
		arr= new int[S];
		next= new int[S];
		top=new int[N];
		free=0;
		for(int i=0;i<N;i++)
			top[i]=-1;
		for(int i=0;i<S-1;i++)
			next[i]=i+1;
		next[S-1]=-1;
		free=0;
	}
	boolean isFull(){
		return free==-1;
	}

	// Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
	public boolean push(int x, int m) {
		if(isFull())
			return false;
		int index=free;
		free=next[index];
		arr[index]=x;
		next[index]=top[m-1];
		top[m-1]=index;
		return true;
	}
	boolean isEmpty(int m){
		return top[m-1]==-1;
	}

	// Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
	public int pop(int m) {
		if(isEmpty(m))
			return -1;
		int index=top[m-1];
		top[m-1]=next[index];
		next[index]=free;
		free=index;
		return arr[index];
	}
}