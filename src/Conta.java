
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected double saldoDevedor;
    protected Cliente cliente;
    protected String nivel;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor, Boolean mostrarInformacao) {
        saldo -= valor;
        if (mostrarInformacao) {
            System.out.println("Saque realizado: R$ " + valor);
        }
    }

    @Override
    public void depositar(double valor, Boolean mostrarInformacao) {
        saldo += valor;
        if (mostrarInformacao) {
            System.out.println("Depósito realizado: R$ " + valor);
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor, false);
        contaDestino.depositar(valor, false);
        System.out.println("Transferência realizada: R$ " + valor);
    }

    @Override
    public void pegarEmprestimo(double valor) {
        this.depositar(valor, false);
        this.alterarSaldoDevedor(valor * -1);
        System.out.println("Empréstimo realizado: R$ " + valor);
    }

    @Override
    public void pagarEmprestimo(double valor) {
        this.alterarSaldoDevedor(valor);
        System.out.println("Pagamento de empréstimo realizado: R$ " + valor);
    }

    private void alterarSaldoDevedor(double valor) {
        this.saldoDevedor += valor;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNivel() {
        return nivel;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Celular: %s", this.cliente.getCelular()));
        System.out.println("------------------------------");
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        if (this.saldoDevedor != 0) {
            System.out.println(String.format("Saldo Devedor: %.2f", this.saldoDevedor));
        }
    }
}
