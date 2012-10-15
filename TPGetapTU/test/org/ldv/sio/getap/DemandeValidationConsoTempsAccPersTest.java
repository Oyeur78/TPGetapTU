package org.ldv.sio.getap;

import static org.junit.Assert.*;

import java.sql.Date;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class DemandeValidationConsoTempsAccPersTest extends TestCase{
	
	private DemandeValidationConsoTempsAccPers dvctap;
	
	@Before
	public void setUp() throws Exception {
		Classe classe = new Classe(1, "SIO22");
		Discipline discipline = new Discipline(1, "SLAM4");
		User eleve = new User(1l, "Nizar", "Ben la", classe, "eleve","Nizoo","","nizar@gmail.com");
		User prof = new User(2l, "Oliver", "Capuzzo", classe, "profPrincipal",
				discipline);
		
		AccPersonalise accPers = new AccPersonalise(1, "Salon du libre", 0, 1l);
		Date date = Date.valueOf("2012-10-07");

		dvctap = new DemandeValidationConsoTempsAccPers(1l, "2012-2013", date,
				240, prof, accPers, eleve);
	}

	@Test
	public void testEtatInitial() {
		assertTrue("Etat initial", dvctap.isEtatInitial());
	}
	
	@Test
	public void testMultipleEtat() {
		dvctap.modifieeParEleve();
		dvctap.modifieeParEleve();
		dvctap.modifieeDateParLeProfesseur();
		dvctap.modifieeDureeParLeProfesseur();
		dvctap.accepteeParEleve();
		assertFalse("AcceptÃ© par l'Ã©lÃ¨ve!", dvctap.accepteeParEleve());
	}
	
	@Test
	public void testModifieeEleve(){
		dvctap.modifieeParEleve();
		// dvctap.modifieeDateParLeProfesseur();
		assertTrue("L'Etat ne peux pas Ãªtre changer",dvctap.getEtat() == 4 );
	}
	
	@Test
	public void testModEleveValidProf() {
		dvctap.modifieeParEleve();
		dvctap.valideeParLeProfesseur();
		assertFalse("Valider par le professeur!", dvctap.valideeParLeProfesseur());
	}
	
	@Test
	public void testModElevePuisAccepterEleve(){
		dvctap.modifieeDateParLeProfesseur();
		dvctap.accepteeParEleve();
		assertFalse("Accepter par l'Ã©lÃ¨ve", dvctap.modifieeParEleve());
	}
	
	@Test
	public void testValiderProfPuisRefuserEleve(){
		dvctap.valideeParLeProfesseur();
		dvctap.rejeteParEleve();
		assertFalse("RejetÃ© par l'Ã©lÃ¨ve", dvctap.valideeParLeProfesseur());
	}
	

}

