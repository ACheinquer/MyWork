import java.util.*; // Importação das bibliotecas do java

public class Main{

  public static void main(String[] args) throws Exception {
    System.out.println("==INICIO==");

    // Variáveis
    int numeroCiclos = 0;
    int ciclos = 0;
    int cicloCount = 0;
    int escolha = 0;

    try (// Instânciamento da classe Scanner
    Scanner in = new Scanner(System.in)) {
      // Instânciamento da classe Ciclo
      Ciclo ciclo = new Ciclo(ciclos);

      // Print do menu principal!
      System.out.println("---------------------------");
      System.out.println("       0 - Sair            ");
      System.out.println("       1 - iniciar         ");
      System.out.println("---------------------------");
      System.out.println();
      System.out.println("Por favor! Escolha uma das opções!");
      System.out.println(" 0 -> Sair do programa");
      System.out.println(" 1 -> Iniciar o programa");
      System.out.print("Sua escolha -> ");

      try {
        escolha = in.nextInt();
      } catch (Exception e) {
        System.out.println("Número inválido!");
      }

      switch (escolha) {
        case 0:
          System.out.println("Você escolheu:  0 - Sair ");
          System.exit(0);
          break;

        case 1:
          System.out.println("Você escolheu: 1 - Iniciar ");
          break;
      }

      System.out.println();
      System.out.println("<===============================>");
      System.out.println("            Bem vindo ao Junes!!!");
      System.out.println("       O melhor mercado de Inaba");
      System.out.println("<===============================>");
      System.out.println();
      System.out.println("Os ciclos são o número de vezes que o programa irá executar suas funções!");
      System.out.println("Um Ciclo consciste em três estapas: A, B, C");
      System.out.println("A) Possivel entrada de um pedido no sistema!");
      System.out.println("B) Separadores disponíveis irão atender os pedidos! ");
      System.out.println("C) Entregadores disponíveis irão entregar os pedidos!");
      System.out.println();
      System.out.println("Por favor, digite o número de ciclo que o programa terá!");
      System.out.print("Número de ciclos --> ");
      try {
        numeroCiclos = in.nextInt(); // O usuário irá passar a quantidade de ciclos que este programa terá!
      } catch (Exception e) {
        System.out.println("Número inválido!");
      }

      // For Loop para "rodar" os ciclos
      for (int i = 0; i < numeroCiclos; i++) {
        ciclo.rodada(); // Método da classe ciclo que executa uma rodada (round/ciclo)
        cicloCount++;
      }

      System.out.println();
      System.out.println("O número de ciclos foi: " + cicloCount + " ! ");
      System.out.println("o número de pedidos separados foi "+ciclo.GetNseparados());//numero de pedidos separados
      System.out.println("o número de pedidos entregue foi "+ciclo.GetNconcluidos());//numero de pedidos entregue
      System.out.println("o número de pedidos cancelados foi "+ciclo.getNcancelados());//numero de pedidos cancelados
      System.out.println();
      System.out.println("==FIM==");
    }

  }
}
