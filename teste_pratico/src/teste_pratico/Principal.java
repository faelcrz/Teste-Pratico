package teste_pratico;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

	
public class Principal{		
	
  public static void main(String[] args) {
	  DecimalFormat formatador = new DecimalFormat("#,###.00");
	  
	  
	  ArrayList<Funcionario> funcionarios = new ArrayList<>();
	  funcionarios.add(new Funcionario("Maria", "18/10/2000","2009.44","Operador"));
	  funcionarios.add(new Funcionario("João", "12/05/1990","2284.38","Operador"));
	  funcionarios.add(new Funcionario("Caio", "02/05/1961","9836.14","Coordenador"));
	  funcionarios.add(new Funcionario("Miguel", "14/10/1988","19119.88","Diretor"));    
	  funcionarios.add(new Funcionario("Alice", "05/01/1995","2234.68","Recepcionista"));
	  funcionarios.add(new Funcionario("Heitor", "19/11/1999","1582.72","Operador"));
	  funcionarios.add(new Funcionario("Arthur", "31/03/1993","4071.84","Contador"));  
	  funcionarios.add(new Funcionario("Laura", "08/07/1994","3017.45","Gerente"));
	  funcionarios.add(new Funcionario("Heloísa", "24/05/2003","1606.85","Eletricista"));
	  funcionarios.add(new Funcionario("Helena", "02/09/1996","2799.93","Gerente"));
	    
	    
	  //Remove Funcionario João da lista
	  funcionarios.removeIf(n -> (n.getNome() == "João"));
	    
	  
	  System.out.println();
	  System.out.println("--Imprimir todos usuários--");
	  System.out.println();
	  //imprime todos usuarios	
	  for(Funcionario funcionario : funcionarios){
		  System.out.println(funcionario);
	  } 

	  	  
	  //10% de aumento
	  for(Funcionario funcionario : funcionarios){
		  BigDecimal salarioSemAumento = new BigDecimal(funcionario.getSalario());
		  BigDecimal aumentoDezPorcento = new BigDecimal("1.10");
		  BigDecimal salarioComDezPorcento = salarioSemAumento.multiply(aumentoDezPorcento);
		  funcionario.setSalario(salarioComDezPorcento);	  	 
	  } 
	  	  

	  //Função MAP
      Map<String, List<Funcionario>> gruposCargos = 
    		  funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getCargo));
      
	  System.out.println();
	  System.out.println("--Grupos de Cargos--");
	  System.out.println();    
      //Print funcionarios separados por cargos
	  System.out.println(gruposCargos);

	  	  
	  System.out.println();
	  System.out.println("--Funcionarios que fazem aniversario no mes 10 e 12--");
	  System.out.println();
	  //Funcionarios do mes 10 e 12
	  for(Funcionario funcionario : funcionarios){
  		if(funcionario.getDataMes() == 10 || funcionario.getDataMes() == 12){
  		   System.out.println(funcionario);
  		}
	  }
	  
	  
	  System.out.println();
	  System.out.println("-- Funcionario com Maior Idade --");
	  System.out.println();		  
	  //Idade
	  int maiorIdade = 0;
	  String nomeMaiorIdade = "";
	  for(Funcionario funcionario : funcionarios){
		  if(funcionario.getIdade() > maiorIdade) {
		  	maiorIdade = funcionario.getIdade();
		  	nomeMaiorIdade = funcionario.getNome();
		  }
	  } 
	  System.out.println("Nome: " + nomeMaiorIdade + "- Idade: " + maiorIdade);
	  
	  	  

	  System.out.println();
	  System.out.println("-- Ordem Alfabetica --");
	  System.out.println();	
	  //Ordem Alfabetica
	  ArrayList<String> ordemAlfabetica = new ArrayList<>(); 
	  for(Funcionario funcionario : funcionarios){
		  ordemAlfabetica.add(funcionario.getNome());
	  }
	  Collections.sort(ordemAlfabetica);
	  for(String ordem : ordemAlfabetica){
		  for(Funcionario funcionario : funcionarios){
			  if(ordem == funcionario.getNome()) {
				  System.out.println(funcionario);
			  }
		  }
	  }
	  
	  
	  System.out.println();
	  System.out.println("-- Total Salario --");
	  System.out.println();	  
	  //Total Salario
	  BigDecimal salariototal = new BigDecimal("0");
	  for(Funcionario funcionario : funcionarios){
		  BigDecimal b = new BigDecimal(funcionario.getSalario());
		  salariototal = b.add(salariototal);	  	 
	  }
	  System.out.println("Salario Total: " + formatador.format(salariototal));
	  	  
	  	  

	  System.out.println();
	  System.out.println("-- Salarios Minimos por Pessoa --");
	  System.out.println();
	  //SalariosMinimoPorPessoa
	  for(Funcionario funcionario : funcionarios){
		  BigDecimal salarioMinimoPessoa = new BigDecimal("0");
		  BigDecimal b = new BigDecimal(funcionario.getSalario());		  
		  BigDecimal SalarioMinimo = new BigDecimal("1212");
		  salarioMinimoPessoa = b.divide(SalarioMinimo, MathContext.DECIMAL128);	
		  System.out.println(funcionario +" - Qtde de salarios: " +formatador.format(salarioMinimoPessoa));
	 }	  
  }
}