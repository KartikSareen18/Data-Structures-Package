#include<iostream>
using namespace std;
const int n=4;
bool checkSafe(int board[n][n],int row,int col)
{
	for(int i=0;i<col;i++)               //check row on left side
		if(board[row][i]==1)
			return false;
	for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--)        //check upper diagonal on left side
		if(board[i][j]==1)
			return false;
	for(int i=row+1,j=col-1;i<n && j>=0;i++,j--)         //check lower diagonal on left side
		if(board[i][j]==1)
			return false;
	return true;
}

bool func(int board[n][n],int col)
{
	if(col>=n)
		return true;
	for(int i=0;i<n;i++)
	{
		if(checkSafe(board,i,col))
		{
			board[i][col]=1;
			if(func(board,col+1))
				return true;
			board[i][col]=0;
		}
	}
	return false;
}

void solveNQ()
{
	int board[n][n]={{0}};
	bool x=func(board,0);
	if(x==false)
	{
		cout<<"No solution"<<endl;
		return;
	}
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
			cout<<board[i][j]<<" ";
		cout<<endl;
	}
}

int main()
{
	cout<<"Output\n";
	solveNQ();
}
