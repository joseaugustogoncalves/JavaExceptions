
/**
 * Exemplo de um Error: StackOverflowError
 * O StackOverflowError ocorre quando a pilha de chamadas (stack) 
 * fica cheia, normalmente devido a recursão infinita.
 * 
 * Quando o programa corre, a JVM começa a chamar causarStackOverflow() 
 * repetidamente, guardando cada chamada na stack.
 * Como nunca há uma condição de paragem, 
 * a stack fica cheia e a JVM lança:
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class ErrorClass02
{
    
    // Método recursivo que nunca termina
    public void causarStackOverflow() {
        causarStackOverflow(); // chamada recursiva sem condição de paragem
    }

}