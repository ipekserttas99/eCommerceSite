package eCommerceSite.business.abstracts;

import eCommerceSite.entities.concretes.User;

public interface UserCheckService {
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkEmail(User user);
	boolean checkVerifiedEmail(User user);
	boolean checkPassword(User user);
	boolean isValid(User user);
	boolean checkGoogle(User user);
}
