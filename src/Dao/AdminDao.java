package Dao;

import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.Update;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import GestionReservations.Reservation;
import GestionSallesMachines.Machine;
import GestionSallesMachines.Salle;
import GestionUtilisateurs.Admin;
import GestionUtilisateurs.Etudiant;


public class AdminDao {
	public AdminDao() {}

	/**
	 * Authentification d'un admin
	 */
	public Admin login(String id,String password) {
		String sqladmin = "select * from admin where ida=? and passworda=? ";//faut coorriger le password dans bd admin
		Admin ares = null;
		Query();
		parameter.add(id);
		parameter.add(password);
		afferentSQL(sqladmin);
		List<Object> objs = Select();

		if (objs.size()!=0) {
			Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
			ares = new Admin();
			ares.setIdentifiant((String) rowData.get("ida"));
			ares.setMdp((String)rowData.get("passwoda"));
			ares.setNom((String)rowData.get("noma"));
			ares.setPrenom((String)rowData.get("prenoma"));
			System.out.println("welcom "+rowData.get("noma"));
			return ares; } 

		else {
			System.out.println("pwd wrong");
			return null;

		}
	}


	/**
	 *  Afficher toutes les machines
	 */
	ArrayList<Machine> lstMachine;
	ArrayList<Etudiant> lstEtudiant;
	public ArrayList<Machine> tousmachine ()
	{
		String sqlreserver = "select * from machine";
		Query(); 
		afferentSQL(sqlreserver);
		this.lstMachine= new ArrayList<Machine>();
		List<Object> objs = Select();
		for (int i = 0; i < objs.size(); i++) {
			Map<String, Object> rowData = (Map<String, Object>) objs.get(i);
			Machine machine= new Machine();
			machine.setNumMachine((String)rowData.get("numma"));
			machine.setSalle(new Salle((String)rowData.get("numsalle")));
			lstMachine.add(machine);
		}

		return lstMachine;
	}



	/**
	 * Afficher tous les comptes des eleves
	 * @return
	 */
	public ArrayList<Etudiant> tousEtudiant (){
		String sqlreserver = "select * from etudiant";
		Query(); 
		afferentSQL(sqlreserver);
		this.lstEtudiant= new ArrayList<Etudiant>();
		List<Object> objs = Select();
		for (int i = 0; i < objs.size(); i++) {
			Map<String, Object> rowData = (Map<String, Object>) objs.get(i);
			Etudiant etudiant= new Etudiant();
			etudiant.setIdentifiant((String)rowData.get("ide"));
			etudiant.setMdp((String)rowData.get("passworde"));
			etudiant.setNom((String)rowData.get("nome"));
			etudiant.setPrenom((String)rowData.get("prenome"));
			lstEtudiant.add(etudiant);
		}
		return lstEtudiant;
	}
	
	/**
	 * Recuperer toutes les salles
	 */
	public ArrayList<Salle> toutesSalles () {
		String sqlreserver = "select numsalle from machine group by numsalle";
		Query(); 
		afferentSQL(sqlreserver);
		ArrayList<Salle> lstSalles = new ArrayList<Salle>();
		List<Object> objs = Select();
		for (int i = 0; i < objs.size(); i++) {
			Map<String, Object> rowData = (Map<String, Object>) objs.get(i);
			Salle salle = new Salle((String)rowData.get("numsalle"));
			lstSalles.add(salle);
		}

		return lstSalles;
	}

	/**
	 * Supprimer un compte etudiant
	 * @return true si compte supprime, false sinon
	 */
	public boolean supprimerEtudiant(Etudiant etu) {
		String sql="DELETE FROM etudiant WHERE ide=?";
		Query();
		afferentSQL(sql);
		parameter.add(etu.getIdentifiant());
		int ligne=Update();
		return ligne >= 1;
	}

	/**
	 * Supprimer une machine
	 * @return true si machine supprime, false sinon
	 */
	public boolean supprimerMachine(Machine machine) {
		String sql="DELETE FROM machine WHERE numma=?";
		Query();
		afferentSQL(sql);
		parameter.add(machine.getNumMachine());
		int ligne=Update();
		return ligne >= 1;
	}
	

/*  Mettre une reservation EN RECLAMATION reservation
	*  @return true si la reservation, false sinon
	*/
	public boolean traiterReclamation(Reservation reservation) {
		String sql = "UPDATE reserver "
				+ "SET etatr = 'RESERVEE' "
				+ "WHERE numma = ? "
				//+ "AND ide = ? "
				+ "AND jour = ? "
				+ "AND heuredebr = ? "
				+ "AND heurefinr = ? ";
				//+ "AND creneau = ?";	

			Query();
			parameter.add(reservation.getMachine().getNumMachine());
			//parameter.add(reservation.getIdee());
			parameter.add(reservation.getJour());
			parameter.add(reservation.getHeureDeb());
			parameter.add(reservation.getHeureFin());
			//parameter.add(reservation.getCreaneau());
			afferentSQL(sql);			
			int ligne=Update();
			return ligne >= 1;
		}
	
	/* recuperer les machines qui sont passees en reclamation*/

	ArrayList<Reservation> machinesSignalees;
	public ArrayList<Reservation> machinesSignalees(){
		String sql ="select * from reserver,machine "
				+ "where reserver.numma = machine.numma "
				+ "and reserver.etatr = 'EN RECLAMATION' ";
		
		Query(); 		
		afferentSQL(sql);
		this.machinesSignalees = new ArrayList<Reservation>();
		List<Object> objs = Select();
		for (int i = 0; i < objs.size(); i++) {
			Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
			Machine pc= new Machine();
			Reservation rr= new Reservation();//ici

			pc.setSalle(new Salle((String)rowData.get("numsalle")));
			pc.setNumMachine((String)rowData.get("numma"));
			rr.setMachine(pc);//ici
			rr.setJour((String)rowData.get("jour"));//ici
			rr.setHeureDeb((String)rowData.get("heuredebr"));//ici
			rr.setHeureFin((String)rowData.get("heurefinr"));//ici
			machinesSignalees.add(rr);
		}
		System.out.println(machinesSignalees);
		return machinesSignalees;
	}

	// tester
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDao a1 = new AdminDao();	
		//a1.login("1","2");
		//a1.tousmachine();
		//a1.tousetudiant();
		Etudiant etu1 =new Etudiant();
		// etu1.setIdentifiant("e4");
		// a1.supprimerEtudiant(etu1);

		Machine  ma1 = new Machine();
		ma1.setNumMachine("ma7");
		a1.supprimerMachine(ma1);
	}


}