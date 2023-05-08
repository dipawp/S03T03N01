package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import model.Arbre;
import model.Decoracio;
import model.Flor;
import model.Floristeria;
import model.Material;
import model.Producte;
import model.Ticket;
import model.TipusProducte;
import repository.FloristeriaRepository;
import utility.FloristeriaUtility;


public class FloristeriaController {
	
	
	private static FloristeriaRepository floristeriaRepository;
	public static Scanner scanner;
	public static String in = "";
	private Floristeria floristeria = null;
	
	public FloristeriaController() {
		floristeriaRepository = new FloristeriaRepository();
		scanner = new Scanner(System.in);
		try {
			floristeria = FloristeriaRepository.getFloristeria();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	//Crea una floristeria
	public void creaFloristeria() throws IOException,FileNotFoundException {
		if(FloristeriaUtility.floristeriaExists()) {
			System.out.println("Ja existeix una floristeria");
			return;
		}
		String nom = Input.getString("Introdueix el nom de la floristeria");
		
		if(!FloristeriaUtility.floristeriaExists()) {
			floristeria = floristeriaRepository.creaFloristeria(new Floristeria(nom));
			System.out.println("S'ha creat la floristeria " + nom);
		}else {
			System.out.println("La floristeria ja existeix");
		}
	}
	
	
	//Afegeix un producte a la llista de productes de la floristeria
	public void afegirProducte(String productType) throws ClassNotFoundException, IOException {
		if(floristeria == null) {
			System.out.println("Primer tens que crear una floristeria");
			return;
		}
		String nom = "";
		float preu = 0.0f;
		int quantitat = 0;
		switch (productType){
        case "Arbre" :
        	nom = Input.getString("Introdueix el nom de l'arbre");
    		preu = Input.getFloat("Introdueix el preu");
    		float alcada = Input.getFloat("Introueix l'alçada");
    		quantitat = Input.getInt("Introdueix la quantitat");
    		if(!FloristeriaUtility.productExists(nom)) {
    			floristeriaRepository.afegirProducte(new Arbre(nom, preu,quantitat,TipusProducte.ARBRE, alcada));
    		}else {
    			System.out.println("L'arbre + " + nom + " ja existeix");
    		}
        	break;
        case "Flor" :
        	nom = Input.getString("Introdueix el nom de la flor");
    		preu = Input.getFloat("Introdueix el preu");
    		String color = Input.getString("Introueix el color");
    		quantitat = Input.getInt("Introdueix la quantitat");
    		if(!FloristeriaUtility.productExists(nom)) {
    			floristeriaRepository.afegirProducte(new Flor(nom, preu,quantitat,TipusProducte.FLOR, color));
    			System.out.println("S'ha afegit la flor " + nom);
    		}else {
    			System.out.println("La flor " + nom + " ja existeix");
    		}
        	break;
        case "Decoracio" :
        	nom = Input.getString("Introdueix el nom de la decoració");
    		preu = Input.getFloat("Introdueix el preu");
    		int materialInt = Input.getInt("Tria un material:" + "\n" + "0. - FUSTA." + "\n"
    				                                  + "1. - PLASTIC.");
    		quantitat = Input.getInt("Introdueix la quantitat");
    		
    		Material material;
    		if(materialInt == 0) {
    			material = Material.FUSTA;
    		}else {
    			material = Material.PLASTIC;
    		}
    		if(!FloristeriaUtility.productExists(nom)) {
    			floristeriaRepository.afegirProducte(new Decoracio(nom, preu,quantitat,TipusProducte.DECORACIO, material));
    			System.out.println("S'ha afegit la decoració " + nom);
    		}else {
    			System.out.println("La decoració " + nom + " ja existeix");
    		}
	    }
	}
	
	//Imprimeix tot l'stock 
	public void printStock() throws ClassNotFoundException, IOException {
		if(floristeria == null) {
			System.out.println("Primer tens que crear una floristeria");
			return;
		}
		Floristeria floristeria = FloristeriaRepository.getFloristeria();
		for(Producte producte:floristeria.productes) {
			String type = producte.getClass().getSimpleName();
			switch (type){
	        case "Arbre" :
	        	Arbre arbre = (Arbre) producte;
	        	System.out.println("Tipus-:" + arbre.getTipusProducte() + ", Nom: " + arbre.getNom() + 
				                   ", Alçada: " + arbre.getAlcada() + ", Preu: " + producte.getPreu() + 
				                   ", Quantitat: " + producte.getQuantitat());
	        	break;
	        case "Flor" :
	        	Flor flor = (Flor) producte;
	        	System.out.println("Tipus-:" + flor.getTipusProducte() + ", Nom: " + flor.getNom() + 
				                   ", Color: " + flor.getColor() + ", Preu: " + flor.getPreu() + 
				                   ", Quantitat: " + flor.getQuantitat());
	        	break;
	        case "Decoracio" :
	        	Decoracio decoracio = (Decoracio) producte;
	        	System.out.println("Tipus-:" + decoracio.getTipusProducte() + ", Nom: " + decoracio.getNom() + 
				                   ", Material: " + decoracio.getMaterial() + ", Preu: " + decoracio.getPreu() + 
				                   ", Quantitat: " + decoracio.getQuantitat());
		    }
			
		}
	}
	
	//Retira un producte de l'stock, pot ser arbre,flor,decoració
	public void retirarProducte() {
		if(floristeria == null) {
			System.out.println("Primer tens que crear una floristeria");
			return;
		}
		String nom = Input.getString("Introdueix el nom del producte");
		try {
			boolean retirat = floristeriaRepository.removeProductByName(nom);
			if(retirat) {
				System.out.println("El producte " + nom + " s'ha retirat.");
			}else {
				System.out.println("El producte " + nom + " no existeix.");
			}
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("S'ha produït un error.");
		}
	}
	//Imprimeix l'stock i les quantitas
	public void showStockAndQuantity() throws ClassNotFoundException, IOException {
		if(floristeria == null) {
			System.out.println("Primer tens que crear una floristeria");
			return;
		}
		Floristeria floristeria = FloristeriaRepository.getFloristeria();
		for(Producte producte:floristeria.productes) {
			String type = producte.getClass().getSimpleName();
			switch (type){
	        case "Arbre" :
	        	Arbre arbre = (Arbre) producte;
	        	System.out.println("Nom: " + arbre.getNom() + ", Quantitat: " + producte.getQuantitat());
	        	break;
	        case "Flor" :
	        	Flor flor = (Flor) producte;
	        	System.out.println("Nom: " + flor.getNom() + ", Quantitat: " + flor.getQuantitat());
	        	break;
	        case "Decoracio" :
	        	Decoracio decoracio = (Decoracio) producte;
	        	System.out.println("Nom: " + decoracio.getNom() +  ", Quantitat: " + decoracio.getQuantitat());
		    }
			
		}
	}
	//Mostra el valor total de l'stock de la floristeria
	public void printTotal() throws ClassNotFoundException, IOException {
		if(floristeria == null) {
			System.out.println("Primer tens que crear una floristeria");
			return;
		}
		Floristeria floristeria = FloristeriaRepository.getFloristeria();
		float total = 0;
		for(Producte producte:floristeria.productes) {
			total += producte.getPreu() * producte.getQuantitat();
		}
		System.out.println("El valor total de la floristeria es: " + total + "$");
	}
	
	//Crea un ticket de compra afegint productes
	public void crearTicket() throws ClassNotFoundException, IOException {
		if(floristeria == null) {
			System.out.println("Primer tens que crear una floristeria");
			return;
		}
		Ticket ticket = new Ticket();
		Floristeria floristeria = null;
		int result = 0;
		
		do {
			System.out.println("1. - Afegir producte" + "\n" + "2. - Sortir");
			result = Input.getInt("");
			switch (result) {
			case 1:
				
				floristeria = FloristeriaRepository.getFloristeria();
				int i = 1;
				if(floristeria.productes.size() > 0) {
					for(Producte prod:floristeria.productes) {
						System.out.println(i + ".- Nom: " + prod.getNom() + ", Preu: " + prod.getPreu());
						i++;
					}
					int prodId = Input.getInt("");
					if(prodId > floristeria.productes.size()) {
						System.out.println("Aquest producte no existeix");
					}else {
						int quantitat = Input.getInt("Introdueix la quantitat");
						if(floristeria.productes.get(prodId -1).getQuantitat() >= quantitat) {
							floristeria.productes.get(prodId -1).setQuantitat(
									floristeria.productes.get(prodId -1).getQuantitat() - quantitat);
							ticket.setID(floristeria.tickets.size()+1);
							//ticket.afeigexProducte(floristeria.productes.get(prodId - 1));
							ticket.afeigexProducte(new Producte(floristeria.productes.get(prodId - 1).getNom(), 
									                            floristeria.productes.get(prodId -1).getPreu(), 
									                            quantitat, floristeria.productes.get(prodId -1).getTipusProducte()));
							floristeriaRepository.save(floristeria);
							System.out.println("El producte s'ha afegit al ticket.");
						}else {
							System.out.println("No ni ha stock suficient d'aquest producte.");
							break;
						}
					}
				}else {
					System.out.println("Primer tens que afegir productes.");
					return;
				}
				
			break;
			case 2:
				if(floristeria != null) {
					floristeria.tickets.add(ticket);
					floristeriaRepository.save(floristeria);
				}
			}
		}while (result != 2);
	}
	
	//Mostra tots els tickets
	public void printTickets() throws ClassNotFoundException, IOException {
		if(floristeria == null) {
			System.out.println("Primer tens que crear una floristeria");
			return;
		}
		Floristeria floristeria = FloristeriaRepository.getFloristeria();
		for(Ticket ticket:floristeria.tickets) {
			System.out.println("ID ticket: " + ticket.getID());
			for(Producte producte:ticket.getProductes()) {
				String type = producte.getClass().getSimpleName();
				switch (type){
		        case "Arbre" :
		        	Arbre arbre = (Arbre) producte;
		        	System.out.println("Nom: " + arbre.getNom() + ", Quantitat: " + producte.getQuantitat());
		        	break;
		        case "Flor" :
		        	Flor flor = (Flor) producte;
		        	System.out.println("Nom: " + flor.getNom() + ", Quantitat: " + flor.getQuantitat());
		        	break;
		        case "Decoracio" :
		        	Decoracio decoracio = (Decoracio) producte;
		        	System.out.println("Nom: " + decoracio.getNom() +  ", Quantitat: " + decoracio.getQuantitat());
			    }
			}
			double sum = ticket.getProductes().stream().mapToDouble(e -> e.getPreu() * e.getQuantitat()).sum();
			System.out.print("Total: " + sum + "$\n");
			System.out.print("################################\n");
		}
	}
	
	//Mostra el total de totes les vendes de la floristeria
	public void printTotalVendes() throws ClassNotFoundException, IOException {
		if(floristeria == null) {
			System.out.println("Primer tens que crear una floristeria");
			return;
		}
		Floristeria floristeria = FloristeriaRepository.getFloristeria();
		double total = 0.0;
		for(Ticket ticket:floristeria.tickets) {
			total += ticket.getProductes().stream().mapToDouble(e -> e.getPreu() * e.getQuantitat()).sum();
		}
		
		System.out.println("El total guanyat per la floristeria" + floristeria.getNom() + "es: " + total +"$\n");
	}

}



