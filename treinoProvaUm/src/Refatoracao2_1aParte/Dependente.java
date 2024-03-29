package Refatoracao2_1aParte;

public class Dependente extends Deducao{

	private String nome; 
	private CPF cpf; 
	
	public Dependente(String nome, int[] cpf) {
		super("Dependente", (float) 171.97);
		this.nome = nome;
		this.cpf = new CPF(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int[] getCpf() {
		return cpf.getCPF();
	}

	public void setCpf(int[] cpf) {
		this.cpf = new CPF(cpf);
	}
	
}
