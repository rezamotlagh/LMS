package domain;

public class BookCopies {

	private int noOfCopies;
	private Book bookId;
	private Branch branchId;
	
	public int getNoOfCopies() {
		return noOfCopies;
	}
	public Book getBookId() {
		return bookId;
	}
	public Branch getBranchId() {
		return branchId;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	public void setBranchId(Branch branchId) {
		this.branchId = branchId;
	}
	
	@Override
	public String toString() {
		return "BookCopies [noOfCopies=" + noOfCopies + ", bookId=" + bookId + ", branchId=" + branchId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + noOfCopies;
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
		BookCopies other = (BookCopies) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		if (noOfCopies != other.noOfCopies)
			return false;
		return true;
	}
	
	
}
