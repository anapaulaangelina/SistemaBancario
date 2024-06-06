
public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Ana");
        cliente.setCelular("24999742879");

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);

        System.out.println("## Data: 01/05/2024");
        cc.depositar(100, true);

        System.out.println("## Data: 03/05/2024");
        cc.transferir(100, poupanca);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        System.out.println("\n## Data: 05/05/2024");
        cc.pegarEmprestimo(2500);
        cc.imprimirExtrato();

        System.out.println("\n## Data: 06/05/2024");
        cc.pagarEmprestimo(500);
        cc.imprimirExtrato();
    }
}
