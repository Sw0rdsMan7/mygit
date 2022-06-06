#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/**********************************************************************************
���м��㷨�����ڱ��������ģ�����ʵ�飬����Ҫģ���������һ���п��ܲ������������Σ�
ϵͳ��Ŀǰ�кܶ��̣߳�ÿ���̶߳����Լ��������Դ����Ҳ�Ѿ�������һЩ��Դ������ҪһЩ��Դ��
�����������£�ϵͳ���׷�������(ԭ��˼����)��
Ȼ������ʹ�����м��㷨���ҵ���Щ�̵߳�һ�ֿ��ܵ�ִ��˳�򣬱�֤���ᷢ��������
************************************************************************************/

/*********************************************************************************
���д���ĸ��־��������ֶ�����ķ�ʽ������ͬѧ�Ǹĳɶ��ļ��ķ�ʽ�������������
**********************************************************************************/

void* start_banker(void* param);

#define MAX_PRO 256 /* max process count */
#define MAX_RES 256 /* max resource type */

int available[MAX_RES];
int max[MAX_PRO][MAX_RES];
int allocation[MAX_PRO][MAX_RES];
int need[MAX_PRO][MAX_RES];
int request[MAX_RES];
int work[MAX_RES];         //��ǰ�ɹ�ʹ�õ���Դ
int finish[MAX_PRO];
FILE *fd,*fo;				//��������ĵ�
int stop_flag = 0;
int m, n;
pthread_mutex_t mutex;
int proc_ids[MAX_PRO];

int main(int argc, char* argv[]) {
    pthread_t tid[MAX_PRO];
    pthread_attr_t attr[MAX_PRO];
    fd = fopen("input.txt", "r+");
    fo = fopen("output.txt", "w");
    int id;
    pthread_mutex_init(&mutex, NULL);
    int i, j;
    //���뵱ǰϵͳ���м����������߳�
    fprintf(fo,"please input the process count(<=%d).\n", MAX_PRO);
    fscanf(fd, "%d", &n);
    //���뵱ǰϵͳ���м�����Դ
    fprintf(fo,"please input the resource type count(<=%d).\n", MAX_RES);
    fscanf(fd, "%d", &m);

    if (m > 256 || n > 256 || m < 0 || n < 0) {
        fprintf(fo,"input error\n");
        return -1;
    }
    //�����Ѿ��������Դ����
    fprintf(fo,"please input allocation matrix\n");
    for (i = 0; i < n; i++)
        for (j = 0; j < m; j++)
            fscanf(fd, "%d", &allocation[i][j]);

    //���������Դ�������
    fprintf(fo,"please input max matrix\n");
    for (i = 0; i < n; i++)
        for (j = 0; j < m; j++)
            fscanf(fd, "%d", &max[i][j]);

    //���뵱ǰϵͳ�л��ɵõ���Դ����
    fprintf(fo,"please input available vector\n");
    for (j = 0; j < m; j++)
        fscanf(fd, "%d", &available[j]);

    for (i = 0; i < n; i++)
        for (j = 0; j < m; j++)
            need[i][j] = max[i][j] - allocation[i][j];
    /****************** get the need matrix here ************************/
    //�����������need����

    //��ǰĳ���߳��ַ������µ����󣬻��ǵ��Ͽν��ķ�������������м��㷨��
    //�������ĸ��̣߳������˶�����Դ
    fprintf(fo,"please input the process No. that request new resources\n");
    fscanf(fd, "%d", &id);

    fprintf(fo,"please input the request vector\n");
    for (j = 0; j < m; j++)
        fscanf(fd, "%d", &request[j]);

    fprintf(fo,"#########################################\n");
    fprintf(fo,"Allocation Matrix\n");
    for (i = 0; i < n; i++) {
        fprintf(fo,"P%d\t\t", i);
        for (j = 0; j < m; j++)
            fprintf(fo,"%d\t", allocation[i][j]);
        fprintf(fo,"\n");
    }

    fprintf(fo,"Max Matrix\n");
    for (i = 0; i < n; i++) {
        fprintf(fo,"P%d\t\t", i);
        for (j = 0; j < m; j++)
            fprintf(fo,"%d\t", max[i][j]);
        fprintf(fo,"\n");
    }

    fprintf(fo,"Available Vector\n");
    for (j = 0; j < m; j++)
        fprintf(fo,"%d\t", available[j]);
    fprintf(fo,"\n");

    fprintf(fo,"with additional resouces requests\nP%d\t\t", id);
    for (j = 0; j < m; j++)
        fprintf(fo,"%d\t", request[j]);
    fprintf(fo,"\n");

    for (j = 0; j < m; j++) {
        /************** a new request, available matrix should be modified
         * **********************/
        //��Ȼĳ���̷߳������µ�������Ӧ��available����allocation����need�����ǲ��Ƕ�Ҫ�޸ģ�
        //�ǲ���ֱ���޸����ǾͿ����ˣ���Ҫ�����ж�ʲô��


		//����У�������Ƿ���ڿ��ṩ����Դ������У����������󣬵�ǰ�߳���ռ�е���Դ���Ƿ��Ѿ����������ռ����Դ����
		//���Է����ĳ������У������Ƿ�����ɰ�ȫ���С�
        available[j] = available[j] - request[j];
        if (available[j] < 0) {                    //���鵱ǰ��Դ�Ƿ��㹻����
            fprintf(fo,"unsafe!\n");
            return 0;
        }
        allocation[id][j] = allocation[id][j] + request[j];
        if (allocation[id][j] > max[id][j]) {  //������Դ�������Ƿ񳬹��߳�����
            fprintf(fo,"unsafe!\n");
            return 0;
        }
        need[id][j] = need[id][j] - request[j];
        for (i = 0; i < n; i++)
            finish[i] = 0;
        for (j = 0; j < m; j++)
            work[j] = available[j];

        /************** a new request, allocation and need matrix should be
         * modified ******************/
		//ʵ��ִ�У�����Ƿ���С�
        for (i = 0; i < n; i++) {
            proc_ids[i] = i;
            int ret = pthread_create(&tid[i], NULL, start_banker, (void*)i);
            sleep(1);
        }
        sleep(1);
        for (i = 0; i < n; i++) {
            if (finish[i] ==0)  //���佫���³����޷����ɰ�ȫ���У���ԭ������������
            {
                fprintf(fo,"unsafe!! can't answer request\n");
				need[id][j]=need[id][j]+request[j];
				available[j]=available[j]+request[j];
				allocation[id][j]=allocation[id][j]-request[j];
                break;
            }
        }
		if(i==n)
			fprintf(fo,"request can be answered\n");
        sleep(1);
        for (i = 0; i < n; i++)
            pthread_join(tid[i], NULL);
		return 0;
    }

    // n��ʾ�߳���Ŀ��һ��ʼ��ÿ���̶߳���ǳ�δ���,finish[i] = 0;
    for (i = 0; i < n; i++)
        finish[i] = 0;
    // m��ʾ��Դ������Ŀ��������ABC������Դ����ôm=2
    //��ʼʱ����available��ֵ��work��
    for (j = 0; j < m; j++)
        work[j] = available[j];

    // pay attention to the thread mutual exclusion
    fprintf(fo,"start...\n");
    for (i = 0; i < n; i++) {
        proc_ids[i] = i;
        /******************** init and creat threads here, which will implement
         * start_banker with parameter "process id" *********/
        //���ǿ�ʼ����n���̣߳�������ô�����̣߳���4�������ǲ���ʵ�����ˣ���Ҫ�ļ���������
        //�����������߳̾�ȥִ��start_banker
        int ret = pthread_create(&tid[i], NULL, start_banker, (void*)i);
        sleep(1);
    }
    sleep(1);
    for (i = 0; i < n; i++) {
        if (finish[i] ==
            0)  //���ֻҪ������һ���̵߳�finish=0����˵��û�ҵ���������̷߳�����Դ��ϵͳ���ǲ���ȫ�ģ��п�������
        {
            fprintf(fo,"unsafe!!\n");
            break;
        }
    }
    if (i == n)
        fprintf(fo,"safe!!\n");
    stop_flag = 1;
    fprintf(fo,"Finish...\n");
    sleep(1);
    for (i = 0; i < n; i++)
        pthread_join(tid[i], NULL);
    /******************** use XX function here to wait the threads to finish
     * **********************/
    //��Ȼ���������̣߳������Ǿ�Ҫ�ȴ��߳̽�����������ʲô�����ȴ��߳̽�����

    return 0;
}

void* start_banker(void* param) {
    int j;
    int id = (int)param;  // process id
    while (!stop_flag && !finish[id]) {
        for (j = 0; j < m; j++) {
            if (need[id][j] >=
                work[j] /************* fill the condition to break ***********/)  //����id����̣߳�����Ҫ��ĳ��Դ��Ŀ��ô�����Ͳ���Ҫ����ִ����,����߳����ڿ϶�����ִ�У�need>work
                break;
        }
        //���ÿ���������Դ���Ƚ���һ�飬���ֶ���break���Ǿ�˵���Ը��̵߳�ÿ���������Դneed<work����ô����߳̿���ִ�С�
        if (j == m)  // need <= work
        {
            pthread_mutex_lock(&mutex);   //��ȫ�ֱ������б���
            finish[id] = 1;
            for (int i = 0; i < m; i++) {
                work[i] = work[i] + allocation[id][i];
            }
            /******************** fill the code here to calculate work matrix
             * and set finish value *******************/
            //����߳�ִ������ˣ�Ҫ�޸��ĸ�����work����Ҫ�޸ģ���Ϊ���߳�ִ����ϣ����ͷ�����allocation
            //����߳�ִ������ˣ���Ҫ�ǵð�����̵߳�finish����£�˵���������ˣ��´β�Ҫ������ˡ�
            //����������work��finish��������˼��һ�£���������кü����̶߳�����j==m������������ܽ������if������ô�����ǲ��ǻ�һ���޸�work��finish�أ�����̲߳������ʹ����������ʲô���⣿��ô�����
            fprintf(fo,"P%d finished\n", id);
			pthread_mutex_unlock(&mutex);

            
        }
    }
    pthread_exit(0);
}
