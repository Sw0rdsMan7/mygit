
#include <algorithm>
#include <iostream>
#include <string>
using namespace std;

int make_length(string& num1, string& num2) {  //化为相同长度字符串
    int len1 = num1.length();
    int len2 = num2.length();
    if (len1 < len2) {
        for (int i = 0; i < len2 - len1; ++i) {
            num1 = "0" + num1;
        }
        return len2;
    } else {
        for (int i = 0; i < len1 - len2; ++i) {
            num2 = "0" + num2;
        }
        return len1;
    }
}
string Minus(string num1, string num2) {  //大数减法
    int len1 = num1.length();
    int len2 = num2.length();

    if (num1 == num2) {
        return "0";
    }
    bool flag = true;
    if (len1 < len2 ||
        (len1 == len2 &&
         num1 < num2)) {  //运算结果判断，若为负则交换两数，运算完毕后加上负号
        flag = false;

        string tmp = num1;
        num1 = num2;
        num2 = tmp;
        int temp = len1;
        len1 = len2;
        len2 = temp;
    }
    string result;
    int i = len1 - 1, j = len2 - 1;
    int a, b, sum, C = 0;
    while (i >= 0 || j >= 0) {
        if (i >= 0)
            a = num1[i] - '0';
        else
            a = 0;
        if (j >= 0)
            b = num2[j] - '0';
        else
            b = 0;
        sum = a - b - C;
        C = 0;

        if (sum < 0) {
            sum += 10;
            C = 1;
        }
        result.insert(result.begin(),sum + '0');  //添加为字符，所以使用迭代器进行添加
        --i;
        --j;
    }
    string::iterator it = result.begin();
    while (it != result.end() && *it == '0') {
        it++;
    }
    result.erase(result.begin(), it);  //消除因字符串减法带来的多余
    if (flag == true) {
        return result;
    } else
        return "-" + result;
}
string Add(string num1, string num2) {  //大数加法
    int len1 = num1.length();
    int len2 = num2.length();
    if (len1 <= 0) {
        return num2;
    }
    if (len2 <= 0) {
        return num1;
    }
    string result;
    int i = len1 - 1, j = len2 - 1;
    int a, b, sum, C = 0;
    while (i >= 0 || j >= 0 || C > 0) {
        if (i >= 0)
            a = num1[i] - '0';
        else
            a = 0;
        if (j >= 0)
            b = num2[j] - '0';
        else
            b = 0;
        sum = a + b + C;
        C = sum / 10;
        result.insert(result.begin(),sum % 10 + '0');  //数字转字符并添加在字符串前
        --i;
        --j;
    }
    return result;
}
string AddZero(string num, int len) {  //补零
    if (num == "0") {
        return num;
    }
    for (int i = 0; i < len; i++) {
        num += "0";
    }
    return num;
}
string Multiply(string num1, string num2) {
    int len = make_length(num1, num2);
    if (len == 0) {
        return 0;
    }
    if (len == 1) {
        return to_string((num1[0] - '0') * (num2[0] - '0'));
    }
    int mid = len / 2;
    string x1 = num1.substr(0, mid);  //拆分大数
    string x0 = num1.substr(mid, len - mid);
    string y1 = num2.substr(0, mid);
    string y0 = num2.substr(mid, len - mid);
    string z0 = Multiply(x0, y0);  //递归运算
    string z1 = Multiply(Add(x1, x0), Add(y1, y0));
    string z2 = Multiply(x1, y1);
    string r1 = AddZero(z2, 2 * (len - mid));  //相当于乘10^2m
    string r2 = AddZero(Minus(Minus(z1, z2), z0), len - mid);
    return Add(Add(r1, r2), z0);
}
int main() {
    string num1 = "123";
    string num2 = "123";
    cin>>num1;
    cin>>num2;
    string result = Multiply(num1, num2);
    cout << result << endl;
    return 0;
}