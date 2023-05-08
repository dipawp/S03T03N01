package model;

public class Decoracio extends Producte{
	
	private static final long serialVersionUID = 1L;
 	private Material material;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Decoracio(String nom, float preu, int quantitat, TipusProducte tipusProducte, Material material) {
		super(nom, preu, quantitat, tipusProducte);
		this.material = material;
	}

	
	
}
