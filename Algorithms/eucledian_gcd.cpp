#include <iostream> 
using namespace std; 
  
int gcd(int a, int b) 
{ 
    if (a == 0) 
        return b; 
    return gcd(b % a, a); 
} 
  

int main() 
{ 
    int a,b;
    cout<<"Enter a and b: ";
	cin>>a>>b; 
    cout << "GCD(" << a << ", " << b << ") = " << gcd(a, b) << endl; 
    return 0; 
} 
