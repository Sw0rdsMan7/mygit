#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10000
typedef struct Node
{
	struct Node *next;
    int element;
} lkStack;
lkStack *lkMakeEmpty()
{

	lkStack *top;
	top = (lkStack *)malloc(sizeof(lkStack));
	top->next=NULL;
    return top;
}
void lkPush(lkStack *top, int item)
{
	struct Node*cell;
    cell=(lkStack *)malloc(sizeof(struct Node));
    cell->element=item;
    cell->next=top->next;
    top->next=cell;



}
int lkPop(lkStack *top)
{
	struct Node *cell;
    int popelement;
    if(top->next==NULL)
    {
        printf("堆栈空");
        return 0;
    }
    else
    {
        cell=top->next;
        top->next=cell->next;
        popelement=cell->element;
        free(cell);
        return popelement;
    }

}
int main(int argc, char *argv[])
{
	lkStack *lktop;
	lktop = lkMakeEmpty();
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
					lkPush(lktop, x % 2);
					x /= 2;
				}
				while (lktop->next !=NULL)
				{
					fprintf(out, "%d", lkPop(lktop));
				}
			}
			fprintf(out, "\n");
		}
	}
}