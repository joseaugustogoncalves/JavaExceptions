
/**
 * Escreva uma descrição da classe ErrorClassTest02 aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ErrorClassTest02
{
    public static void main(String[] args) {
        ErrorClass02 exemplo = new ErrorClass02();

        System.out.println("A provocar um StackOverflowError...");

        exemplo.causarStackOverflow(); // aqui o erro acontece

        System.out.println("Esta linha nunca será executada!");
    }
        
}