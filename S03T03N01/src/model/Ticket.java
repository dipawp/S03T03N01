package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ticket implements Serializable{

	private static final long serialVersionUID = 1L;
	private long ID;
	private List<Producte> productes;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public List<Producte> getProductes() {
		return productes;
	}
	
	public void afeigexProducte(Producte producte) {
		productes.add(producte);
	}
	public Ticket() {
		productes = new ArrayList<>();
	}
	
	
}
