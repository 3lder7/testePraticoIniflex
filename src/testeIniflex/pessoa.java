package testeIniflex;
import java.time.LocalDate;

public class pessoa {
	//variaveis privadas que pertencem a esta classe
    private String nome;
    private LocalDate dataNascimento;

    public pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    //get e sets de pessoa
    public void setNome(String nome) {
        this.nome = nome;
    }//set de nome
    
    public String getNome() {
        return nome;
    }//retorna o valor de nome

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }//set de data de nascimento

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }//retorna o valor de data de nasc

}
