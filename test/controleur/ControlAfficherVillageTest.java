package controleur;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irr�ductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAffVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAffVillage, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAffVillage = new ControlAfficherVillage(village);
		assertEquals(controlAffVillage.donnerNomsVillageois()[0], "Abraracourcix");
		assertEquals(controlAffVillage.donnerNomsVillageois()[1], "Bonemine");
		assertEquals(controlAffVillage.donnerNomsVillageois()[2], village.donnerVillageois()[2]);
	}
	
	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAffVillage = new ControlAfficherVillage(village);
		assertEquals(controlAffVillage.donnerNomVillage(), "le village des irr�ductibles");
	}
	
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAffVillage = new ControlAfficherVillage(village);
		assertEquals(controlAffVillage.donnerNbEtals(), 5);
	}
}