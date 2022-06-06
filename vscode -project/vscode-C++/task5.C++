#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    vector<int> ve1(n);
    vector<int> ::iterator p;
    p=ve1.begin();
    for(int i=0;i<=n-1;i++){
        ve1[i]=i+1;
    }
    int flag=0;
    int i=-1;
    cin>>flag;
    while(1)
    {
        if(ve1.empty())
            break;
        
        i=(i+flag)%n;
        cout<<ve1[i];
        ve1.erase(ve1.begin()+i);
        i=i-1;
        n=n-1;
        
            }
}