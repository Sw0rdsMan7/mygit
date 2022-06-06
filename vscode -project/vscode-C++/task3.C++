#include <bits/stdc++.h>
using namespace std;
int main() {
    int flag=0;
    for (int i = 1; i <= 5; i++) {
        for (int j = 1; j <= 5; j++) {
            for (int h = 1; h <= 5; h++) {
                if(i!=j && i!=h && j!=h){
                    printf("%d %d %d\n",i,j,h);
                    flag++;
                }
            }
        }
    }
    printf("There have %d ways to assign the books.",flag);
    return 0;
}
// assignBooks()
// flag <-- 0
// for i<-- 1 to 5
//     for j<--1 to 5
//         for h<-- 1 to 5
//             if i!=j and j!=h and i!=h
//                 输出i,j,h
//                 flag= flag+1
// end