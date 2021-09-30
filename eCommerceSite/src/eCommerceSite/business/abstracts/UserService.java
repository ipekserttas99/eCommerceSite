package eCommerceSite.business.abstracts;

import eCommerceSite.entities.concretes.User;

public interface UserService {
	void signIn(User user);
	void signUp(User user);
}
