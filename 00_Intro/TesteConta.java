public class TesteConta {

    public static void main(String[] args) {

        Conta c = new Conta();

        System.out.println("=== Teste de Depósitos ===");
        try {
            c.depositar(100);
            c.depositar(50);
            System.out.println("Saldo após depósitos: " + c.saldo);
        } catch (Exception e) {
            System.out.println("Erro no depósito: " + e.getMessage());
        }

        System.out.println("\n=== Teste de Depósito Inválido ===");
        try {
            c.depositar(0);   // Deve lançar IllegalArgumentException
        } catch (Exception e) {
            System.out.println("Exceção apanhada: " + e.getMessage());
        }

        System.out.println("\n=== Teste de Levantamentos ===");
        try {
            c.levantar(30);
            System.out.println("Saldo após levantamento: " + c.saldo);
        } catch (Exception e) {
            System.out.println("Erro no levantamento: " + e.getMessage());
        }

        System.out.println("\n=== Teste de Levantamento com Saldo Insuficiente ===");
        try {
            c.levantar(1000); // Deve lançar IllegalStateException
        } catch (Exception e) {
            System.out.println("Exceção apanhada: " + e.getMessage());
        }

        System.out.println("\n=== Teste da Média dos Depósitos ===");
        try {
            System.out.println("Média dos depósitos: " + c.mediaDepositos());
        } catch (Exception e) {
            System.out.println("Erro ao calcular média: " + e.getMessage());
        }

        System.out.println("\n=== Teste da Média dos Levantamentos ===");
        try {
            System.out.println("Média dos levantamentos: " + c.mediaLevantamentos());
        } catch (Exception e) {
            System.out.println("Erro ao calcular média: " + e.getMessage());
        }

        System.out.println("\n=== Teste da Média sem Movimentos ===");
        Conta c2 = new Conta(); // conta vazia
        try {
            System.out.println("Média de depósitos (conta vazia): " + c2.mediaDepositos());
        } catch (Exception e) {
            System.out.println("Exceção esperada: " + e.getMessage());
        }
    }
}