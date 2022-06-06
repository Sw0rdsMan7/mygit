package demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import utils.JDBCUtils;

/** 数据库操作类 */
public class DbPreparedOperation {
	/** 声明连接对象 */
	private Connection conn = null;
	/** 声明预处理对象 */
	private PreparedStatement pstmt = null;
	private Scanner input= new Scanner(System.in);
	/** 构造方法 */
	public DbPreparedOperation() throws SQLException {
		this.conn = JDBCUtils.getConnection();
	}

	/** 返回连接对象 */
	public Connection getConnection() {
		return conn;
	}

	/** 返回预处理对象 */
	public PreparedStatement getPreparedStatement() {
		return pstmt;
	}
	public void reader_operate(String mode ) throws Exception{
		if(mode.equals("1"))
		{
			while(true)
			{
				String reader_number,name,department,gender,telephone="";
				
				System.out.print("输入读者号:");
				reader_number=input.nextLine();
				System.out.print("输入读者姓名:");
				name=input.nextLine();
				System.out.print("输入部门名:");
				department=input.nextLine();
				System.out.print("输入读者性别:");
				gender=input.nextLine();
				while( !gender.equals("男")&&!gender.equals("女"))
				{
					System.out.print("格式有误,请重新输入");
					gender=input.nextLine();
				}
				System.out.print("输入读者手机号:");
				telephone=input.nextLine();
				 String regex = "1[34578][0-9]{10}";
				 while(telephone.matches(regex))
				 {
						System.out.print("格式有误,请重新输入");
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
				System.out.print("1.继续修改2.退出:");
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
		else if(mode.equals("2")) {
			while(true) {
				System.out.print("输入需要修改的读者的读者号:");
				String reader_number=input.nextLine();
				while(true)
				{
					String updateStr="";
					System.out.print("输入需要修改的读者信息");
					System.out.print("1.读者号2.读者姓名3.部门名4.读者性别5.读者手机号");
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
					System.out.print("输入修改后的读者信息:");
					String updateData=input.nextLine();
						String sql = "UPDATE reader SET "+updateStr+" =? WHERE reader_number=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, updateData);
						pstmt.setString(2,reader_number);
						int n=pstmt.executeUpdate();
					System.out.print("1.继续修改当前读者2.退出:");
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
				System.out.print("1.继续修改读者信息2.退出:");
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
		else if(mode.equals("3")) {
			while(true) {
				System.out.print("输入需要删除的读者的读者号:");
				String reader_number=input.nextLine();
				String sql = "DELETE FROM reader WHERE reader_number=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, reader_number);
				int n=pstmt.executeUpdate();
				System.out.print("1.继续修改2.退出:");
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
	}
	public void book_operate(String mode) throws Exception {
				if(mode.equals("1")) {
					while(true)
					{
						String book_number,category,book_name,publisher,author="";
						float price=0;
						int book_total,inventory;
						
						System.out.print("输入书号:");
						book_number=input.nextLine();
						System.out.print("输入书类:");
						category=input.nextLine();
						System.out.print("输入书名:");
						book_name=input.nextLine();
						System.out.print("输入出版社:");
						publisher=input.nextLine();
						System.out.print("输入作者:");
						author=input.nextLine();
						System.out.print("输入价格:");
						price=input.nextFloat();
						System.out.print("输入书总数:");
						book_total=input.nextInt();
						System.out.print("输入库存:");
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
						System.out.print("1.继续修改2.退出:");
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
				else if(mode.equals("2")) {
					while(true) {
						System.out.print("输入需要修改的图书的书号:");
						String book_number=input.nextLine();
						while(true)
						{
							String updateStr="";
							System.out.print("输入需要修改的图书信息");
							System.out.print("1.书号2.书类3.书名4.出版社5.作者6.价格7.书总数8.书库存");
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
							System.out.print("输入修改后的图书信息:");
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
							System.out.print("1.继续修改当前图书2.退出:");
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
						System.out.print("1.继续修改图书2.退出:");
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
				else if(mode.equals("3")) {
					while(true) {
						System.out.print("输入需要删除的图书的书号:");
						String book_number=input.nextLine();
						String sql = "DELETE FROM book WHERE book_number=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, book_number);
						int n=pstmt.executeUpdate();
						System.out.print("1.继续修改2.退出:");
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
				else if(mode.equals("4")) {
					while(true) {
						System.out.print("输入需要查询的借阅者的读者号:");
						String reader_number=input.nextLine();
						String sql = "SELECT reader_number,borrow_book.book_number,book_name,publisher,borrow_time from borrow_book,book where borrow_book.book_number=book.book_number AND reader_number=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, reader_number);
						ResultSet rs = pstmt.executeQuery();
						rs.last();
						// 得到当前行号，即结果集记录数
						int rowCount = rs.getRow();
						System.out.println("查找到" + rowCount + "条记录");

						// 为了取数据,将结果集的指针移到初始位置
						rs.beforeFirst();
						// 结果集的指针向后移动：返回true表示还有记录,否则没有记录
						while (rs.next()) {
							// 取得ID字段的数据
							String reader_Number = rs.getString("reader_number");
							// 取得ID字段的数据
							String book_number = rs.getString("borrow_book.book_number");
							// 取得dept_name字段的数据
							String book_name = rs.getString("book_name");
							// 取得salary字段的数据
							String publisher = rs.getString("publisher");
							String borrow_time=rs.getDate("borrow_time").toString();
							System.out.println("读者号:" + reader_Number + ",书号:" + book_number + ",书名:" + book_name + ",出版社:" + publisher+",借书时间:"+borrow_time);			
						}
						System.out.print("1.继续查阅2.退出:");
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
					else if(mode.equals("5")) {
						while(true) {
							System.out.print("输入需要查询的退书者的读者号:");
							String reader_number=input.nextLine();
							String sql = "SELECT reader_number,return_book.book_number,book_name,publisher,return_time from return_book,book where return_book.book_number=book.book_number AND reader_number=?";
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, reader_number);
							ResultSet rs = pstmt.executeQuery();
							rs.last();
							// 得到当前行号，即结果集记录数
							int rowCount = rs.getRow();
							System.out.println("查找到" + rowCount + "条记录");

							// 为了取数据,将结果集的指针移到初始位置
							rs.beforeFirst();
							// 结果集的指针向后移动：返回true表示还有记录,否则没有记录
							while (rs.next()) {
								// 取得ID字段的数据
								String reader_Number = rs.getString("reader_number");
								// 取得ID字段的数据
								String book_number = rs.getString("return_book.book_number");
								// 取得dept_name字段的数据
								String book_name = rs.getString("book_name");
								// 取得salary字段的数据
								String publisher = rs.getString("publisher");
								String borrow_time=rs.getDate("return_time").toString();
								System.out.println("读者号:" + reader_Number + ",书号:" + book_number + ",书名:" + book_name + ",出版社:" + publisher+",还书时间:"+borrow_time);			
							}
							
							
							
							
							
							System.out.print("1.继续查阅2.退出:");
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
	}
	/** 插入数据 */
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
				System.out.println("输入格式有误!");
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
	/** 根据ID删除数据 */
	
	
}
