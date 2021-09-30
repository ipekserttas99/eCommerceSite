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
		System.out.println(email + " kullan�c�ya do�rulama maili g�nderildi. L�tfen do�rulay�n�z. ");
		link();
		
	}
	
	public void link() {
		Scanner girdi = new Scanner(System.in);
		System.out.print("Do�rulama kodunuz mailinizdir. L�tfen giriniz: ");
		String kod = girdi.next();
		System.out.println("Kod aktive edildi: "+kod);
		verifyMail(kod);
		
	}
	
	@Override
	public void verifyMail(String email) {
		System.out.println(email + " do�ruland�. ");
		verificatedEmails.add(email);
		System.out.println("Giri� yap�ld�: "+email);
		
	}

	@Override
	public boolean checkVerifyAccount(String email) {
		if(verificatedEmails.contains(email)) {
			System.out.println("Bu mail do�rulanm��. ");
			verificatedEmails.add(email);
			return true;
		}
		else{
			System.out.println("Bu mail adresi do�rulanmad�. ");
			link();
			return false;
		}
		
	}



}
