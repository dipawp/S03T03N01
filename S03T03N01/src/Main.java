import java.io.FileNotFoundException;
import java.io.IOException;

import controller.FloristeriaController;
import controller.Input;
import model.Arbre;
import model.Decoracio;
import model.Flor;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		FloristeriaController floristeriaController = new FloristeriaController();
		
		
		int opcio;
		
		do{
			System.out.println("0. - Sortir" +
		            "\n" + "1. - Crear Floristeria." +
	                "\n" + "2. - Afegir Arbre." +
	                "\n" + "3. - Afegir Flor." +
	                "\n" + "4. - Afegir Decoració" +
	                "\n" + "5. - Imprimeix el stock d'una floristeria." +
	                "\n" + "6. - Retirar arbre." +
	                "\n" + "7. - Retirar flor." +
	                "\n" + "8. - Retirar decoració." +
	                "\n" + "9. - Printar per pantalla stock amb quantitats." +
	                "\n" + "10.- Printar per pantalla valor total de la floristeria." +
	                "\n" + "11.- Crear tickets de compra amb múltiples objectes." +
	                "\n" + "12.- Mostrar una llista de compres antigues." +
	                "\n" + "13.- Visualitzar el total de diners guanyats amb totes les vendes.");
			
			opcio = Input.getInt("Tria una opció");
			
			switch (opcio){
	        case 1  -> floristeriaController.creaFloristeria();
	        case 2  -> floristeriaController.afegirProducte(Arbre.class.getSimpleName());
	        case 3  -> floristeriaController.afegirProducte(Flor.class.getSimpleName());
	        case 4  -> floristeriaController.afegirProducte(Decoracio.class.getSimpleName());
	        case 5  -> floristeriaController.printStock();
	        case 6,7,8  -> floristeriaController.retirarProducte();
	        case 9  -> floristeriaController.showStockAndQuantity();
	        case 10 -> floristeriaController.printTotal();
	        case 11 -> floristeriaController.crearTicket();
	        case 12 -> floristeriaController.printTickets();
	        case 13 -> floristeriaController.printTotalVendes();
		    }
	   }while (opcio != 0);

	}

}
