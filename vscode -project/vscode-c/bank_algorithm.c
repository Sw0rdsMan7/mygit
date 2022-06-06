#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/**********************************************************************************
银行家算法是用于避免死锁的，本次实验，我们要模拟出这样的一种有可能产生死锁的情形：
系统中目前有很多线程，每个线程都有自己的最大资源需求、也已经分配了一些资源、还需要一些资源。
在这种情形下，系统容易发生死锁(原因思考下)。
然后，我们使用银行家算法来找到这些线程的一种可能的执行顺序，保证不会发生死锁。
************************************************************************************/

/*********************************************************************************
下列代码的各种矩阵是用手动输入的方式，建议同学们改成读文件的方式，这样方便调试
**********************************************************************************/

void* start_banker(void* param);

#define MAX_PRO 256 /* max process count */
#define MAX_RES 256 /* max resource type */

int available[MAX_RES];
int max[MAX_PRO][MAX_RES];
int allocation[MAX_PRO][MAX_RES];
int need[MAX_PRO][MAX_RES];
int request[MAX_RES];
int work[MAX_RES];         //当前可供使用的资源
int finish[MAX_PRO];
FILE *fd,*fo;				//输入输出文档
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
    //输入当前系统中有几个并发的线程
    fprintf(fo,"please input the process count(<=%d).\n", MAX_PRO);
    fscanf(fd, "%d", &n);
    //输入当前系统中有几种资源
    fprintf(fo,"please input the resource type count(<=%d).\n", MAX_RES);
    fscanf(fd, "%d", &m);

    if (m > 256 || n > 256 || m < 0 || n < 0) {
        fprintf(fo,"input error\n");
        return -1;
    }
    //输入已经分配的资源矩阵
    fprintf(fo,"please input allocation matrix\n");
    for (i = 0; i < n; i++)
        for (j = 0; j < m; j++)
            fscanf(fd, "%d", &allocation[i][j]);

    //输入最大资源需求矩阵
    fprintf(fo,"please input max matrix\n");
    for (i = 0; i < n; i++)
        for (j = 0; j < m; j++)
            fscanf(fd, "%d", &max[i][j]);

    //输入当前系统中还可得的资源向量
    fprintf(fo,"please input available vector\n");
    for (j = 0; j < m; j++)
        fscanf(fd, "%d", &available[j]);

    for (i = 0; i < n; i++)
        for (j = 0; j < m; j++)
            need[i][j] = max[i][j] - allocation[i][j];
    /****************** get the need matrix here ************************/
    //在这里计算下need矩阵

    //当前某个线程又发出了新的请求，还记得上课讲的发出新请求的银行家算法吗？
    //输入是哪个线程，请求了多少资源
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
        //既然某个线程发出了新的请求，相应的available矩阵、allocation矩阵、need矩阵是不是都要修改？
        //是不是直接修改它们就可以了？需要额外判断什么？


		//首先校验需求是否大于可提供的资源数，再校验满足需求后，当前线程所占有的资源数是否已经超过了最大占有资源数，
		//最后对分配后的程序运行，检验是否可生成安全序列。
        available[j] = available[j] - request[j];
        if (available[j] < 0) {                    //检验当前资源是否足够分配
            fprintf(fo,"unsafe!\n");
            return 0;
        }
        allocation[id][j] = allocation[id][j] + request[j];
        if (allocation[id][j] > max[id][j]) {  //检验资源分配数是否超过线程上线
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
		//实际执行，检测是否可行。
        for (i = 0; i < n; i++) {
            proc_ids[i] = i;
            int ret = pthread_create(&tid[i], NULL, start_banker, (void*)i);
            sleep(1);
        }
        sleep(1);
        for (i = 0; i < n; i++) {
            if (finish[i] ==0)  //分配将导致程序无法生成安全序列，还原程序分配情况。
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

    // n表示线程数目，一开始，每个线程都标记成未完成,finish[i] = 0;
    for (i = 0; i < n; i++)
        finish[i] = 0;
    // m表示资源种类数目，例如有ABC三类资源，那么m=2
    //开始时，把available赋值给work。
    for (j = 0; j < m; j++)
        work[j] = available[j];

    // pay attention to the thread mutual exclusion
    fprintf(fo,"start...\n");
    for (i = 0; i < n; i++) {
        proc_ids[i] = i;
        /******************** init and creat threads here, which will implement
         * start_banker with parameter "process id" *********/
        //我们开始创建n个线程，想想怎么创建线程？第4章我们是不是实践过了？需要哪几个函数？
        //创建出来的线程就去执行start_banker
        int ret = pthread_create(&tid[i], NULL, start_banker, (void*)i);
        sleep(1);
    }
    sleep(1);
    for (i = 0; i < n; i++) {
        if (finish[i] ==
            0)  //最后，只要发现有一个线程的finish=0，就说明没找到机会给该线程分配资源，系统就是不安全的，有可能死锁
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
    //既然创建出来线程，那我们就要等待线程结束，想想用什么函数等待线程结束？

    return 0;
}

void* start_banker(void* param) {
    int j;
    int id = (int)param;  // process id
    while (!stop_flag && !finish[id]) {
        for (j = 0; j < m; j++) {
            if (need[id][j] >=
                work[j] /************* fill the condition to break ***********/)  //对于id这个线程，它需要的某资源数目怎么样，就不需要继续执行了,这个线程现在肯定不能执行，need>work
                break;
        }
        //如果每个种类的资源都比较了一遍，发现都不break，那就说明对该线程的每个种类的资源need<work，那么这个线程可以执行。
        if (j == m)  // need <= work
        {
            pthread_mutex_lock(&mutex);   //对全局变量进行保护
            finish[id] = 1;
            for (int i = 0; i < m; i++) {
                work[i] = work[i] + allocation[id][i];
            }
            /******************** fill the code here to calculate work matrix
             * and set finish value *******************/
            //这个线程执行完毕了，要修改哪个矩阵？work矩阵要修改，因为该线程执行完毕，会释放它的allocation
            //这个线程执行完毕了，还要记得把这个线程的finish标记下，说明它做完了，下次不要检查它了。
            //完成了上面的work和finish，我们再思考一下，如果现在有好几个线程都满足j==m这个条件，都能进到这个if语句里，那么他们是不是会一起修改work与finish呢？多个线程并发访问共享变量会有什么问题？怎么解决？
            fprintf(fo,"P%d finished\n", id);
			pthread_mutex_unlock(&mutex);

            
        }
    }
    pthread_exit(0);
}
