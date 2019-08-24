import java.util.*;
public class Median
{
	MaxHeap x=new MaxHeap();
	MinHeap y=new MinHeap();
	public double median(int n)
	{
		if(x.getSize()==0)
		{
			x.insert(n);
		}
		else
		{
			if(x.getMax()>n)
				x.insert(n);
			else
				y.insert(n);
			if(Math.abs(x.getSize()-y.getSize())>1)
			{
				if(x.getSize()>y.getSize())
					y.insert(x.DeleteMax());
				else
					x.insert(y.DeleteMin());
			}
		}
		if((x.getSize()+y.getSize())%2==0)
			return (x.getMax()+y.getMin())/2.0;
		else
		{
			if(x.getSize()>y.getSize())
				return x.getMax();
			else
				return y.getMin();
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no.(-1 to exit): ");
		int n=sc.nextInt();
		Median m=new Median();
		while(n!=-1)
		{
			System.out.println("Median: "+m.median(n));
			System.out.print("Enter no.(-1 to exit): ");
			n=sc.nextInt();
		}
	}
}