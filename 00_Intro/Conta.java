import java.util.ArrayList;
/**
 * Versão 2 da conta
 * Introduzir pré‑condições (design by contract)
 * Antes de executar um método, 
 * deve‑se garantir o estado mínimo aceitável
 */
public class Conta
{
    // Variáveis de Instância
    public double saldo = 0;
    public ArrayList<Movimento> movimentos = new ArrayList<>();

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return;
        }
        saldo += valor;
        movimentos.add(new Movimento(Movimento.Tipo.DEPOSITO, valor));
    }

    public void levantar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return;
        }
    
        saldo -= valor;
        movimentos.add(new Movimento(Movimento.Tipo.LEVANTAMENTO, valor));
    }

}