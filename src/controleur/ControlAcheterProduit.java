package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String[] trouverProduit(String produit) {
		int longueur = village.rechercherVendeursProduit(produit).length;
		String[] liste = new String[longueur];
		for (int i = 0 ; i < longueur ; i++) {
			liste[i] = village.rechercherVendeursProduit(produit)[i].getNom();
		}
		return liste;
	}
	
	public int acheterProduit(String nomVendeur, int qte) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(qte);
	}
	//TODO a completer
}
