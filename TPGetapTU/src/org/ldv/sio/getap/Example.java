package org.ldv.sio.getap;

import org.omg.CORBA.portable.ValueOutputStream;
import java.sql.Date;

public class Example {

	static DemandeValidationConsoTempsAccPers dvctap;

	
	public Example(){
		
	}
	
	static public void main(String[] args) {
		Classe classe = new Classe(1, "SIO22");
		Discipline discipline = new Discipline(1, "SLAM4");
		User eleve = new User(1l, "Nizar", "Ben la", classe, "eleve","Nizoo","","nizar@gmail.com");
		User prof = new User(2l, "Oliver", "Capuzzo", classe, "prof",
				discipline);
		
		AccPersonalise accPers = new AccPersonalise(1, "Salon du libre", 0, 1l);
		Date date = Date.valueOf("2012-10-07");

		dvctap = new DemandeValidationConsoTempsAccPers(1l, "2012-2013", date,
				240, prof, accPers, eleve, 0);
		
		System.out.println(dvctap);
		dvctap.setEtat(4);
		System.out.println(dvctap);
		dvctap.setEtat(32);
		System.out.println(dvctap);
		dvctap.setEtat(4);
		System.out.println(dvctap);
		dvctap.setEtat(2048);
		System.out.println(dvctap);
		dvctap.setEtat(2);
		System.out.println(dvctap);
		dvctap.setEtat(32);
		System.out.println(dvctap);
	}
}
