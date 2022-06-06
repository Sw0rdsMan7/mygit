#include<bits/stdc++.h>
using namespace std;
stack<int> s; ///用来保存逆序
int graph[100][100]={0}; ///邻接矩阵存储，节点从0开始
int in[100]={0};
int visited[100]={0};
int n; ///节点个数
int e; ///用来存边的条数
queue<int>qu;

//dfs 实现


// void dfs(int v){
//     visited[v] = 1;
//     for(int i=0;i<n;i++){
//         if(graph[v][i]==1&&visited[i]==0){
//             dfs(i);
//             if(visited[i]==1)
//                 s.push(i);
//         }
//     }
// }

// void solve(){
//     ///初始化
//     scanf("%d",&n);
//     scanf("%d",&e);
//     for(int i=0;i<e;i++){
//         int v1,v2;
//         scanf("%d%d",&v1,&v2);
//         graph[v1][v2]=1;
//     }
//     //dfs过程
//     for(int i=0;i<n;i++){
//         if(visited[i]==0){
//             dfs(i);
//             if(visited[i]==1)
//                 s.push(i);
//         }
//     }
   

//     ///输出入
//     while(!s.empty()){
//         printf("%d ",s.top());
//         s.pop();
//     }
// }


//入度法实现
void solve(){
    //初始化
    scanf("%d",&n);
    scanf("%d",&e);
    for(int i=0;i<e;i++){
        int v1,v2;
        scanf("%d%d",&v1,&v2);
        graph[v1][v2]=1;
        in[v2]++;
    }
    for(int i=0;i<n;i++){
        if(in[i]==0)
            qu.push(i);
    }
    while(!qu.empty()){
        int t=qu.front();
        qu.pop();
        printf("%d ",t);
        for(int i =0;i<n;i++)
        {
            if(graph[t][i]!=0)
             {
                 in[i]--;
                 if(in[i]==0)
                    qu.push(i);
             }   
        }
    }

}


int main() {
    solve();
    return 0;
}
/*
7
11
1 0
2 1
2 5
3 2
3 4
3 5
4 0
4 6
5 0
5 1
5 4
*/
// solve(){
//     初始化链接表
//     for i<-0 to e //遍历图的每一条边
//         a<- 始点
//         b<- 终点
//         graph[a][b] <- 1
//         in[b] =in[b]+1 //入度+1
//     for i<-0 to n 遍历每个点,找出入度为0的点作为入口起点
//         if in[i]=0
//             qu.push(i)   加入队列
//     while !qu.empty      //队列不为空时
//         t <-qu.frout    //将队列头传给t
//         qu.pop          //出队列
//         for i<-0 to n       //遍历t点的每一条边,对终点减去1入度
//             if graph[t][i] 
//                 in[i]--
//                 if in[i]=0
//                     qu.push(i)   //入度为0入队列
// }