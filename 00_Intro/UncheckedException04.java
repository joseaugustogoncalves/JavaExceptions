/**
 * Não são obrigatórias de tratar. 
 * Acontecem muitas vezes por erros de programação.
 * Exemplos:
 * NullPointerException
 * ArithmeticException
 * ArrayIndexOutOfBoundsException
 * IllegalArgumentException
 */
public class UncheckedException04
{
    public static void main(String[] args) {
        // NullPointerException        
        // met1();
        // ArrayIndexOutOfBoundsException
        met2();
    }
    
    private static void met1() {
        // NullPointerException: tentar chamar método numa referência a null
        String nome = null;
        System.out.println(nome.length());
    }
    
    private static void met2() {
        // ArrayIndexOutOfBoundsException: índice 5 não existe em array de tamanho 3
        int[] numeros = {1, 2, 3};
        int x = numeros[5];
    }
}