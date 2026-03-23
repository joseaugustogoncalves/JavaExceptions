
/**
 * Escreva uma descrição da classe ExceptionClass03 aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ExceptionClass03
{
    
    // Erro em tempo de execução: NumberFormatException.
    // O método Integer.parseInt() tenta converter a string "FCP" para um número inteiro.
    // Como a string contém letras e não representa um valor numérico válido,
    // o método lança uma NumberFormatException, interrompendo o programa se não for tratada.
    public static void main(String[] args) {
        int myInt = Integer.parseInt("FCP");
    }
}