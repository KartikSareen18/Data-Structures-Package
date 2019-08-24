import java.util.*;
public class KthLargest
{
	private int size;
	private int n;
	private int arr[];
	static Scanner sc=new Scanner(System.in);
	public KthLargest(int n1)
	{
		size=n1;
		n=n1;
		arr=new int[n];
	}
	public void getArr()
	{
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
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
	public void HeapifyForward(int i)
	{
		int left=2*i+1;
		int right=2*i+2;
		int max;
		if(left<n && arr[i]<arr[left])
			max=left;
		else
			max=i;
		if(right<n && arr[max]<arr[right])
			max=right;
		if(max!=i)
		{
			swap(max,i);
			HeapifyForward(max);
		}
	}
	public int DeleteMax()
	{
		if(n==0)
			return -1;
		int max=arr[0];
		arr[0]=arr[n-1];
		n--;size--;
		HeapifyForward(0);
		return max;
	}
	public void HeapifyBackward(int i)
	{
		if(i<1)
			return;
		int parent=(i-1)/2;
		if(arr[parent]>=arr[i])
			return;
		else
		{
			swap(parent,i);
			HeapifyBackward(parent);
		}
	}
	public void insert(int e)
	{
		arr[n]=e;
		n++;size++;
		HeapifyBackward(n-1);
	}
	public void BuildHeap()
	{
		for(int i=n/2-1;i>=0;i--)
			HeapifyForward(i);
	}
	public int kthLargest(int k)
	{
		if(k>n)
			k=n;
		//int size=n-1;
		for(int i=1;i<=k;i++)
		{ 
			int a=arr[0];
			arr[0]=arr[n-1];
			arr[n-1]=a;n--;
			//size--;
			HeapifyForward(0);
		}
		return arr[size-k];
	}
	public static void main(String args[])
	{
		int n1=sc.nextInt();
		KthLargest h=new KthLargest(n1);
		h.getArr();
		h.BuildHeap();	
		h.printArr();
		System.out.println(h.DeleteMax());
		h.printArr();
		h.insert(30);
		h.printArr();
		int k=sc.nextInt();
		System.out.println(h.kthLargest(k));
		
	}
}