
/**
 *  1. Erros de Sintaxe — detetados pelo compilador
 * Estes são os erros mais básicos.
 * Acontecem antes do programa executar, durante a compilação.
 * Ocorrem quando o código não segue as regras da linguagem Java.
 * 
 * Estes não são Errors (classe Error) da JVM.
 * São problemas detetados pelo compilador, antes do programa correr.
 */
public class ErroSintaxe01
{
    public static void main(String[] args) {
        System.out.println("-- ERRO --")// falta ponto e vírgula → ERRO DE SINTAXE
    }

}