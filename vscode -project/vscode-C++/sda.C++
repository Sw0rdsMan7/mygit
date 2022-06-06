#include <bits/stdc++.h>

using namespace std;

void Gauss(int N) {
    double x[N];
    for (int i = 0; i < N; i++) {
        x[N] = 0;
    }
    double a[N][N + 1];
    for (int i = 0; i <= N - 1; i++) {
        for (int j = 0; j <= N; j++) {
            cin >> a[i][j];
        }
    }
    int row, col = 0; //当前处理的行列

    for (; row < N && col < N; row++, col++) {
        int maxrow = row; //当前处理列最大的绝对值最大数的行值
        for (int i = row; i < N; i++) { //寻找当前列绝对值最大的数的行号,并与row交换(换到最上行)
            if (fabs(a[i][col]) > fabs(a[maxrow][col]))
                maxrow = i;
        }
        for (int j = col; j < N + 1; j++) {
            double temp = a[maxrow][j];
            a[maxrow][j] = a[row][j];
            a[row][j] = temp;
        }
//        for (int j = 0; j <= N; j++) {
//            printf("%d %d %f, ", row, j, a[row][j]);
//        }
//        cout << endl;
        if (fabs(a[row][col]) < 1e-6) //当前行列值全为0，为自由变元
        {
            row--;
            printf("no result");
            return;
        }
        for (int i = row + 1; i < N; i++) {
            double temp = a[i][col] / a[row][col];
            for (int j = col; j < N + 1; j++) {
                a[i][j] -= temp * a[row][j];
            }
        }
    }
    for (int i = 0; i < N; i++) {
        if (fabs(a[i][i]) < 1e-6) {
            printf("no result");
            return;
        }
    }

    for (int i = N - 1; i >= 0; i--) {
        double temp = a[i][N];
        for (int j = i + 1; j < N;
             j++) {
            temp -= a[i][j] * x[j];
        }
        x[i] = temp / a[i][i];
    }
    for (int i = 0; i < N; i++) {
        printf("x%d = %f\n", i, x[i]);
    }

}

int main() {
    int N = 0;
    cin >> N;
    Gauss(N);

    return 0;
}