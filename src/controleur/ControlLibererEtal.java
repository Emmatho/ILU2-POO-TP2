package controleur;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		boolean vendeurReconnu = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null;
		return vendeurReconnu;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		
		if (controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null) {
			String[] donneesEtal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).etatEtal();
			controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).libererEtal();
			return donneesEtal;
		}
		return null;
	}

}
