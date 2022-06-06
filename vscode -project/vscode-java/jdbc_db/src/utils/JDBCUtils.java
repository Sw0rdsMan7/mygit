package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/** JDBC������ */
public class JDBCUtils {
	/** �������ݿ���������(MySQL) */
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	/** �������ݿ����ӵ�ַ */
	private static final String URL = "jdbc:mysql://localhost:3306/dbtest1?serverTimezone=UTC&characterEncoding=utf-8";
	/** �������ݿ��������¼�û��� */
	private static final String USERNAME = "root";
	/** �������ݿ��¼���� */
	private static final String PASSWORD = "123456";

	/**
	 * ���þ�̬��ʼ����������ݿ��������� ��̬��ʼ�����������ʱ�͵���,��ֻ����һ��
	 */
	static {
		try {
			// �������ݿ���������
			Class.forName(DRIVER);
			System.out.println("���ݿ�����������سɹ���");
		} catch (Exception e) {
			System.out.println("���ݿ������������ʧ�ܣ�" + e.getMessage());
		}
	}

	/** ��ȡConnection����ķ��� */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// �������ݿ⣬��ȡConnection����
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("�������ݿ�ɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�" + e.getMessage());
		}
		return conn;
	}

	/** �ر����ӡ������ռ估����� */
	public static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
