package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
private Connection con=null;
private Statement stm=null;
private ResultSet rs=null;

  public  DB(){
	try{    
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost:3306/user";//ֱ��ʹ�õ�ǰ��Ŀ¼�µ����ݿ��ļ� 
	    con = DriverManager.getConnection(url,"root","mysql");
	    stm = con.createStatement();
		}catch(Exception e){
			System.out.println("������������ʧ��!");} 
}
       public void close() {
	     if(rs != null){
		 rs = null;
	   }
	   if(stm != null){
		stm = null;
	  }
	  if(con != null){
		con = null;
	  }
}
   //��ɾ�Ĳ�
    public boolean update(String sql) {
     int result = 0;
     try {
     	result = stm.executeUpdate(sql);
     	} catch (Exception e) {
     	// TODO Auto-generated catch block
     		e.printStackTrace();
     	} finally {
     				close();
     	}
     			if(result == 1){
     				return true;
     			}else{
     				return false;
     			}
     		}

     		public ResultSet gets(String sql) {
     			try {
     				rs = stm.executeQuery(sql);
     			} catch (Exception e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			} finally {
     				//close();
     			}
     			return rs;
     		}

















}

