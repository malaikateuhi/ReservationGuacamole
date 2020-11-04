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
import GestionReservations.Seance;
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
    
  
    if (objs.size()!=0) {
    	Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
    	  etures = new Etudiant();
          etures.setIdentifiant((String) rowData.get("ide"));
          etures.setMdp((String)rowData.get("passwode"));
          etures.setNom((String)rowData.get("nome"));
          etures.setPrenom((String)rowData.get("prenome"));   
    	System.out.println("welcom "+rowData.get("nome"));
    	return etures;
    	  
    }
    else {
    return null;}
    }

  
/*	//Historique des r¨¦servations de l'¨¦tudiant
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
	}*/
    
    //  S'il y a une seance dans la p¨¦riode sp¨¦cifi¨¦e, v¨¦rifiez la salle o¨´ le cours a eu lieu
			public Salle recommande(Etudiant etudiant, String jour,int time) {
			 String avoircours ="select * from passer,etudiant,seance where etudiant.numgroup =seance.numgroup "
			 		+ "and seance.numseance =passer.numseance and ide=? and jour=? and creneau=? ";
			        Query(); 
			        parameter.add(etudiant.getIdentifiant());
			        parameter.add(jour);
			        parameter.add(time);
			        afferentSQL(avoircours);
			        List<Object> objs = Select();
			            if (objs.size()!=0) {
			        	 Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
			        	 Salle salle = new Salle();
			             salle.setNomSalle((String)rowData.get("numsalle"));   
			             System.out.println(salle.getNomSalle());
			             Seance seance =new Seance();
			      
			             return salle;
			        }
			        else 
			        {return null;}
			}
			
		 //S'il y a une seance, v¨¦rifiez les informations de cette seance
			public Seance avoirseance(Etudiant etudiant, String jour,int time) {
				 String avoircours ="select * from passer,etudiant,seance where etudiant.numgroup =seance.numgroup and seance.numseance =passer.numseance and ide=? and jour=? and creneau=? ";
				        Query(); 
				        parameter.add(etudiant.getIdentifiant());
				        parameter.add(jour);
				        parameter.add(time);
				        afferentSQL(avoircours);
				        List<Object> objs = Select();
				            if (objs.size()!=0) {
				        	 Map<String, Object> rowData =(Map<String, Object>)objs.get(0);
				             Seance seance =new Seance();
				             seance.setNumSeance((String)rowData.get("numseance"));
				             seance.setNomCours((String)rowData.get("nomcours"));
				             System.out.println(seance.getNumSeance());
				             return seance;
				        }
				        else 
				        {return null;}
				}
				
			
			
        //  Recommander une machine disponible dans la salle o¨´ les etudiant a une seance				
			public Machine machinelibre (Salle salle,String jour,int time)
			{
				String sqlmachine = "select * from machine where numsalle=? "
						+ "and numma not in (select numma from reserver where jour=? and creneau=?)";
				Query(); 
				parameter.add(salle.getNomSalle());
				parameter.add(jour);
				
		        parameter.add(time);
			    afferentSQL(sqlmachine);
				  List<Object> objs = Select();
				       if (objs.size()!=0) {
			        	Map<String, Object> rowData =(Map<String, Object>) objs.get(0);
			        	Machine machine = new Machine();
		                machine.setNumMachine((String)rowData.get("numma")); 
			            machine.setEtat((String)rowData.get("etatm"));
			            System.out.println(machine.getNumMachine());
			            return machine;
		       }
				return null;
			}
			  
			
			/*Si l'¨¦tudiant n'a pas de seance pendant le creneau o¨´ il veut ,
			alors recommander une machine qui n'est pas occup¨¦e pendant cette p¨¦riode, 
			et cette machine n'est pas dans la classe qui a des cours pendant cette p¨¦riode*/
			
			 public Machine choisi(Etudiant etudiant,String jour,int time) {
			 String pascours ="select * from machine "
			 		+ "where machine.numma not in(select numma from reserver where ide=? and jour=?and creneau=?) "
			 		+ "and numsalle not in (select numsalle from passer where jour=?and creneau=?)";
			 Query(); 
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
			 String sql="insert into reserver values(?,?,?,?,?,?,?)";
			  Query();
		      afferentSQL(sql);
		      parameter.add(reservation.getNumma());
		      parameter.add(reservation.getIdee());
		      parameter.add(reservation.getJour());
		      parameter.add(reservation.getHeureDeb());
		      parameter.add(reservation.getHeureFin());
		      parameter.add(reservation.getEtat());
		      parameter.add(reservation.getCreaneau());
		      int ligne=Update();
		      if(ligne>=1){ //Nombre de lignes affect¨¦es (c'est-¨¤-dire le nombre de mises ¨¤ jour
		          System.out.println("succcess");
		      };  
			
			 System.out.println();
		 }
     

		     public void annuler(Reservation reservation) {
			 String sql="DELETE FROM reserver WHERE numma= ? AND ide = ? AND jour = ? AND creneau= ?";
			  Query();
		      afferentSQL(sql);
		      parameter.add(reservation.getNumma());
		      parameter.add(reservation.getIdee());
		      parameter.add(reservation.getJour());
		      parameter.add(reservation.getCreaneau());
		      int ligne=Update();
		      if(ligne>=1){ //Nombre de lignes affect¨¦es (c'est-¨¤-dire le nombre de mises ¨¤ jour
		          System.out.println("succcess");
		      };  
			
			 System.out.println();
		 }
		     
		     
		     
		     
		     ArrayList<Reservation> lstreservation;
		     public  ArrayList<Reservation> inforeserver(Etudiant etudiant) {
		    	 String sql="select * from reserver where ide=? order by jour,creneau";
		    	 Query();
		    	 parameter.add(etudiant.getIdentifiant());
		    	 afferentSQL(sql);
		    	 this.lstreservation=new  ArrayList<Reservation>();
		    	  List<Object> objs = Select();
			        for (int i = 0; i < objs.size(); i++) {
			        	Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
			        	Reservation rr= new Reservation();
			        	rr.setNumma((String)rowData.get("numma"));
			        	rr.setCreaneau((int)rowData.get("creneau"));
			        	rr.setHeureDeb((String)rowData.get("heuredeb"));
			        	rr.setHeureFin((String)rowData.get("heurefinr"));
			        	rr.setEtat((String)rowData.get("etatr"));
			        	rr.setIdee((String)rowData.get("ide"));
			        	rr.setJour((String)rowData.get("jour"));
			        	lstreservation.add(rr);
			        }
			        System.out.println(lstreservation);
			        return lstreservation;
		     }
		     
		     
				public static void main(String[] args) {
					// TODO Auto-generated method stub
					EtudiantDao t1 = new EtudiantDao();	
					Etudiant e1= new Etudiant();
					t1.login("1","1");
					
					e1.setIdentifiant("1");
						//	t1.login("a","b");
						Salle salle1=new Salle();
						salle1.setNomSalle("M1");
						//t1.machinelibre(salle1, "2020-11-10", 0);
							//t1.recommande(e1, "2020-11-10", 0);
						t1.avoirseance(e1, "2020-11-10", 0);
						//t1.choisi(e1, "2020-11-10", 0);
						Reservation r1= new Reservation("ma1","1","2020-11-10","9:30","10:30","reserve",0);
						
						t1.annuler(r1);
						//t1.prendreserver(r1);
						//t1.inforeserver(e1);
				}




}
