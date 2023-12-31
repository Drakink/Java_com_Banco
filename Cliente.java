package classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Clientes {

	
	@Column (name= "nome_cli")
	private String nome; 
	@Id 
	@Column(name= "cpf_cli" ,unique = true, nullable = false)
	private String cpf;
	@Column (name= "endereco_cli")
	private String endereco;
	@Column  (name= "telefone_cli" , nullable = false)
	private String telefone;
	@ManyToOne
	private Pecas pecas;
	
	
	
	public Clientes(String nome, String cpf, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		
	}

	public Clientes() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Pecas getPecas() {
		return pecas;
	}

	public void setPecas(Pecas pecas) {
		this.pecas = pecas;
	}

	
	
}

