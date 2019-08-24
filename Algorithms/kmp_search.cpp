#include<iostream>
#include<string.h>
using namespace std;

void compute_lps_array(char *pat,int M,int *lps)
{
	int len=0;
	int i=1;
	lps[0]=0;
	while(i<M)
	{
		if(pat[i]==pat[len])
		{
			len++;
			lps[i]=len;
			i++;
		}
		else{
			if(len==0)
			{
				lps[i]=0;
				i++;
			}
			else
			{
				len=lps[len-1];
			}
		}
	}
}

void KMPSearch(char *pat,char *txt)
{
	int M=strlen(pat);
	int N=strlen(txt);
	int lps[M];
	compute_lps_array(pat,M,lps);
	int i=0;
	int j=0;
	while(i<N)
	{
		if(pat[j]==txt[i])
		{
			i++;
			j++;
		}
		if(j==M)
		{
			cout<<"Pattern Found at index: "<<i-j<<endl;
			j=lps[j-1];
		}
		else if(i<N && pat[j]!=txt[i])
		{
			if(j==0)
				i++;
			else
				j=lps[j-1];
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
	KMPSearch(pat,txt);
	return 0;
}
