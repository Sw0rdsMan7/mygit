#include <stdio.h>
#include <stdlib.h>
typedef struct HeapStruct *Maxheap;
struct HeapStruct
{
    int* Elements;
    int Size;
    int Capacity;
};
Maxheap Create(int MaxSize ){
    Maxheap H=malloc(sizeof( struct HeapStruct));
    H->Elements=malloc((MaxSize+1)*sizeof(int));
    H->Size=0;
    H->Capacity=MaxSize;
    H->Elements[0]=32767;
    return H;

}
int isFull(Maxheap H){
    if(H->Size==H->Capacity)
        return 1;
    else
        return 0;

}
void insert(Maxheap H,int item){
    int i;
    if(isFull(H)==1){
        printf("最大堆已满");
        return ;
    }
    i=++H->Size;
    for(;H->Elements[i/2]<item;i/=2)
        H->Elements[i]=H->Elements[i/2];
    H->Elements[i]=item;
}
int DeleteMax(Maxheap H){
    int item=H->Elements[1];
    int item_index=1;
    int bigger;
    int bigger_index;
    H->Elements[1]=H->Elements[H->Size+1];
    for(;item_index<=H->Size/2;item_index*=2){
        bigger=H->Elements[item_index*2]>H->Elements[item_index*2+1]?H->Elements[item_index*2]:H->Elements[item_index*2+1];
        bigger_index=H->Elements[item_index*2]>H->Elements[item_index*2+1]?item_index*2:item_index*2+1;
        if(H->Elements[item_index]>bigger)
            break;
        else
            H->Elements[bigger_index]=H->Elements[item_index];
            H->Elements=bigger;
    }
    return item;
}
void Heap_sort(int A[],int N){

}
int main(){

    return 0;
}