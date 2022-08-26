package bean;

public class Condominio {
	// values
	private String nome;
	private int qtdCasas;
	private String cidade;
	
	// constructors
	public Condominio(String nome, int qtdCasas, String cidade) {
		super();
		this.nome = nome;
		this.qtdCasas = qtdCasas;
		this.cidade = cidade;
	}

	public Condominio() {
	}

	// methods
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdCasas() {
		return qtdCasas;
	}

	public void setQtdCasas(int qtdCasas) {
		this.qtdCasas = qtdCasas;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Condominio [nome=" + nome + ", qtdCasas=" + qtdCasas + ", cidade=" + cidade + "]";
	}
}
