package controleur;

import java.util.ArrayList;
import java.util.HashMap;

import Dao.*;
import GestionReservations.Reservation;
import GestionReservations.Seance;
import GestionSallesMachines.Machine;
import GestionSallesMachines.Salle;
import GestionUtilisateurs.Admin;
import GestionUtilisateurs.Enseignant;
import GestionUtilisateurs.Etudiant;

public class Controleur {

	private AdminDao adminDao;
	private EnseignantDao enseignantDao;
	private EtudiantDao etudiantDao;	
	private MachineDao machineDao;


	public Controleur() {
		this.adminDao = new AdminDao();
		this.enseignantDao = new EnseignantDao();
		this.etudiantDao = new EtudiantDao();
		this.machineDao = new MachineDao();
	}

	/****************************************/
	/*		CONNEXIONS UTILISATEURS 		*/
	/****************************************/

	public Etudiant connecterEtudiant(String id, String pwd) {
		return etudiantDao.login(id, pwd);
	}

	public Enseignant connecterEnseignant(String id, String pwd) {
		return enseignantDao.login(id, pwd);
	}

	public Admin connecterAdmin(String id, String pwd) {
		return adminDao.login(id, pwd);
	}

	/****************************************/
	/* 		METHODES POUR ETUDIANT 			*/
	/****************************************/

	/**
	 * Recommander une machine pour une seance prevue d'un etudiant
	 * @param idEtudiant identifiant de l'etudiant
	 * @param jour date de la seance
	 * @param creneau numero de creneau de la seance
	 * @return HashMap avec le numero de machine, la salle, le numero de seance, le nom du cours
	 */
	public HashMap<String, String> machinePourCours (String idEtudiant, String jour, int creneau) {
		HashMap<String, String> donnesMachine = new HashMap<String , String>();

		Etudiant etudiant = new Etudiant(idEtudiant);
		Seance seance = etudiantDao.avoirseance(etudiant, jour, creneau);
		Salle salle = etudiantDao.recommande(etudiant, jour, creneau);		
		Machine machine = etudiantDao.machinelibre(salle, jour, creneau);


		donnesMachine.put("machine", machine.getNumMachine());
		donnesMachine.put("salle", salle.getNomSalle());
		donnesMachine.put("seance", machine.getNumMachine());
		donnesMachine.put("cours", machine.getNumMachine());		

		return donnesMachine;		
	}

	/**
	 *  Recommander une machine pour acces libre
	 * @param idEtudiant identifiant de l'etudiant
	 * @param jour date de la reservation
	 * @param creneau creneau de reservation
	 * @return HashMap avec le numéro de machine et la salle
	 */
	public HashMap<String, String> machineAccesLibre (String idEtudiant, String jour, int creneau) {
		HashMap<String, String> donnesMachine = new HashMap<String , String>();

		Etudiant etudiant = new Etudiant(idEtudiant);	
		Machine machine = etudiantDao.choisi(etudiant, jour, creneau);		

		donnesMachine.put("machine", machine.getNumMachine());
		donnesMachine.put("salle", machine.getSalle().getNomSalle());

		return donnesMachine;		
	}

	/**
	 *  Demander une reservation de machine pour un etudiant
	 * @param numMachine numero de la machine
	 * @param idEtudiant numero etudiant
	 * @param jour date de reservation
	 * @param heureDeb heure de debut de reservation
	 * @param heureFin heure de fin de reservation
	 * @param creneau creneau de reservation
	 * @return true si reservation reussie, flase sinon
	 */
	public boolean reserverMachine(String numMachine, String idEtudiant, String jour, String heureDeb, String heureFin, int creneau) {
		Machine machine = new Machine(numMachine);
		Reservation reser = new Reservation(machine, idEtudiant, jour, heureDeb, heureFin, "RESERVEE", creneau);
		return etudiantDao.prendreReservation(reser);
	}

	/**
	 *  Consulter les reservations a venir d'un etudiant
	 * @param idEtudiant numero etudiant
	 * @return liste des reservations
	 */
	public void listeReservationsEtudiant(String idEtudiant) {
		ArrayList<Reservation> reservations = etudiantDao.infoReserver(new Etudiant(idEtudiant));


	}

	/**
	 *  Demander l'annulation d'une reservation par un etudiant	
	 * @param idEtudiant numero etudiant
	 * @param res donnees de la reservation
	 * @return true si annulation reussie, false sinon
	 */
	public boolean annulerReservationEtudiant(String idEtudiant, String res) {
		// "jour heureDeb heureFin numMachine"
		String[] donneesRes = res.split(" ");
		String jour = donneesRes[0];
		String heureDeb = donneesRes[1];
		String heureFin = donneesRes[2];
		int creneau = 0;
		switch(heureDeb) {
		case "09:30" :
			creneau = 0;
			break;
		case "11:00" :
			creneau = 1;
			break;
		case "14:00" :
			creneau = 2;
			break;
		case "15:30" :
			creneau = 3;
			break;
		};
		Reservation reservation = new Reservation(new Machine(donneesRes[3]), idEtudiant, jour, heureDeb, heureFin, "RESERVEE", creneau);
		return etudiantDao.annulerReservation(reservation);
	}

	/**
	 *  Effectuer une reclamation pour une machine reservee
	 * @param res
	 * @return true si signalement effectue, false sinon
	 */
	public boolean effectuerReclamation(String res) {
		String[] donneesRes = res.split(" ");
		String jour = donneesRes[0];
		String heureDeb = donneesRes[1];
		String heureFin = donneesRes[2];
		String numMachine = donneesRes[3];
		Reservation reservation = new Reservation();
		reservation.setMachine(new Machine(numMachine));
		reservation.setJour(jour);
		reservation.setHeureDeb(heureDeb);
		reservation.setHeureFin(heureFin);
		return etudiantDao.signalerReservation(reservation);
	}

	/****************************************/
	/* 		METHODES POUR ENSEIGNANT 		*/
	/****************************************/

	// Demander l'annulation d'une seance

	// Consulter les seances a venir d'un enseignant

	// Consulter les reservations pour une seance


	/****************************************/
	/* 		METHODES POUR ADMIN 			*/
	/****************************************/

	/**
	 *  Consulter les machines en reclamation
	 * @return
	 */
	public Object[][] consulterReclamations() {
		ArrayList<Reservation> machinesRes = adminDao.machinesSignalees();
		Object[][] listeMachines = new Object[machinesRes.size()][5];

		for(int i = 0 ; i < machinesRes.size() ; i++) {
			listeMachines[i][0] = machinesRes.get(i).getJour();
			listeMachines[i][1] = machinesRes.get(i).getHeureDeb();
			listeMachines[i][2] = machinesRes.get(i).getHeureFin();			
			listeMachines[i][3] = machinesRes.get(i).getMachine().getSalle().getNomSalle();
			listeMachines[i][4] = machinesRes.get(i).getMachine().getNumMachine();
		}

		return listeMachines;
	}

	/**
	 *  Traiter une machine en reclamation
	 * @param numMachine numero de machine en reclamation
	 */
	public void traiterReclamation(String numSalle, String numMachine, String jour, String heureDeb, String heureFin) {
		Salle salle = new Salle(numSalle);
		Machine machine = new Machine(numMachine, salle);
		Reservation reservation = new Reservation();
		reservation.setMachine(machine);
		reservation.setJour(jour);
		reservation.setHeureDeb(heureDeb);
		reservation.setHeureFin(heureFin);
		adminDao.traiterReclamation(reservation);
	}

	/**
	 *  Consulter les machines
	 * @return
	 */
	public String[] consulterMachines() {
		ArrayList<Machine> machines = adminDao.tousmachine();
		String[] numMachines = new String[machines.size()];

		for(int i = 0 ; i < machines.size() ; i++) {
			numMachines[i] = machines.get(i).getNumMachine();
		}

		return numMachines;
	}


	/**
	 *  Consulter les salles
	 * @return
	 */
	public String[] consulterSalles() {
		ArrayList<Salle> salles = adminDao.toutesSalles();
		String[] numSalles = new String[salles.size()];

		for(int i = 0 ; i < salles.size() ; i++) {
			numSalles[i] = salles.get(i).getNomSalle();
		}

		return numSalles;
	}

	/**
	 *  Consulter les comptes etudiants
	 */
	public Object[][] consulterComptes() {
		ArrayList<Etudiant> comptes = adminDao.tousEtudiant();
		Object[][] listeComptes = new Object[comptes.size()][3];

		for(int i = 0 ; i < comptes.size() ; i++) {
			listeComptes[i][0] = comptes.get(i).getIdentifiant();
			listeComptes[i][1] = comptes.get(i).getNom();
			listeComptes[i][2] = comptes.get(i).getPrenom();
		}

		return listeComptes;
	}

	/**
	 *  Supprimer une machine
	 * @param num numero de machine
	 * @return
	 */
	public boolean supprimerMachine(String num) {
		Machine machine = new Machine(num);
		return adminDao.supprimerMachine(machine); 
	}

	/**
	 *  Supprimer une salle
	 * @param num numero de salle
	 * @return true si salle supprime, false sinon
	 */
	public boolean supprimerSalle(String num) {
		Salle salle = new Salle(num);
		//return adminDao.supprimerSalle(salle); // A implementer
		return true;
	}

	/**
	 * Supprimer un compte etudiant
	 * @param id numero etudiant
	 * @return true si compte supprime, false sinon
	 */
	public boolean supprimerCompte(String id) {
		Etudiant etu = new Etudiant(id);
		return adminDao.supprimerEtudiant(etu);
	}

	////// NON IMPLEMENTE
	
	// Modifier une machine

	// Modifier une salle

	// Modifier un compte etudiant

	// Ajouter une machine

	// Ajouter une salle

	// Ajouter un compte etudiant	



}
