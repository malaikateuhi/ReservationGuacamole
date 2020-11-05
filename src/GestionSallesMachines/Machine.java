package GestionSallesMachines;

public class Machine {
	public String numMachine;
	public String etat;
	public String numsalle;
		
	public Machine() {
		
	}
	public String getNumsalle() {
		return numsalle;
	}
	public void setNumsalle(String numsalle) {
		this.numsalle = numsalle;
	}
	public String getNumMachine() {
		return numMachine;
	}
	public void setNumMachine(String numMachine) {
		this.numMachine = numMachine;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
