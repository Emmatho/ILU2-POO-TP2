package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour acheter ici.");
			return;
		}
		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String[] listeVendeurs = controlAcheterProduit.trouverProduit(produit);
		int longListeVendeurs = listeVendeurs.length, i = 0;
		if (longListeVendeurs == 0) {
			System.out.println("Désolée, personne ne vend ce produit au marché.");
			return;
		}
		System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
		while (i < longListeVendeurs) {
			System.out.println(i+1 + " - " + listeVendeurs[i]);
			i++;
		}
		String vendeurChoisi = listeVendeurs[Clavier.entrerEntier("")-1];
		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurChoisi);
		System.out.println("Bonjour " + nomAcheteur + ".");
		int qteProduitVoulu = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
		int qteAchetee = controlAcheterProduit.acheterProduit(vendeurChoisi, qteProduitVoulu);
		if (qteProduitVoulu == qteAchetee) {
			System.out.println(nomAcheteur + " achète " + qteProduitVoulu + " " + produit + " à " + vendeurChoisi + ".");
		} else if (qteAchetee > 0) {
			System.out.println(nomAcheteur + " veut acheter " + qteProduitVoulu + " " + produit + ", malheureusement " + vendeurChoisi + "n'en a plus que " + qteAchetee + ". " + nomAcheteur + " achète tout le stock de " + vendeurChoisi + ".");
		} else {
			System.out.println(nomAcheteur + " veut acheter " + qteProduitVoulu + " " + produit + ", malheureusement il n'y en a plus !");
		}
	}
}
