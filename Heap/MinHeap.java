public class MinHeap
{
	private int n;
	private int arr[];
	MinHeap()
	{
		n=0;
		arr=new int[100];
	}
	public int getSize()
	{
		return n;
	}
	public int getMin()
	{
		if(n==0)
			return -1;
		return arr[0];
	}
	public void printArr()
	{
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public void swap(int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public void HeapifyBackward(int i)
	{
		if(i<1)
			return;
		int parent=(i-1)/2;
		if(arr[parent]<=arr[i])
			return;
		else
		{
			swap(parent,i);
			HeapifyBackward(parent);
		}
	}
	public void HeapifyForward(int i)
	{
		int min;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && arr[left]<=arr[i])
			min=left;
		else
			min=i;
		if(right<n && arr[right]<=arr[min])
			min=right;
		if(min!=i)
		{
			swap(min,i);
			HeapifyForward(min);
		}
	}
	public int DeleteMin()
	{
		if(n==0)
			return -1;
		int min=arr[0];
		arr[0]=arr[n-1];
		n--;
		HeapifyForward(0);
		return min;
	}
	public void sort()
	{
		for(int i=n-1;i>=0;i--)
		{
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			n--;
			HeapifyForward(0);
		}
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public void insert(int elem)
	{
		arr[n]=elem;
		n++;
		HeapifyBackward(n-1);
	}
}