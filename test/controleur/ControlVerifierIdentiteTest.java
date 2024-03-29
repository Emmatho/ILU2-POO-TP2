package controleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiterTest {
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
	}

	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerId = new ControlVerifierIdentite(village);
		assertNotNull(controlVerId, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerId = new ControlVerifierIdentite(village);
		assertTrue(controlVerId.verifierIdentite("Bonemine"));
		assertFalse(controlVerId.verifierIdentite("Inexistant"));
	}
}