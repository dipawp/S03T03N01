package model;

import java.io.Serializable;

public class Producte implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nom;
    private float preu;
    private int quantitat;
    private TipusProducte tipusProducte;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPreu() {
		return preu;
	}
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	public int getQuantitat() {
		return quantitat;
	}
	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}
	
	public TipusProducte getTipusProducte() {
		return tipusProducte;
	}
	public void setTipusProducte(TipusProducte tipusProducte) {
		this.tipusProducte = tipusProducte;
	}
	public Producte(String nom, float preu, int quantitat, TipusProducte tipusProducte) {
		super();
		this.nom = nom;
		this.preu = preu;
		this.quantitat = quantitat;
		this.tipusProducte = tipusProducte;
	}
	
	
	
	

}
