#include<bits/stdc++.h>
using namespace std;
void solveLCS(string str1,string str2);
int main(){

char str1[100],str2[100];
scanf("%s %s",str1,str2);
string sstr1(str1),sstr2(str2);
solveLCS(sstr1,sstr2);

return 0;
}
void solveLCS(string str1,string str2){
    string lcs_str[str1.size()+1][str2.size()+1];
    int lcs[str1.size()+1][str2.size()+1]={0};
    for(int i=1;i<=str1.size();i++){
        for(int j=1;j<=str2.size();j++){
            if(str1[i-1]==str2[j-1]){
                lcs[i][j]=lcs[i-1][j-1]+1;
                lcs_str[i][j]=lcs_str[i-1][j-1];
                lcs_str[i][j]+=str1[i-1];
            }
                
            else{
                lcs[i][j]=max(lcs[i-1][j],lcs[i][j-1]);
                lcs_str[i][j]=lcs_str[i-1][j].size()>lcs_str[i][j-1].size()?lcs_str[i-1][j]:lcs_str[i][j-1];
            }
        }
    }
    cout<<"The length of lcs is "<<lcs[str1.size()][str2.size()]<<endl;
    cout<<"Lcs is "<<lcs_str[str1.size()][str2.size()];
    
}