package contas;

public abstract class Conta {

    protected String name;
    protected int agencia;
    protected  int numeroConta;
    protected double saldo;

    public Conta() {
    }

    public Conta(String name, int agencia, int numeroConta, double saldo) {
        this.name = name;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getName() {
        return name;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public  void sacar(double valor){
        if(saldo < valor){
            throw new RuntimeException("Saldo Insuficiente");
        }
        saldo -= valor;
    }
    public void depositar(double valor){
        saldo += valor;

    }
    public  void transferir(double valor, Conta contaDestino){
        if (saldo < valor){
            throw new RuntimeException("Saldo Insuficiente");
        }
        sacar(valor);
        contaDestino.depositar(valor);
    }
}
