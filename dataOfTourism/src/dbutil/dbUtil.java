package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.lvyou;


public class dbUtil {

	String URL ="jdbc:mysql://localhost:3306/jingquTest?characterEncoding=utf8";
	String USER ="jingqu";
	String PWD = "scz000614";
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	List<lvyou> lvyous = new ArrayList<lvyou>();
	
		//��ȡconnection����
		public Connection getConnection () throws ClassNotFoundException, SQLException {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PWD);
			
			
			return connection;
			
		}
		//���preparestatement����
		public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
			
			Connection connection = getConnection();
			pstmt = (PreparedStatement) connection.prepareStatement(sql);
			
			return pstmt;
		}
		//�ر���
		public void shutdown(PreparedStatement pstmt, Connection connection,ResultSet res) throws SQLException {
			
			if (pstmt!=null) {
				pstmt.close();
			}
			if (connection!=null) {
				connection.close();
			}
			if (res!=null) {
				res.close();
			}
			
		
		}
		
		//ͨ�õ���ɾ��
		public boolean Upload(String sql,Object[] obj) {
			
			try {
				pstmt = getPreparedStatement(sql);
				
				for(int i = 0; i<obj.length;i++) {
					pstmt.setObject(i+1, obj[i]);
//					System.out.println(obj[i]);
				}
			int count = pstmt.executeUpdate();
			
			if (count>0) {
				return true;
				
			}else {
				return false;
			}
			
			
			
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					shutdown(pstmt, connection, res);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			return false;
			
		}
		//ͨ�õĲ�
		public ResultSet query(String sql,Object[] obj) {

			
			try {
				pstmt = getPreparedStatement(sql);
				
				for(int i=0;i<obj.length;i++) {
					
					pstmt.setObject(i+1, obj[i]);
					
				}
				 res = pstmt.executeQuery();
				 
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			return res;
			
			
		}

		//��ѯ�������� ����뾭γ��
		public List<lvyou> getName(String sql, Object[] param){
			
			 res = query(sql, param);
			 
			 try {
				while (res.next()) {
					String name = res.getString("name");
					String introduce = res.getString("�������");
					String longitude = res.getString("����");
					String latitude = res.getString("γ��");
					String prvince = res.getString("��");
					lvyou lvyou = new lvyou(name, introduce, longitude, latitude, prvince);
					lvyous.add(lvyou);
					
				}
				return lvyous;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					shutdown(pstmt, connection, res);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			 
			return null;
			
		}

}
