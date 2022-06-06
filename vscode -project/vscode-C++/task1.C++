#include<bits/stdc++.h>
using namespace std;
int gcd1(int m,int n){
    if (n!=0)
        return gcd1(n,m%n);
    else
        return m;
}
int gcd2(int m,int n){
    int p=n;
    if(p==0)
        return 0;
    while(1){
        if(m%p==0){
            if(n%p==0)
                return p;
            else
                p--;
        }
        else
            p--;
    }
    
}
int main(int argc, char const* argv[]){
    int a,b=0;
    cin>>a;
    cin>>b;
    int little=0;
    if(a<b)
        {
            little=a;
            a=b;
            b=little;
        }
    cout<<gcd1(a,b)<<endl;
    if(gcd2(a,b)==0)
        cout<<"Out of range";
    else
        cout<<gcd2(a,b);
    


    return 0;
}

// gcd1(m,n){
//     if n≠0
//         return gcd1(n,m mod n);
//     else
//         return m;
// }

// gcd2(m,n)
//     p<-n
//     if p=0           //除数为0，不符合该算法输入的值域
//         输出错误提示
//     while 1=1 do 
//         if m%p=0
//             if n%p=0
//                 return p
//             else
//                 p<-p-1
        
//         else
//             p<-p-1
    
    
