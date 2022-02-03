package teste_pratico;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    private String nome;
    private String data;
   
    
    Pessoa(String nome,String data){
        this.nome = nome;
        this.data = data;
    }
    
    
    //NOME
    public String getNome(){ return this.nome; }
    public void setNome(String nome){ this.nome = nome; }
       
    
    //DATAS E IDADE
    public String getData(){ 
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          LocalDate formatDateTime = LocalDate.parse(data, formatter);
          return formatDateTime.format(formatter);
    }
    public int getDataMes(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate formatDateTime = LocalDate.parse(data, formatter);
        int mes = formatDateTime.getMonthValue();
        return mes;
    } 
    public int getIdade(){ 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate dataAniversario = LocalDate.parse(data, formatter);
        LocalDate date = LocalDate.now(); // test, in real world without args
        return Period.between(dataAniversario, date).getYears();
    }

}