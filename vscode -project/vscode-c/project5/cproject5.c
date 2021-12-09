#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10
typedef struct Gnode* PtrToGnode;
struct Gnode {
    int Nv;
    int Ne;
    int G[MAXSIZE][MAXSIZE];
    int visit[MAXSIZE];
};
typedef PtrToGnode MGraph;
MGraph BuiltGraph(MGraph Graph, FILE* in) {
    int i, j, v1, v2, w;
    fscanf(in, "%d", &Graph->Nv);
    for (i = 0; i < Graph->Nv; i++) {
        for (j = 0; j < Graph->Nv; j++)
            Graph->G[i][j] = 0;  //规定0表示图结点间不存在边。
    }
    fscanf(in, "%d", &Graph->Ne);
    for (i = 0; i < Graph->Ne; i++) {
        fscanf(in, "%d %d %d", &v1, &v2, &w);
        Graph->G[v1][v2] = w;
    }
    return Graph;
}
void DFS(int m, MGraph Graph, FILE* out) {
    if (Graph->visit[m] == 0) {
        fprintf(out, "V%d ", m);
        Graph->visit[m] = 1;
    }
    for (int j = 0; j < Graph->Nv; j++) {
        if (Graph->G[m][j] != 0 && Graph->visit[j] != 1) {
            DFS(j, Graph, out);
        }
    }
}
typedef struct {
    int data[MAXSIZE];
    int front;
    int rear;
} Queue;
Queue* createQuene() {
    Queue* ptrl;
    ptrl = (Queue*)malloc(sizeof(Queue));
    ptrl->rear = 0;
    ptrl->front = 0;
    return ptrl;
}
void addq(Queue* ptrl, int T) {  //将树结点指针传入队列
    if ((ptrl->rear + 1) % MAXSIZE == ptrl->front) {
        printf("队列满");
        return;
    }
    ptrl->rear = (ptrl->rear + 1) % MAXSIZE;
    ptrl->data[ptrl->rear] = T;
}
int deleteq(Queue* ptrl) {
    if (ptrl->front == ptrl->rear) {
        printf("Quene is empty");
        return 0;
    } else {
        ptrl->front = (ptrl->front + 1) % MAXSIZE;
        return ptrl->data[ptrl->front];
    }
}
int isEmpty(Queue* ptrl) {
    if (ptrl->rear == ptrl->front)
        return 1;
    else
        return 0;
}
void BFS(int m, MGraph Graph, FILE* out) {
    Queue* Q = createQuene();
    if (Graph->visit[m] == 0) 
        Graph->visit[m] = 1;
    addq(Q, m);
    while (isEmpty(Q) == 0) {
        m = deleteq(Q);
        fprintf(out, "V%d ", m);
        for (int j = 0; j < Graph->Nv; j++) {
            if (Graph->G[m][j] != 0 && Graph->visit[j] != 1) {
                Graph->visit[j] = 1;
                addq(Q, j);
            }
        }
    }
}

int main() {
    FILE *in, *out;
    in = fopen("input5.txt", "r");
    out = fopen("output5.txt", "w");
    MGraph Graph = (MGraph)malloc(sizeof(struct Gnode));
    Graph = BuiltGraph(Graph, in);
    int m = 0;
    fscanf(in, "%d", &m);
    fprintf(out, "BFS from V%d: ", m);
    for (int i = 0; i < Graph->Nv; i++)
        Graph->visit[i] = 0;
    BFS(m, Graph, out);
    fprintf(out, "\n");
    fscanf(in, "%d", &m);
    fprintf(out, "DFS from V%d: ", m);
    for (int i = 0; i < Graph->Nv; i++)
        Graph->visit[i] = 0;
    DFS(m, Graph, out);
}