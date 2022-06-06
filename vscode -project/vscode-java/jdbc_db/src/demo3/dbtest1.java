package demo3;

import utils.JDBCUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import jdk.internal.util.xml.impl.Input;
public class dbtest1 {
	
	public static void main(String[] args) {
		try {
			DbPreparedOperation dbOperation = new DbPreparedOperation();
			// ��������
			Scanner input= new Scanner(System.in);
			String manager_id="",manager_pwd="";
			while(true) {
				System.out.print("���������Ա���:");
				manager_id=input.nextLine();
				if(dbOperation.checkManagerId(manager_id))
					break;
				else
				{
					System.out.print("�޶�Ӧ���,����������:");
				}
					continue;
			}
			
			
			while(true)
			{
				System.out.print("���������Ա����:");
				manager_pwd=input.nextLine();
				if(dbOperation.login(manager_id,manager_pwd))
					break;
				else
				{
					System.out.print("�����������������:");
					manager_pwd=input.nextLine();
					continue;
					
				}
					
			}
			System.out.println("**************************************************");
			System.out.println("��ӭ����ͼ�����ϵͳ��������Ӧ������ŷ�����Ӧ����");
			while(true) {
				System.out.println("1.�޸�����\n2.ͼ����Ϣ����\n3.������Ϣ����\n4.�˳�ϵͳ");
				String choose_flag=input.nextLine();
				if(choose_flag.equals("1")) {
					while(true) {
					System.out.print("������������:");
					String newpassword=input.nextLine();
					if(dbOperation.updatepassword(manager_id, newpassword))
							break;
					else
						continue;
					}
					
				}	
				else if(choose_flag.equals("2")) {
					while(true) {
					System.out.println("1.������ͼ����Ϣ\n2.�޸�ͼ����Ϣ\n3.ɾ��ͼ����Ϣ\n4.��ѯ������Ϣ\n5.��ѯ������Ϣ");
					String choose_flag_inner=input.nextLine();
					while(!choose_flag_inner.equals("1") &&!choose_flag_inner.equals("2") &&!choose_flag_inner.equals("3")&&!choose_flag_inner.equals("4") &&!choose_flag_inner.equals("5")  )
						{System.out.print("��ʽ����,����������:");
						choose_flag_inner=input.nextLine();
						}
						dbOperation.book_operate(choose_flag_inner);
					System.out.print("1.��������ͼ����Ϣ2.�˳�:");
					String flag=input.nextLine();
					if(flag.equals("1"))
						continue;
					else if(flag.equals("2"))
						break;
					else
						{
						System.out.print("�����ʽ����!");
						break;
						}
					}
					
				}
				else if(choose_flag.equals("3")) {
					while(true) {
					System.out.println("1.�����¶�����Ϣ\n2.�޸Ķ�����Ϣ\n3.ɾ��������Ϣ");
					String choose_flag_inner=input.nextLine();
					while(choose_flag.equals("1") &&choose_flag.equals("2") &&choose_flag.equals("3")  )
					{
					System.out.print("��ʽ����,����������:");
					choose_flag_inner=input.nextLine();
					}
					dbOperation.reader_operate(choose_flag_inner);
					System.out.print("1.��������������Ϣ2.�˳�:");
					String flag=input.nextLine();
					if(flag.equals("1"))
						continue;
					else if(flag.equals("2"))
						break;
					else
						{
						System.out.print("�����ʽ����!");
						break;
						}
					}
					
				}
				else if(choose_flag.equals("4"))
				{
					JDBCUtils.close(dbOperation.getConnection(), dbOperation.getPreparedStatement(), null);
					System.exit(0);
				}
				else {
					System.out.println("�����ʽ����,���������룡");
				}
				
			}
			
			
			
			 
			// �޸�����
			// dbOperation.updateData("88479", "����777", "Music", 234567);

			// ɾ������
			// dbOperation.deleteData("88479");
			
			// ��ѯ��������
			// dbOperation.selectAllData();
			
			// ����ID��ѯ����
			// dbOperation.selectByID("98347");
			 
			// ����nameģ����ѯ����
			// dbOperation.selectByName("d");
			 


			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
