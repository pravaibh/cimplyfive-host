package app.helper;

import app.document.UserDTO;

public class MailingHelper {

	public static final String REGISTRATION_SUCCESSFUL_BODY = String.join(
    	    System.getProperty("line.separator"),
    	    "<p>Greetings!<p>",
    	    "<p>You have successfully registered to our mailing service and will receive periodic digest starting now.", 
    	    "<p>Regards,<br/>Team Cimplyfive"
    	    );
//	public static final String REGISTRATION_SUCCESSFUL_BODY = "You have successfully registered to our mailing service and will receive periodic digest starting now.";
	public static final String REGISTRATION_SUCCESSFUL_SUBJECT = "Registration for digest successful";
	
	public static String[] getParametersForSimpleEmail(UserDTO dto, String messageSubject, String messageBody) {
		String[] parameters = new String[5];
		parameters[0] = dto.getEmail();
		parameters[1] = "appevently@gmail.com";
		parameters[2] = "cimplyfive-email-demo";
		parameters[3] = messageSubject;
		parameters[4] = messageBody;
		return parameters;
	}
}
