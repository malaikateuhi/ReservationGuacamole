package GestionUtilisateurs;

public class Admin extends Utilisateur{
	
	public Admin() {
		
	}

	public Admin(String id, String mdp) {
		super(id,mdp);
	}
	
	public String getIdentifiant() {
		return super.getIdentifiant();
	}
	
	public void setIdentifiant(String identifiant) {
		super.setIdentifiant(identifiant);
	}
	
	public String getMdp() {
		return super.getMdp();
	}
	
	public void setMdp(String mdp) {
		super.setMdp(mdp);;
	}
	public String getNom() {
		return super.getNom();
	}
	public void setNom(String nom) {
		super.setNom(nom);;
	}
	public String getPrenom() {
		return super.getPrenom();
	}
	public void setPrenom(String prenom) {
		super.setPrenom(prenom);;
	}
	public void ajouterMachine() {
		
	}
	public void supprimerMachine() {
		
	}
	public void ModifierMachine() {
		
	}
	public void ajouterSalle() {
		
	}
	public void supprimerSalle() {
		
	}
	public void modifierSalle() {
		
	}
	public void ajouterCompte() {
		
	}
	public void supprimerCompte() {
		
	}
	public void modifierCompte() {
		
	}
}
