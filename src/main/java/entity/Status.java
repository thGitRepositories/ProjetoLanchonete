package entity;

import java.util.Objects;

public class Status {
	private String statusName;

	public Status() {
		
	}

	public Status(String statusName) {
		super();
		this.statusName = statusName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(statusName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		return Objects.equals(statusName, other.statusName);
	}

	@Override
	public String toString() {
		return "Status [statusName=" + statusName + "]";
	}
	
	
	
	
}
