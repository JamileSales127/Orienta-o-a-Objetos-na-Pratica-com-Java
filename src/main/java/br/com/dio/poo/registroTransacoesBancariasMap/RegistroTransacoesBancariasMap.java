package br.com.dio.poo.registroTransacoesBancariasMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class RegistroTransacoesBancariasMap {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Lê o saldo inicial da conta
    double saldo = scanner.nextDouble();

    // Lê a quantidade de transações
    int quantidadeTransacoes = scanner.nextInt();

    // Lista para armazenar as transações
    List<Transacao> transacoes = new ArrayList<>();

    for (int i = 1; i <= quantidadeTransacoes; i++) {
      // Lê o tipo de transação
      char tipoTransacao = scanner.next().charAt(0);

      // Lê o valor da transação
      double valorTransacao = scanner.nextDouble();

      // Cria uma nova transação e adiciona à lista
      Transacao transacao = new Transacao(tipoTransacao, valorTransacao);
      transacoes.add(transacao);

      // Atualiza o saldo com base no tipo de transação
      if (Character.toUpperCase(tipoTransacao) == 'D') {
        saldo += valorTransacao;
      } else if (Character.toUpperCase(tipoTransacao) == 'S') {
        saldo -= valorTransacao;
      }
    }

    // Exibe o saldo final
    System.out.println("Saldo : " + saldo);

    // Exibe a lista de transações utilizando Stream API e Collectors
    System.out.println("Transacoes:");
    String listaTransacoes = transacoes.stream()
        .map(transacao -> Character.toLowerCase(transacao.getTipo()) + " de " + transacao.getValor())
        .collect(Collectors.joining("\n"));
    System.out.println(listaTransacoes);

    // Fecha o scanner para evitar vazamentos de recursos
    scanner.close();
  }
}

class Transacao {
  private char tipo;
  private double valor;

  public Transacao(char tipo, double valor) {
    this.tipo = tipo;
    this.valor = valor;
  }

  public char getTipo() {
    return tipo;
  }

  public double getValor() {
    return valor;
  }
}
