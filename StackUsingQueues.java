import kartik.* ;
public class StackUsingQueues<E>
{
	private kartik.Queue<E> q1=new kartik.LinkedQueue<E>();
	private kartik.Queue<E> q2=new kartik.LinkedQueue<E>();
	public StackUsingQueues()
	{
	}
	public int size() {  
		return q1.size();
    }
    public boolean isEmpty() {
	    return q1.size()==0;
    }
    public E top() {
	    return q1.first();
    } 
	public void push(E elem)
	{
		if(q1.isEmpty())
			q1.enqueue(elem);
		else
		{
			q2.enqueue(elem);
			while(!q1.isEmpty())
			{
				E x=q1.dequeue();
				q2.enqueue(x);
			}
			Queue<E> temp=q1;
			q1=q2;
			q2=temp;
		}
	}
	public E pop()
	{
		if(q1.isEmpty())
			return null;
		return q1.dequeue();
	}
	public static void main(String[] args) {
		StackUsingQueues<Integer> S = new StackUsingQueues<>();  // contents: ()
		S.push(5);                              // contents: (5)
		S.push(3);  							// contents: (5, 3)
		System.out.println(S.size());           // contents: (5, 3)     outputs 2
		System.out.println(S.pop());            // contents: (5)        outputs 3
		System.out.println(S.isEmpty());        // contents: (5)        outputs false
		System.out.println(S.pop());            // contents: ()         outputs 5
		System.out.println(S.isEmpty());        // contents: ()         outputs true
		System.out.println(S.pop());            // contents: ()         outputs null
		S.push(7);                              // contents: (7)
		S.push(9);                              // contents: (7, 9)
		System.out.println(S.top());            // contents: (7, 9)     outputs 9
		S.push(4);                              // contents: (7, 9, 4)
		System.out.println(S.size());           // contents: (7, 9, 4)  outputs 3
		System.out.println(S.pop());            // contents: (7, 9)     outputs 4
		S.push(6);                              // contents: (7, 9, 6)
		S.push(8);                              // contents: (7, 9, 6, 8)
		System.out.println(S.pop());            // contents: (7, 9, 6)  outputs 8
  }
}