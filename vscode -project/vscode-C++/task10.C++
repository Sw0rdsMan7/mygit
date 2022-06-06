#include<bits/stdc++.h>
using namespace std;

int main(){
    int t,N,M;
    cin>>t;
    while(t--){
        cin>>N>>M;
        int a[N+1][M+1]={0};//空余0行0列，作为没有输入的0值列
        for(int j=0;j<=N;j++)
            a[0][j]=0;
        for(int i=0;i<=N;i++)
            a[i][0]=0;
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                cin>>a[i][j];
                a[i][j]=a[i-1][j]>a[i][j-1]?a[i-1][j]+a[i][j]:a[i][j-1]+a[i][j];//取左与右之前较大值最优路径
                
            }
        }
        
        cout<<a[N][M]<<endl;

    }
}