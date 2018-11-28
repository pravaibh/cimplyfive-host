package app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.assembler.UserAssembler;
import app.document.RegistrationResponseDTO;
import app.document.User;
import app.document.UserDTO;
import app.helper.MailingHelper;
import app.repository.NoSqlRepository;
import constants.RegistrationMessageConstants;

@Service
public class RegistrationService {
	
	private final NoSqlRepository repository;
	private final MailingService service;
	Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	
	@Autowired
	public RegistrationService(NoSqlRepository repository, MailingService service) {
		this.repository = repository;
		this.service = service;
	}
	
	public RegistrationResponseDTO performRegistration(UserDTO dto) {
		RegistrationResponseDTO response = new RegistrationResponseDTO();
		//perform mailing.
		String[] emailRequestParams = MailingHelper.getParametersForSimpleEmail(dto, MailingHelper.REGISTRATION_SUCCESSFUL_SUBJECT, MailingHelper.REGISTRATION_SUCCESSFUL_BODY);
		try {
			if(repository.existsById(dto.getEmail())) {
				response.setDisplayMessage(RegistrationMessageConstants.ERR_EMAIL_ALREADY_EXISTS);
				return response;
			}
			service.sendSimpleEmail(emailRequestParams[0], emailRequestParams[1], emailRequestParams[2], emailRequestParams[3], emailRequestParams[4]);
			User user = repository.save(UserAssembler.getEntity(dto));
			response.setUserId(user.getEmail());
			response.setStatus("OK");
			response.setDisplayMessage(RegistrationMessageConstants.SUCCESS_EMAIL_REGISTERED + dto.getEmail());
		} catch (Exception e) {
			response.setStatus("FAILED");
			response.setDisplayMessage(RegistrationMessageConstants.ERR_INVALID_EMAIL);
			repository.deleteById(dto.getEmail());
			logger.error("Registration failed with the following exception: " + e.getMessage());
		}
		return response;
	}
	
}
