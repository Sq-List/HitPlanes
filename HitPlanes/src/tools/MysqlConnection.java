package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Score;

public class MysqlConnection
{
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/hitplanes";
	
	private static final String USER = "root";
	private static final String PASS = "123456";
	
	private Connection conn;
	private Statement stmt;
	
	public MysqlConnection()
	{
		try
		{
			//连接数据库
			Class.forName(JDBC_DRIVER);
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt = conn.createStatement();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void insertScore(int score)
	{
		//向数据库写入分数
		String sql = "INSERT INTO TopScore(user_score) VALUES(" + score + ")";
		try
		{
			int rs = stmt.executeUpdate(sql);
			if (rs != -1)
			{
//				System.out.println("插入成功！");
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Score> selectScore()
	{
		//从数据中读出倒序前十的分数并返回List类型的对象
		List<Score> scoreList = new ArrayList<Score>();
		String sql = "SELECT user_score FROM TopScore ORDER BY user_score DESC LIMIT 10";
		try
		{
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next())
			{
				Score sc = new Score();
				sc.setUser_score(rs.getInt("user_score"));
				scoreList.add(sc);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return scoreList;
	}
}
