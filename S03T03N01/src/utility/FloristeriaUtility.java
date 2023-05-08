package utility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import model.Producte;
import repository.FloristeriaRepository;


public class FloristeriaUtility {
	
	//Verifica si ja existeix una floristeria
	public static boolean floristeriaExists() {
		boolean exists = false;
		File file = new File("src/floristeria.txt");
		System.out.println(file.length());
		if(file.exists()) {
			exists = true;
		}
		return exists;
	}
	
	//Verifica si ja existeix un producte
	public static boolean productExists(String nom) throws ClassNotFoundException, IOException {
		boolean exist = false;
		List<Producte> productes = FloristeriaRepository.getFloristeria().productes;
		for(Producte prod:productes) {
			if(prod.getNom().equals(nom)) {
				exist = true;
			}
		}
		return exist;
		
	}

}
