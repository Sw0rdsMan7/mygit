#include <bits/stdc++.h>
using namespace std;
int a[100][100]={0};
void table(int size, int a[100][100]);
void table(int size, int a[100][100]) {
    int cur = 1;
    a[1][cur] = 1;
    while (cur < size) {
        cur*=2;
        for (int i = (1 + cur) / 2 + 1; i <= cur; i++) {  //填充右上
            for (int j = 1; j <= (1 + cur) / 2; j++) {
                a[i][j] = a[i - cur / 2][j] + cur / 2;  
            }
        }
        for (int i = 1; i <= (1 + cur) / 2; i++) {  //填充左下
            for (int j = (1 + cur) / 2 + 1; j <= cur; j++) {
                a[i][j] = a[i][j - cur / 2] + cur / 2;
            }
        }
        for (int i = (1 + cur) / 2+1; i <= cur; i++) {//填充右下
            for (int j = (1 + cur) / 2+1; j <= cur; j++) {
                a[i][j] = a[i - cur / 2][j - cur / 2];
            }
        }
    }
}
int main() {

    int size = 0;

    cin >> size;

    table( size, a);
    for (int i =1; i <= size; i++) {
        for (int j = 1; j <= size; j++) {
            printf("%d", a[i][j]);
            if (j == size)
                cout << endl;
        }
    }
    return 0;
}


