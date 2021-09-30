package eCommerceSite.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import eCommerceSite.business.abstracts.UserCheckService;
import eCommerceSite.entities.concretes.User;

public class UserCheckManager implements UserCheckService{

	List<String> listOfEmaiList = new ArrayList<>();
	
	@Override
	public boolean checkFirstName(User user) {
		if(user.getFirstName().isEmpty()==true) {
			System.out.println("Ýsim alaný boþ geçilemez! ");
			return false;
		}else if(user.getFirstName().length()<2) {
			System.out.println("Ýsim en az 2 karakterden oluþmalýdýr! ");
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public boolean checkLastName(User user) {
		if(user.getLastName().isEmpty()) {
			System.out.println("Soyisim alaný boþ geçilemez! ");
			return false;
		}else if(user.getLastName().length()<2) {
			System.out.println("Soyisim en az 2 karakterden oluþmalýdýr! ");
			return false;
		}else {
			return true;
		}
		
	}
	
	@Override
	public boolean checkEmail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		if(user.getEmail().isEmpty()) {
			System.out.println("Email alaný boþ geçilemez! ");
			return false;
		}else if(pattern.matcher(user.getEmail()).find() == false) {
			System.out.println("Email adresinizi formata uygun giriniz. Örnek: example@example.com ");
			return false;
		}else {
			return true;
		}
		
	}
	
	@Override
	public boolean checkVerifiedEmail(User user) {
		if (listOfEmaiList.contains(user.getEmail())) {
			System.out.println("Bu mail adresi kullanýmda! ");
			return false;
		}
		else {
			listOfEmaiList.add(user.getEmail());
			return true;
		}
		
	}

	@Override
	public boolean checkPassword(User user) {
		if(user.getPassword().isEmpty()) {
			System.out.println("Parola kýsmý boþ geçilemez! ");
			return false;
		}else if(user.getPassword().length()<6){
			System.out.println("Parola en az 6 karakterden oluþmalýdýr! ");
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public boolean checkGoogle(User user) {
		String regex = "gmail.com";
		if(user.getEmail().contains(regex)) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean isValid(User user) {
		if(checkFirstName(user) && checkLastName(user)&& checkEmail(user)&&checkPassword(user)&&checkVerifiedEmail(user)==true) {
			return true;
		}else if(checkFirstName(user) && checkLastName(user)&& checkEmail(user)&&checkPassword(user)&&checkGoogle(user)&&checkVerifiedEmail(user)==true) {
			return true;
		}else {
			return false;
		}
		
	}

	

}
