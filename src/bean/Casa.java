package bean;

public class Casa {
	// values
	private int numero;
	private String nomeProp;
	private int numeroCond;
	
	// constructors
	public Casa(int numero, String nomeProp, int numeroCond) {
		this.numero = numero;
		this.nomeProp = nomeProp;
		this.numeroCond = numeroCond;
	}
	
	public Casa() {
		
	}

	// methods
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNomeProp() {
		return nomeProp;
	}

	public void setNomeProp(String nomeProp) {
		this.nomeProp = nomeProp;
	}

	public int getNumeroCond() {
		return numeroCond;
	}

	public void setNumeroCond(int numeroCond) {
		this.numeroCond = numeroCond;
	}

	@Override
	public String toString() {
		return "Casa [numero=" + numero + ", nomeProp=" + nomeProp + ", numeroCond=" + numeroCond + "]";
	}
}
