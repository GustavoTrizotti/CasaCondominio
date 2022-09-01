package bean;

public class Casa {
	// values
	private int numero;
	private String nomeProp;
	private String nomeCond;
	
	// constructors
	public Casa(int numero, String nomeProp, String nomeCond) {
		this.numero = numero;
		this.nomeProp = nomeProp;
		this.nomeCond = nomeCond;
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

	public String getNomeCond() {
		return nomeCond;
	}

	public void setNomeCond(String nomeCond) {
		this.nomeCond = nomeCond;
	}

	@Override
	public String toString() {
		return "Casa [numero=" + numero + ", nomeProp=" + nomeProp + ", nomeCond=" + nomeCond + "]";
	}
}
