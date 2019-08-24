import kartik.* ;
public class QueueUsingStacks<E>
{
	private Stack<E> s1=new LinkedStack<E>();
	private Stack<E> s2=new LinkedStack<E>();
	public QueueUsingStacks()
	{
	}
	public int size() {  
		return s1.size();
    }
    public boolean isEmpty() {
	    return s1.size()==0;
    }
    public E first() {
	    return s1.top();
    } 
	public void enqueue(E elem)
	{
		if(s1.isEmpty())
			s1.push(elem);
		else
		{
			while(!s1.isEmpty())
			{
				E x=s1.pop();
				s2.push(x);
			}
			s2.push(elem);
			while(!s2.isEmpty())
			{
				E x=s2.pop();
				s1.push(x);
			}
		}
	}
	public E dequeue()
	{
		if(s1.isEmpty())
			return null;
		return s1.pop();
	}
	/** Demonstrates sample usage of a queue. */
  public static void main(String[] args) {
    QueueUsingStacks<Integer> S = new QueueUsingStacks<>();  	// contents: ()
    S.enqueue(5);                               // contents: (5)
    S.enqueue(3);  								// contents: (5, 3)
    System.out.println(S.size());           	// contents: (5, 3)     outputs 2
    System.out.println(S.dequeue());            // contents: (3)        outputs 5
    System.out.println(S.isEmpty());        	// contents: (3)        outputs false
    System.out.println(S.dequeue());            // contents: ()         outputs 3
    System.out.println(S.isEmpty());        	// contents: ()         outputs true
    System.out.println(S.dequeue());            // contents: ()         outputs null
    S.enqueue(7);                               // contents: (7)
    S.enqueue(9);                               // contents: (7, 9)
    System.out.println(S.first());              // contents: (7, 9)     outputs 7
    S.enqueue(4);                               // contents: (7, 9, 4)
    System.out.println(S.size());               // contents: (7, 9, 4)  outputs 3
    System.out.println(S.dequeue());            // contents: (9, 4)     outputs 7
    S.enqueue(6);                               // contents: (9, 4, 6)
    S.enqueue(8);                               // contents: (9, 4, 6, 8)
    System.out.println(S.dequeue());            // contents: (4, 6, 8)  outputs 9
  }
}