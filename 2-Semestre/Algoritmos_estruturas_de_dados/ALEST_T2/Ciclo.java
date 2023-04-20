// Essa classe representa o que acontece em um ciclo do programa

// O ciclo representa três etapas diferentes do nosso sistema
// A primeira etapa será: a possivel entrada de um pedido no sistema!
// A segunda etapa será: separadores disponíveis irão atender os pedidos! Colocando eles na fila de separação...
// ... após a separação, os pedidos são enviados para as filas de entrega!
// A terceira etapa será: depois de serem colocados na lista de entrega, os entregadores...
// ... disponíveis irão entregar os pedidos conforme o tempo de rodadas(ciclos)!


import java.util.*; // Importações das bibliotecas do java


// Classe ciclo (Rodada)
public class Ciclo {  
  //atibutos da classe ciclo
  private int ciclos = 1; //número de rodadas(ciclos)
  private int Nseparados = 0;//numero de pedidos separados
  private int Nconcluidos = 0;//Numero de pedidos separados
  private int Ncancelados = 0;//número de pedidos cancelados
  private int NmrPedido = 0; //número de indentificação do pedido

  // Instânciamento das filas (Separação e Entrega) !!!

  FilaDeSeparacao filaDeSeparacao = new FilaDeSeparacao();
  FilaDeEntrega filaDeEntrega = new FilaDeEntrega();


  // Método construtor da classe ciclo

  public Ciclo(int ciclos){
   this.ciclos = ciclos;
   // this.tempoDeSeparcao = tempoDeSeparcao;
  //  this.tempoDeEntrega = tempoDeEntrega;
   // this.NmrPedido = NmrPedido;
  } 

  public int GetNseparados(){
    return Nseparados;
  }

  public int GetNconcluidos(){
    return Nconcluidos;
  }

  public int getNcancelados(){
    return Ncancelados;
  }
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// Método Rodada
// Esse método representa um ciclo(Rodada) do programa!
  public void rodada() throws Exception{
      System.out.println();
      System.out.println("Bem vindo(a)! esta é a " + ciclos + " rodada!");
      System.out.println();

      cancelamento();// Excecução dos cancelamentos
      primeiraEtapa(); // Execução da Primeira Etapa (A)
      segundaEtapa(); // Execução da Segunda Etapa (B)
      terceiraEtapa(); // Execução da Terceira Etapa (C)

      System.out.println();
      System.out.println("Fim da " + ciclos + " rodada!");
      System.out.println();
      ciclos++;
  }

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  public void cancelamento(){//cancelamentos podem ocorrer após o quinto ciclo que um pedido foi pedido...
    Random d20 = new Random(); // Instância de Random
    for(int i = 0;i<filaDeEntrega.size();i++){
      if(ciclos - filaDeEntrega.GetThisCicloInit(i) + d20.nextInt(10) > 15){//...E se tornam mais provaveis a cada ciclo subsequente
        filaDeEntrega.Cancelar(i);
        Ncancelados++;
      }
    }

    for(int i = 0;i<filaDeSeparacao.size();i++){
      if(ciclos - filaDeSeparacao.GetThisCicloInit(i) + d20.nextInt(10) > 15){//...E se tornam mais provaveis a cada ciclo subsequente
        filaDeSeparacao.Cancelar(i);
      }
    }
  }
  
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------




// Método Primeira Etapa (A)
// Representa a fase de criação dos pedidos!
  public void primeiraEtapa(){
    //int NmrPedido = 0;
    Random d20 = new Random(); // Instância de Random 
    

    System.out.println();
    System.out.println("Início da primeira Etapa da " + ciclos + " rodada!");
    System.out.println();
 
    // Se o dado de 20 lados cair com um número a cima de 10um pedido novo será criado!

    if(d20.nextInt(19) >= 10){ 
      
    // Geração dos dados do pedido que está sendo criado!
    int tamanho = 1 + d20.nextInt(9); // O pédido poderá ter até 10 itens no seu pedido!
    int separar = d20.nextInt(4) + tamanho; // Essa variável representa o número de ciclos(rodadas) que irá demorar para o pedido ser seprado! (tempo que ficará na fila de separação)
    int entregar = 4 + d20.nextInt(4); // Essa variável representa o número de cilcos(rodadas) que irá demorar para o pedido ser entregue! (tempo que ficará na fila de entrega)
    int CicloInit = ciclos; // O ciclo em que este pedido foi criado!

    // Instânciamento do objeto do pedido que está sendo criado!
    // Os dados gerados a cima, será passados como parâmetros para esta...
    // ... instância de objeto da classe Pedido;
    Pedido pedido = new Pedido(NmrPedido, CicloInit, tamanho, separar, entregar);
    filaDeSeparacao.enqueue(pedido);//pedido recem criado é adicionado a fila de separação
    NmrPedido++; // O número do pedido séra somado, para que assim na próxima criação do pedido, ele tenha "O número do pedido antigo + 1".
    }
    System.out.println();
    System.out.println("Fim da primeira Etapa da " + ciclos + " rodada!");
    System.out.println();
  }

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Método Segunda Etapa (B)
  // Representa a fase de separação dos pedidos!
  public void segundaEtapa() throws Exception{

    System.out.println();
    System.out.println("Início da segunda Etapa da " + ciclos + " rodada!");
    System.out.println();
    System.out.println("O pedido está sendo separado!");
    System.out.println();
    filaDeSeparacao.StartSeparacao();//Separadores começam a separar pedidos não atendidos
    if(filaDeSeparacao.SwapDeqSep1()){//Se um pedido e separado ele vai para a frente da fila temporariamente
      filaDeEntrega.enqueue(filaDeSeparacao.dequeue());//O pedido concluido agora na frente e removido e adicionado a fila de entrega
      filaDeSeparacao.UnSwap1();//O pedido que estava anteriormente na frente, volta para a frente
      Nseparados ++;
    }
    if(filaDeSeparacao.SwapDeqSep2()){
      filaDeEntrega.enqueue(filaDeSeparacao.dequeue());//O pedido concluido agora na frente e removido e adicionado a fila de entrega
      filaDeSeparacao.UnSwap2();//O pedido que estava anteriormente na frente, volta para a frente
      Nseparados ++;
    }
    if(filaDeSeparacao.SwapDeqSep3()){
      filaDeEntrega.enqueue(filaDeSeparacao.dequeue());
      filaDeSeparacao.UnSwap3();
      Nseparados++;
    }
    System.out.println();
    System.out.println("Fim da segunda Etapa da " + ciclos + " rodada!");
    System.out.println();
  }

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Método Terceira Etapa (C)
  // Representa a fase de entrega e finalização dos pedidos!
  public void terceiraEtapa() throws Exception{

    System.out.println();
    System.out.println("Início da terceira Etapa da " + ciclos + " rodada!");
    System.out.println();
    filaDeEntrega.StartEntrega();//Entregadores começam a entregar pedidos não atendidos
    if(filaDeEntrega.SwapDeqEntregador1()){//Se um pedido é concluido ele vai para a frente da fila temporariamente
      filaDeEntrega.dequeue();//O pedido concluido agora na frente e removido e adicionado a fila de entrega
      filaDeEntrega.UnSwap1();//O pedido que estava anteriormente na frente, volta para a frente
      Nconcluidos ++;
    }
    if(filaDeEntrega.SwapDeqEntregador2()){
      filaDeEntrega.dequeue();//O pedido concluido agora na frente e removido e adicionado a fila de entrega
      filaDeEntrega.UnSwap2();//O pedido que estava anteriormente na frente, volta para a frente
      Nconcluidos ++;
    }
    if(filaDeEntrega.SwapDeqEntregador3()){
      filaDeEntrega.dequeue();
      filaDeEntrega.UnSwap3();
      Nconcluidos++;
    }
    System.out.println();
    System.out.println("Fim da terceira Etapa da " + ciclos + " rodada!");
    System.out.println();
  }

} // Fim da clase ciclo
