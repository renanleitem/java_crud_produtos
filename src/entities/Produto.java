package entities;

public class Produto {

	// atributos (dados)
	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidade;

	// método construtor default (sem argumentos)
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	// sobrecarga do método construtor (construtor com entrada de argumentos)
	public Produto(Integer id, String nome, String descricao, Double preco, Integer quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
