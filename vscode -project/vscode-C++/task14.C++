#include <bits/stdc++.h>
using namespace std;
int main() {
    int n = 0;
    cin >> n;
    int max_flag = 0;
    string final = "";
    string maxstring = "";
    vector<string> v(n);
    for (int i = 0; i < n; i++)
        cin >> v[i];
    while (v.size() != 0) {
        maxstring = "";
        for (int i = 0; i < v.size(); i++) {
            if (v[i] > maxstring) {
                max_flag = i;
                maxstring = v[i];
            }
        }
        final += maxstring;
        v.erase(v.begin() + max_flag);
    }
    cout << final;
}