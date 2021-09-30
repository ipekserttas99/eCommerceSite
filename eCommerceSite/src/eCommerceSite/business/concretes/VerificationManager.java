package eCommerceSite.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.LabelUI;

import eCommerceSite.business.abstracts.VerificationService;
import eCommerceSite.entities.concretes.User;

public class VerificationManager implements VerificationService{

	List<String> verificatedEmails = new ArrayList<>();
	
	@Override
	public void sendVerifyMail(String email) {
		System.out.println(email + " kullanýcýya doðrulama maili gönderildi. Lütfen doðrulayýnýz. ");
		link();
		
	}
	
	public void link() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("Doðrulama kodunuz mailinizdir. Lütfen giriniz: ");
		String kod = girdi.next();
		System.out.println("Kod aktive edildi: "+kod);
		verifyMail(kod);
		
	}
	
	@Override
	public void verifyMail(String email) {
		System.out.println(email + " doðrulandý. ");
		verificatedEmails.add(email);
		System.out.println("Giriþ yapýldý: "+email);
		
	}

	@Override
	public boolean checkVerifyAccount(String email) {
		if(verificatedEmails.contains(email)) {
			System.out.println("Bu mail doðrulanmýþ. ");
			verificatedEmails.add(email);
			return true;
		}
		else{
			System.out.println("Bu mail adresi doðrulanmadý. ");
			link();
			return false;
		}
		
	}



}
