package personnages;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophee = 0;
	
	public Musee() {
		trophees = new Trophee[200];
	}
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee nvTrophee = new Trophee(gaulois, equipement);
		int place = 0;
		if (nbTrophee < 200) {
			while(trophees[place] != null) {
				place++;
			}
			trophees[place] = nvTrophee;
			nbTrophee++;
		} else {
			System.out.println("Il n'y a plus de place pour ce trophee.");
		}
	}
	
	public String extraireInstructionsOCaml() {
		String chaine = "let musee = [ ";
		int elem = 0;
		while(elem < nbTrophee) {
			Gaulois gaulois = trophees[elem].getGaulois();
			chaine += gaulois.getNom();
			chaine += ", ";
			chaine += trophees[elem].getEquipement();
			if (elem != nbTrophee - 1) {
				chaine += "; ";
			}
			elem++;
		}
		chaine += "]";
		return chaine;
	}
}
