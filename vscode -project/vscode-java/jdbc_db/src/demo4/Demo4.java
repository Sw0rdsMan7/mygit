package demo4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import utils.JDBCUtils;

public class Demo4 {
	private static Connection conn;
	private static Statement stmt;

	public static void main(String[] args) throws SQLException {
		conn = JDBCUtils.getConnection();
		try {
			stmt = conn.createStatement();
			String sql1 = "INSERT INTO instructor(ID,name,dept_name,salary) values('11004','Jack','Music',71850.0)";
			String sql2 = "INSERT INTO instructor(ID,name,dept_name,salary) values('11005','Tom','Music',94670.0)";

			// �ر��Զ��ύģʽ
			conn.setAutoCommit(false);
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			// �����쳣
			int x = 6 / 0;
			// �ύ����
			conn.commit();
			System.out.println("���������ύ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�����쳣���������������Ĳ���\n"+e.getMessage());
			// �������������Ĳ���
			conn.rollback();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}
