#include<iostream>
#include<algorithm>
using namespace std;

int platforms(int *arr,int *dep,int n)
{
	sort(arr,arr+n);
	sort(dep,dep+n);
	int plat=0,max=0;
	int i=0,j=0;
	while(i<n && j<n)
	{
		if(arr[i]<=dep[j])
		{
			plat++;
			i++;
			if(plat>max)
				max=plat;
		}
		else
		{
			plat--;
			j++;
		}
	}
	return max;
}

int main()
{
	int n;
	cout<<"Enter n: ";
	cin>>n;
	int arr[n],dep[n];
	for(int i=0;i<n;i++)
	{
		cout<<"Enter arrival and departure time(9:00=900): ";
		cin>>arr[i]>>dep[i];
	}	
	cout<<"Min no. of platforms required: "<<platforms(arr,dep,n)<<endl;
	return 0;
}
