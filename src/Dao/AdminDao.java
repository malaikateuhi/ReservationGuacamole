package Dao;

import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import GestionReservations.Reservation;
import GestionSallesMachines.Machine;
import GestionUtilisateurs.Admin;
import GestionUtilisateurs.Etudiant;


public class AdminDao {
	public AdminDao() {}
	public Admin login(String id,String password) {

	    String sqladmin = "select * from admin where ida=? and passworda=? ";//faut coorriger le password dans bd admin
	    Admin ares = null;
	    Query();
	    parameter.add(id);
	    parameter.add(password);
	    afferentSQL(sqladmin);
	    List<Object> objs = Select();
	    System.out.println(objs.get(0));
	    Map<String, Object> rowData =(Map<String, Object>)objs.get(0);

           if (objs.size()!=0) {
	    	/*
	    	  ares = new Admin();
	          ares.setNuma((String) rowData.get("ida"));
	          ares.setPassword((String)rowData.get("passwoda"));
	          ares.setNom((String)rowData.get("noma"));
	          ares.setPrenom((String)rowData.get("prenoma"));
	         */ 
	    	System.out.println("welcom "+rowData.get("noma"));
	    	return ares;
	    	  
	    }
	    else {
	    return null;}
	    }
	
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
	        	machine.setNumMachine((String)rowData.get("jour"));
	        	machine.setEtat((String)rowData.get("etatr"));
	            lstMachine.add(machine);
	        }
		return lstMachine;
	}

	
	
	public ArrayList<Etudiant> tousetudiant (){
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
	
	///////////Arslane debut
	
	/*  Mettre une reservation EN RECLAMATION à reservé
	*  @return true si la reservation, false sinon
	*/
	public boolean traiterReclamation(Machine machine /*mais je suis pas sur des données a mettre en entrée*/) {
		String sql = "UPDATE reserver "
				+ "SET etatr = 'RESERVEE' "
				+ "WHERE numma = ? "
				+ "AND ide = ? "
				+ "AND jour = ? "
				+ "AND heuredebr = ? "
				+ "AND heurefinr = ?"
				+ "AND creneau = ?";	

			Query();
			parameter.add(reservation.getMachine().getNumMachine());
			parameter.add(reservation.getIdee());
			parameter.add(reservation.getJour());
			parameter.add(reservation.getHeureDeb());
			parameter.add(reservation.getHeureFin());
			parameter.add(reservation.getCreneau());
			afferentSQL(sql);			
			int ligne=Update();
			return ligne >= 1;
		}
	
	/* recuperer les machines qui sont passées en réclamation*/

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

			pc.setSalle(new Salle((String)rowData.get("numSalle")));
			pc.setNumMachine((String)rowData.get("numma"));
			rr.setMachine(pc);//ici
			rr.setJour((String)rowData.get("jour"));//ici
			rr.setHeureDeb((String)rowData.get("heuredeb"));//ici
			rr.setHeureFin((String)rowData.get("heurefin"));//ici
			machinesSignalees.add(rr);
		}
		System.out.println(machinesSignalees);
		return machinesSignalees;
	}
	///////////Arslane fin
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDao a1 = new AdminDao();	
		a1.login("1","2");
	}

	
}
