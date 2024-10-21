package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	private boolean vainqueur;

	public Romain(String nom, int force) {
		assert (force >= 0);
		this.nom = nom;
		this.force = force;
		equipements = new Equipement[2];
		this.vainqueur = true;
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public boolean getVainqueur() {
		return vainqueur;
	}


	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			vainqueur = true;
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			vainqueur = false;
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force <= oldForce;
		return equipementEjecte;
	}

	public void sEquiper(Equipement aEquiper) {
		if (nbEquipement == 2) {
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
		} else if (nbEquipement == 1) {
			if (equipements[0] == aEquiper) {
				System.out.println("Le soldat " + nom + " possède déjà un " + aEquiper + " !");
			} else {
				equipements[1] = aEquiper;
				nbEquipement++;
				System.out.println("Le soldat " + nom + " s'équipe d'un " + aEquiper + " !");
			}
		} else {
			equipements[0] = aEquiper;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe d'un " + aEquiper + " !");
		}
	}

	private int calculResistanceEquipement(int forceCoup) {
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					System.out.println("Equipement bouclier");
					resistanceEquipement += 8;
				} else if ((equipements[i] != null && equipements[i].equals(Equipement.CASQUE))) {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
		}
		parler("Ma force est de " + this.force + ", et la force du coup est de " + forceCoup 
				+ "\nMais heureusement, grace à mon équipement sa force est diminué de " + resistanceEquipement + "!");
		if (resistanceEquipement < forceCoup) {
			forceCoup -= resistanceEquipement;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;

	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.parler("UN GAU... UN GAUGAU...");
		minus.recevoirCoup(7);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
