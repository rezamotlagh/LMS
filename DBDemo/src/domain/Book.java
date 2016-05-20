package domain;

public class Book {
 
	private int bookId;
	private Author authId;
	private Publisher pubId;
	private String title;
	public int getBookId() {
		return bookId;
	}
	public int getAuthId() {
		return authId.getAuthorId();
	}
	public int getPubId() {
		return pubId.getPublisherId();
	}
	public String getTitle() {
		return title;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setAuthId(int authorId) {
		authId.setAuthorId(authorId);
		
	}
	public void setPubId(int publisherId) {
	    pubId.setPublisherId(publisherId);
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
		
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", authId=" + authId.getAuthorId() + ", pubId=" + pubId.getPublisherId() + ", title=" + title + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authId.getAuthorId();
		result = prime * result + bookId;
		result = prime * result + pubId.getPublisherId();
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authId != other.authId)
			return false;
		if (bookId != other.bookId)
			return false;
		if (pubId != other.pubId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
