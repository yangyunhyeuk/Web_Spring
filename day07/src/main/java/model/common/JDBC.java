package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	
	// 1. 로드
	// 2. 연결
	// 3. 리턴
	
   public static Connection getConnection() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","yang","1234");
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   public static void close(Connection conn,PreparedStatement pstmt) {
      try {
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
      try {
         rs.close();
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
	// conn.close의 경우 얘가 열었던 애들을 책임지고 닫아서 정확하고 확실하게 닫고 싶은 경우 위와 같이 구현한다.
}
	
	
	
	
	
	
