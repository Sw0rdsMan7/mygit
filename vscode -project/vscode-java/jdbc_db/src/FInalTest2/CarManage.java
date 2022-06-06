package FInalTest2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.Scanner;

import utils.JDBCUtils;
public class CarManage {
    /** 声明连接对象 */
	private Connection conn = null;
	/** 声明预处理对象 */
	private PreparedStatement pstmt = null;
	private Scanner input= new Scanner(System.in);
	/** 构造方法 */
	public CarManage() throws SQLException {
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
}
