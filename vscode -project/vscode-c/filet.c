#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
int main(){

char char1[20];

int int1[20];
FILE* fd = fopen("input.txt", "r+");
while(EOF!=fscanf(fd,"%d %c %d",int1,char1,int1+1)){
    printf("%d %c %d\n",int1[0],char1[0],int1[1]);
}
}