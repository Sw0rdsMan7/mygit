#include <stdlib.h>
#include <iostream>
using namespace std;

int counter = 0;
/***************** Parameter Setting *****************/
int const InsideCount = 3;  // frames
int Inside[InsideCount];
int const PageCount = 20;  //锟杰碉拷页锟斤拷锟斤拷
int Page[PageCount] = {1, 2, 3, 4, 2, 1, 5, 6, 2, 1,
                       2, 3, 7, 6, 3, 2, 1, 2, 3, 6};

int insert = 0;  //锟斤拷used in FIFO
double lost = 0.0;

bool isInside(int num)  // check whether the page is in memory or not
{
    for (int i = 0; i < InsideCount; i++) {
        if (Inside[i] == Page[num]) {
            return true;
        }
    }
    return false;
}

void LRU(int num) {
    int max =
        0;  //锟斤拷示锟节达拷锟叫碉拷页锟脚ｏ拷锟斤拷一锟轿筹拷锟街的撅拷锟斤拷
    int maxchange;  //锟斤拷示锟节达拷锟斤拷锟铰次筹拷锟街撅拷锟斤拷锟斤拷锟斤拷页锟斤拷锟斤拷锟节达拷锟叫碉拷位锟斤拷
    int k;
    if (isInside(num)) {
        cout << "It is already in memory!" << endl;
        for (int i = 0; i < InsideCount; i++)
            cout << "Inside[" << i << "]:" << Inside[i] << endl;
    } else if (counter == InsideCount) {
        lost++;
        for (int j = 0; j < InsideCount; j++) {
            k = 0;
            //锟接碉拷前锟斤拷页锟斤拷锟斤拷前锟斤拷锟斤拷锟斤拷锟斤拷页锟斤拷锟斤拷锟节达拷锟叫碉拷页锟斤拷锟斤拷同锟斤拷break
            //锟斤拷锟饺斤拷锟节达拷锟斤拷锟斤拷锟斤拷页锟脚ｏ拷锟斤拷锟斤拷一锟斤拷锟竭碉拷远锟斤拷锟斤拷max锟斤拷录
            //*****************************锟斤拷锟斤拷锟斤补锟斤拷锟姐法*****************************************
            for (int i = num - 1; i >= 0; i--) {
                if (Inside[j] != Page[i])
                    k++;

                else {
                    if (k > max) {
                        max = k;
                        maxchange = j;
                    }
                    break;
                }
            }
        }
        Inside[maxchange] = Page[num];
        for (int i = 0; i < InsideCount; i++)
            cout << "Inside[" << i << "]:" << Inside[i] << endl;
    } else {
        lost++;
        Inside[counter] = Page[num];
        counter++;

        for (int i = 0; i < InsideCount; i++)
            cout << "Inside[" << i << "]:" << Inside[i] << endl;
    }
}

void FIFO(int num) {
    if (isInside(num)) {
        cout << "It is already in memory!" << endl;
        for (int i = 0; i < InsideCount; i++)
            cout << "Inside[" << i << "]:" << Inside[i] << endl;
    } else if (counter == InsideCount) {
        lost++;
        //*****************************锟斤拷锟斤拷锟斤补锟斤拷锟姐法*****************************************
        Inside[insert] = Page[num];
        insert = (insert + 1) % 3;
        for (int i = 0; i < InsideCount; i++)
            cout << "Inside[" << i << "]:" << Inside[i] << endl;
    } else {
        lost++;
        Inside[counter] = Page[num];
        counter++;
        for (int i = 0; i < InsideCount; i++)
            cout << "Inside[" << i << "]:" << Inside[i] << endl;
    }
}

void MIN(int num) {
    int max =
        0;  // 锟斤拷示锟节达拷锟叫碉拷页锟脚ｏ拷锟斤拷一锟轿筹拷锟街的撅拷锟斤拷
    int maxchange;  //锟斤拷示锟节达拷锟斤拷锟铰次筹拷锟街撅拷锟斤拷锟斤拷锟斤拷页锟斤拷锟斤拷锟节达拷锟叫碉拷位锟斤拷
    int k;
    int i=0;
    if (isInside(num)) {
        cout << "It is already in memory!" << endl;
        for (int i = 0; i < InsideCount; i++)
            cout << "Inside[" << i << "]:" << Inside[i] << endl;
    } else if (counter == InsideCount) {
        lost++;
        for (int j = 0; j < InsideCount; j++) {
            //*****************************锟斤拷锟斤拷锟斤补锟斤拷锟姐法*****************************************
            k = 0;
            //锟接碉拷前锟斤拷页锟斤拷锟斤拷前锟斤拷锟斤拷锟斤拷锟斤拷页锟斤拷锟斤拷锟节达拷锟叫碉拷页锟斤拷锟斤拷同锟斤拷break
            //锟斤拷锟饺斤拷锟节达拷锟斤拷锟斤拷锟斤拷页锟脚ｏ拷锟斤拷锟斤拷一锟斤拷锟竭碉拷远锟斤拷锟斤拷max锟斤拷录
            //*****************************锟斤拷锟斤拷锟斤补锟斤拷锟姐法*****************************************
            for (i = num + 1; i < PageCount; i++) {
                if (Inside[j] != Page[i])
                    k++;

                else {
                    if (k > max) {
                        max = k;
                        maxchange = j;
                    }
                    break;
                }
            }
             if(i==PageCount)
                if (k > max) {
                        max = k;
                        maxchange = j;
                    }
        }
       
        Inside[maxchange] = Page[num];
        for (int i = 0; i < InsideCount; i++)
            cout << "Inside[" << i << "]:" << Inside[i] << endl;
    } else {
        lost++;
        Inside[counter] = Page[num];
        counter++;
        for (int i = 0; i < InsideCount; i++)
            cout << "Inside[" << i << "]:" << Inside[i] << endl;
    }
}

int main() {
    char ch;
    while (1) {
        cout << "M: MIN"
             << "\n"
             << endl;
        cout << "F: FIFO"
             << "\n"
             << endl;
        cout << "L: LRU"
             << "\n"
             << endl;
        cin >> ch;
        switch (ch) {
            case 'M': {
                lost = 0;
                counter = 0;
                for (int j = 0; j < InsideCount; j++) {
                    Inside[j] = 0;
                }
                for (int i = 0; i < PageCount; i++) {
                    cout << "Accessing Page[" << i << "]=" << Page[i] << endl;
                    MIN(i);
                }
                cout << "Accessing " << PageCount << " pages, "
                     << "page faults " << lost << " times, page-fault rate is "
                     << lost / (PageCount) << "\n\n"
                     << endl;
            } break;
            case 'F': {
                insert = 0;  //对于
                lost = 0;
                counter = 0;
                for (int j = 0; j < InsideCount; j++) {
                    Inside[j] = 0;
                }
                for (int i = 0; i < PageCount; i++) {
                    cout << "Accessing Page[" << i << "]=" << Page[i] << endl;
                    FIFO(i);
                }
                cout << "Accessing " << PageCount << " pages, "
                     << "page faults " << lost << " times, page-fault rate is "
                     << lost / (PageCount) << "\n\n"
                     << endl;
            } break;
            case 'L': {
                lost = 0;
                counter = 0;
                for (int j = 0; j < InsideCount; j++) {
                    Inside[j] = 0;
                }
                for (int i = 0; i < PageCount; i++) {
                    cout << "Accessing Page[" << i << "]=" << Page[i] << endl;
                    LRU(i);
                }
                cout << "Accessing " << PageCount << " pages, "
                     << "page faults " << lost << " times, page-fault rate is "
                     << lost / (PageCount) << "\n\n"
                     << endl;
            } break;
        }
    }
    return 0;
}
