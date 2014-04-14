package Refatoracao2_1aParte_FeitoEmSala;

import java.util.Enumeration;
import java.util.Vector;


public class Contribuinte {

	private String nome; 
	//private int[] cpf;
	CPF cpf;
	float totalRendimentos, totalRendimentosTributaveis, totalRendimentosIsentos;
	float totalDeducoes; 
	float baseDeCalculo;
	float valor1aFaixa = 0, 
	              valor2aFaixa = 0, 
	              valor3aFaixa = 0, 
	              valor4aFaixa = 0, 
	              valor5aFaixa = 0;
	Vector<Rendimento> rendimentos;
	Vector<Deducao> deducoes; 
	
	public Contribuinte(String nome, int[] cpf) {
		this.nome = nome; 
		//this.cpf = cpf;
		this.cpf = new CPF(cpf);
		this.rendimentos = new Vector<Rendimento>();
		this.deducoes = new Vector<Deducao>();
	}
	

	public float calcularImposto() {
		
		calcularRendimentos();
		
		return new ContribuinteTributo(this).computarTributo();
		
	}


	private void calcularRendimentos() {
		//1a PARTE: CALCULOS DOS RENDIMENTOS TRIBUTAVEIS
		totalRendimentos = 0; 
		totalRendimentosTributaveis = 0; 
		totalRendimentosIsentos = 0;
		
		//calculo o total de rendimentos, rendimentos tribut�veis e rendimentos isentos
		Enumeration<Rendimento> r  = rendimentos.elements();
		while (r.hasMoreElements()) {
			Rendimento temp = (Rendimento) r.nextElement();
			totalRendimentos += temp.getValor(); 
			if (temp.isTributavel())
				totalRendimentosTributaveis += temp.getValor(); 
			else
				totalRendimentosIsentos += temp.getValor();
		}
	}
	
	public boolean adicionarRendimento(Rendimento rendimento) {
		boolean resposta = rendimentos.add(rendimento);
		calcularImposto();
		return resposta;
	}
	
	
	public boolean excluirRendimento(Rendimento rendimento){
		
		boolean resposta = false;
		
		Enumeration<Rendimento> e = rendimentos.elements();
		while (e.hasMoreElements()){  //percorre o vetor varrendo os elementos
			Rendimento temp = e.nextElement();
			if (temp.getDescricao() == rendimento.getDescricao() &&  //se os elementos forem iguais ...
				temp.getValor() == rendimento.getValor()) {
				resposta = rendimentos.remove(temp); //... excluo o elemento do vetor
			}
		}	
		calcularImposto();
		return resposta; 
	}
	
	
	public boolean adicionarDeducao(Deducao deducao) {
		boolean resposta = deducoes.add(deducao);
		calcularImposto();
		return resposta; 
	}
	
	
	public boolean excluirDeducao(Deducao deducao){
		boolean resposta = false; 
		Enumeration<Deducao> e = deducoes.elements();
		
		while (e.hasMoreElements()){
			Deducao temp = e.nextElement();
			
			if (temp.getDescricao() == deducao.getDescricao() && 
			    temp.getValor() == deducao.getValor()){  // se descricao e valor s�o iguais...
				if (temp.getClass().getName().equals(Dependente.class.getName())) {  //...verifique se o objeto � da classe DEPENDENTE ... 
					//... se forem da classe dependente, certifique se ambos objetos referem-se ao mesmo dependente.
					Dependente temp2, temp3; 
					temp2 = (Dependente) temp; 
					temp3 = (Dependente) deducao; 
					
					if (temp2.getNome().equals(temp3.getNome())) {
						resposta = deducoes.remove(temp);
					}
				} else {
					resposta = deducoes.remove(temp);
				}
			} 
		}
		
		calcularImposto();
		return resposta;
	}


	public float getTotalRendimentos() {
		return totalRendimentos;
	}

	public float getTotalRendimentosTributaveis() {
		return totalRendimentosTributaveis;
	}
	
	public float getTotalRendimentosIsentos() {
		return totalRendimentosIsentos;
	}

	public double getTotalDeducoes() {
		return totalDeducoes;
	}
	
	public double getBaseDeCalculo() {
		return baseDeCalculo;
	}

	public float getValor1aFaixa() {
		return valor1aFaixa;
	}

	public float getValor2aFaixa() {
		return valor2aFaixa;
	}

	public float getValor3aFaixa(){
		return valor3aFaixa;
	}
	

	public float getValor4aFaixa() {
		return valor4aFaixa;
	}

	public float getValor5aFaixa() {
		return valor5aFaixa;
	}
}
