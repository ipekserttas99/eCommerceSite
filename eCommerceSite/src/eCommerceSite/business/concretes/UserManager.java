package eCommerceSite.business.concretes;

import eCommerceSite.business.abstracts.UserCheckService;
import eCommerceSite.business.abstracts.UserService;
import eCommerceSite.business.abstracts.VerificationService;
import eCommerceSite.core.GoogleService;
import eCommerceSite.dataAccess.abstracts.UserDao;
import eCommerceSite.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private UserCheckService checkService;
	private VerificationService verificationService;
	private GoogleService googleService;
	  
		
	public UserManager(UserDao userDao, UserCheckService checkService, VerificationService verificationService,GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.checkService = checkService;
		this.verificationService = verificationService;
		this.googleService = googleService;
	}

	@Override
	public void signIn(User user) {
		if(checkService.isValid(user)==true) {
			if(verificationService.checkVerifyAccount(user.getEmail())==true){
				System.out.println(user.getFirstName()+" ile giriþ yapýldý.");
			}
		}
		else if(checkService.isValid(user)==true) {
			if(verificationService.checkVerifyAccount(user.getEmail())==false){
				verificationService.sendVerifyMail(user.getEmail());
				
			}
		}
		else if(!checkService.isValid(user)) {
			System.out.println("Bilgileriniz hatalý! ");
		}
		
	}

	@Override
	public void signUp(User user) {
		if(checkService.isValid(user)) {
			System.out.println(user.getFirstName()+" ile kaydoldu.");
			verificationService.sendVerifyMail(user.getEmail());
			this.userDao.add(user);
		}
		else if(!checkService.isValid(user))	{
			System.out.println("Bilgilerinizi kontrol ediniz! ");
		}
		
	}

}
