package eCommerceSite;

import eCommerceSite.Google.GoogleManager;
import eCommerceSite.business.abstracts.UserService;
import eCommerceSite.business.concretes.UserCheckManager;
import eCommerceSite.business.concretes.UserManager;
import eCommerceSite.business.concretes.VerificationManager;
import eCommerceSite.core.GoogleManagerAdapter;
import eCommerceSite.dataAccess.concretes.HibernateUserDao;
import eCommerceSite.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new HibernateUserDao(), new UserCheckManager(), new VerificationManager(), new GoogleManagerAdapter());
		
		User jungkook = new User();
		jungkook.setId(1);
		jungkook.setFirstName("Jungkook");
		jungkook.setLastName("Jeon");
		jungkook.setEmail("jeonj@hotmail.com");
		jungkook.setPassword("010997");
		
		User namjoon = new User();
		namjoon.setId(2);
		namjoon.setFirstName("namjoon");
		namjoon.setLastName("kim");
		namjoon.setEmail("kimnamjoon@gmail.com");
		namjoon.setPassword("120994");
		
		User jennie = new User();
		jennie.setId(3);
		jennie.setFirstName("jennie");
		jennie.setLastName("kim");
		jennie.setEmail("kimjennie@gmail.com");
		jennie.setPassword("160196");
		
		//userService.signIn(namjoon);
		userService.signIn(jennie);
	}

}
