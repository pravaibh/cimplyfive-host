package app.assembler;

import app.document.User;
import app.document.UserDTO;

public class UserAssembler {
	
	public static UserDTO getDTO(User user) {
		// Not to be used currently.
		return null;
	}
	
	public static User getEntity(UserDTO dto) {
		User user = null;
		if(dto != null) {
			user = new User();
			user.setAddress1(dto.getAddress1());
			user.setAddress2(dto.getAddress2());
			user.setCity(dto.getCity());
			user.setCountry(dto.getCountry());
			user.setDesignation(dto.getDesignation());
			user.setEmail(dto.getEmail());
			user.setFirstName(dto.getFirstName());
			user.setFrequency(dto.getFrequency());
			user.setLandmark(dto.getLandmark());
			user.setLastName(dto.getLastName());
			user.setMiddleName(dto.getMiddleName());
			user.setMobileNumber(dto.getMobileNumber());
			user.setOfficeNumber(dto.getOfficeNumber());
			user.setOrgName(dto.getOrgName());
			user.setPin(dto.getPin());
			user.setState(dto.getState());
		}
		return user;
	}

}
