#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10000
typedef struct node {
    char data;
    struct node* lchild;
    struct node* rchild;
} BiTree;
typedef struct {
    BiTree* data[MAXSIZE];
    int top;
} ltStack;
ltStack* ltMakeEmpty() {
    ltStack* ptrl;
    ptrl = (ltStack*)malloc(sizeof(ltStack));
    ptrl->top = -1;
    return ptrl;
}
int ltFull(ltStack* ptrl) {
    if (ptrl->top == MAXSIZE - 1)
        return 1;
    else
        return 0;
}
void ltPush(ltStack* ptrl, BiTree* item) {
    if (ltFull(ptrl)) {
        printf("堆栈满");
        return;
    } else {
        ptrl->data[++(ptrl->top)] = item;
    }
}
BiTree* ltPop(ltStack* ptrl) {
    if (ptrl->top == -1) {
        printf("堆栈空");
        return NULL;
    } else {
        return ptrl->data[(ptrl->top)--];
    }
}

void CreateBiTree(BiTree* T) {
    char ch;
    scanf("%c", &ch);
    if (ch == '#')
        T = NULL;
    else {
        T = (BiTree*)malloc(sizeof(BiTree));
        T->data = ch;
        CreateBiTree(T->lchild);
        CreateBiTree(T->rchild);
    }
}
void PreOrderTraverse(BiTree* T) {
    if (T == NULL)
        return;
    else {
        printf("%c", T->data);
        PreOrderTraverse(T->lchild);
        PreOrderTraverse(T->rchild);
    }
    printf("\n");
}
void InOrderTraverse(BiTree* T) {
    if (T == NULL)
        return;
    else {
        InOrderTraverse(T->lchild);
        printf("%c", T->data);
        InOrderTraverse(T->rchild);
    }
    printf("\n");
}
void PostOrderTraverse(BiTree* T) {
    if (T == NULL)
        return;
    else {
        PostOrderTraverse(T->lchild);
        PostOrderTraverse(T->rchild);
        printf("%c", T->data);
    }
    printf("\n");
}
void InOrderTraverse_2(BiTree* T) {  //非递归实现中序遍历二叉树
    ltStack* S = ltMakeEmpty();
    for (;;) {
        for (; T; T = T->lchild)
            ltPush(S, T);
        T = ltPop(S);
        if (!T)
            break;
        printf("%5d", T->data);
        T = T->rchild;
    }
    printf("\n");
}
typedef struct {
    BiTree* data[MAXSIZE];
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
void addq(Queue* ptrl, BiTree* T) {  //将树结点指针传入队列
    if ((ptrl->rear + 1) % MAXSIZE == ptrl->front) {
        printf("队列满");
        return;
    }
    ptrl->rear = (ptrl->rear + 1) % MAXSIZE;
    ptrl->data[ptrl->rear] = T;
}
BiTree* deleteq(Queue* ptrl) {
    if (ptrl->front == ptrl->rear) {
        printf("队列空");
        return NULL;
    } else {
        ptrl->front = (ptrl->front + 1) % MAXSIZE;
        return ptrl->data[ptrl->front];
    }
}
void levelOrderTraverse(Queue* ptrl, BiTree* T) {
    if (!T)
        return;
    addq(ptrl, T);
    for (;;) {
        T = deleteq(ptrl);
        if (T) {
            printf("%d", T->data);
            if (T->lchild)
                addq(ptrl, T->lchild);
            if (T->rchild)
                addq(ptrl, T->rchild);
        } else
            break;
    }
    printf("\n");
}
int LeafCount(BiTree* T) {
    if (T == NULL)
        return 0;
    if (T->lchild == NULL && T->rchild == NULL)
        return 1;
    else
        return LeafCount(T->lchild) + LeafCount(T->rchild);
}
int Depth(BiTree* T) {
    if (T == NULL)
        return 0;
    else {
        int m = 0;
        int n = 0;
        m = Depth(T->lchild);
        n = Depth(T->rchild);
        return m > n ? m + 1 : n + 1;
    }
}
int main() {
    Queue* ptrl = createQuene();
    ltStack* S = ltMakeEmpty();
    BiTree* ptr = NULL;
    CreateBiTree(ptr);
    printf("%d\n", LeafCount(ptr));
    printf("%d\n", Depth(ptr));
    PreOrderTraverse(ptr);
    InOrderTraverse(ptr);
    InOrderTraverse_2(ptr);
    PostOrderTraverse(ptr);
    levelOrderTraverse(ptrl, ptr);

    return 0;
}