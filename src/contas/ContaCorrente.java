package contas;

public class ContaCorrente extends Conta{

    public ContaCorrente(String name, int agencia, int numeroConta, double saldo) {
        super(name, agencia, numeroConta, saldo);
    }

    @Override
    public void sacar(double valor) {
        super.sacar(valor);
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        super.transferir(valor, contaDestino);
    }
}
