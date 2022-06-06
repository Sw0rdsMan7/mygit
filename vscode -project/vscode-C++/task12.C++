#include<bits/stdc++.h>
using namespace std;
int solve(int N){
    int len[N+1];
    int pro[N+1];
    int totpro=0;
    int a[N+1][N+1];
    for(int i=1;i<=N;i++){
        cin>>len[i];
        cin>>pro[i];
    }
    for(int i=0;i<=N;i++){
        for(int j=0;j<=N;j++){
            a[i][j]=0;
        }
    }
    for(int i=1;i<=N;i++){
        for(int j=1;j<=N;j++){
            if(j>=len[i]){
                a[i][j]=a[i-1][j-len[i]]+pro[i];
                if(a[i][j]<a[i-1][j])
                    a[i][j]=a[i-1][j];
            }
            else{
                a[i][j]=a[i-1][j];

            }
        }
    }
    return a[N][N];
}
int main(){
    int N=0;
    int totlen=0;
    cin>>N;
    int totpro=solve(N);
    printf("Max profit=%d\n",totpro);
    
    return 0;
}
//  10
// 1 1
// 2 5
// 3 8
// 4 9
// 5 10
// 6 17
// 7 17
// 8 20
// 9 24
// 10 30
//  Max profit=30