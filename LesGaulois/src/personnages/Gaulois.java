//TODO Auto-generated method stub

package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees = 0;
	private Equipement[] trophees;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		trophees = new Equipement[100];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mï¿½choire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] nvTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; nvTrophees != null && i < nvTrophees.length; i++, nbTrophees++) {
				trophees[nbTrophees] = nvTrophees[i];
		}
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois dï¿½cuplï¿½e.");
	}
	
	public void faireUneDonnation(Musee musee) {
		parler("Je donne au musee tous mes trophees :");
		int tropheeActuel = 0;
		while (nbTrophees > 0) {
			musee.donnerTrophees(this, trophees[tropheeActuel]);
			System.out.println(" - " + trophees[tropheeActuel]);
			nbTrophees--;
			tropheeActuel++;
		}
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astï¿½rix", 8);
		System.out.println(asterix);
		asterix.parler("Bonjour");
	}
}
