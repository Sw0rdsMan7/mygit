#include<bits/stdc++.h>
using namespace std;
//dp[i]:包含a[i]的最大下降子序列,对通过对dp[0]~dp[i-1]的遍历,求得dp[i]=max(dp[0],dp[i-1])+1;
int main(){
    int N;
    cin>>N;
    int a[N];
    int dp[N];
    int flag=0;
    for(int i=0;i<N;i++){
        cin>>a[i];
        dp[i]=0;
    }
    for(int i=0;i<N;i++){
        for(int j=i;j>=0;j--){
            if(a[i]<=a[j]){
                if(dp[j]+1>dp[i])
                    dp[i]=dp[j]+1;
            }
        }
    }
    int max=0;
    for(int i=0;i<N;i++){
        if(dp[i]>max)
            max=dp[i];
    }
    cout<<max<<endl;
}