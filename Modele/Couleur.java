package Modele;


public enum Couleur {
	
	PIQUE("Pique"),
	CARREAU("Carreau"),
	TREFLE("Trefle"),
	COEUR("Coeur"),
	NONE("None");
	
	private String nom;
	
	private Couleur (String nom) {
	
		this.nom = nom;
	}
		
	public String toString() {
		
		return nom;
	}
	
}
