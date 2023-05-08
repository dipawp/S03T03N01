package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import model.Decoracio;
import model.Flor;
import model.Floristeria;
import model.Producte;



public class FloristeriaRepository {
	
	private static String pathFloristeria = "src/floristeria.txt";
	
	public FloristeriaRepository() {

	}
	
	
    public Floristeria creaFloristeria(Floristeria floristeria) throws IOException,FileNotFoundException {
    	save(floristeria);
		return floristeria;
		
	}
	
	
	public void afegirProducte(Producte producte) throws ClassNotFoundException, IOException {
		Floristeria floristeria = getFloristeria();
		floristeria.productes.add(producte);
		save(floristeria);
	}

	
	public void save(Floristeria floristeria) throws IOException,FileNotFoundException {
		File file = new File(pathFloristeria);
		file.delete();
    	FileOutputStream fileOutputStream = new FileOutputStream(pathFloristeria);
    	
    	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    	objectOutputStream.writeObject(floristeria);
    	objectOutputStream.flush();
    	objectOutputStream.close();
	}
	
	public Floristeria read() throws IOException, ClassNotFoundException, FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(pathFloristeria);
		try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			Floristeria floristeria = (Floristeria) objectInputStream.readObject();
			return floristeria;
		}
	}
	
	
	
	public static Floristeria getFloristeria() throws IOException, ClassNotFoundException{
		FileInputStream fileInputStream = new FileInputStream(pathFloristeria);
		try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			Floristeria floristeria = (Floristeria) objectInputStream.readObject();
			if(objectInputStream != null) {
				objectInputStream.close();
			}
			return floristeria;
		}
	}
	
	public boolean removeProductByName(String name) throws ClassNotFoundException, IOException {
		boolean retirat = false;
		Floristeria floristeria = getFloristeria();
		Predicate<Producte> condition= p->p.getNom().equals(name);
		retirat = floristeria.productes.removeIf(condition);
		if(retirat) {
			save(floristeria);
		}
		return retirat;
		
	}
	

}
