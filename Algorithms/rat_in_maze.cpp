#include<iostream>
using namespace std;
const int m=4,n=4;
bool checkSafe(int x,int y,int arr[m][n])
{
	if(x<m && y<n && arr[x][y]==1)
		return true;
	return false;	
}

bool func(int x,int y,int arr[m][n],int sol[m][n])
{
	if(x==m-1 && y==n-1)
	{
		sol[x][y]=1;
		return true;
	}
	if(checkSafe(x,y,arr))
	{
		sol[x][y]=1;
		if(func(x,y+1,arr,sol))
			return true;
		if(func(x+1,y,arr,sol))
			return true;
		sol[x][y]=0;
	}
	return false;
}

void solveMaze(int arr[m][n])
{
	int sol[m][n]={{0}};
	bool x=func(0,0,arr,sol);
	if(x==false)
	{
		cout<<"No solution"<<endl;
		return;
	}
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
			cout<<sol[i][j]<<" ";
		cout<<endl;
	}
}

int main()
{
	cout<<"Enter 16 elements for 4*4 matrix:";
	//cin>>m>>n;
	int arr[m][n];
	for(int i=0;i<m;i++)
		for(int j=0;j<n;j++)
			cin>>arr[i][j];
	cout<<"Output\n";
	solveMaze(arr);
}
