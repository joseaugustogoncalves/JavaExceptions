public class TesteContaVersao4 {

    public static void main(String[] args) {

        Conta c = new Conta();

        System.out.println("=== Teste de Depósitos ===");
        try {
            c.depositar(100);
            c.depositar(50);
            System.out.println("Saldo após depósitos: " + c.saldo);
        } catch (ValorInvalidoException e) {
            System.out.println("Erro no depósito: " + e.getMessage());
        }

        System.out.println("\n=== Teste de Depósito Inválido ===");
        try {
            c.depositar(0);  // deve lançar ValorInvalidoException
        } catch (ValorInvalidoException e) {
            System.out.println("Exceção apanhada: " + e.getMessage());
        }

        System.out.println("\n=== Teste de Levantamento ===");
        try {
            c.levantar(30);
            System.out.println("Saldo após levantamento: " + c.saldo);
        } catch (ValorInvalidoException | SaldoInsuficienteException e) {
            System.out.println("Erro no levantamento: " + e.getMessage());
        }

        System.out.println("\n=== Teste de Levantamento Inválido (valor <= 0) ===");
        try {
            c.levantar(0);  // deve lançar ValorInvalidoException
        } catch (ValorInvalidoException | SaldoInsuficienteException e) {
            System.out.println("Exceção apanhada: " + e.getMessage());
        }

        System.out.println("\n=== Teste de Levantamento com Saldo Insuficiente ===");
        try {
            c.levantar(1000); // deve lançar SaldoInsuficienteException
        } catch (ValorInvalidoException | SaldoInsuficienteException e) {
            System.out.println("Exceção apanhada: " + e.getMessage());
        }

        System.out.println("\n=== Teste Média dos Depósitos ===");
        try {
            int media = c.mediaDepositos();
            System.out.println("Média dos depósitos: " + media);
        } catch (SemMovimentosException e) {
            System.out.println("Erro ao calcular média: " + e.getMessage());
        }

        System.out.println("\n=== Teste Média dos Levantamentos ===");
        try {
            int media = c.mediaLevantamentos();
            System.out.println("Média dos levantamentos: " + media);
        } catch (SemMovimentosException e) {
            System.out.println("Erro ao calcular média: " + e.getMessage());
        }

        System.out.println("\n=== Teste com Conta Vazia (médias) ===");
        Conta c2 = new Conta();

        try {
            System.out.println("Média depósitos (conta vazia): " + c2.mediaDepositos());
        } catch (SemMovimentosException e) {
            System.out.println("Exceção esperada: " + e.getMessage());
        }

        try {
            System.out.println("Média levantamentos (conta vazia): " + c2.mediaLevantamentos());
        } catch (SemMovimentosException e) {
            System.out.println("Exceção esperada: " + e.getMessage());
        }

        System.out.println("\n=== Fim dos testes ===");
    }
}
