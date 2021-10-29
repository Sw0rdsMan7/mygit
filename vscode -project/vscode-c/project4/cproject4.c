#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10000
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
typedef struct node {
    char data;
    struct node* lchild;
    struct node* rchild;

} BiTree;
void CreateBiTree(BiTree* T) {
    char ch;
    BiTree* T;
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
        printf("%5d", T->data);
        T = T->rchild;
    }
}

int main() {
    return 0;
}