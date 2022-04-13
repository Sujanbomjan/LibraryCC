package author_table_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import common.DBConnection_LMS_Portal;
import common_use_bean.Author_Use_Bean;
import common_use_bean.Category_Use_Bean;



public class Author_Table_Model {
	public int insert_author(Author_Use_Bean obj_Author_Use_Bean){
		Connection connection=null;
		DBConnection_LMS_Portal obj_DBConnection_SMS_Portal=new DBConnection_LMS_Portal();
		connection=obj_DBConnection_SMS_Portal.getConnection();
		PreparedStatement ps=null;
		
		int flag=0;
	try { 
		
		
		
		

		String query="insert into author (" +
						"author_name," +
						
						"added_on" +
						") values(?,?)";
		ps=connection.prepareStatement(query);

		ps.setString(1,obj_Author_Use_Bean.getAuthor_name());
		
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kathmandu"));
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
		 
		  Date today4 = new Date();
		  String date4 = format.format(today4);
		
		
		ps.setString(2,date4);
		
	    System.out.println(ps);
		flag=ps.executeUpdate();
		 
		
	 }catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try {
					connection.close();
				}
			 	catch (Exception e2) {
				// TODO: handle exception
			 	}
		}
		if(ps!=null){
			try {
				
				ps.close();
				}
			 catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
}
	
	return flag;

	}	
	
	
	
	
	
	
	

	public int edit_author(Author_Use_Bean obj_Author_Use_Bean){
		Connection connection=null;
		DBConnection_LMS_Portal obj_DBConnection_SMS_Portal=new DBConnection_LMS_Portal();
		connection=obj_DBConnection_SMS_Portal.getConnection();
		PreparedStatement ps=null;
		
		int flag=0;
	try { 
		
		
		
		

		String query="update author set author_name=? where sl_no=?";
		ps=connection.prepareStatement(query);
		ps.setString(1,obj_Author_Use_Bean.getAuthor_name());
		ps.setString(2,obj_Author_Use_Bean.getSl_no());
		System.out.println(ps);
		flag=ps.executeUpdate();
		query="update book_table set author_name=? where author_num=?";
		ps=connection.prepareStatement(query);
		ps.setString(1,obj_Author_Use_Bean.getAuthor_name());
		ps.setString(2,obj_Author_Use_Bean.getSl_no());
		ps.executeUpdate();
		
	
		
		
	 }catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try {
					connection.close();
				}
			 	catch (Exception e2) {
				// TODO: handle exception
			 	}
		}
		if(ps!=null){
			try {
				
				ps.close();
				}
			 catch (Exception e2) {
				// TODO: handle exception
			}
		}
	
}
	
	return flag;

	}	
	
	
	
	 
	
	
	
	
	

			public List<Author_Use_Bean> get_all_authors(){
				Connection connection=null;
				DBConnection_LMS_Portal obj_DBConnection_SMS_Portal=new DBConnection_LMS_Portal();
				connection=obj_DBConnection_SMS_Portal.getConnection();
				PreparedStatement ps=null;
				ResultSet rs=null;
				List<Author_Use_Bean> list=new ArrayList<Author_Use_Bean>();
			try { 
				
				String query="select * from author order by added_on desc";
				ps=connection.prepareStatement(query);
				
				
				System.out.println(ps);
				rs=ps.executeQuery();
				
				
				while(rs.next()){
					Author_Use_Bean obj_Author_Use_Bean=new Author_Use_Bean();
					obj_Author_Use_Bean.setSl_no(rs.getString("sl_no"));
					obj_Author_Use_Bean.setAuthor_name(rs.getString("author_name"));
					
					list.add(obj_Author_Use_Bean);
				}
				
			 }catch(Exception e){
				e.printStackTrace();
			}finally{
				if(connection!=null){
					try {
							connection.close();
						}
					 	catch (Exception e2) {
						// TODO: handle exception
					 	}
				}
				if(ps!=null){
					try {
						
						ps.close();
						}
					 catch (Exception e2) {
						// TODO: handle exception
					}
				}
			
		}
			
			return list;
		
			}	
			
			
			public List<Author_Use_Bean> get_search_result_author(String search){
				Connection connection=null;
				DBConnection_LMS_Portal obj_DBConnection_SMS_Portal=new DBConnection_LMS_Portal();
				connection=obj_DBConnection_SMS_Portal.getConnection();
				PreparedStatement ps=null;
				ResultSet rs=null;
				List<Author_Use_Bean> list=new ArrayList<Author_Use_Bean>();
			try { 
				
				String query="select * from author where  author_name like ?";
				ps=connection.prepareStatement(query);
				ps.setString(1, "%"+search+"%");
				
				System.out.println(ps);
				rs=ps.executeQuery();
				
				
				while(rs.next()){
					Author_Use_Bean obj_Author_Use_Bean=new Author_Use_Bean();
					obj_Author_Use_Bean.setSl_no(rs.getString("sl_no"));
					obj_Author_Use_Bean.setAuthor_name(rs.getString("author_name"));
					
					list.add(obj_Author_Use_Bean);
				}
				
			 }catch(Exception e){
				e.printStackTrace();
			}finally{
				if(connection!=null){
					try {
							connection.close();
						}
					 	catch (Exception e2) {
						// TODO: handle exception
					 	}
				}
				if(ps!=null){
					try {
						
						ps.close();
						}
					 catch (Exception e2) {
						// TODO: handle exception
					}
				}
			
		}
			
			return list;
		
			}	
			
			
	
	
	

}
