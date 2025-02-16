package br.com.dio.poo.exercicios;

import java.util.Scanner;

public class Exercicio3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Criar uma nova conta bancária com o saldo inicial
    double saldoInicial = scanner.nextDouble();
    ContaBancaria1 conta = new ContaBancaria1(saldoInicial);

    // Lê a Entrada com o valor do deposito e aciona o método "depositar"
    double valorDeposito = scanner.nextDouble();
    conta.depositar(valorDeposito);

    // Lê a Entrada com o valor do saque e aciona o método "sacar"
    double valorSaque = scanner.nextDouble();
    conta.sacar(valorSaque);

    // Fechar o scanner para evitar vazamentos de recursos
    scanner.close();
  }
}

class ContaBancaria {
  private double saldo;

  public ContaBancaria(double saldoInicial) {
    this.saldo = saldoInicial;
  }

  public void depositar(double valor) {
    saldo += valor;
    System.out.println("Deposito feito.");
    // Incrementar o saldo com o valor e imprimir "Depósito feito."
    imprimirSaldo();
  }

  public void sacar(double valor) {
    if (saldo >= valor) {
      saldo -= valor;
      System.out.println("Saque feito.");
    } else {
      System.out.println("Saldo insuficiente. Saque não realizado.");
    }
    // Verificar se o saldo é suficiente considerando o valor:
    // Se sim, atualizar o saldo e imprimir "Saque feito."
    // Se não, imprimir "Saldo insuficiente. Saque não realizado."
    imprimirSaldo();
  }

  private void imprimirSaldo() {
    System.out.printf("Saldo atual: %.1f\n", this.saldo);
  }
}
