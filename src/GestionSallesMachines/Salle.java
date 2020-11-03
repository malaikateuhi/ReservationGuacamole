package GestionSallesMachines;

import java.util.ArrayList;
import java.util.HashMap;

import GestionReservations.Seance;
import GestionReservations.TempsDeSeance;

public class Salle {
	private String nomSalle;
	private EtatMachineSalle etat;
	private ArrayList<Machine> lstMachines;
	//private HashMap<TempsDeSeance,Seance> hmSeance;
	
	public Salle() {
		
	}
	public Salle(String nomSalle, EtatMachineSalle etat, ArrayList<Machine> lstMachines) {
		super();
		this.nomSalle = nomSalle;
		this.etat = etat;
		this.lstMachines = lstMachines;
	}
	public String getNomSalle() {
		return nomSalle;
	}
	
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	public EtatMachineSalle getEtat() {
		return etat;
	}
	public void setEtat(EtatMachineSalle etat) {
		this.etat = etat;
	}
	public ArrayList<Machine> getLstMachines() {
		return lstMachines;
	}
	public void setLstMachines(ArrayList<Machine> lstMachines) {
		this.lstMachines = lstMachines;
	}
	
}
