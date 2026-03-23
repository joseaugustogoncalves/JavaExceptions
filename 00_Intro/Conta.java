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
    
    public double mediaDepositos() {
        double soma = 0;
        int cont = 0;
    
        for (Movimento m : movimentos) {
            if (m.tipo == Movimento.Tipo.DEPOSITO) {
                soma += m.valor;
                cont++;
            }
        }
    
        return soma / cont;
    }

    public double mediaLevantamentos() {
        double soma = 0;
        int cont = 0;
    
        for (Movimento m : movimentos) {
            if (m.tipo == Movimento.Tipo.LEVANTAMENTO) {
                soma += m.valor;
                cont++;
            }
        }
    
        return soma / cont;
    }

}