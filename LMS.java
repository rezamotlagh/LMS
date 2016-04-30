import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class LMS {

	
	
	/*private ArrayList<Books> loadBooks(String query)
	{
		int bookId;
		String title;
	 	int authId;
	 	int pubId;
	 	Books book;
	 	ResultSet rs = null;
		Connection connection = null;
		Statement statement = null; 
		ArrayList<Books> bookList= new ArrayList<Books>();
		//System.out.println(query);
		try {
	
			connection = JDBCMysqlConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
			while (rs.next()) 
			{
				book=new Books();
				book.setBookId(rs.getInt("bookId"));
				book.setTitle(rs.getString("title"));
				book.setAuthId(rs.getInt("authId"));
				book.setPubId(rs.getInt("pubId"));
				bookList.add(book);
			}
			
			
		}//try 
		catch (SQLException e) {
			//e.printStack
			
			e.printStackTrace();
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
		return bookList;
	}*/
	private void addBookCopies(int branchId)
	{
		int bookId;
		int noofCopies;
		String title;
	 	int authId;
	 	int pubId;
	 	Books book;
	 	boolean noCopy=false;
	 	ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		ArrayList<String> bookList= new ArrayList<String>();
				//System.out.println(query);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		
			connection = JDBCMysqlConnection.getConnection();
			statement = connection.createStatement();
			String query="select bookId, title, authorName from tbl_book, tbl_author where tbl_book.authId=tbl_author.authorId";
			rs = statement.executeQuery(query);
			while (rs.next()) 
				{
				bookList.add(rs.getInt("bookId")+")."+rs.getString("title")+" by "+rs.getString("authorName"));
				}
			System.out.println("Select a book to add copies:");
			for(String bl:bookList)
				System.out.println(bl);
			System.out.println((bookList.size()+1)+")."+"Cancel the operation");
			bookId=Integer.parseInt(br.readLine());
			if(bookId>0 && bookId <= bookList.size())
			{
				query="select noOfCopies from tbl_book_copies where bookId="+bookId+" and branchId="+branchId;//write a query for selecting the book from the book copies table and do the update process
				rs=statement.executeQuery(query);
				//System.out.println(query);
				if(!rs.next())
				{
					noofCopies = 0;
					noCopy=true;
				}
				else
				{
					noofCopies=rs.getInt("noOfCopies");
					noCopy=false;
				}
					while(true)
				{
				System.out.println("This book has "+noofCopies+" copies in this branch. how many to add?");
				try{
						
						int addedCopies=Integer.parseInt(br.readLine());
						
						if(addedCopies>=0)
						{
							
							if(noCopy==true)
								query="insert into tbl_book_copies values("+bookId+","+branchId+","+addedCopies+")";	
							else
								query="update tbl_book_copies set noOfCopies= "+(noofCopies+addedCopies)+" where branchId="+branchId+" and bookId="+bookId;
							
							//System.out.println(bookId+" , "+branchId+" , "+noofCopies);
							//System.out.println(query);
							connection = JDBCMysqlConnection.getConnection();
							statement = connection.createStatement();
							statement.executeUpdate(query);
							System.out.println("Updated!");
							return;
						}
						else
							System.out.println("wrong Input!");
							
				}
				catch(NumberFormatException e)
				{
					System.out.println("Wrong Input!");
				}
				catch (SQLException e) {
					//e.printStack
					
					e.printStackTrace();
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

				}//while(true)
			}
			else if(bookId==bookList.size()+1)
			{
				return;
			}
			
		}//try 
		catch (SQLException e) {
			//e.printStack
			
			e.printStackTrace();
		} 
		catch (IOException e) {
			//e.printStack
			
			e.printStackTrace();
		} 
		catch (NumberFormatException e) {
			//e.printStack
			
			System.out.println("Wrong Input!");
		} 
		
		//return bookList;
		//System.out.println("Please Select a Library Branch number or go back to the previous menu:");
		//for (Books bl : bookList)
			//System.out.println(bl.getTitle());
		//System.out.println(bl);
		//System.out.println((branchList.size()+1)+".Previous menu"); //(branchList.size()+1) is the number of the last item in array list plus 
		
	}
	
	
	private String updateTextFields(String newName)
	{
		
		if(newName.equals("quit"))
		{
			System.out.println("Operation is cancelled by the user");
			return "qt";
		}
		else if(newName.equals("N/A"))
		{
			System.out.println("Name not changed!");
			return "";	
		}
		else
		{
			System.out.println("New Name is set as: "+newName);
			return newName;
			
		}
		
	}
	 private void librarianSubmenu2(int branchId)
	 {
		 	String branchName="";
		 	String branchAddress="";
		 	ResultSet rs = null;
			Connection connection = null;
			Statement statement = null; 
			ArrayList<String> branchList= new ArrayList<String>();
			Librarian librarian = null;
			String query = "select branchName,branchAddress from tbl_library_branch where branchId="+branchId;
			//System.out.println(query);
			try {
		
				connection = JDBCMysqlConnection.getConnection();
				statement = connection.createStatement();
				rs = statement.executeQuery(query);
				if(rs.next()) 
				{
					branchName=rs.getString("branchName");
					branchAddress=rs.getString("branchAddress");
				
				}
			}//try 
			catch (SQLException e) {
				//e.printStack
				
				e.printStackTrace();
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
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int choice;
			String newName;
			String newAddress;
			librarian=new Librarian();
			while(true)
			{
			System.out.println("Library Branch: "+ branchName);
			System.out.println("Please choose:");
			System.out.println(" 1.Update branch details\n 2.Add Book Copies\n 3.Previous Menu");
			
			try
			{
				choice=Integer.parseInt(br.readLine());
				switch(choice)
				{
				case 1:			
						System.out.println("You have chosen to update the Branch with Branch Id: "+branchId+", Branch Name:"+branchName+" and branch address='"+branchAddress+"'. \nEnter ‘quit’ at any prompt to cancel operation.");
						System.out.println("Please enter new branch name or enter N/A for no change:");
						newName=br.readLine();
						newName=updateTextFields(newName);
						if(newName.equals("qt"))
							return;
						System.out.println("Please enter new branch Address or enter N/A for no change:");
						newAddress=br.readLine();
						newAddress=updateTextFields(newAddress);
						if(newAddress.equals("qt"))
							return;
						if(newName!="" || newAddress!="")
						{
						librarian.updateBranch(branchId,newName,newAddress);
						System.out.println("returned");
						return;//HERE decide whether write the inner most methods inside classes or not
						}
				case 2: 
						String query1="select title, authorName from tbl_book, tbl_author where tbl_book.authId=tbl_author.authorId";
					    //ArrayList<Books> bookList=loadBooks(query1);
						addBookCopies(branchId);
						break;
						//return;
				case 3:
						return;
				default:
						System.out.println("Wrong Input!");
				}
				
			}
			catch(NumberFormatException e)
			{
				System.out.println("Wrong Input!");
				//A stack trace can be written to the log file
			}
			catch(IOException e)
			{
				//A stack trace can be written to the log file
			}
			}//while(true)
	 }
	 private void librarianSubmenu()
	 {
		 //We first load the branch names from the DB and then ask user to select any branch number
		 //the branch number is same as the branchId in the DB. Therefore after validation we pass the chosen number(Id) to the submenu2
		 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int choice;
			
		 	ResultSet rs = null;
			Connection connection = null;
			Statement statement = null; 
			ArrayList<String> branchList= new ArrayList<String>();
			Librarian librarian = null;
			String query = "select branchId,branchName from tbl_library_branch";
			//System.out.println(query);
			try {
		
				connection = JDBCMysqlConnection.getConnection();
				statement = connection.createStatement();
				rs = statement.executeQuery(query);
				while (rs.next()) 
				{
					branchList.add(rs.getInt("branchId")+"."+rs.getString("branchName"));
				}
			}//try 
			catch (SQLException e) {
				//e.printStackTrace();
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

				while(true)
				{
				System.out.println("Please Select a Library Branch number or go back to the previous menu:");
				for (String bl : branchList)
				System.out.println(bl);
				System.out.println((branchList.size()+1)+".Previous menu"); //(branchList.size()+1) is the number of the last item in array list plus 1
				try{
					choice=Integer.parseInt(br.readLine());
					if(choice>0 && choice<(branchList.size()+1))
						{
						librarianSubmenu2(choice);
						return;
						}
					else if(choice==(branchList.size()+1))
							return;
					else
					{
						System.out.println("Wrong Input!");
					}
					
					}//try
			catch(IOException e){
				//e.printStackTrace();
			}
			catch(NumberFormatException e)
			{
				System.out.println("Wrong Input!");
			}
		 }//while(true)
	 }
	 private void LibrarianMenu()
	 {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		String branch;
		while(true)
		{
		System.out.println("*-*-*-*-*GCIT Library Management System*-*-*-*-*");
		System.out.println("Please choose:");
		System.out.println(" 1.Branch Management\n 2.Previous menu");
		
		try
		{
			choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1:			
					librarianSubmenu();
					break;
			case 2:
					return;
			}
			
		}
		catch(NumberFormatException e)
		{
			System.out.println("Wrong Input!");
			//A stack trace can be written to the log file
		}
		catch(IOException e)
		{
			//A stack trace can be written to the log file
		}
		}//while(true)
}

	 
	 
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		LMS submenu=new LMS();
		while(true)
		{
		System.out.println("*-*-*-*-*Welcome to the GCIT Library Management System*-*-*-*-*");
		System.out.println("Which category of a user are you?");
		System.out.println(" 1.Librarian\n 2.Administrator\n 3.Borrower\n 4.Exit");
		
		try{
		choice=Integer.parseInt(br.readLine());
		switch(choice)
		{
		case 1:System.out.println("You are a Librarian");
			   submenu.LibrarianMenu();
			break;
		/*case 2:System.out.println("You are an administrator");
			break;
		case 3:System.out.println("You are a borrower");
			break;*/
		case 4:System.out.println("Thank You for Visiting GCIT!");
			System.exit(0);
		default: System.out.println("Wrong Choice! Choose a number between 1 to 3");

		}//switch
		}//try
		catch(NumberFormatException e)
		{
			System.out.println("Wrong input!");
			//e.printStackTrace();
		}
		catch(IOException e)
		{
			//e.printStackTrace();
		}
		}//while(true)
		
		//System.out.println("Enter the branch name:");
		//String branch;
		//try {
			//branch= br.readLine();
			//LMS demo = new LMS();
			//Librarian librarian = demo.getLibrarian(branch);
			//System.out.println(librarian);			
		//} catch (NumberFormatException e) {
			//e.printStackTrace();
		//} catch (IOException e) {
		//	e.printStackTrace();
	//	}		
		
	}
/*
	public Librarian getLibrarian(String branch)  {	
		
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null; 
		
		Librarian librarian = null;
		String query = "select * from tbl_library_branch where branchName='" + branch+"'";
		System.out.println(query);
		try {			
			connection = JDBCMysqlConnection.getConnection();
			
			statement = connection.createStatement();
			
			rs = statement.executeQuery(query);
			
			if (rs.next()) {
				librarian = new Librarian();
				librarian.setBranchId(rs.getInt("branchId"));
				librarian.setBranchName(rs.getString("branchName"));
				librarian.setBranchAddress(rs.getString("branchAddress"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return librarian;
	}
	
	*/
}
