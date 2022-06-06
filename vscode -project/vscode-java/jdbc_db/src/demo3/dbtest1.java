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
			// 插入数据
			Scanner input= new Scanner(System.in);
			String manager_id="",manager_pwd="";
			while(true) {
				System.out.print("请输入管理员编号:");
				manager_id=input.nextLine();
				if(dbOperation.checkManagerId(manager_id))
					break;
				else
				{
					System.out.print("无对应编号,请重新输入:");
				}
					continue;
			}
			
			
			while(true)
			{
				System.out.print("请输入管理员密码:");
				manager_pwd=input.nextLine();
				if(dbOperation.login(manager_id,manager_pwd))
					break;
				else
				{
					System.out.print("密码错误请重新输入:");
					manager_pwd=input.nextLine();
					continue;
					
				}
					
			}
			System.out.println("**************************************************");
			System.out.println("欢迎来到图书管理系统！输入相应操作编号访问相应功能");
			while(true) {
				System.out.println("1.修改密码\n2.图书信息管理\n3.读者信息管理\n4.退出系统");
				String choose_flag=input.nextLine();
				if(choose_flag.equals("1")) {
					while(true) {
					System.out.print("请输入新密码:");
					String newpassword=input.nextLine();
					if(dbOperation.updatepassword(manager_id, newpassword))
							break;
					else
						continue;
					}
					
				}	
				else if(choose_flag.equals("2")) {
					while(true) {
					System.out.println("1.插入新图书信息\n2.修改图书信息\n3.删除图书信息\n4.查询借书信息\n5.查询还书信息");
					String choose_flag_inner=input.nextLine();
					while(!choose_flag_inner.equals("1") &&!choose_flag_inner.equals("2") &&!choose_flag_inner.equals("3")&&!choose_flag_inner.equals("4") &&!choose_flag_inner.equals("5")  )
						{System.out.print("格式有误,请重新输入:");
						choose_flag_inner=input.nextLine();
						}
						dbOperation.book_operate(choose_flag_inner);
					System.out.print("1.继续操作图书信息2.退出:");
					String flag=input.nextLine();
					if(flag.equals("1"))
						continue;
					else if(flag.equals("2"))
						break;
					else
						{
						System.out.print("输入格式有误!");
						break;
						}
					}
					
				}
				else if(choose_flag.equals("3")) {
					while(true) {
					System.out.println("1.插入新读者信息\n2.修改读者信息\n3.删除读者信息");
					String choose_flag_inner=input.nextLine();
					while(choose_flag.equals("1") &&choose_flag.equals("2") &&choose_flag.equals("3")  )
					{
					System.out.print("格式有误,请重新输入:");
					choose_flag_inner=input.nextLine();
					}
					dbOperation.reader_operate(choose_flag_inner);
					System.out.print("1.继续操作读者信息2.退出:");
					String flag=input.nextLine();
					if(flag.equals("1"))
						continue;
					else if(flag.equals("2"))
						break;
					else
						{
						System.out.print("输入格式有误!");
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
					System.out.println("输入格式有误,请重新输入！");
				}
				
			}
			
			
			
			 
			// 修改数据
			// dbOperation.updateData("88479", "胡三777", "Music", 234567);

			// 删除数据
			// dbOperation.deleteData("88479");
			
			// 查询所有数据
			// dbOperation.selectAllData();
			
			// 根据ID查询数据
			// dbOperation.selectByID("98347");
			 
			// 根据name模糊查询数据
			// dbOperation.selectByName("d");
			 


			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
