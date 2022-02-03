package teste_pratico;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class Funcionario extends Pessoa {

	private String salario;
	private String cargo;	
	    
	
	Funcionario(String nome, String data, String salario, String cargo){
		super(nome,data);
		this.salario = salario;
		this.cargo = cargo;
	}
  
	
	//SALARIO
	public String getSalario(){ return this.salario; }
	public String getSalarioFormato(){
		DecimalFormat df = new DecimalFormat("#,###.00");
		BigDecimal salarioBig = new BigDecimal(this.salario);  
		return df.format(salarioBig); 
	}
	public void setSalario(BigDecimal salario){ 
		String s = salario.toString();
		this.salario = s; 
	}    

	    	    
	//CARGO
	public String getCargo(){ return this.cargo; }
	public void setCargo(String cargo){ this.cargo = cargo; }
	    
	    	    
	@Override
	public String toString() {
		return "[Nome=" + super.getNome() + 
				", Data=" + super.getData() + 
				", Salario=" + getSalarioFormato() + 
				", Cargo=" + this.cargo + "]";
	}
}
