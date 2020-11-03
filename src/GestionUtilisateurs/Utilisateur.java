package GestionUtilisateurs;

public abstract class Utilisateur {
	private String identifiant;
	private String mdp;
	private String nom;
	private String prenom;
	
	public Utilisateur(String identifiant, String mdp, String nom, String prenom) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	protected String getIdentifiant() {
		return identifiant;
	}
	protected String getMdp() {
		return mdp;
	}
	protected String getNom() {
		return nom;
	}
	protected String getPrenom() {
		return prenom;
	}
	
}
