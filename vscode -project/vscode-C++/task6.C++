#include<bits/stdc++.h>
using namespace std;
void function1(int * a,int b){
    vector <int> v1;
    while(b!=0){
        v1.push_back(b%2);
        b=b/2;
        
    }
    for(int i=0;i<v1.size();i++){
        a[i]+=v1[i];
    }
    
}
int main(){
    int n=0;
    int a[15]={0};//存储位信息
    cin>>n;
    vector<int> v1(n);   //存储堆信息
    for (int i=0;i<n;i++)
        cin>>v1[i];

    sort(v1.begin(),v1.end());

    //将堆内数转化位二进制并存入a数组
    for (int i=0;i<n;i++)
        function1(a,v1[i]);


    int flag=0;
    for(int i=0;i<15;i++){
        if(a[i]%2==1)   //异或和不为0,flag为1,先手必胜
            flag=1;
        }
    if(flag==1)
        cout<<"冰墩墩 win";
    else
        cout<<"雪融融 win";
    




    return 0;
}