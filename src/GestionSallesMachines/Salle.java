package GestionSallesMachines;

import java.util.ArrayList;
import java.util.HashMap;

import GestionReservations.Seance;
import GestionReservations.TempsDeSeance;

public class Salle {
	private String nomSalle;
	private ArrayList<Machine> lstMachines;
	private HashMap<TempsDeSeance,Seance> hmSeance;
	public String getNomSalle() {
		return nomSalle;
	}
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	
}
