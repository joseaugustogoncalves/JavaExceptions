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
    public int saldo = 0;
    public ArrayList<Movimento> movimentos = new ArrayList<>();
    
    /**
     * Regista um depósito na conta.
     *
     * Pré-condições:
     *  - valor deve ser maior que zero.
     *
     * Pós-condições:
     *  - o saldo aumenta em 'valor';
     *  - um movimento do tipo DEPOSITO é adicionado à lista.
     */
    public void depositar(int valor) {
        
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return;
        }

        saldo += valor;
        movimentos.add(new Movimento(Movimento.Tipo.DEPOSITO, valor));
    }
    
    /**
     * Regista um levantamento na conta.
     *
     * Pré-condições:
     *  - valor deve ser maior que zero;
     *  - valor deve ser menor ou igual ao saldo atual
     *    (para evitar saldo negativo).
     *
     * Pós-condições:
     *  - o saldo diminui em 'valor';
     *  - um movimento do tipo LEVANTAMENTO é adicionado.
     */
    public void levantar(int valor) {
        
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
    
    
    /**
     * Calcula a média dos valores de todos os depósitos realizados.
     *
     * Pré-condições:
     *  - deve existir pelo menos um movimento do tipo DEPOSITO;
     *    caso contrário, ocorrerá divisão por zero.
     *
     * Pós-condições:
     *  - nenhuma alteração ao estado interno da conta.
     *
     * Nota: esta versão não verifica as pré-condições.
     */

    public int mediaDepositos() {
        int soma = 0;
        int cont = 0;
        
        if(this.movimentos.size() == 0) {
            return 0;    
        }
        
        for (Movimento m : movimentos) {
            if (m.tipo == Movimento.Tipo.DEPOSITO) {
                soma += m.valor;
                cont++;
            }
        }
        
        if (cont == 0) {
            return 0;
        }
        
        return soma / cont;
    }

    /**
     * Calcula a média dos valores dos levantamentos.
     *
     * Pré-condições:
     *  - deve existir pelo menos um movimento do tipo LEVANTAMENTO;
     *    caso contrário, ocorrerá divisão por zero.
     *
     * Pós-condições:
     *  - nenhuma alteração ao estado interno da conta.
     *
     * Nota: esta versão não verifica as pré-condições.
     */

    public int mediaLevantamentos() {
        int soma = 0;
        int cont = 0;
        
        if(this.movimentos.size() == 0) {
            return 0;    
        }
        
        for (Movimento m : movimentos) {
            if (m.tipo == Movimento.Tipo.LEVANTAMENTO) {
                soma += m.valor;
                cont++;
            }
        }
        
        if (cont == 0) {
            return 0;
        }
        
        return soma / cont;
    }

}