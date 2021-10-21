#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10000
typedef struct
{
	int date[MAXSIZE];
	int top;
} ltStack;
ltStack *ltMakeEmpty()
{

	ltStack *ptrl;
	ptrl = (ltStack *)malloc(sizeof(ltStack));
	ptrl->top = -1;
	return ptrl;
}
int ltFull(ltStack *ptrl)
{
	if (ptrl->top == MAXSIZE - 1)
		return 1;
	else
		return 0;
}
void ltPush(ltStack *ptrl, int item)
{
	if (ltFull(ptrl))
	{
		printf("堆栈满");
		return;
	}
	else
	{
		ptrl->date[++(ptrl->top)] = item;
	}
}
int ltPop(ltStack *ptrl)
{
	if (ptrl->top == -1)
	{
		printf("堆栈空");
		return 0;
	}
	else
	{
		return ptrl->date[(ptrl->top)--];
	}
}

int main(int argc, char *argv[])
{
	ltStack *ltptrl;
	ltptrl = ltMakeEmpty();
	FILE *in, *out;
	in = fopen("input.txt", "r");
	out = fopen("output.txt", "w");
	int x = 0;
	while (fscanf(in, "%d", &x) != 0)
	{
		if (x == -1)
			break;
		else
		{
			fprintf(out, "%d--->", x);
			if (x == 0)
			{
				fprintf(out, "%d", x);
			}
			else
			{
				while (x != 0)
				{
					ltPush(ltptrl, x % 2);
					x /= 2;
				}
				while (ltptrl->top != -1)
				{
					fprintf(out, "%d", ltPop(ltptrl));
				}
			}
			fprintf(out, "\n");
		}
	}
}