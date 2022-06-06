package demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utils.JDBCUtils;

/** ���ݿ������ */
public class DbPreparedOperation {
	/** �������Ӷ��� */
	private Connection conn = null;
	/** ����Ԥ������� */
	private PreparedStatement pstmt = null;
	private Scanner input= new Scanner(System.in);
	/** ���췽�� */
	public DbPreparedOperation() throws SQLException {
		this.conn = JDBCUtils.getConnection();
	}

	/** �������Ӷ��� */
	public Connection getConnection() {
		return conn;
	}

	/** ����Ԥ������� */
	public PreparedStatement getPreparedStatement() {
		return pstmt;
	}
	public void reader_operate(String mode ) throws Exception{
		if(mode.equals("1"))
		{
			while(true)
			{
				String reader_number,name,department,gender,telephone="";
				
				System.out.print("������ߺ�:");
				reader_number=input.nextLine();
				System.out.print("�����������:");
				name=input.nextLine();
				System.out.print("���벿����:");
				department=input.nextLine();
				System.out.print("��������Ա�:");
				gender=input.nextLine();
				while( !gender.equals("��")&&!gender.equals("Ů"))
				{
					System.out.print("��ʽ����,����������");
					gender=input.nextLine();
				}
				System.out.print("��������ֻ���:");
				telephone=input.nextLine();
				 String regex = "1[34578][0-9]{10}";
				 while(telephone.matches(regex))
				 {
						System.out.print("��ʽ����,����������");
						telephone=input.nextLine();
					}
				String sql = "INSERT INTO reader(reader_number,name,department,gender,telephone) VALUES(?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, reader_number);
				pstmt.setString(2,name);
				pstmt.setString(3,department);
				pstmt.setString(4,gender);
				pstmt.setString(5,telephone);
				int n=pstmt.executeUpdate();
				System.out.print("1.�����޸�2.�˳�:");
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
		else if(mode.equals("2")) {
			while(true) {
				System.out.print("������Ҫ�޸ĵĶ��ߵĶ��ߺ�:");
				String reader_number=input.nextLine();
				while(true)
				{
					String updateStr="";
					System.out.print("������Ҫ�޸ĵĶ�����Ϣ");
					System.out.print("1.���ߺ�2.��������3.������4.�����Ա�5.�����ֻ���");
					int choose_flag=Integer.parseInt(input.nextLine());
					if(choose_flag==1)
						updateStr="reade_number";
					else if(choose_flag==2)
						updateStr="name";
					else if(choose_flag==3)
						updateStr="department";
					else if(choose_flag==4)
						updateStr="gender";
					else if(choose_flag==5)
						updateStr="telephone";
					System.out.print("�����޸ĺ�Ķ�����Ϣ:");
					String updateData=input.nextLine();
						String sql = "UPDATE reader SET "+updateStr+" =? WHERE reader_number=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, updateData);
						pstmt.setString(2,reader_number);
						int n=pstmt.executeUpdate();
					System.out.print("1.�����޸ĵ�ǰ����2.�˳�:");
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
				System.out.print("1.�����޸Ķ�����Ϣ2.�˳�:");
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
		else if(mode.equals("3")) {
			while(true) {
				System.out.print("������Ҫɾ���Ķ��ߵĶ��ߺ�:");
				String reader_number=input.nextLine();
				String sql = "DELETE FROM reader WHERE reader_number=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, reader_number);
				int n=pstmt.executeUpdate();
				System.out.print("1.�����޸�2.�˳�:");
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
	}
	public void book_operate(String mode) throws Exception {
				if(mode.equals("1")) {
					while(true)
					{
						String book_number,category,book_name,publisher,author="";
						float price=0;
						int book_total,inventory;
						
						System.out.print("�������:");
						book_number=input.nextLine();
						System.out.print("��������:");
						category=input.nextLine();
						System.out.print("��������:");
						book_name=input.nextLine();
						System.out.print("���������:");
						publisher=input.nextLine();
						System.out.print("��������:");
						author=input.nextLine();
						System.out.print("����۸�:");
						price=input.nextFloat();
						System.out.print("����������:");
						book_total=input.nextInt();
						System.out.print("������:");
						inventory=input.nextInt();
						String sql = "INSERT INTO book(reader_number,category,book_name,publisher,author,price,book_total,book_name) VALUES(?,?,?,?,?,?,?,?)";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, book_number);
						pstmt.setString(2,category);
						pstmt.setString(3,book_name);
						pstmt.setString(4,publisher);
						pstmt.setString(5,author);
						pstmt.setFloat(6,price);
						pstmt.setInt(7, book_total);
						pstmt.setInt(8, inventory);
						int n=pstmt.executeUpdate();
						System.out.print("1.�����޸�2.�˳�:");
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
				else if(mode.equals("2")) {
					while(true) {
						System.out.print("������Ҫ�޸ĵ�ͼ������:");
						String book_number=input.nextLine();
						while(true)
						{
							String updateStr="";
							System.out.print("������Ҫ�޸ĵ�ͼ����Ϣ");
							System.out.print("1.���2.����3.����4.������5.����6.�۸�7.������8.����");
							int choose_flag=Integer.parseInt(input.nextLine());
							if(choose_flag==1)
								updateStr="book_number";
							else if(choose_flag==2)
								updateStr="category";
							else if(choose_flag==3)
								updateStr="book_name";
							else if(choose_flag==4)
								updateStr="publiser";
							else if(choose_flag==5)
								updateStr="author";
							else if(choose_flag==6)
								updateStr="price";
							else if(choose_flag==7)
								updateStr="book_total";
							else if(choose_flag==8)
								updateStr="inventory";
							System.out.print("�����޸ĺ��ͼ����Ϣ:");
							String updateData=input.nextLine();
							if(choose_flag==7 || choose_flag==8) {
								int updateDataInt=Integer.parseInt(updateData);
								String sql = "UPDATE book SET "+updateStr+" =? WHERE book_number=?";
								pstmt = conn.prepareStatement(sql);
								pstmt.setInt(1, updateDataInt);
								pstmt.setString(2,book_number);
								int n=pstmt.executeUpdate();
							}
							else if(choose_flag==6) {
								float updateDataFloat  = Float.parseFloat(updateData);
								String sql = "UPDATE book SET "+updateStr+" =? WHERE book_number=?";
								pstmt = conn.prepareStatement(sql);
								pstmt.setFloat(1, updateDataFloat);
								pstmt.setString(2,book_number);
								int n=pstmt.executeUpdate();
							}
							else {
								String sql = "UPDATE book SET "+updateStr+" =? WHERE book_number=?";
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, updateData);
								pstmt.setString(2,book_number);
								int n=pstmt.executeUpdate();
							}
							System.out.print("1.�����޸ĵ�ǰͼ��2.�˳�:");
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
						System.out.print("1.�����޸�ͼ��2.�˳�:");
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
				else if(mode.equals("3")) {
					while(true) {
						System.out.print("������Ҫɾ����ͼ������:");
						String book_number=input.nextLine();
						String sql = "DELETE FROM book WHERE book_number=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, book_number);
						int n=pstmt.executeUpdate();
						System.out.print("1.�����޸�2.�˳�:");
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
				else if(mode.equals("4")) {
					while(true) {
						System.out.print("������Ҫ��ѯ�Ľ����ߵĶ��ߺ�:");
						String reader_number=input.nextLine();
						String sql = "SELECT reader_number,borrow_book.book_number,book_name,publisher,borrow_time from borrow_book,book where borrow_book.book_number=book.book_number AND reader_number=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, reader_number);
						ResultSet rs = pstmt.executeQuery();
						rs.last();
						// �õ���ǰ�кţ����������¼��
						int rowCount = rs.getRow();
						System.out.println("���ҵ�" + rowCount + "����¼");

						// Ϊ��ȡ����,���������ָ���Ƶ���ʼλ��
						rs.beforeFirst();
						// �������ָ������ƶ�������true��ʾ���м�¼,����û�м�¼
						while (rs.next()) {
							// ȡ��ID�ֶε�����
							String reader_Number = rs.getString("reader_number");
							// ȡ��ID�ֶε�����
							String book_number = rs.getString("borrow_book.book_number");
							// ȡ��dept_name�ֶε�����
							String book_name = rs.getString("book_name");
							// ȡ��salary�ֶε�����
							String publisher = rs.getString("publisher");
							String borrow_time=rs.getDate("borrow_time").toString();
							System.out.println("���ߺ�:" + reader_Number + ",���:" + book_number + ",����:" + book_name + ",������:" + publisher+",����ʱ��:"+borrow_time);			
						}
						System.out.print("1.��������2.�˳�:");
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
					else if(mode.equals("5")) {
						while(true) {
							System.out.print("������Ҫ��ѯ�������ߵĶ��ߺ�:");
							String reader_number=input.nextLine();
							String sql = "SELECT reader_number,return_book.book_number,book_name,publisher,return_time from return_book,book where return_book.book_number=book.book_number AND reader_number=?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, reader_number);
							ResultSet rs = pstmt.executeQuery();
							rs.last();
							// �õ���ǰ�кţ����������¼��
							int rowCount = rs.getRow();
							System.out.println("���ҵ�" + rowCount + "����¼");

							// Ϊ��ȡ����,���������ָ���Ƶ���ʼλ��
							rs.beforeFirst();
							// �������ָ������ƶ�������true��ʾ���м�¼,����û�м�¼
							while (rs.next()) {
								// ȡ��ID�ֶε�����
								String reader_Number = rs.getString("reader_number");
								// ȡ��ID�ֶε�����
								String book_number = rs.getString("return_book.book_number");
								// ȡ��dept_name�ֶε�����
								String book_name = rs.getString("book_name");
								// ȡ��salary�ֶε�����
								String publisher = rs.getString("publisher");
								String borrow_time=rs.getDate("return_time").toString();
								System.out.println("���ߺ�:" + reader_Number + ",���:" + book_number + ",����:" + book_name + ",������:" + publisher+",����ʱ��:"+borrow_time);			
							}
							
							
							
							
							
							System.out.print("1.��������2.�˳�:");
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
	}
	/** �������� */
	public boolean updatepassword(String manager_id, String password) throws Exception
	{	
		String rule="^[a-z0-9_-]{6,18}$";
		if(password.matches(rule)){
			String sql = "UPDATE manager SET password =? WHERE manager_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, manager_id);
			int n=pstmt.executeUpdate();
			if(n>0)
				return true;
			else
			{
				System.out.println("�����ʽ����!");
			}
				return false;
		}
		else {
			return false;
		}
	}
	public boolean checkManagerId(String manager_id) throws Exception {
		String sql = "SELECT * FROM manager WHERE manager_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, manager_id);
		ResultSet rs = pstmt.executeQuery();
		rs.last();
		int count=rs.getRow();
		if(count<1)
			return false;
		else 
			return true;
		
	}
	public boolean login (String manager_id,String password) throws Exception {
		
		String sql = "SELECT * FROM manager WHERE manager_id=? and password=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, manager_id);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		rs.last();
		int count=rs.getRow();
		if(count<1)
			return false;
		else 
			return true;
		
		
		
	} 
	/** ����IDɾ������ */
	
	
}
