#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10000
typedef struct
{
	int date[MAXSIZE];
	int last;
} list;
list L, *ptrl;
list *MakeEmpty(void)
{
	list *ptrl;
	ptrl = (list *)malloc(sizeof(list));
	ptrl->last = -1;
	return ptrl;
}
void insert(int x, int i, list *ptrl)
{
	if (ptrl->last == MAXSIZE - 1)
	{
		printf("表已满");
		return;
	}
	if (i > ptrl->last + 1 || i < 1)
	{
		printf("位置不合法");
		return;
	}
	for (int j = ptrl->last; j > i - 1; j++)
	{
		ptrl->date[j + 1] = ptrl->date[j];
	}
	ptrl->date[i] = x;
	ptrl->last++;
	return;
}
void delect(int i, list *ptrl)
{
	if (i > ptrl->last || i < 1)
	{
		printf("位置不合法");
		return;
	}
	for (int j = i; i <= ptrl->last - 1; j++)
	{
		ptrl->date[j] = ptrl->date[j + 1];
	}
	ptrl->last--;
	return;
}
int find(int x, list *ptrl)
{
	int i;
	for (i = 0; i <= ptrl->last; i++)
	{
		if (ptrl->date[i] == x)
			return i;
	}
	if (i == ptrl->last + 1)
	{
		printf("未找到数据");
		return -1;
	}
}
int length(list *ptrl)
{
	return ptrl->last + 1;
}
typedef struct node
{
	int x;
	struct node *next;
} link;
link LK1, *head;
link *lkMakeEmpty(void)
{
	link *head = (link *)malloc(sizeof(link));
	return head;
}
int lkLength(link *head)
{
	link *p = head;
	int j = 0;
	while (p)
	{
		p = p->next;
		j++;
	}
	return j;
}
link *lkFindKth(int k, link *head)
{
	link *p = head;
	int i = 1;
	while (p != NULL && i < k)
	{
		p = p->next;
		i++;
	}
	if (i == k)
		return p;
	else
		return NULL;
}
link *lkFind(int k, link *head)
{
	link *p = head;
	while (p != NULL && k != p->x)
	{
		p = p->next;
	}
	return p;
}
link *insert(int k, int i, link *head)
{
	link *p, *s;
	if (i == 1)
	{
		s=(link*)malloc(sizeof(link));
		s->x=k;
		s->next=head;
		return s;
	}
	p=lkFindKth(i-1,head);
	if(p==NULL)
	{
		printf("参数i出错");
		return NULL;
	}
	else
	{
		s=(link*)malloc(sizeof(link));
		s->x=k;
		s->next=p->next;
		p->next=s;
		return head;
	}
}
link *delect(int  i,link*head)
{
	link *p,*s;
	if(i==1)
	{
		s=head;
		if(head!=NULL)
		head=head->next;
		else
		return NULL;
		free(s);
		return head;
	}
	p=lkFindKth(i-1,head);
	if(p==NULL)
	{
		printf("第%d个结点不存在",i-1);
		return NULL;
	}
	else if(p->next==NULL)
	{
		printf("第%d个结点不存在",i);
	}
	else
	{
		s=p->next;
		p->next=s->next;
		free(s);
		return head;
	}
}
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[])
{

	return 0;
}
