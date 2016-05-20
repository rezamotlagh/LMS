package domain;

public class Publisher {

	private int publisherId;
	private String publisherName;
	private String publisherAddress;
	private int publisherPhone;
	
	
	public int getPublisherId() {
		return publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public String getPublisherAddress() {
		return publisherAddress;
	}
	public int getPublisherPhone() {
		return publisherPhone;
	}
	
	
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	public void setPublisherPhone(int publisherPhone) {
		this.publisherPhone = publisherPhone;
	}
	
	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherAddress="
				+ publisherAddress + ", publisherPhone=" + publisherPhone + "]";
	}
	@Override
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((publisherAddress == null) ? 0 : publisherAddress.hashCode());
		result = prime * result + publisherId;
		result = prime * result + ((publisherName == null) ? 0 : publisherName.hashCode());
		result = prime * result + publisherPhone;
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
		Publisher other = (Publisher) obj;
		if (publisherAddress == null) {
			if (other.publisherAddress != null)
				return false;
		} else if (!publisherAddress.equals(other.publisherAddress))
			return false;
		if (publisherId != other.publisherId)
			return false;
		if (publisherName == null) {
			if (other.publisherName != null)
				return false;
		} else if (!publisherName.equals(other.publisherName))
			return false;
		if (publisherPhone != other.publisherPhone)
			return false;
		return true;
	}
	
	
	
	
	
	
}
