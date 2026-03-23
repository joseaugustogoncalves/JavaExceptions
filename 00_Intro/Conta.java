import java.util.ArrayList;

/**
 * Versão 4 da Conta
 * Implementação das pré‑condições com exceções personalizadas.
 * Esta versão representa corretamente as regras de negócio.
 */
public class Conta
{
    public int saldo = 0;
    public ArrayList<Movimento> movimentos = new ArrayList<>();

    /**
     * Regista um depósito na conta.
     *
     * @param valor valor a depositar; deve ser > 0
     * @throws ValorInvalidoException se valor <= 0
     */
    public void depositar(int valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor do depósito deve ser maior que zero.");
        }

        saldo += valor;
        movimentos.add(new Movimento(Movimento.Tipo.DEPOSITO, valor));
    }

    /**
     * Regista um levantamento na conta.
     *
     * @param valor valor a levantar; deve ser > 0 e <= saldo
     * @throws ValorInvalidoException se valor <= 0
     * @throws SaldoInsuficienteException se valor > saldo
     */
    public void levantar(int valor)
            throws ValorInvalidoException, SaldoInsuficienteException {

        if (valor <= 0) {
            throw new ValorInvalidoException("O valor do levantamento deve ser maior que zero.");
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para o levantamento.");
        }

        saldo -= valor;
        movimentos.add(new Movimento(Movimento.Tipo.LEVANTAMENTO, valor));
    }

    /**
     * Calcula a média dos depósitos.
     *
     * @return média dos valores depositados
     * @throws SemMovimentosException se não houver depósitos
     */
    public int mediaDepositos() throws SemMovimentosException {
        int soma = 0;
        int cont = 0;

        for (Movimento m : movimentos) {
            if (m.tipo == Movimento.Tipo.DEPOSITO) {
                soma += m.valor;
                cont++;
            }
        }

        if (cont == 0) {
            throw new SemMovimentosException("Não existem depósitos para calcular a média.");
        }

        return soma / cont;
    }

    /**
     * Calcula a média dos levantamentos.
     *
     * @return média dos levantamentos efetuados
     * @throws SemMovimentosException se não houver levantamentos
     */
    public int mediaLevantamentos() throws SemMovimentosException {
        int soma = 0;
        int cont = 0;

        for (Movimento m : movimentos) {
            if (m.tipo == Movimento.Tipo.LEVANTAMENTO) {
                soma += m.valor;
                cont++;
            }
        }

        if (cont == 0) {
            throw new SemMovimentosException("Não existem levantamentos para calcular a média.");
        }

        return soma / cont;
    }
}
