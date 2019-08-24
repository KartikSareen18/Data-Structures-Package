#include<iostream>
#include <bits/stdc++.h> 
using namespace std;

class Item
{
	public:
	int weight;
	int value;
};

bool cmp(Item a,Item b)
{
	double r1=(double)a.value/a.weight;
	double r2=(double)b.value/b.weight;
	return r1>r2;	
}

double fractionalKnapsack(Item arr[],int W,int n)
{
	sort(arr,arr+n,cmp);
	int currWeight=0;
	double finalValue=0;
	for(int i=0;i<n;i++)
	{
		if(currWeight+arr[i].weight<=W)
		{
			currWeight+=arr[i].weight;
			finalValue+=arr[i].value;
		}
		else
		{
			int remain=W-currWeight;
			currWeight=W;
			finalValue+=arr[i].value*((double)remain/arr[i].weight);
			break;	
		}
	}
	return finalValue;
}

int main()
{
	int w;
	cout<<"Enter weight: ";
	cin>>w;
	int n;
	cout<<"Enter n: ";
	cin>>n;
	Item arr[n];
	for(int i=0;i<n;i++)
	{
		cout<<"Enter weight and value: ";
		cin>>arr[i].weight>>arr[i].value;
	}
	cout<<fractionalKnapsack(arr,w,n)<<endl;
}

