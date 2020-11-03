package GestionSallesMachines;

import java.util.ArrayList;
import java.util.HashMap;

import GestionReservations.Seance;
import GestionReservations.TempsDeSeance;

public class Salle {
	private String nomSalle;
	private EtatMachineSalle etat;
	private ArrayList<Machine> lstMachines;
	private HashMap<TempsDeSeance,Seance> hmSeance;
	
}
