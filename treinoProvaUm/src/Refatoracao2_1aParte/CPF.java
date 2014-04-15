package Refatoracao2_1aParte;

public class CPF {
	
	//final int[] cpf;  //antiga representacao do CPF por vetor... 
	NovoCPF novoCPF;
	
	public CPF(int[] cpf) {
		//this.cpf = cpf;
		this.novoCPF = new NovoCPF();
		this.novoCPF.set1oDigito(cpf[0]);
		this.novoCPF.set2oDigito(cpf[1]);
		this.novoCPF.set3oDigito(cpf[2]);
		this.novoCPF.set4oDigito(cpf[3]);
		this.novoCPF.set5oDigito(cpf[4]);
		this.novoCPF.set6oDigito(cpf[5]);
		this.novoCPF.set7oDigito(cpf[6]);
		this.novoCPF.set8oDigito(cpf[7]);
		this.novoCPF.set9oDigito(cpf[8]);
		this.novoCPF.set10oDigito(cpf[9]);
		this.novoCPF.set11oDigito(cpf[10]);		
	}
	
	public int[] getCPF() {
		return new int[]{novoCPF.get1oDigito(), 
				         novoCPF.get2oDigito(), 
				         novoCPF.get3oDigito(), 
				         novoCPF.get4oDigito(), 
				         novoCPF.get5oDigito(), 
				         novoCPF.get6oDigito(), 
				         novoCPF.get7oDigito(), 
				         novoCPF.get8oDigito(), 
				         novoCPF.get9oDigito(), 
				         novoCPF.get10oDigito(), 
				         novoCPF.get11oDigito()};
	}
	
	
}
