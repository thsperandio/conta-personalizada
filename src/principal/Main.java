package principal;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<ContaCorrente> corrente = new ArrayList<>();
        List<ContaPoupanca> poupancas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas Contas Deseja Criar: ");

        int quantidadeContas;
        quantidadeContas = sc.nextInt();

        try {
            quantidade(quantidadeContas);

        }catch (ParametrosInvalidosExeption exeption){
            System.out.println("Quantidade de contas deve ser maior que 0");
            do{
                System.out.print("Entre o número novamente: ");
                quantidadeContas = sc.nextInt();
            }while (quantidadeContas <= 0);

        }

        sc.nextLine();

        for(int i = 0; i < quantidadeContas;i++){
            System.out.print("Nome do Cliente: ");
            String name = sc.nextLine();
            System.out.print("Número da Agência: ");
            int agencia = sc.nextInt();
            System.out.print("Número da Conta: ");
            int numeroConta =  sc.nextInt();

            corrente.add(new ContaCorrente(name,agencia,numeroConta,0));

            Conta cc = new ContaCorrente(name,agencia,numeroConta,0);
            Conta cp = new ContaPoupanca("Jose", 1,3,0);
            cc.depositar(100);
            System.out.println("Saldo: " + cc.getSaldo());
            cc.sacar(50);
            System.out.println("Saldo: " + cc.getSaldo());
            cc.transferir(25,cp);
            System.out.println("Saldo: " + cc.getSaldo());
            System.out.println("Saldo: " + cp.getSaldo());
        }
            sc.nextLine();

        System.out.println("=========================================");

        for (int i = 0; i < quantidadeContas; i++){
            System.out.print("Nome do Cliente: ");
            String name = sc.nextLine();
            System.out.print("Número da Agência: ");
            int agencia = sc.nextInt();
            System.out.print("Número da Conta: ");
            int numeroConta =  sc.nextInt();

            poupancas.add(new ContaPoupanca(name,agencia,numeroConta,0));

            Conta cp = new ContaPoupanca(name,agencia,numeroConta,0);
            Conta cc = new ContaCorrente("Pedereneiras", 1,2,0);

            cp.depositar(100);
            System.out.println("Saldo: " + cp.getSaldo());
            cp.sacar(50);
            System.out.println("Saldo: " + cp.getSaldo());
            cp.transferir(25,cc);
            System.out.println("Saldo CP: " + cp.getSaldo());
            System.out.println("Saldo CC: " + cc.getSaldo());

        }

        System.out.println("=========================================");

        for (ContaCorrente c: corrente){
            System.out.println(c.getAgencia());
            System.out.println(c.getName());
            System.out.println(c.getSaldo());
        }

        for (ContaPoupanca p: poupancas){
            System.out.println(p.getAgencia());
            System.out.println(p.getName());
            System.out.println(p.getSaldo());
        }
        sc.close();
    }
    public static void quantidade(int quantidadeContas) throws ParametrosInvalidosExeption {

        if (quantidadeContas <= 0){
            throw new ParametrosInvalidosExeption();
        }
    }
}