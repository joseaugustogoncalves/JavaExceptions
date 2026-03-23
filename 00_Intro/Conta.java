import java.util.ArrayList;

/**
 * Versão 3 da Conta
 * Implementação das pré‑condições com exceções.
 * Esta versão já impede estados inválidos e falhas lógicas.
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
     *  - valor > 0
     *
     * Exceções:
     *  - IllegalArgumentException se valor <= 0
     *
     * Pós-condições:
     *  - saldo aumenta
     *  - movimento do tipo DEPOSITO é registado
     */
    public void depositar(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser maior do que zero.");
        }

        saldo += valor;
        movimentos.add(new Movimento(Movimento.Tipo.DEPOSITO, valor));
    }

    /**
     * Regista um levantamento na conta.
     *
     * Pré-condições:
     *  - valor > 0
     *  - valor <= saldo (para evitar saldo negativo)
     *
     * Exceções:
     *  - IllegalArgumentException se valor <= 0
     *  - IllegalStateException se valor > saldo
     *
     * Pós-condições:
     *  - saldo diminui
     *  - movimento LEVANTAMENTO é registado
     */
    public void levantar(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do levantamento deve ser maior do que zero.");
        }

        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente para realizar o levantamento.");
        }

        saldo -= valor;
        movimentos.add(new Movimento(Movimento.Tipo.LEVANTAMENTO, valor));
    }

    /**
     * Calcula a média dos depósitos.
     *
     * Pré-condições:
     *  - Deve existir pelo menos um depósito.
     *
     * Exceções:
     *  - IllegalStateException se cont == 0
     *
     * Pós-condições:
     *  - Nenhum estado é alterado
     */
    public int mediaDepositos() {
        int soma = 0;
        int cont = 0;

        for (Movimento m : movimentos) {
            if (m.tipo == Movimento.Tipo.DEPOSITO) {
                soma += m.valor;
                cont++;
            }
        }

        if (cont == 0) {
            throw new IllegalStateException("Não existem depósitos para calcular a média.");
        }

        return soma / cont;
    }

    /**
     * Calcula a média dos levantamentos.
     *
     * Pré-condições:
     *  - Deve existir pelo menos um levantamento.
     *
     * Exceções:
     *  - IllegalStateException se cont == 0
     *
     * Pós-condições:
     *  - Nenhum estado é alterado
     */
    public int mediaLevantamentos() {
        int soma = 0;
        int cont = 0;

        for (Movimento m : movimentos) {
            if (m.tipo == Movimento.Tipo.LEVANTAMENTO) {
                soma += m.valor;
                cont++;
            }
        }

        if (cont == 0) {
            throw new IllegalStateException("Não existem levantamentos para calcular a média.");
        }

        return soma / cont;
    }

}