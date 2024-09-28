package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) { 
		this.chef = chef; 
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois habitant) {
		villageois[nbVillageois] = habitant;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int indiceVillageois = 0 ; indiceVillageois < nbVillageois ; indiceVillageois++) {
			System.out.println("- " + villageois[indiceVillageois].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irr�ductibles", 30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//Le nombre de villageois va de 0 � 30 exclu
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Gaulois obelix = new Gaulois("Ob�lix", 25);
		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
//		Gaulois gaulois = village.trouverHabitant(1); 
//		System.out.println(gaulois);
//      abraracourcix est de classe Chef et non Gaulois, 
//      qui est le type pris en param�tre par ajouterHabitant().
	}
}
