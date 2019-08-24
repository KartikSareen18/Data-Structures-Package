public class TwoStacksUsingArray<E>  
{
	private E[] arr;
	private int size;
	private int top1,top2;
	public TwoStacksUsingArray()
	{
	}
	public TwoStacksUsingArray(int n)
	{
		size=n;
		arr=(E[]) new Object[n];
		top1=-1;
		top2=n;
	}
	public int size1()
	{
		return top1;
	}
	public int size2()
	{
		return size-top2;
	}
	boolean isEmpty1()
	{
		return top1==-1;
	}
	boolean isEmpty2()
	{
		return top2==size;
	}
	void push1(E e)
	{
		if(top1+1>=top2)
			return;
		top1++;
		arr[top1]=e;
	}
	void push2(E e)
	{
		if(top2-1<=top1)
			return;
		top2--;
		arr[top2]=e;
	}
	E top1()
	{
		if(top1==-1)
			return null;
		return arr[top1];
	}
	E top2()
	{
		if(top2==size)
			return null;
		return arr[top2];
	}
	E pop1()
	{
		if(top1==-1)
			return null;
		E res=arr[top1];
		top1--;
		return res;
	}
	E pop2()
	{
		if(top2==size)
			return null;
		E res=arr[top2];
		top2++;
		return res;
	}
	public String toString1() {
	  String res="";
	  for(int i=0;i<=top1;i++)
		  res+=arr[i]+" ";
	  return res;	  
   }
	public String toString2() {
	  String res="";
	  for(int i=size-1;i>=top2;i--)
		  res+=arr[i]+" ";
	  return res;	  
   }
   public static void main(String[] args) {
    TwoStacksUsingArray<Integer> S = new TwoStacksUsingArray<>(5);  // contents: ()
    S.push1(5); 
	S.push2(10); 
	S.push2(15); 
	S.push1(11); 
	S.push2(7); 
	System.out.println(S.toString1());
	System.out.println(S.toString2());
	S.push2(10);
	System.out.println(S.toString1());
	System.out.println(S.toString2());
	S.pop1();
	S.push2(10);
	System.out.println(S.toString1());
	System.out.println(S.toString2());
  }
}