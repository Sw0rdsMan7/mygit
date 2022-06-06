#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
sem_t rmutex, wmutex, mutex;
pthread_mutex_t mutex_t;
char a[100];
int int1[100];
int t = 0;
int reader_count = 0;
void* reader_fun(void* arg) {
    int* time = (int*)arg;
    int id = time[0];
    int t_start = time[1];
    int t_end = time[2];
    while (1) {
        pthread_mutex_lock(&mutex_t);
        if (t_start == t) {
            printf("读者 %d申请读数据...\n", id);
            pthread_mutex_unlock(&mutex_t);
            sem_wait(&mutex);
            sem_wait(&rmutex);
            if (reader_count == 0)
                sem_wait(&wmutex);
            reader_count++;
            sem_post(&rmutex);
            sem_post(&mutex);
            printf("读者 %d申请成功\n", id);
            printf("读者 %d正在读数据...\n", id);
            t_end = t_end + t;
            break;
        } else
            pthread_mutex_unlock(&mutex_t);
    }
    while (1) {
        pthread_mutex_lock(&mutex_t);

        if (t == t_end) {
            pthread_mutex_unlock(&mutex_t);
            printf("读者 %d读完数据退出\n", id);
            sem_wait(&rmutex);
            reader_count--;
            if (reader_count == 0)
                sem_post(&wmutex);
            sem_post(&rmutex);

            break;
        } else
            pthread_mutex_unlock(&mutex_t);
    }
}
void* writer_fun(void* arg) {
    int* time = (int*)arg;
    int id = time[0];
    int t_start = time[1];
    int t_end = time[2];
    while (1) {
        pthread_mutex_lock(&mutex_t);
        if (t_start == t) {
            pthread_mutex_unlock(&mutex_t);
            printf("写者 %d申请写数据...\n", id);
            sem_wait(&mutex);
            sem_wait(&wmutex);
            printf("写者 %d申请成功\n", id);
            printf("写者 %d正在写数据...\n", id);
            t_end = t_end + t;
            break;
        } else {
            pthread_mutex_unlock(&mutex_t);
        }
    }
    while (1) {
        pthread_mutex_lock(&mutex_t);

        if (t == t_end) {
            pthread_mutex_unlock(&mutex_t);
            printf("写者 %d写完数据退出\n", id);
            sem_post(&wmutex);
            sem_post(&mutex);
            break;
        } else
            pthread_mutex_unlock(&mutex_t);
    }
}
int main() {
    int index = 0;
    int flag = 0;
    int t_start = 0;
    int t_end = 0;
    pthread_t reader[10], writer[10];
    pthread_mutex_init(&mutex_t, NULL);
    int ret = sem_init(&rmutex, 0, 1);
    if (ret != 0) {
        printf("sem_init error");
        exit(0);
    }
    ret = sem_init(&wmutex, 0, 1);
    if (ret != 0) {
        printf("sem_init error");
        exit(0);
    }
    ret = sem_init(&mutex, 0, 1);
    if (ret != 0) {
        printf("sem_init error");
        exit(0);
    }
    FILE* fd = fopen("input.txt", "r+");
    if (fd == NULL) {
        printf("open error\n");
        return -1;
    } else {
        printf("读取文件序列中...\n");
        while (1) {
            index += 1;
            flag = fscanf(fd,"%d %c %d",&int1[0],&a[0],&int1[1]);
            printf("%d %c %d \n",int1[0],a[0],int1[1]);
            if (flag != EOF) {
                int id = *a - '1' + 1;
                char cate = *(a + 1);
                t_start = *(a + 2) - '1' + 1;
                t_end = *(a + 3) - '1' + 1;
                int time[3] = {id, t_start, t_end};
                if (cate == 'r')
                    flag = pthread_create(&reader[index], NULL, reader_fun,
                                          (void*)time);
                else
                    flag = pthread_create(&writer[index], NULL, writer_fun,
                                          (void*)time);

                sleep(1);

            } else {
                break;
            }
        }
        printf("读取完毕\n");
        while (1) {
            sleep(1);
            pthread_mutex_lock(&mutex_t);
            t = t + 1;
            printf("世界时间为:%d\n", t);
        }
    }
    for (int i = 1; i < index; i++) {
        pthread_join(reader[index], NULL);
    }
}
