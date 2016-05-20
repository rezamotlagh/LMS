package view;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Librarian {
private String branchName;
private String branchAddress;
private int branchId;

public int getBranchId()
{
	return branchId;
}
public void setBranchId(int id)
{
	branchId=id;
}

public String getBranchName()
{
	return branchName;
}
public String getBranchAddress()
{
	return branchAddress;
}
public void setBranchName(String name)
{
	branchName=name;
}
public void setBranchAddress(String address)
{
	branchAddress=address;
}
public String toString()
	{
		return "Librarian [branchId="+branchId+", branchName="+branchName+", branchAddress="+branchAddress+"]";
				
	}


public void updateBranch(int branchId,String newName,String newAddress)
{
//check the input arguments for sql injection
	Connection connection = null;
	Statement statement = null; 
	String query; 
	//we know that maybe one of the new field names might be null but not both(look at this method's call in LMS)!
	if(newName=="")
		query = "update tbl_library_branch set branchAddress='"+newAddress+"' where branchId="+branchId;
	else if(newAddress=="")
		query = "update tbl_library_branch set branchName='"+newName+"' where branchId="+branchId;
	else
		query = "update tbl_library_branch set branchName='"+newName+"', branchAddress='"+newAddress+"' where branchId="+branchId;
	try {
		
		connection = JDBCMysqlConnection.getConnection();
		statement = connection.createStatement();
		statement.executeUpdate(query);
	}//try
	catch (SQLException e)
	{
		System.out.println("Update unsuccessful!");
	} 
	finally {
		if (connection != null) 
		{
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}//if
	}//finally
}
}//class
