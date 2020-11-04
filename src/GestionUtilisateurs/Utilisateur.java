package GestionUtilisateurs;

public abstract class Utilisateur {
	private String identifiant;
	private String mdp;
	private String nom;
	private String prenom;
	
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Utilisateur() {
		
	}
	public Utilisateur(String identifiant, String mdp, String nom, String prenom) {
		
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Utilisateur(String identifiant, String mdp) {
		
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	public Utilisateur(String identifiant) {
		
		this.identifiant = identifiant;

	}
}
