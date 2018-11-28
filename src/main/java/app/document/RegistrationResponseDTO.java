package app.document;

import java.io.Serializable;

public class RegistrationResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7375349149753587411L;
	private String status;
	private String userId;
	private String displayMessage;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDisplayMessage() {
		return displayMessage;
	}
	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}
	@Override
	public String toString() {
		return "RegistrationResponseDTO [status=" + status + ", userId=" + userId + ", errorMessage=" + displayMessage + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayMessage == null) ? 0 : displayMessage.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		RegistrationResponseDTO other = (RegistrationResponseDTO) obj;
		if (displayMessage == null) {
			if (other.displayMessage != null)
				return false;
		} else if (!displayMessage.equals(other.displayMessage))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
