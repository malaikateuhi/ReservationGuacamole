package GestionUtilisateurs;

import java.util.ArrayList;

public class Groupe {
	private String numGroupe;
	private String nomGroupe;
	
	private ArrayList<Etudiant> lstEtu;

	public String getNumGroupe() {
		return numGroupe;
	}

	public void setNumGroupe(String numGroupe) {
		this.numGroupe = numGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public ArrayList<Etudiant> getLstEtu() {
		return lstEtu;
	}

	public void setLstEtu(ArrayList<Etudiant> lstEtu) {
		this.lstEtu = lstEtu;
	}
	
	
}
