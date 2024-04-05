package controleur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village, villageSansEtal;
	private Chef abraracourcix, chefSansEtal;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		villageSansEtal = new Village("le village sans étal", 10, 0);
		chefSansEtal = new Chef("Chef sans étal", 11, villageSansEtal);
		villageSansEtal.setChef(chefSansEtal);
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		ControlEmmenager controlEmmenagerSansEtal = new ControlEmmenager(villageSansEtal);
		controlEmmenagerSansEtal.ajouterGaulois("Bonemine", 10);
	}

	@Test
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendre = new ControlPrendreEtal(controlVerifId, village);
		assertNotNull(controlPrendre, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendre = new ControlPrendreEtal(controlVerifId, village);
		assertTrue(controlPrendre.resteEtals());
		controlVerifId = new ControlVerifierIdentite(villageSansEtal);
		controlPrendre = new ControlPrendreEtal(controlVerifId, villageSansEtal);
		assertFalse(controlPrendre.resteEtals());
	}
	
	@Test
	void testPrendreEtal() {
		ControlVerifierIdentite controlVerifId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendre = new ControlPrendreEtal(controlVerifId, village);
		assertEquals(controlPrendre.prendreEtal("Bonemine", "fleurs", 3), 0);
		assertEquals(controlPrendre.prendreEtal("Inexistant", "fleurs", 3), -1);
		controlVerifId = new ControlVerifierIdentite(villageSansEtal);
		controlPrendre = new ControlPrendreEtal(controlVerifId, villageSansEtal);
		assertEquals(controlPrendre.prendreEtal("Bonemine", "fleurs", 28), -1);
	}
	
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendre = new ControlPrendreEtal(controlVerifId, village);
		assertTrue(controlPrendre.verifierIdentite("Bonemine"));
		assertFalse(controlPrendre.verifierIdentite("Inexistant"));
	}
}