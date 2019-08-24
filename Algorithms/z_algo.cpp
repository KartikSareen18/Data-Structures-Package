#include<iostream>
using namespace std;

void getZarr(string str,int *Z)
{
	int n=str.length();
	int L,R,k;
	L=R=0;
	for(int i=1;i<n;i++)
	{
		if(i>R)
		{
			L=R=i;
			while(R<n && str[R-L]==str[R])
				R++;
			Z[i]=R-L;
			R--;
		}
		else
		{
			k=i-L;
			if(Z[k]<R-i+1)
				Z[i]=Z[k];
			else
			{
				L = i; 
                while (R<n && str[R-L] == str[R]) 
                    R++; 
                Z[i] = R-L; 
                R--; 
			}
		}
	}
}

void search(string txt,string pat)
{
	string x=pat+"$"+txt;
	int l=x.length();
	int Z[l];
	getZarr(x,Z);
	for(int i=1;i<l;i++)
	{
		if(Z[i]==pat.length())
		{
			cout<<"Pattern found at "<<i-(pat.length()+1)<<endl;
		}
	}
}

int main()
{
	char txt[100],pat[50];
	cout<<"Enter text: ";
	cin>>txt;
	cin.ignore();
	cout<<"Enter pattern: ";
	cin>>pat;
	search(txt,pat);
	return 0;
}
