package testeIniflex;
import java.math.BigDecimal;
import java.time.LocalDate;

public class funcionario extends pessoa {
	//variaveis privadas que pertencem a esta classe
    private BigDecimal salario;
    private String funcao;

    public funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);//super para referenciar nome e data de nascimento da classe pesssoa
        this.salario = salario;
        this.funcao = funcao;
    }

    //get e sets de funcionario
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }//set de salario
    
    public BigDecimal getSalario() {
        return salario;
    }//return de salario

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }//set de função

    public String getFuncao() {
        return funcao;
    }//return de funcao

}
