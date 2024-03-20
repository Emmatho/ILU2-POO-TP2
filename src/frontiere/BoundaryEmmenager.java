package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
		int force = -1, effetMin = -1, effetMax = -1;
		while (force < 0) {
			force = Clavier.entrerEntier("Quelle est votre force ?");
		}
		effetMin = Clavier.entrerEntier("Quelle est la force de la potion la plus faible que vous produisez ?");
		effetMax = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous produisez ?");
		while (effetMin > effetMax) {
			System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
			effetMin = Clavier.entrerEntier("Quelle est la force de la potion la plus faible que vous produisez ?");
			effetMax = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous produisez ?");
		}
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetMin, effetMax);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		
		int force = -1;
		while (force < 0) {
		force = Clavier.entrerEntier("Quelle est votre force ?");
		}
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
		
	}
}
