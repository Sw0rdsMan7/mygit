#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
#define MAXSIZE 10000
/*int main(int argc, char *argv[])
{
	typedef struct
	{
		int date[MAXSIZE];
		int last;
	} list;
	list L, *ptrl;
	list *makeempty(void)
	{
		list *ptrl = list * (list *)malloc(sizeof(list));
		ptrl->list = -1;
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
		for (j = i; i <= ptrl->last - 1; j++)
		{
			ptrl->date[j] = ptrl->date[j + 1];
		}
		ptrl->last--;
		return;
	}
	int find(int x, list *ptrl)
	{
		for (int i = 0; i <= ptrl->last; i++)
		{
			if (ptrl->date[i] == x)
				return i;
		}
		if (i == ptrl->last + 1)
		{
			printf("未找到数据") ； return -1;
		}
	}
	int length(list * ptrl)
	{
		return ptrl->last + 1;
	}

	typedef struct node
	{
		struct *node next;
		int x;
	} ;
	node LK1, *head;
	node *lkmakeempty(void)
	{
		node *head = (node *)malloc(sizeof(node));
		return head;
	}
	int lklength(lk * head)

		return 0;
}*/
