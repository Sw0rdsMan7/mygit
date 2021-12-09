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
        printf("Stack is full");
        return;
    } else {
        ptrl->data[++(ptrl->top)] = item;
    }
}
BiTree* ltPop(ltStack* ptrl) {
    int flag = 0;
    if (ptrl->top == -1 && flag != 1) {
        printf("Stack is empty");
        return NULL;
    } else {
        flag = 1;
        return ptrl->data[(ptrl->top)--];
    }
}
BiTree* CreateBiTree(BiTree* T) {
    BiTree* ptr;
    char ch;
    scanf("%c", &ch);
    getchar();
    if (ch == '#') {
        ptr = NULL;
        return ptr;
    } else {
        ptr = (BiTree*)malloc(sizeof(BiTree));
        ptr->data = ch;
        ptr->lchild = CreateBiTree(ptr->lchild);
        ptr->rchild = CreateBiTree(ptr->rchild);
        return ptr;
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
}
void InOrderTraverse(BiTree* T) {
    if (T == NULL)
        return;
    else {
        InOrderTraverse(T->lchild);
        printf("%c", T->data);
        InOrderTraverse(T->rchild);
    }
}
void PostOrderTraverse(BiTree* T) {
    if (T == NULL)
        return;
    else {
        PostOrderTraverse(T->lchild);
        PostOrderTraverse(T->rchild);
        printf("%c", T->data);
    }
}
void InOrderTraverse_2(BiTree* T) {  //非递归实现中序遍历二叉树
    ltStack* S = ltMakeEmpty();
    for (;;) {
        for (; T; T = T->lchild)
            ltPush(S, T);
        T = ltPop(S);
        if (!T)
            break;
        printf("%c", T->data);
        T = T->rchild;
    }
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
        printf("Quene is empty");
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
            printf("%c", T->data);
            if (T->lchild)
                addq(ptrl, T->lchild);
            if (T->rchild)
                addq(ptrl, T->rchild);
        } else
            break;
    }
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
        return (m > n) ? m + 1 : n + 1;
    }
}

int main() {
    Queue* ptrl;
    BiTree* ptr;
    ptrl = createQuene();
    ptr = CreateBiTree(ptr);
    printf("%d\n", LeafCount(ptr));
    printf("%d\n", Depth(ptr));
    PreOrderTraverse(ptr);
    printf("\n");
    InOrderTraverse(ptr);
    printf("\n");
    InOrderTraverse_2(ptr);
    printf("\n");
    PostOrderTraverse(ptr);
    printf("\n");
    levelOrderTraverse(ptrl, ptr);
    return 0;
}