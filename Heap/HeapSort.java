import java.util.*;
public class HeapSort
{
	private int size;
	private int n;
	private int arr[];
	static Scanner sc=new Scanner(System.in);
	HeapSort(int n1)
	{
		n=n1;
		size=n;
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
	public void HeapifyBackward(int i)
	{
		if(i<1)
			return;
		int parent=(i-1)/2;
		if(arr[parent]>arr[i])
			return;
		else
		{
			swap(parent,i);
			HeapifyBackward(parent);
		}
	}
	public void HeapifyForward(int i)
	{
		int max;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && arr[left]>arr[i])
			max=left;
		else
			max=i;
		if(right<n && arr[right]>arr[max])
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
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public void insert(int elem)
	{
		arr[n]=elem;
		n++;size++;
		HeapifyBackward(n-1);
	}
	public void BuildHeap()
	{
		for(int i=size/2-1;i>=0;i--)
		{
			HeapifyForward(i);
		}
	}
	public static void main(String args[])
	{
		int n1=sc.nextInt();
		HeapSort h=new HeapSort(n1);
		h.getArr();
		h.BuildHeap();	
		h.printArr();
		System.out.println(h.DeleteMax());
		h.printArr();
		h.insert(30);
		h.printArr();
		h.sort();
		
	}
}