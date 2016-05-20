package domain;
import java.sql.Date;

public class BookLoans {

	private Date dateIn;
	private Date dateOut;
	
	private Book bookId;
	private Branch branchId;
	private Borrower cardNo;
	
	
	public Date getDateIn() {
		return dateIn;
	}
	public Date getDateOut() {
		return dateOut;
	}
	public Book getBookId() {
		return bookId;
	}
	public Branch getBranchId() {
		return branchId;
	}
	public Borrower getCardNo() {
		return cardNo;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}
	public void setBranchId(Branch branchId) {
		this.branchId = branchId;
	}
	public void setCardNo(Borrower cardNo) {
		this.cardNo = cardNo;
	}

	
	@Override
	public String toString() {
		return "BookLoans [dateIn=" + dateIn + ", dateOut=" + dateOut + ", bookId=" + bookId + ", branchId=" + branchId
				+ ", cardNo=" + cardNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result + ((dateIn == null) ? 0 : dateIn.hashCode());
		result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
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
		BookLoans other = (BookLoans) obj;
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
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (dateIn == null) {
			if (other.dateIn != null)
				return false;
		} else if (!dateIn.equals(other.dateIn))
			return false;
		if (dateOut == null) {
			if (other.dateOut != null)
				return false;
		} else if (!dateOut.equals(other.dateOut))
			return false;
		return true;
	}
	
	
	
}
