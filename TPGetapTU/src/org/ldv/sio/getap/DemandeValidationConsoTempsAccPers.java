package org.ldv.sio.getap;

import java.sql.Date;

/**
 * Demande de validation d'un temps d'accompagnement personnalisé
 * 
 * 
 */

public class DemandeValidationConsoTempsAccPers {
	private static final int DATE_MODIFIEE = 1024;
	private static final int DUREE_MODIFIEE = 2048;
	private static final int AP_MODIFIEE = 4096;

	/**
	 * Identifiant de la DCTAP
	 */
	private Long id;
	/**
	 * Année scolaire de la demande, par exemple "2011-2012"
	 */
	private String anneeScolaire;
	/**
	 * Date de réalisation de l'accompagnement
	 * 
	 */
	private java.sql.Date dateAction;
	/**
	 * Nombre de minutes d'accompagnement personnalisé à valider
	 */
	private Integer minutes;
	/**
	 * Professeur ayant assuré l'accompagnement personnalisé
	 */
	private User prof;
	/**
	 * Nature de l'accompagnement personnalisé associé à la demande
	 */
	private AccPersonalise accPers;
	/**
	 * Identifiant de l'élève ayant réalisé l'accompagnement personnalisé
	 */
	private User eleve;

	/**
	 * 
	 */
	private int etat;

	/**
	 * constructeur par défaut
	 */
	public DemandeValidationConsoTempsAccPers() {

	}

	/**
	 * Constructeur permettant de créer une demande complète.
	 * 
	 * @param id peut être null (moment de la creation)
	 *            
	 * @param anneeScolaire
	 * @param date
	 * @param minutes
	 * @param prof
	 * @param accPers
	 * @param eleve 
	 * @param etat
	 */
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire, Date date,
			Integer minutes, User prof, AccPersonalise accPers, User eleve,
			int etat) {
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
	
	public DemandeValidationConsoTempsAccPers(Long id, String anneeScolaire, Date date,
			Integer minutes, User prof, AccPersonalise accPers, User eleve) {
		this(id,anneeScolaire,date,minutes,prof,accPers,eleve,0);
	}

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
	 * Permet de modifier l'état de la demande
	 * 
	 * @param etat
	 *            prend ses valeur dans :
	 *            <ul>
	 *            <li>0 - demande créée par l'élève</li>
	 *            <li>1 - demande acceptée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>2 - demande rejetée par l'élève aprés modification du
	 *            professeur</li>
	 *            <li>4 - demande modifiée par l'élève</li>
	 *            <li>8 - demande annulée par l'élève</li>
	 *            <li>32 - demande validée par le professeur</li>
	 *            <li>64 - demande refusée par le professeur</li>
	 *            <li>1024 - demande où la date a été modifiée par le professeur
	 *            </li>
	 *            <li>2048 - demande où la durée a été modifiée par le
	 *            professeur</li>
	 *            <li>4096 - demande où l'accompagnement personnalisé a été
	 *            modifiée par le professeur</li>
	 *            </ul>
	 */
	
	private static final int DVCTAP_CREER = 0;
	private static final int DVCTAP_ACCEPTERMOFPROF = 1;
	private static final int DVCTAP_REJETEE = 2;
	private static final int DVCTAP_MODELEVE = 4;
	private static final int DVCTAP_ANNULE = 8;
	private static final int DVCTAP_VALPROF = 32;
	private static final int DVCTAP_REFUSE= 64;
	private static final int DVCTAP_DATEMOD = 1024;
	private static final int DVCTAP_DUREEMOD = 2048;
	private static final int DVCTAP_ACCPERSMOD = 4096;
	
	public void setEtat(int etat) {
		this.etat = etat;
	}

	
	@Override
	public String toString() {
		return "DemandeConsoTempsAccPers [id=" + id + ", anneeScolaire="
				+ anneeScolaire + ", dateAction=" + dateAction + ", minutes="
				+ minutes + ", prof=" + prof + ", accPers=" + accPers
				+ ", eleve=" + eleve + ", etat=" + etat + "]";
	}

	public boolean isEtatInitial() {
		if (etat==0){
			return true;
		}
		return false;
	}
	
	public boolean isEtatAccepteEleveApresModif() {
		boolean acccepter = (this.etat & DVCTAP_ACCEPTERMOFPROF) != 0;
		return acccepter;
	}
	
	public boolean isEtatRejeterEleveApresModif() {
		boolean rejeter = (this.etat & DVCTAP_REJETEE) != 0;
		return rejeter;
	}
	
	public boolean isEtatModifierEleve() {
		boolean modifierEleve = (this.etat & DVCTAP_MODELEVE) != 0;
		return modifierEleve;
	}
	
	public boolean isEtatAnnulerEleve() {
		boolean annulEleve = (this.etat & DVCTAP_ANNULE) != 0;
		return annulEleve;
	}
	
	public boolean isEtatValiderProf() {
		boolean validationProf = (this.etat & DVCTAP_VALPROF) != 0;
		return validationProf;
	}
	
	public boolean isEtatRefuserProf() {
		boolean refuserProf = (this.etat & DVCTAP_REFUSE) != 0;
		return refuserProf;
	}
	
	public boolean isEtatDemandeModifierDateProf() {
		boolean modfiDateProf = (this.etat & DVCTAP_DATEMOD) != 0;
		return modfiDateProf;
	}
	
	public boolean isEtatDemandeDureeModifierProf() {
		boolean modifDureProf = (this.etat & DVCTAP_DUREEMOD) != 0;
		return modifDureProf;
	}
	
	public boolean isEtatDemandeAccPersModifierProf() {
		boolean modifAccPers = (this.etat & DVCTAP_ACCEPTERMOFPROF) != 0;
		return modifAccPers;
	}
	


}
