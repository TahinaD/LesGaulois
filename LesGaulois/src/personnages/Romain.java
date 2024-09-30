package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert(force >= 0);
		this.nom = nom;
		this.force = force;
		equipement = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert(force >= 0);
		int ancienneforce = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aï¿½e");
		} else {
			parler("J'abandonne");
		}
		assert(force < ancienneforce);
	}
	
	public void sEquiper(Equipement aEquiper) {
		if (nbEquipement == 2) {
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
		}
		else if (nbEquipement == 1) {
			if (equipement[0] == aEquiper) {
				System.out.println("Le soldat " + nom + " possède déjà un " + aEquiper + " !");
			} else {
				equipement[1] = aEquiper;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'équipe d'un " + aEquiper + " !");
			}
		}
		else {
			equipement[0] = aEquiper;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe d'un " + aEquiper + " !");
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler("UN GAU... UN GAUGAU...");
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
