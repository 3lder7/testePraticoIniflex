package testeIniflex;
import java.math.BigDecimal;//importação de BigDecimal para melhor trabalho com valores mais precisos
import java.text.NumberFormat;
import java.time.LocalDate;//importação de localdate para uso de datas
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class principal {
	public static void main(String[] args) {
		//criação de uma arraylist para armazenar todos os funcionarios referenciando a subclasse funcionario
		List<funcionario> funcionarios = new ArrayList<>(Arrays.asList(
                new funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));
		
		 //remove joao da lista
		 funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));
		 
		 //criação de instâncias dos formatadores de texto 
	     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");//cria um datformatter para o padrão pedido de data (dd/mm/aaaa)
	     NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));//cria um numberFormat para o padrão brasileiro R$
	     
	     
	     
	     //foreach para imprimir a lista de funcionarios data salario e sua função
		 System.out.println("Funcionários:");
	        for (funcionario i : funcionarios){				
				System.out.println(i.getNome() + " - " + i.getDataNascimento().format(dateFormatter) + " - " +
	                    currencyFormatter.format(i.getSalario()) + " - " + i.getFuncao());
	        }
	        
	        
	        
	        
	     //iterando por cada funcionario e retornando i como bigdecimal fazendo o cálculo para o aumento de 10%
	     funcionarios.forEach(i -> i.setSalario(i.getSalario().multiply(BigDecimal.valueOf(1.10))));
	     
	     //não entendi como funciona o map, então passei a 3.5 e 3.6
	     
	     
	     //imprimir funcionarios que fazem aniversaio mês 10 e 12
	     System.out.println("\nFuncionários que fazem aniversário nos meses 10 e 12:");
	        funcionarios.stream()//converte a lista em um fluxo stream
	                .filter(i -> i.getDataNascimento().getMonthValue() == 10 || i.getDataNascimento().getMonthValue() == 12)//vericação do mês para sua impressão
	                .forEach(i -> System.out.println(i.getNome() + " - " + i.getDataNascimento().format(dateFormatter)));//for each para imprimir os funcionarios dps dps da verificação
	  
	        
	        
	        
	      //imprimir funcionario mais velho
	     funcionario maisVelho = funcionarios.stream().min(Comparator.comparing(funcionario::getDataNascimento))//metodo min para encontrar o elemento de menor valor e compara os objetos com base na data de nasimento
	                .orElseThrow(NoSuchElementException::new);//retorna o menor valor encontrad ou exceção caso esteja vazio
	     
	     //calcula a diferença de anos entre a data de nascimento do funcionário mais velho e a data atual
	     int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
	        System.out.println("\nFuncionário com a maior idade:");
	        System.out.println(maisVelho.getNome() + " - " + idade + " anos");//exibe nome e a idade referenciando o objeto "maisVelho"
	        
	        
	        
	     //ordem alfabetica
	        System.out.println("\nFuncionários em ordem alfabética:");
	      //fluxo de elementos pra ordenar pelo nome em ordem alfabética
	        funcionarios.stream().sorted(Comparator.comparing(funcionario::getNome)).forEach(i -> System.out.println(i.getNome()));
	        
	        
	        
	      //calculo total
	        BigDecimal totalSalarios = funcionarios.stream().map(funcionario::getSalario)//pega todos os salalrios dos funcionarios (utilizei o map aqui mas com ajuda de pesquisas na web, pois n estudei ainda essa função)
	        		.reduce(BigDecimal.ZERO, BigDecimal::add);
	        System.out.println("\nTotal dos salários: " + currencyFormatter.format(totalSalarios));//imprime o salario total como R$(formatador)
	        
	        
	       //3.12 tentei e até consegui pesquisando um pouco, mas não entendi como funcionava então achei melhor não pôr
	}

}
