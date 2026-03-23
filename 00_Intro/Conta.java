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
    public int saldo = 0;
    public ArrayList<Movimento> movimentos = new ArrayList<>();

    public void depositar(int valor) {
        saldo += valor;
        movimentos.add(new Movimento(Movimento.Tipo.DEPOSITO, valor));
    }

    public void levantar(int valor) {
        saldo -= valor;
        movimentos.add(new Movimento(Movimento.Tipo.LEVANTAMENTO, valor));
    }
    
    public int mediaDepositos() {
        int soma = 0;
        int cont = 0;
    
        for (Movimento m : movimentos) {
            if (m.tipo == Movimento.Tipo.DEPOSITO) {
                soma += m.valor;
                cont++;
            }
        }
    
        return soma / cont;
    }

    public int mediaLevantamentos() {
        int soma = 0;
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