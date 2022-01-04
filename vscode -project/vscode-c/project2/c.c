#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10000
typedef struct
{
	int date[MAXSIZE];
	int last;
} list;
list *MakeEmpty(void)
{
	list *ptrl;
	ptrl = (list *)malloc(sizeof(list));
	ptrl->last = 0;
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
link *lkMakeEmpty(void)
{
	link *head = (link *)malloc(sizeof(link));
	head->next=NULL; //head的next在没有定义时不指向NULL
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
link *lkinsert(int k, int i, link *head)
{
	link *p, *s;
	if (i == 1)
	{
		s = (link *)malloc(sizeof(link));
		s->x = k;
		s->next = head;
		return s;
	}
	p = lkFindKth(i - 1, head);
	if (p == NULL)
	{
		printf("参数i出错");
		return NULL;
	}
	else
	{
		s = (link *)malloc(sizeof(link));
		s->x = k;
		s->next = p->next;
		p->next = s;
		return head;
	}
}
link *lkdelect(int i, link *head)
{
	link *p, *s;
	if (i == 1)
	{
		s = head;
		if (head != NULL)
			head = head->next;
		else
			return NULL;
		free(s);
		return head;
	}
	p = lkFindKth(i - 1, head);
	if (p == NULL)
	{
		printf("第%d个结点不存在", i - 1);
		return NULL;
	}
	else if (p->next == NULL)
	{
		printf("第%d个结点不存在", i);
	}
	else
	{
		s = p->next;
		p->next = s->next;
		free(s);
		return head;
	}
}
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[])
{
	list lt, *lthead;
	lthead = MakeEmpty();
	link * lkhead = lkMakeEmpty();
	int n = 0, x = 0, j = 0; //j用来标记数组长度
	FILE *in, *out;
	in = fopen("input.txt", "r");
	out = fopen("output.txt", "w");
	int flag1=0;//确定case数
	int flag2=0;//确定case所包含的数据数量
	while (1)
	{
		flag2=0;
		flag1++;
		fscanf(in, "%d", &n);
		flag2+=n;
		if (n == -1)
			break;
		else
		{
			lthead = MakeEmpty();
			j = n;
			for (int i = 1; i <= n; i++)
			{
				fscanf(in, "%d", &x);
				insert(x, i, lthead);
			}
		}
		fscanf(in, "%d", &n);
		flag2+=n;
		lkhead = lkMakeEmpty();
		for (int i = 1; i <= n; i++)
		{
			fscanf(in, "%d", &x);
			lkhead =lkinsert(x, i, lkhead);
		}
		int i = 1;
		link *p = lkhead;
		fprintf(out,"Case %d:%d\n",flag1,flag2);
		while (i <= j || p->next != NULL)//输出链表和顺序表的内容
		{
			if (i <= j && p->next != NULL)
			{
				if (lthead->date[i] < p->x)
				{
					fprintf(out, "%d ", lthead->date[i]);
					i++;
				}
				else
				{
					fprintf(out, "%d ", p->x);
					p = p->next;
				}
			}
			else if (i <= j)
			{
				fprintf(out, "%d ", lthead->date[i]);
				i++;
			}
			else
			{
				fprintf(out, "%d ", p->x);
				p = p->next;
			}
		}
		fprintf(out,"\n");
	}
	return 0;
}
