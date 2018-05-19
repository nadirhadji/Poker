package Modele;

public enum ActionUtilisateur {
	
	MISER("Miser"),
	PAROLE("Parole"),
	PASSER("Passer"),
	FERMER("fermer"),
	SUIVRE("Suivre");
	
	private String nom;
	
	private ActionUtilisateur (String nom) {
	
		this.nom = nom;
	}
		
	public String toString() {
		
		return nom;
	}
}
