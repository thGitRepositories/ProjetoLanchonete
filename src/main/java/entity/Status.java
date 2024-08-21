package entity;

import java.util.Objects;

public class Status {
	private Long id;
	private String statusName;

	public Status() {
		
	}

	public Status(String statusName,Long id) {
		super();
		this.id = id;
		this.statusName = statusName;
	}

	public String getStatusName() {
		return statusName;
	}
	
	public Long getStatus() {
		return id;
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
		return "Status [id=" + id + ", statusName=" + statusName + "]";
	}

	
	
	
	
	
}
