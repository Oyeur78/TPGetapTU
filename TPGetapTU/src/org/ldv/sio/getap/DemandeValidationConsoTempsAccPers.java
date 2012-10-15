package org.ldv.sio.getap;

import java.sql.Date;

/**
 * Demande de validation d'un temps d'accompagnement personnalisÃ©
 * 
 */

public class DemandeValidationConsoTempsAccPers {
	/**
	 * Les etats
	 */
	private static final int DVCTAP_CREER = 0;
	private static final int DVCTAP_ACCEPTERMOFPROF = 1;
	private static final int DVCTAP_REJETEE = 2;
	private static final int DVCTAP_MODELEVE = 4;
	private static final int DVCTAP_ANNULE = 8;
	private static final int DVCTAP_VALPROF = 32;
	private static final int DVCTAP_REFUSE = 64;
	private static final int DVCTAP_DATEMOD = 1024;
	private static final int DVCTAP_DUREEMOD = 2048;
	private static final int DVCTAP_ACCPERSMOD = 4096;

	/**
	 * Identifiant de la DCTAP
	 */
	private Long id;
	/**
	 * AnnÃ©e scolaire de la demande, par exemple "2011-2012"
	 */
	private String anneeScolaire;
	/**
	 * Date de rÃ©alisation de l'accompagnement
	 * 
	 */
	private java.sql.Date dateAction;
	/**
	 * Nombre de minutes d'accompagnement personnalisÃ© Ã  valider
	 */
	private Integer minutes;
	/**
	 * Professeur ayant assurÃ© l'accompagnement personnalisÃ©
	 */
	private User prof;
	/**
	 * Nature de l'accompagnement personnalisÃ© associÃ© Ã  la demande
	 */
	private AccPersonalise accPers;
	/**
	 * Identifiant de l'Ã©lÃ¨ve ayant rÃ©alisÃ© l'accompagnement personnalisÃ©
	 */
	private User eleve;

	/**
	 * 
	 */
	private int etat;

	/**
	 * constructeur par dÃ©faut
	 */
	public DemandeValidationConsoTempsAccPers() {

	}

	/**
	 * Constructeur permettant de crÃ©er une demande complÃ¨te.
	 * 
	 * @param id
	 * 
	 *            peut Ãªtre null (moment de la creation)
	 * 
	 * @param anneeScolaire
	 * @param date
	 * @param minutes
	 * @param prof
	 * @param accPers
	 * @param eleve
	 * @param etat
	 */
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire,
			Date date, Integer minutes, User prof, AccPersonalise accPers,
			User eleve, int etat) {
		super();
		this.id = id;
		this.anneeScolaire = anneeScolaire;
		this.dateAction = date;
		this.minutes = minutes;
		this.prof = prof;
		this.accPers = accPers;
		this.eleve = eleve;
		this.etat = etat;
	}
	
	/**
	 * Constructeur permettant de crÃ©er une demande complÃ¨te avec etat a 0
	 * 
	 * @param id
	 * 
	 *            peut Ãªtre null (moment de la creation)
	 * 
	 * @param anneeScolaire
	 * @param date
	 * @param minutes
	 * @param prof
	 * @param accPers
	 * @param eleve
	 * @param etat
	 */
	
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire,
			Date date, Integer minutes, User prof, AccPersonalise accPers,
			User eleve) {
		this(id, anneeScolaire, date, minutes, prof, accPers, eleve, 0);
	}

	/**
	 * getters / setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	public java.sql.Date getDateAction() {
		return dateAction;
	}

	public void setDateAction(java.sql.Date date) {
		this.dateAction = date;
	}

	public Integer getMinutes() {
		return minutes;
	}

	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}

	public User getProf() {
		return prof;
	}

	public void setProf(User prof) {
		this.prof = prof;
	}

	public AccPersonalise getAccPers() {
		return accPers;
	}

	public void setAccPers(AccPersonalise accPers) {
		this.accPers = accPers;
	}

	public User getEleve() {
		return eleve;
	}

	public void setEleve(User eleve) {
		this.eleve = eleve;
	}

	public int getEtat() {
		return etat;
	}

	/**
	 * Permet de modifier l'Ã©tat de la demande
	 * 
	 * @param etat
	 *            prend ses valeur dans :
	 *            <ul>
	 *            <li>0 - demande crÃ©Ã©e par l'Ã©lÃ¨ve</li>
	 *            <li>1 - demande acceptÃ©e par l'Ã©lÃ¨ve aprÃ©s modification du
	 *            professeur</li>
	 *            <li>2 - demande rejetÃ©e par l'Ã©lÃ¨ve aprÃ©s modification du
	 *            professeur</li>
	 *            <li>4 - demande modifiÃ©e par l'Ã©lÃ¨ve</li>
	 *            <li>8 - demande annulÃ©e par l'Ã©lÃ¨ve</li>
	 *            <li>32 - demande validÃ©e par le professeur</li>
	 *            <li>64 - demande refusÃ©e par le professeur</li>
	 *            <li>1024 - demande oÃ¹ la date a Ã©tÃ© modifiÃ©e par le professeur
	 *            </li>
	 *            <li>2048 - demande oÃ¹ la durÃ©e a Ã©tÃ© modifiÃ©e par le
	 *            professeur</li>
	 *            <li>4096 - demande oÃ¹ l'accompagnement personnalisÃ© a Ã©tÃ©
	 *            modifiÃ©e par le professeur</li>
	 *            </ul>
	 */

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	/**
	 * Premet de verifie si l'etat intial est a 0
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isEtatInitial() {
		if (etat == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * On test si l'etat est creer par l'eleve
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isCreeEleve() {
		boolean cree = (this.etat & DVCTAP_CREER) != 0;
		return cree;
	}
	/**
	 * On test si l'etat est accepter par l'eleve apres modification d'un professeur
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isEtatAccepteEleveApresModif() {
		boolean acccepter = (this.etat & DVCTAP_ACCEPTERMOFPROF) != 0;
		return acccepter;
	}
	/**
	 * On test si l'etat est rejeter par l'eleve apres une modification
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isEtatRejeterEleveApresModif() {
		boolean rejeter = (this.etat & DVCTAP_REJETEE) != 0;
		return rejeter;
	}
	/**
	 * On test si l'etat est modifier par l'eleve
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isEtatModifierEleve() {
		boolean modifierEleve = (this.etat & DVCTAP_MODELEVE) != 0;
		return modifierEleve;
	}
	/**
	 * On test si l'etat est annuler par l'eleve
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isEtatAnnulerEleve() {
		boolean annulEleve = (this.etat & DVCTAP_ANNULE) != 0;
		return annulEleve;
	}
	/**
	 * On test si l'etat estvaliderr par le professeur
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isEtatValiderProf() {
		boolean validationProf = (this.etat & DVCTAP_VALPROF) != 0;
		return validationProf;
	}
	/**
	 * On test si l'etat a ete reguser par le professeur
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isEtatRefuserProf() {
		boolean refuserProf = (this.etat & DVCTAP_REFUSE) != 0;
		return refuserProf;
	}
	/**
	 * On test si l'etat est modifier (date) par le professeur
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isEtatModifierDateProf() {
		boolean modfiDateProf = (this.etat & DVCTAP_DATEMOD) != 0;
		return modfiDateProf;
	}
	/**
	 * On test si l'etat est modifier (duree) par le professeur
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isEtatDureeModifierProf() {
		boolean modifDureProf = (this.etat & DVCTAP_DUREEMOD) != 0;
		return modifDureProf;
	}
	/**
	 * On test si l'etat de l'accaompagnement persoanlise a Ã©tÃ© modifier par le professeur
	 * 
	 * @return un boolean de l'etat
	 */
	public boolean isEtatAccPersModifierProf() {
		boolean modifAccPers = (this.etat & DVCTAP_ACCEPTERMOFPROF) != 0;
		return modifAccPers;
	}
	/**
	 * Permet de realiser un masque binaire qui valide ou pas le passage d'un etat a un autre
	 * 
	 * @return un boolean
	 */
	public boolean valideeParLeProfesseur() throws DVCTAPException {
		boolean flag = true;
		if (!this.isEtatAnnulerEleve() && !this.isEtatRefuserProf()
				&& !this.isEtatAccepteEleveApresModif()
				&& !this.isEtatRejeterEleveApresModif()
				&& !this.isEtatValiderProf()) {
			this.etat = this.etat | DVCTAP_VALPROF;
		} else {
			System.out
					.println("La demande ne peux Ãªtre valider par le professeur !");
			flag = false;
		}
		return flag;
	}
	/**
	 * Permet de realiser un masque binaire qui valide ou pas le passage d'un etat a un autre
	 * 
	 * @return un boolean
	 */
	public boolean refuseeParLeProfesseur() throws DVCTAPException {
		boolean flag = true;
		if (!this.isEtatAnnulerEleve() && !this.isEtatValiderProf()
				&& !this.isEtatAccepteEleveApresModif()
				&& !this.isEtatRejeterEleveApresModif()
				&& !this.isEtatRefuserProf()) {
			this.etat = this.etat | DVCTAP_REFUSE;
		} else {
			System.out.println("Erreur lors du changement de l'Ã©tat !");
			flag = false;
		}
		return flag;
	}
	/**
	 * Permet de realiser un masque binaire qui valide ou pas le passage d'un etat a un autre
	 * 
	 * @return un boolean
	 */
	public boolean annuleeParEleve() throws DVCTAPException {
		boolean flag = true;
		if (!this.isEtatValiderProf() && !this.isEtatRefuserProf()
				&& !this.isEtatAccepteEleveApresModif()
				&& !this.isEtatRejeterEleveApresModif()
				&& !this.isEtatAccPersModifierProf()
				&& !this.isEtatDureeModifierProf()
				&& !this.isEtatModifierDateProf() && !this.isEtatAnnulerEleve()) {
			this.etat = this.etat | DVCTAP_ANNULE;
		} else {
			System.out.println("La demande ne peut Ãªtre annulÃ© par l'Ã©lÃ¨ve !");
			flag = false;
		}
		return flag;
	}
	/**
	 * Permet de realiser un masque binaire qui valide ou pas le passage d'un etat a un autre
	 * 
	 * @return un boolean
	 */
	public boolean modifieeParEleve() throws DVCTAPException {
		boolean flag = true;
		if (!this.isEtatValiderProf() && !this.isEtatRefuserProf()
				&& !this.isEtatAccepteEleveApresModif()
				&& !this.isEtatRejeterEleveApresModif()
				&& !this.isEtatAccPersModifierProf()
				&& !this.isEtatDureeModifierProf()
				&& !this.isEtatModifierDateProf() && !this.isEtatAnnulerEleve()) {
			this.etat = this.etat | DVCTAP_MODELEVE;
		} else {
			System.out.println("Erreur lors du changement de l'Ã©tat !");
			flag = false;
		}
		return flag;
	}
	/**
	 * Permet de realiser un masque binaire qui valide ou pas le passage d'un etat a un autre
	 * 
	 * @return un boolean
	 */
	public boolean modifieeDateParLeProfesseur() throws DVCTAPException {
		boolean flag = true;
		if (!this.isEtatValiderProf() && !this.isEtatRefuserProf()
				&& !this.isEtatAccepteEleveApresModif()
				&& !this.isEtatRejeterEleveApresModif()
				&& !this.isEtatAnnulerEleve()) {
			this.etat = this.etat | DVCTAP_DATEMOD;
		} else {
			System.out.println("Erreur lors du changement de l'Ã©tat !");
			flag = false;
		}
		return flag;
	}
	/**
	 * Permet de realiser un masque binaire qui valide ou pas le passage d'un etat a un autre
	 * 
	 * @return un boolean
	 */
	public boolean modifieeDureeParLeProfesseur() throws DVCTAPException {
		boolean flag = true;
		if (!this.isEtatValiderProf() && !this.isEtatRefuserProf()
				&& !this.isEtatAccepteEleveApresModif()
				&& !this.isEtatRejeterEleveApresModif()
				&& !this.isEtatAnnulerEleve()) {
			this.etat = this.etat | DVCTAP_DUREEMOD;
		} else {
			System.out.println("Erreur lors du changement de l'Ã©tat !");
			flag = false;
		}
		return flag;
	}
	/**
	 * Permet de realiser un masque binaire qui valide ou pas le passage d'un etat a un autre
	 * 
	 * @return un boolean
	 */
	public boolean modifieeParLeProfesseur() throws DVCTAPException {
		boolean flag = true;
		if (!this.isEtatValiderProf() && !this.isEtatRefuserProf()
				&& !this.isEtatAccepteEleveApresModif()
				&& !this.isEtatRejeterEleveApresModif()
				&& !this.isEtatAnnulerEleve() && !this.isEtatRefuserProf()) {
			this.etat = this.etat | DVCTAP_ACCPERSMOD;
		} else {
			System.out.println("Erreur lors du changement de l'Ã©tat !");
			flag = false;
		}
		return flag;
	}
	/**
	 * Permet de realiser un masque binaire qui valide ou pas le passage d'un etat a un autre
	 * 
	 * @return un boolean
	 */
	public boolean rejeteParEleve() throws DVCTAPException {
		boolean flag = true;
		if (!this.isEtatValiderProf()
				&& !this.isEtatRefuserProf()
				&& !this.isEtatAccepteEleveApresModif()
				&& !this.isEtatAnnulerEleve()
				&& !this.isEtatValiderProf()
				&& !this.isEtatRejeterEleveApresModif()
				&& (this.isEtatAccPersModifierProf()
						|| this.isEtatModifierDateProf() || this
							.isEtatDureeModifierProf())) {
			this.etat = this.etat | DVCTAP_REJETEE;
		} else {
			System.out.println("La demande ne peux Ãªtre rejetÃ© par l'Ã©lÃ¨ve !");
			flag = false;
		}
		return flag;
	}
	/**
	 * Permet de realiser un masque binaire qui valide ou pas le passage d'un etat a un autre
	 * 
	 * @return un boolean
	 */
	public boolean accepteeParEleve() throws DVCTAPException {
		boolean flag = true;
		if (!this.isEtatValiderProf()
				&& !this.isEtatRefuserProf()
				&& !this.isEtatRejeterEleveApresModif()
				&& !this.isEtatAnnulerEleve()
				&& !this.isEtatValiderProf()
				&& !this.isEtatAccepteEleveApresModif()
				&& (this.isEtatAccPersModifierProf()
						|| this.isEtatModifierDateProf() || this
							.isEtatDureeModifierProf())) {
			this.etat = this.etat | DVCTAP_ACCEPTERMOFPROF;
		} else {
			System.out.println("La demande ne peux Ãªtre acceptÃ© par l'Ã©lÃ¨ve !");
			flag = false;
		}
		return flag;
	}
	/**
	 * Permet l'affichage
	 * 
	 * @return string un recapitulatif de la DVCTAP
	 * 
	 */
	@Override
	public String toString() {
		return "DemandeConsoTempsAccPers [id=" + id + ", anneeScolaire="
				+ anneeScolaire + ", dateAction=" + dateAction + ", minutes="
				+ minutes + ", prof=" + prof + ", accPers=" + accPers
				+ ", eleve=" + eleve + ", etat=" + etat + "]";
	}
}
