package org.classes;

import java.util.*;

public class ContaCorrente {
    private String titular;
    private Double saldo;
    private List<Historico> listaHistorico;

    public ContaCorrente(String titular, Double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.listaHistorico = new ArrayList<>();
    }

    public void depositar(Double valor, Integer mes, Integer dia, Integer ano){
        boolean validacaoValor = valor <= 0;
        if(validacaoValor){
            System.out.println("precisa ser maior que 0");
        }else{
            saldo += valor;
            Historico operacao = new Historico (dia,mes,ano,valor,"deposito");
            listaHistorico.add(operacao);
        }
    }

    public void saque(Double valor, Integer mes, Integer dia, Integer ano){
        boolean verificaSaldo = valor <= saldo && valor >=0;
        if(verificaSaldo){
            saldo -= valor;
            Historico operacao = new Historico (dia,mes,ano,valor,"saque");
            listaHistorico.add(operacao);
        }else{
            System.out.println("valor deve ser menor ou igual ao total");
        }
    }

    public void exibirExtrato(){
        System.out.println(titular);
        System.out.println(saldo);
        listaHistorico.forEach(System.out::println);
//        listaHistorico.stream().forEach(
//                operacao -> System.out.println(
//                        operacao.getValor() +"-"+ operacao.getAno() + "-" + operacao.getMes() +"-"+ operacao.getDia() +"-" + "R$" + operacao.getValor()));
    }
}
