#include <bits/stdc++.h>
using namespace std;
int frogjump(int n) {
    if (n == 1)  //青蛙爬到1层只有一种跳法
        return 1;
    else if (n == 2)
        return 2;  //爬到2层有12 ，02 两种跳法
    else
        return frogjump(n - 1) +
               frogjump(n -
                        2);  //爬到n层数的方法数为 f(n-1)+f(n-2) 两种方法数相加
}
void frogjump2(int n, string a, int& q) {
    if (n == 0) {
        cout << a + '\n';
        q = q + 1;

    }

    else if (n == 1) {
        cout << a + '1' + '\n';
        q = q + 1;

    }

    else {
        char c = n + '0';
        string a2 = a + c;
        frogjump2(n - 1, a2, q);
        frogjump2(n - 2, a2, q);
    }
}
int main() {
    int q = 0;
    cin >> q;
    cout << frogjump(q);

    return 0;
}
