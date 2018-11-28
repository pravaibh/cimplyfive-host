package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.document.RegistrationResponseDTO;
import app.document.UserDTO;
import app.service.RegistrationService;

@RestController
@RequestMapping("register")
public class RegistrationController {

	private final RegistrationService service;
	
	@Autowired
	RegistrationController(RegistrationService service) {
		this.service = service;
	}
//	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public RegistrationResponseDTO registerNewUser(@RequestBody UserDTO dto) {
		
		// Add data to mongodb.
		
		// Raise notifications.
		return service.performRegistration(dto);
	}
}
