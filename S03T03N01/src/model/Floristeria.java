package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Floristeria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
//	public List<Arbre> llistaArbre = new ArrayList<Arbre>();
//	public List<Flor> llistaFlor = new ArrayList<Flor>();
//	public List<Decoracio> llistaDecoracio = new ArrayList<Decoracio>();
	
	
	public List<Producte> productes;
	public List<Ticket> tickets;

	public Floristeria(String nom) {
		super();
		this.nom = nom;
		productes = new ArrayList<>();
		tickets = new ArrayList<>();
		//productes.add(new Arbre(nom, 0, 0, TipusProducte.ARBRE, 0));
		//String hhString = "";
	}

}
