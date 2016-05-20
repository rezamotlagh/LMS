package dao;
import domain.Author;
import view.JDBCMysqlConnection;
import java.sql.*;
import java.util.ArrayList;
public class AuthorDao implements DAOInterface{
	public void createAuthor(Author author)
	{
		
	}
	public void readAuthor()
	{
		
	}
	public void updateAuthor(Author author)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="update tbl_author set autorId="+author.getAuthorId()+", authorName="+author.getAuthorName()+")";
			st.executeUpdate(query);
		}
		// check the correctness of the query
		//  check the attribute names in the DB
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteAuthor(int authorId, String authorName)
	{
		Author ath=new Author();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query;
			if(authorId>0 && authorName!=null)
			query="delete from tbl_authour where authorId="+authorId+" and authorName="+authorName;	
			else if(authorId==0 && authorName!=null)
		    query="delete from tbl_authour where authorName="+authorName;	
			else if(authorId>0 && authorName==null)
			query="delete from tbl_authour where authorId="+authorId;	
			else 
				return ;
			st.executeUpdate(query);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		
	}
	public void insertAuthor(Author author)
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="insert into tbl_author values("+author.getAuthorId()+","+author.getAuthorName()+")";
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void deleteAuthor()
	{
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="delete from tbl_author";
			st.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public ArrayList<Author> findAuthor(int authorId, String authorName)
	{
		ArrayList<Author> authList=new ArrayList();
		Author ath=new Author();
		try
		{
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs;
			String query;
			if(authorId>0 && authorName!=null)
			query="select authorId,authorName from tbl_authour where authorId="+authorId+" and authorName="+authorName;	
			else if(authorId==0 && authorName!=null)
		    query="select authorId,authorName from tbl_authour where authorName="+authorName;	
			else if(authorId>0 && authorName==null)
			query="select authorId,authorName from tbl_authour where authorId="+authorId;	
			else 
				return null;
			rs=st.executeQuery(query);
			while(rs.next())
			{
				ath.setAuthorId(rs.getInt("authorId"));
				ath.setAuthorName(rs.getString("authorName"));
				authList.add(ath);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	 
		return authList;
	}
	public ArrayList<Author> findAuthor()
	{ //select all
		ArrayList<Author> authList=new ArrayList();
		Author ath=new Author();
		try
		{
			
			Connection con=JDBCMysqlConnection.getConnection();
			Statement st=con.createStatement();
			String query="select * from Author";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				ath.setAuthorId(rs.getInt("authorId"));
				ath.setAuthorName(rs.getString("authorName"));
				authList.add(ath);
			}
		}
		// check the correctness of the query
		//  check the attribute names in the DB
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
		return authList;
	}
}
