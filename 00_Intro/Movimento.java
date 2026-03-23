
/**
 * Escreva uma descrição da classe Movimento aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Movimento
{
    // variáveis de instância
    public enum Tipo { DEPOSITO, LEVANTAMENTO }

    public Tipo tipo;
    public double valor;

    public Movimento(Tipo tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

}