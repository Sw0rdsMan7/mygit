#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxlength=0;
        string a="";
        string ::iterator p=s.begin();
        for ( p;p!=s.end();p++){
            for(string::iterator p2=p;p2!=s.end();p2++){
                if(a.find(*p2)==a.npos){
                    a.push_back(*p2);
                    if(a.size()>maxlength)
                        maxlength=a.size();
                }
                else{
                    a="";
                    break;
                }
            }
        }
        return maxlength;
        
    }
};
int main(int argc, char const* argv[]){
    Solution a;
    cout<<a.lengthOfLongestSubstring(" ");
    string s="";
    string s2=" ";
    string::iterator p=s2.begin();
    cout<<*s2.begin();
    cout<<(s.find(' ')==s.npos);
    
    return 0;
}