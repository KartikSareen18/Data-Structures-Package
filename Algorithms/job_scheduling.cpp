#include<iostream>
#include <bits/stdc++.h> 
using namespace std;

class Job
{
	public:
	char id;
	int deadline;
	int profit;
};

bool cmp(Job a,Job b)
{
	return a.profit>b.profit;	
}

void jobScheduling(Job arr[],int n)
{
	sort(arr,arr+n,cmp);
	bool filled[n];
	int result[n];
	for(int i=0;i<n;i++)
		filled[i]=false;
	for(int i=0;i<n;i++)
	{
		for(int j=min(n,arr[i].deadline)-1;j>=0;j--)
		{
			if(filled[j]==false)
			{
				result[j]=i;
				filled[j]=true;
				break;
			}
		}
	}
	for(int i=0;i<n;i++)
		if(filled[i])
		cout<<arr[result[i]].id<<" ";
}

int main()
{
	int n;
	cout<<"Enter n: ";
	cin>>n;
	Job arr[n];
	for(int i=0;i<n;i++)
	{
		cout<<"Enter Job_id, deadline and profit: ";
		cin>>arr[i].id>>arr[i].deadline>>arr[i].profit;
	}
	jobScheduling(arr,n);
}

