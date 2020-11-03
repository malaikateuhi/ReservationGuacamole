package GestionUtilisateurs;
public class Groupe {
	private String numGroupe;
	private String nomGroupe;
	
	public Groupe(String numGroupe, String nomGroupe) {
		this.numGroupe = numGroupe;
		this.nomGroupe = nomGroupe;
	}
	
	public String getNumGroupe() {
		return numGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
}
