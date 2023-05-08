package model;

public class Arbre extends Producte{
	
	private static final long serialVersionUID = 1L;
 	private float alcada;
	

	public float getAlcada() {
		return alcada;
	}

	public void setAlcada(float alcada) {
		this.alcada = alcada;
	}

	public Arbre(String nom, float preu, int quantitat, TipusProducte tipusProducte, float alcada) {
		super(nom, preu, quantitat, tipusProducte);
		this.alcada = alcada;
	}

	

	
	
	
}
