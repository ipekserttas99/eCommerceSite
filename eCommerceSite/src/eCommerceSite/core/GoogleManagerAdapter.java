package eCommerceSite.core;

import eCommerceSite.Google.GoogleManager;

public class GoogleManagerAdapter implements GoogleService{

	@Override
	public void signUpGoogle(String message) {
		GoogleManager google = new GoogleManager();
		google.signUpWithGoogle(message);
		
	}
	
}
