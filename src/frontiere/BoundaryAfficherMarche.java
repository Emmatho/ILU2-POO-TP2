package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		} else {
			int i = 0;
			System.out.println(nomAcheteur + ", vous trouverez au marché :");
			while (i < infosMarche.length) {
				StringBuilder infosEtal = new StringBuilder();
				infosEtal.append("-" + infosMarche[i]);
				i++;
				infosEtal.append(" qui vend " + infosMarche[i]);
				i++;
				infosEtal.append(" " + infosMarche[i]);
				i++;
				System.out.println(infosEtal.toString());
			}
		}
	}
}
