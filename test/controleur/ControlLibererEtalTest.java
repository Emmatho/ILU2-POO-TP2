package controleur;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
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
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTrouver = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLiberer = new ControlLibererEtal(controlTrouver);
		assertNotNull(controlLiberer, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTrouver = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLiberer = new ControlLibererEtal(controlTrouver);
		assertTrue(controlLiberer.isVendeur("Bonemine"));
		assertFalse(controlLiberer.isVendeur("Panoramix"));
		assertFalse(controlLiberer.isVendeur("Inexistant"));
	}
	
	@Test
	void testLibererEtal() {
		ControlTrouverEtalVendeur controlTrouver = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLiberer = new ControlLibererEtal(controlTrouver);
		assertNull(controlLiberer.libererEtal("Panoramix"));
		assertNull(controlLiberer.libererEtal("Inexistant"));
		assertEquals(controlLiberer.libererEtal("Bonemine")[0], "true");
		//assertEquals(controlLiberer.libererEtal("Bonemine")[1], "Bonemine");
		assertEquals(controlLiberer.libererEtal("Bonemine")[2], "fleurs");
		assertEquals(controlLiberer.libererEtal("Bonemine")[3], 3);
		assertEquals(controlLiberer.libererEtal("Bonemine")[4], 3);
	}
}
