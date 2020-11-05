package Dao;
import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.Update;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import GestionReservations.Reservation;
import GestionSallesMachines.Machine;
import GestionSallesMachines.Salle;
import GestionUtilisateurs.Etudiant;


public class EtudiantDao {
public EtudiantDao() {}
public Etudiant login(String id,String password) {

    String sqlclient = "select * from etudiant where ide=? and passworde=? ";
    Etudiant etures = null;
    
    Query();   
    parameter.add(id);
    parameter.add(password);
    afferentSQL(sqlclient);
    List<Object> objs = Select();
    System.out.println(objs.get(0));
    Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
  
    if (objs.size()!=0) {
    	/*
    	  etures = new Etudiant();
          etures.setNume((String) rowData.get("ide"));
          etures.setPassword((String)rowData.get("passwode"));
          etures.setNom((String)rowData.get("nome"));
          etures.setPrenom((String)rowData.get("prenome"));
         */ 
    	System.out.println("welcom "+rowData.get("nome"));
    	return etures;
    	  
    }
    else {
    return null;}
    }

  

ArrayList<Reservation> lstreservation;
public ArrayList<Reservation> hisreserver (Etudiant etudiant)
{
	String sqlreserver = "select * from reserver where ide=? ";
	Query(); 
	parameter.add(etudiant.getIdentifiant());
	afferentSQL(sqlreserver);
	this.lstreservation= new ArrayList<Reservation>();
	  List<Object> objs = Select();
        for (int i = 0; i < objs.size(); i++) {
        	Map<String, Object> rowData = (Map<String, Object>) objs.get(i);
        	Reservation reserver= new Reservation();
        	reserver.setJour((String)rowData.get("jour"));
            reserver.setEtat((String)rowData.get("etatr"));
            reserver.setHeureDeb((String)rowData.get("heuredebr"));
            reserver.setHeureFin((String)rowData.get("heurefinr"));
            lstreservation.add(reserver);
        }
	return lstreservation;
}

public Machine recommande(Etudiant etudiant,Date jour,String time) {
 String avoircours ="select * from passer,etudiant,seance where etudiant.numgroup =seance.numgroup and seance.numseance =passer.numseance and ide=?"
 		+ "and jour=? and creneau=?";
       
        Query(); 
        parameter.add(etudiant.getIdentifiant());
        parameter.add(jour);
        parameter.add(time);
        afferentSQL(avoircours);
        List<Object> objs = Select();
        System.out.println(objs.get(0));
        if (objs.size()!=0) {
        	 Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
        	 Machine machine = new Machine();
        	machine.numMachine=((String)rowData.get("numma")); 
            machine.setEtat((String)rowData.get("etatm"));
            machine.setNumsalle((String)rowData.get("numsalle"));
            return machine;
        }
        else {return null;}
}

 public Machine choisi(Etudiant etudiant,Date jour,String time) {
 String pascours ="select * from machine where machine.numma not in(select * from reserver where ide=? and jour=? and creneau=?)"
 		+ "and numsalle not in (select * from passer and jour=? and creneau=?)";
    parameter.add(etudiant.getIdentifiant());
    parameter.add(jour);
    parameter.add(time);
    parameter.add(jour);
    parameter.add(time);
    afferentSQL(pascours);
    List<Object> objs = Select();
    System.out.println(objs.get(0));
    if (objs.size()!=0) {
   	 Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
   	 Machine machine = new Machine();
   	machine.numMachine=((String)rowData.get("numma")); 
       machine.setEtat((String)rowData.get("etatm"));
       machine.setNumsalle((String)rowData.get("numsalle"));
       return machine;
   }
   else {return null;}
 }
 
 public void prendreserver(Reservation reservation) {
	 String sql="insert into reserver values(?,?,?,?,?,?)";
	  Query();
      afferentSQL(sql);
      parameter.add(reservation.getNumma());
      parameter.add(reservation.getIdee());
      parameter.add(reservation.getJour());
      parameter.add(reservation.getHeureDeb());
      parameter.add(reservation.getHeureFin());
      parameter.add(reservation.getEtat());
      int ligne=Update();
      if(ligne>=1){ //Nombre de lignes affect¨¦es (c'est-¨¤-dire le nombre de mises ¨¤ jour
          System.out.println("succcess");
      };  
	 
	 
 }
 
 /** ARSLANE DEBUT
  *  Mettre une reservation EN RECLAMATION
  *  @return true si la reservation, false sinon
  */
 public boolean signalerReservation(Machine machine /*mais je suis pas sur des données a mettre en entrée*/) {
 	String sql = "UPDATE reserver "
 			+ "SET etatr = 'EN RECLAMATION' "
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
 //ARSLANE FIN
 
 
public static void main(String[] args) {
	// TODO Auto-generated method stub
	EtudiantDao t1 = new EtudiantDao();	
	t1.login("a","b");
}

}
