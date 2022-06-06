#include<bits/stdc++.h>
using namespace std;
int integer[20];
int intArray[20];
int arrayNow;
int main(){
    for(int i=0;i<20;i++){
        integer[i]=rand()%20;
        if(integer[i]%2==0)
            integer[i]=integer[i]*-1;
    }
    int arrayNow=0;//记录当前数组的下标号
    int array_num=0; //记录整数数组号
    int array_flag=1;//当前数组的整数正负值(以正负区分整数,将整数数组转化为子数组和数组)
    for(int i=0;i<20;i++){
        if(integer[i]/array_flag>0)
            arrayNow+=integer[i];
        else if(integer[i]/array_flag==0)   
            continue;
        else{
            intArray[array_num]=arrayNow;
            array_num++;
            arrayNow=integer[i];
            array_flag*=-1;
        }
    }
    return 0;
}