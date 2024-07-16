package br.com.dio.poo.exercicios;


import java.util.Scanner;

abstract class Cofre {
  protected String tipo;
  protected String metodoAbertura;

  public Cofre(String tipo, String metodoAbertura) {
    this.tipo = tipo;
    this.metodoAbertura = metodoAbertura;
  }

  public void imprimirInformacoes() {
    System.out.println("Tipo: " + this.tipo);
    System.out.println("Metodo de abertura: " + this.metodoAbertura);
  }
}

class CofreDigital extends Cofre {
  private int senha;

  public CofreDigital(int senha) {
    super("Cofre Digital", "Senha");
    this.senha = senha;
  }

  public boolean validarSenha(int confirmacaoSenha) {
    return confirmacaoSenha == this.senha;
  }
}

class CofreFisico extends Cofre {
  public CofreFisico() {
    super("Cofre Fisico", "Chave");
  }
}

public class Desafio1 {
  public static void main(String[] args) {
    // Lê o tipo de cofre (primeira linha da entrada)
    Scanner scanner = new Scanner(System.in);
    String tipoCofre = scanner.nextLine();

    if (tipoCofre.equalsIgnoreCase("digital")) {
      // Lê a senha e a confirmação de senha
      int senha = scanner.nextInt();
      int confirmacaoSenha = scanner.nextInt();

      // Cria uma instância de CofreDigital
      CofreDigital cofreDigital = new CofreDigital(senha);
      cofreDigital.imprimirInformacoes();

      // Valida a senha
      if (cofreDigital.validarSenha(confirmacaoSenha)) {
        System.out.println("Cofre aberto!");
      } else {
        System.out.println("Senha incorreta!");
      }
    } else if (tipoCofre.equalsIgnoreCase("fisico")) {
      // Cria uma instância de CofreFisico
      CofreFisico cofreFisico = new CofreFisico();
      cofreFisico.imprimirInformacoes();
    } else {
      System.out.println("Tipo de cofre desconhecido.");
    }

    scanner.close();
  }
}

