//    1.sort函数只支持线性随机访问迭代器支持 如vector,string,deque等容器   map(非线性)、list(双向链表迭代器)、set(链表红黑树)等并不支持
//    2.只有线性随机访问迭代器支持加减法,重载了+、+=等加减法运算符,其他只支持自增自减运算符
//    3.迭代器旨在支持随机访问或顺序访问,像堆栈和队列只允许在指定位置插入输出数据的数据结构,使用迭代器并没有意义,因此并没有迭代器,也就不支持sort函数
//    *4.函数体外只能进行全局函数和变量的声明，而无法执行语句或调用函数。
    // 例(对应tip4):
    // #include<iostream>     
    // int a;                                //声明全局变量
    // a=3;                                   //系统将报错,因为在函数外不能执行语句,也就不能赋值
    // int main(){

    // }


#include <bits/stdc++.h>
using namespace std;

int main(int argc, char const* argv[]) {
             //vector(动态数组)实例
    // int n = 0;
    // cin >> n;
    // vector<int> v(n);
    // for (int i = 0; i < n; i++) {
    //     cin >> v[i];
    // }
    // vector<int>::iterator p;
    // v.assign(v.begin(),v.end());            //assign() 的区间是[begin,end)左闭右开,参数是迭代器(存储数据的对象,重载了*)
    // for (int i = 0; i < n; i++) {
    //     cout << v[i] << " ";
    // }
    // cout << endl;
    // sort(v.begin(),v.end());
    // for(p=v.begin();p<=v.begin()+3;p++){
    //     cout<<*p<<" ";
    // }
    // cout<<endl;
    // return 0;
    //***************************************************************************************
    //***************************************************************************************
    //***************************************************************************************
             //map(映射集)实例
    // class comparerule{                                                     //自定义Compare  方法1 ：定义函数对象
    //     public:                                                            //实现功能:以长度进行存储与排序，字符串长度相同即视作key值相同          
    //     bool operator() (const string&s1,const string &s2)const {
    //         return s1.length()<s2.length();                            
    //     }
    // };
    // struct comparerule{                                                 //自定义Compare  方法2 ：struct 重载运算符            
    //     bool operator() (const string&s1,const string &s2)const {
    //         return s1.length()<s2.length();                            
    //     } 
    // };                                                       
    // map <string,float,comparerule> map1;              
    // map1.insert(make_pair("Cafe1",12.3));             //map 排序详解地址https://wenku.baidu.com/view/602a0a98d5bbfd0a7856734d.html
    // map1.insert(make_pair("Bafe22",4.3));
    // map1.insert(make_pair("Dafe333",5.3));
    // map<string,float>::iterator p_map;
    // for(p_map=map1.begin();p_map!=map1.end();p_map++){
    //     cout<<p_map->first<<" "<<p_map->second<<endl;
    // }
    // cout<<endl;
    // map <string ,float,less<string>> map2(map1.begin(),map1.end());       //greater按key降序排序,less按key降序排序,也可自定义比较法则(参数须为key)   
    //                                                                        //tips:由于map2与map1的排序准则不同，不同直接采用map2(map1)的构造方法!   
    // for(p_map=map2.begin();p_map!=map2.end();p_map++){
    //     cout<<p_map->first<<" "<<p_map->second<<endl;
    // }
    //***************************************************************************************
    //***************************************************************************************
    //***************************************************************************************
             //list(双向线性链表)实例
    // int n=5;
    // list <int> list1 (5,30);
    // list1.push_back(50);
    // list1.push_front(1010);
    // list<int> ::iterator p=list1.begin();
    // for(;p!=list1.end();p++){
    //     cout<<*p<<endl;
    // }
    // cout<<endl;
    // list1.sort(greater<int>());                                             //降序排序(默认为升序排序) tips: sort()函数要求使用随机迭代器,而list使用的是双向迭代器,因此无法使用sort函数,需要使用自身的成员函数sort()进行排序。   
    // for(p=list1.begin();p!=list1.end();p++){
    //     cout<<*p<<endl;
    // }
    //***************************************************************************************
    //***************************************************************************************
    //***************************************************************************************
             //set(链表实现平衡二叉树)实例
    // set<int,greater<int>> set1;
    // set1.insert(5);
    // set1.insert(3);
    // set1.insert(4);
    // set<int,less<int>> set2(set1.begin(),set1.end());
    // set<int>:: iterator  p_set=set2.begin();
    // set2.erase(3);                                                          //删除指定元素
    // p_set=set2.find(4);                                                     //返回元素4的位置,并删除
    // set2.erase(p_set);
    // for(p_set=set2.begin();p_set!=set2.end();p_set++)
    //     cout<<*p_set;
    //***************************************************************************************
    //***************************************************************************************
    //***************************************************************************************
             //queue(单向队列形式线性表)实例
    // queue<int>qu;
    // qu.push(3);
    // qu.push(1);
    // qu.push(2);
    // while(!qu.empty())
    // {
    //     cout<<qu.front()<<endl;
    //     qu.pop();
    // }
    //***************************************************************************************
    //***************************************************************************************
    //***************************************************************************************
    //          //priorty_queue(优先队列)实例
    // priority_queue<int,vector<int>,less<int>> pq1;                  //由于制定了比较方法,因此必须指定容器类型
    // pq1.push(3);
    // pq1.push(5);
    // pq1.push(8);
    // pq1.push(1);
    // pq1.push(13);
    // pq1.push(6);
    // cout<<pq1.top()<<endl;
    // pq1.pop();
    // cout<<pq1.top();
    // cout<<endl;
    // struct stu {
    //     int score=5;
    //     string name;
    //     bool operator <(const stu &a)const{                       //重载operator< 确定比较规则(priority_queue默认使用less<>比较,当使用greater<>时)，
    //         return score<a.score;                                 //应当重载 operator>
    //     }
        
    // };
    // priority_queue<stu,vector<stu>,less<stu>> q_stu;
    // stu stu1;
    // stu1.score=90;
    // stu1.name="Jack";
    // q_stu.push(stu1);
    // stu1.score=80;
    // stu1.name="Michael";
    // q_stu.push(stu1);
    // stu1.score=95;
    // stu1.name="Liu";
    // q_stu.push(stu1);
    // while(q_stu.empty()!=true){
    //     cout<<q_stu.top().name<<" "<<q_stu.top().score<<endl;
    //     q_stu.pop();
    // }    

    


}
