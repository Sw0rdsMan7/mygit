#include <stdio.h>
#include <stdlib.h>

struct HeapStruct;
typedef struct HeapStruct* Maxheap;
Maxheap Create(int MaxSize);
int isFull(Maxheap H);
void insert(Maxheap H, int item);
int DeleteMax(Maxheap H);
void Heap_sort(int A[], int N);
typedef int ElementType;
void Quick_Sort(ElementType A[], int N);
void Quicksort(ElementType A[], int Left, int Right);
ElementType Median3(ElementType A[], int Left, int Right);
void MSort(ElementType A[], ElementType TmpA[], int L, int RightEnd);
void Insertion_Sort(ElementType* a, ElementType end);
void Merge_sort(ElementType A[], int N);
void Merge(ElementType A[], ElementType TmpA[], int L, int R, int RightEnd);
void Swap(ElementType* a, ElementType* b);
void Swap(ElementType* a, ElementType* b) {
    ElementType swap1;
    swap1 = *a;
    *a = *b;
    *b = swap1;
}
void Insertion_Sort(ElementType A[], int N) {
    int i = 0;
    for (int P = 1; P < N; P++) {
        int Tmp = A[P];
        for (i = P; i > 0 && A[i - 1] > Tmp; i--)
            A[i] = A[i - 1];
        A[i] = Tmp;
    }
}
void Merge_sort(ElementType A[], int N) {
    ElementType* TmpA;
    TmpA = (int*)malloc(N * sizeof(ElementType));
    if (TmpA != NULL) {
        MSort(A, TmpA, 0, N - 1);
        free(TmpA);
    } else {
        printf("空间不足");
    };
}
void MSort(ElementType A[], ElementType TmpA[], int L, int RightEnd) {
    int Center;
    if (L < RightEnd) {
        Center = (L + RightEnd) / 2;
        MSort(A, TmpA, L, Center);
        MSort(A, TmpA, Center + 1, RightEnd);
        Merge(A, TmpA, L, Center + 1, RightEnd);
    }
}
void Merge(ElementType A[], ElementType TmpA[], int L, int R, int RightEnd) {
    int LeftEnd = R - 1;
    int Tmp = L;
    int NumElements = RightEnd - L + 1;
    while (L <= LeftEnd && R <= RightEnd) {
        if (A[L] <= A[R])
            TmpA[Tmp++] = A[L++];
        else
            TmpA[Tmp++] = A[R++];
    }
    while (L <= LeftEnd)
        TmpA[Tmp++] = A[L++];
    while (R <= RightEnd)
        TmpA[Tmp++] = A[R++];
    for (int i = 0; i < NumElements; i++, RightEnd--)
        A[RightEnd] = TmpA[RightEnd];
}
ElementType Median3(ElementType A[], int Left, int Right) {
    int Center = (Left + Right) / 2;
    if (A[Left] > A[Center])
        Swap(&A[Left], &A[Center]);
    if (A[Left] > A[Right])
        Swap(&A[Left], &A[Right]);
    if (A[Center] > A[Right])
        Swap(&A[Center], &A[Right]);
    Swap(&A[Center], &A[Right - 1]);
    return A[Right - 1];
}
void Quicksort(ElementType A[], int Left, int Right) {
    if (2 <= Right - Left) {
        int Pivot = Median3(A, Left, Right);
        int i = Left;
        int j = Right - 1;
        for (;;) {
            while (A[++i] < Pivot) {
            }
            while (A[--j] > Pivot) {
            }
            if (i < j)
                Swap(&A[i], &A[j]);
            else
                break;
        }
        Swap(&A[i], &A[Right - 1]);
        Quicksort(A, Left, i - 1);
        Quicksort(A, i + 1, Right);
    } else
        Insertion_Sort(A + Left, Right - Left + 1);
}
void Quick_Sort(ElementType A[], int N) {
    Quicksort(A, 0, N - 1);
}
struct HeapStruct {
    int* Elements;
    int Size;
    int Capacity;
};
Maxheap Create(int MaxSize) {
    Maxheap H = (Maxheap)malloc(sizeof(struct HeapStruct));
    H->Elements = (int*)malloc((MaxSize + 1) * sizeof(int));
    H->Size = 0;
    H->Capacity = MaxSize;
    H->Elements[0] = 32767;
    return H;
}
int isFull(Maxheap H) {
    if (H->Size == H->Capacity)
        return 1;
    else
        return 0;
}
void insert(Maxheap H, int item) {
    int i;
    if (isFull(H) == 1) {
        printf("最大堆已满");
        return;
    }
    i = ++H->Size;
    for (; H->Elements[i / 2] < item; i /= 2)
        H->Elements[i] = H->Elements[i / 2];
    H->Elements[i] = item;
}
int DeleteMax(Maxheap H) {
    int item = H->Elements[1];
    int item_index = 1;
    int bigger;
    int bigger_index;
    H->Elements[1] = H->Elements[H->Size--];
    for (; item_index <= H->Size / 2;) {
        if (item_index * 2 +1<= H->Size) {
            bigger =
                H->Elements[item_index * 2] > H->Elements[item_index * 2 + 1]
                    ? H->Elements[item_index * 2]
                    : H->Elements[item_index * 2 + 1];
            bigger_index =
                H->Elements[item_index * 2] > H->Elements[item_index * 2 + 1]
                    ? item_index * 2
                    : item_index * 2 + 1;

        } else {
            bigger = H->Elements[item_index * 2];
            bigger_index = item_index * 2;
        }

        if (H->Elements[item_index] > bigger)
            break;
        else{
            H->Elements[bigger_index] = H->Elements[item_index];
            H->Elements[item_index] = bigger;
            item_index = bigger_index;
        }
    }
    return item;
}
void Heap_sort(int A[], int N) {
    Maxheap heap = Create(N);
    for (int i = 0; i <= N - 1; i++) {
        insert(heap, A[i]);
    }
    for (int i = N - 1; i >= 0; i--) {
        A[i] = DeleteMax(heap);
    }
    free(heap);
}
int main() {
    FILE *in, *out;
    in=fopen("input6.txt","r");
    out=fopen("output6.txt","w");
    int A[100]={0};
    int N=0;
    fscanf(in, "%d", &N);
    int time=0;
    while (N != -1) {
        time++;
        fprintf(out,"Case %d:%d\n",time,N);
        for (int i=0;i<=N-1;i++){
            fscanf(in, "%d", &A[i]);
        }
        Heap_sort(A,N);
        for(int i=0;i<=N-1;i++){
            printf("%d ",A[i]);
            fprintf(out,"%d ",A[i]);
        }
        fprintf(out,"\n");
        fscanf(in, "%d", &N);
    }
    
    return 0;
}
