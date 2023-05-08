package model;

public class Flor extends Producte{
	
	private static final long serialVersionUID = 1L;
    private String color;


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Flor(String nom, float preu, int quantitat, TipusProducte tipusProducte, String color) {
		super(nom, preu, quantitat, tipusProducte);
		this.color = color;
	}
	
}
