package org.classes;

public class TesteContaCorrente {
    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("Jose", 0.0);
        conta.depositar(500.0,9,20,1999);
        conta.depositar(-500.0,9,21,1999);
        conta.saque(200.0,9,20,1999);
        conta.saque(-200.0,9,20,1999);
        conta.exibirExtrato();


    }
}
