package view;


public class Books {
	
	public int bookId;
	public int authId;
	public int pubId;
	public String title;
	public int getBookId()
	{
		return bookId;
	}
	public void setBookId(int id)
	{
		bookId=id;
	}

	public String getTitle()
	{
		return title;
	}
	public void setTitle(String name)
	{
		title=name;
	}
	public int getAuthId()
	{
		return authId;
	}
	public void setAuthId(int id)
	{
		authId=id;
	}
	public int getPubId()
	{
		return pubId;
	}
	public void setPubId(int id)
	{
		pubId=id;
	}
	
	
}
