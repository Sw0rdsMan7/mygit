#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
#include<semaphore.h>

#define PRODUCER_NUM 5 //生产者数目
#define CONSUMER_NUM 5 //消费者数目
#define POOL_SIZE	 11  //缓冲池大小
int pool[POOL_SIZE];	//缓冲区
int p_out=0;	//缓冲池读取指针
int p_in=0; //缓冲池写入指针
sem_t	empty_sem;		//同步信号信号量，表示缓冲区有可用空间
sem_t	full_sem;		//同步信号量，表示缓冲区有可用产品
pthread_mutex_t mutex;

void* producer_fun(void *arg)
{
	while (1)
	{
		sleep(1);
		sem_wait(&empty_sem);
		pthread_mutex_lock(&mutex); 
		pool[p_in] = 1;
		p_in = (p_in + 1) % POOL_SIZE;
		printf("生产者生产 %d 进入缓冲区\n", (int)arg);
		printf("缓冲区大小为%d\n",(p_in-p_out+POOL_SIZE)%POOL_SIZE);
		pthread_mutex_unlock(&mutex); 
		sem_post(&full_sem);	
  }
}

void* consumer_fun(void *arg)
{
	while (1)
	{
		int data;
		sleep(10);
		sem_wait(&full_sem);
		pthread_mutex_lock(&mutex); 
		data = pool[p_out];
		p_out = (p_out + 1) % POOL_SIZE;
		printf("消费者消费 %d 从缓冲区拿出\n", (int)arg);
		printf("缓冲区大小为%d\n",(p_in-p_out+POOL_SIZE)%POOL_SIZE);
		pthread_mutex_unlock(&mutex);
		sem_post(&empty_sem);
	}
}

int main()
{
	pthread_t producer_id[PRODUCER_NUM];
	pthread_t consumer_id[CONSUMER_NUM];
	pthread_mutex_init(&mutex, NULL);	//初始化互斥量
	int ret = sem_init(&empty_sem, 0, POOL_SIZE-1);	//初始化信号量empty_sem为缓冲池大小
	if (ret != 0)
	{
		printf("sem_init error");
		exit(0);
	}
	ret = sem_init(&full_sem, 0, 0);	//初始化信号量full_sem为0，开始时缓冲池中没有数据
	if (ret != 0)
	{
		printf("sem_init error");
		exit(0);
	}
	for (int i = 0; i < PRODUCER_NUM; i++)
	{
		//创建生产者线程
		ret =pthread_create(&producer_id[i], NULL, producer_fun, (void*)i);
		if (ret != 0)
		{
			printf("producer_id error");
			exit(0);
		}
		//创建消费者线程
		ret = pthread_create(&consumer_id[i], NULL, consumer_fun, (void*)i);
		if (ret != 0)
		{
			printf("consumer_id error");
			exit(0);
		}
	}
	for(int i=0;i<PRODUCER_NUM;i++)
	{
		pthread_join(producer_id[i],NULL);
		pthread_join(consumer_id[i],NULL);
	}

	exit(0);
}
