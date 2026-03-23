import java.util.ArrayList;
/**
 * Escreva uma descrição da classe Conta aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Conta
{
    // Variáveis de Instância
    public double saldo = 0;
    public ArrayList<Movimento> movimentos = new ArrayList<>();

    public void depositar(double valor) {
        saldo += valor;
        movimentos.add(new Movimento(Movimento.Tipo.DEPOSITO, valor));
    }

    public void levantar(double valor) {
        saldo -= valor;
        movimentos.add(new Movimento(Movimento.Tipo.LEVANTAMENTO, valor));
    }

}