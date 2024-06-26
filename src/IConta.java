
public interface IConta {

    void sacar(double valor, Boolean mostrarInformacao);

    void depositar(double valor, Boolean mostrarInformacao);

    void pegarEmprestimo(double valor);

    void pagarEmprestimo(double valor);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();
}
