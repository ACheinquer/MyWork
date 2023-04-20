Grupo: Alexadre Cheinquer e Bernardo Klein Heitz
Aqui se encontra o resumo do trabalho bem como as justificativas das implementações:

Resumo do Trabalho: 

Primeiramente nós nos juntamos para criarmos o esboço do trabalho, criando assim as classes que utilizamos nele.

Esssas classes são: A "Main", onde o cógido é inciado, a classe "Pedido", que possui todos os atributos que um pedido possui,
as classes das "Filas", que utilizamos para "armazenar" os objetos de pedidos e por fim a classse "Ciclo", onde ocorre a execução
dos métodos referentes as 3 etapas de uma rodada.

A classe Pedido possui 5 atributos, sendo eles: "NmrPedido", referente ao número do pedido(Identificação do pedido), "tamanho", referente a quantidade de itens que serão colocados em um objeto de pedido, "separar", que se refere ao tempo que irá levar para separar um dos pedidos (O tempo que um obejeto de pedido ficará na fila de separação), "entregar", que se refere ao tempo que irá para entregar um obejeto de pedido(O tempo que uma instância de pedido ficará na fila de entrega) e por fim, "CicloInit", referente ao ciclo/rodada no qual essa instância de pedido foi criada!
A classe Pedido possui Getters e Setters referentes aos seus atributos, junto de um método toString() para imprimir as informaçõs de uma instância de pedido.

A classe FilaDeSeparacao possui uma classe Nodo com 2 atributos, sendo eles Pedido pedio e Nodo prox, o nodo possui setters e getters para os seus atributos. Já a FilaDeSeaparacao possui atributos como "inicio" e "fim" para os nodos, "Sep1", "Sep2", "Sep3" que são Nodos separadaores e 3 nodos auxiliares, bem como um atributo "NSepPedido", que se refere ao número de elementos da lista.
Nossa fila de separação possui diversos métodos, sendo eles, "enqueue", que adiciona um pedido na fila "por trás". "dequeue", que retira um elemento da fila "pela frente". "GetAvaialbe", que retorna o primeiro elemento da fila que não está sendo separado. "StartSeparacao, que começar o processo de separação utilizando "set e get pox" e "getAvailable". Os métodos "SwapDeqSep" são utilizados para passar elementos já separados para frente da fila, para assim eles receberem um "dequeue", para depois serem entregues na fila de entrega. Já os "unSwap" servem para fazer a fila voltar "ao normal" após o "SwapDeqSep". Existem também métodos "size", para receber o número de pedidos e o método "IsEmpty", que retorna verdadeiro se a fila está vazia. "GetThisCicloInit", retorna o ciclo inicia, já o método "Cancelar" cancela um pedido.

A classe FilaDeEntrega possui uma classe Nodo com 2 atributos, sendo eles Pedido pedio e Nodo prox, o nodo possui setters e getters para os seus atributos. Já a FilaDeEntrega possui atributos como "inicio" e "fim" para os nodos, "Entregador1", "Entregador2", "Entregador3" que são Nodos entregadores e 3 nodos auxiliares, bem como um atributo "NPedido", que se refere ao número de elementos da lista.
Nossa fila de separação possui diversos métodos, sendo eles, "enqueue", que adiciona um pedido na fila "por trás". "dequeue", que retira um elemento da fila "pela frente". "GetAvaialbe", que retorna o primeiro elemento da fila que não está sendo separado. "StartEntrega, que começar o processo de entrega utilizando "set e get pox" e "getAvailable". Os métodos "SwapDeqEntregador" são utilizados para passar elementos já separados para frente da fila, para assim eles receberem um "dequeue", para depois serem entregues na fila de entrega. Já os "unSwap" servem para fazer a fila voltar "ao normal" após o "SwapDeqEntregador". Existem também métodos "size", para receber o número de pedidos e o método "IsEmpty", que retorna verdadeiro se a fila está vazia. "GetThisCicloInit", retorna o ciclo inicia, já o método "Cancelar" cancela um pedido.

A classe Ciclo possui 4 atributos, sendo eles, int ciclos, int Nseparados, int Nconcluidos, int NmrPedido. Essa classe também possui a instância de dois objetos das classes FilaDeSeparacao e FilaDeEntrega. Como métodos temos "GetNseparados", que retorna o número de pedidos separados, "getNconcluidos", que retorna o número de pedidos concluídos. "cancelamento", que gera uma chance do item ser cancelado após um número determinado de ciclos de um pedido em andamento. "primeiraEtapa", esse método representa a primeira etapa de uma rodada, a partir de uma certa chance um objeto de pedido é criada, com o tempo de separação e tempo de entrega aleatórios, após a criação do objeto de pedido, ele é adicionado a lista de separação para ser separado. "segundaEtapa", representa a segunda etapa de um ciclo, nessa etapa o processo de separação será inciado, fazendo assim com que os noso Sep começem a referenciar os primiros itens da lista, esses nodos irão separar os pediso. "terceiraEtapa", epresenta a terceira etapa de um ciclo, nessa etapa o processo de entrega será inciado, fazendo assim com que os nosso Entregador começem a referenciar os primiros itens da lista, esses nodos irão ser entregues. E por fim temos os método "rodada", em que ocorrerá a execução dos métodos, cancelamento(), primeiraEtapa(), segundaEtapa(), terceiraEtapa


Justificativas das implementações:

filas: Decidimos usar linked list para ambas as filas, pois parecia apropriado ter os separadores e entregadores como Nodos da fila "ligados" aos pedidos que estão atentendendo

tamanho de pedidos: completamente aleatorio já que depende do cliente

tempo de separação: o proprio tamanho do pedido mais um numero aleatorio de 0-4(simbolizando a localização dos itens no mercado) ciclos de tempo

tempo de entrega: um numero de ciclos aleatorio entre 4-8(simbolizando a distancia do cliente e mercado+tempo parado no transito)

tempo de cancelamentos: se numero de ciclos desde o inicio do pedido + numero aleatorio entre 0-10(paciencia do cliente) > 15 então o pedido é cancelado, dessa maneira as chances de um pedido ser cancelado nos primeiros 5 ciclos de sua existencia são 0, porém a partir deste ponto as chances vão aumentando, e um pedido sempre é cancelado ao atingir 15 ciclos