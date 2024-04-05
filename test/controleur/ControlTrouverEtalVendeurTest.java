package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		ControlVerifierIdentite controlVerifId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendre = new ControlPrendreEtal(controlVerifId, village);
		controlPrendre.prendreEtal("Bonemine", "fleurs", 3);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouver = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouver, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouver = new ControlTrouverEtalVendeur(village);
		assertNull(controlTrouver.trouverEtalVendeur("Panoramix"));
		assertNull(controlTrouver.trouverEtalVendeur("Inexistant"));
		assertNotNull(controlTrouver.trouverEtalVendeur("Bonemine"));
	}
}
