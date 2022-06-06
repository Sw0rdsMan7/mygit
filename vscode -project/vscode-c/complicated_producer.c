#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
#include<semaphore.h>

#define PRODUCER_NUM 5 //��������Ŀ
#define CONSUMER_NUM 5 //��������Ŀ
#define POOL_SIZE	 11  //����ش�С
int pool[POOL_SIZE];	//������
int p_out=0;	//����ض�ȡָ��
int p_in=0; //�����д��ָ��
sem_t	empty_sem;		//ͬ���ź��ź�������ʾ�������п��ÿռ�
sem_t	full_sem;		//ͬ���ź�������ʾ�������п��ò�Ʒ
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
		printf("���������� %d ���뻺����\n", (int)arg);
		printf("��������СΪ%d\n",(p_in-p_out+POOL_SIZE)%POOL_SIZE);
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
		printf("���������� %d �ӻ������ó�\n", (int)arg);
		printf("��������СΪ%d\n",(p_in-p_out+POOL_SIZE)%POOL_SIZE);
		pthread_mutex_unlock(&mutex);
		sem_post(&empty_sem);
	}
}

int main()
{
	pthread_t producer_id[PRODUCER_NUM];
	pthread_t consumer_id[CONSUMER_NUM];
	pthread_mutex_init(&mutex, NULL);	//��ʼ��������
	int ret = sem_init(&empty_sem, 0, POOL_SIZE-1);	//��ʼ���ź���empty_semΪ����ش�С
	if (ret != 0)
	{
		printf("sem_init error");
		exit(0);
	}
	ret = sem_init(&full_sem, 0, 0);	//��ʼ���ź���full_semΪ0����ʼʱ�������û������
	if (ret != 0)
	{
		printf("sem_init error");
		exit(0);
	}
	for (int i = 0; i < PRODUCER_NUM; i++)
	{
		//�����������߳�
		ret =pthread_create(&producer_id[i], NULL, producer_fun, (void*)i);
		if (ret != 0)
		{
			printf("producer_id error");
			exit(0);
		}
		//�����������߳�
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
