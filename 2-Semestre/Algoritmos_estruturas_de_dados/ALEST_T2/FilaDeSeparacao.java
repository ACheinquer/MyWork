
public class FilaDeSeparacao{//todo pedido que é criado é automaticamente mandado para a fila de separação
    
    // NODO ! ! !

    private class Nodo{//nodo que representa os pedidos
        private Pedido pedido;//Pedido(NmrPedido, tamanho, separar, entregar, CicloInit, Separado, Cancelado)
        private Nodo prox;
        public Nodo(Pedido valor){
            this.pedido=valor;
            this.prox=null;
        }
        
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public Pedido getPedido(){//retorna o pedido do nodo
            return this.pedido;
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void setPedido(Pedido novo){//Da um pedido novo ao nodo
            this.pedido = novo;
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public Nodo getProx(){//retorna o proximo nodo (pedido)
            return this.prox;
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void setProx(Nodo novo){//dita o proximo nodo (pedido)
            this.prox = novo;
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Atributos da fila de separação
        private Nodo inicio; //frente da fila
        private Nodo fim; // tras da fila
        private Nodo Sep1,Sep2,Sep3;//Separadores
        private Nodo aux1,aux2,aux3;//Auxiliares para Swap e unSwap
        private int NSepPedidos; // elementos da fila
        
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Fila de separação
        public FilaDeSeparacao(){
            NSepPedidos = 0;
            inicio = null;
            this.fim = null;
            this.Sep1 = null;
            this.Sep2 = null;
            this.Sep3 = null;
            this.aux1 = null;
            this.aux2 = null;
            this.aux3 = null;
        }
        
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void enqueue(Pedido pedido){
            Nodo novoPedido = new Nodo(pedido);

            if(IsEmpty())
                inicio = novoPedido;
            else
                fim.setProx(novoPedido);

            fim = novoPedido;
            NSepPedidos++;
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public Pedido dequeue() throws Exception{
            if(IsEmpty()){
                Pedido pedido = inicio.getPedido();
                Nodo PedidoARemover=inicio;
                inicio=inicio.getProx();
                NSepPedidos--;
                PedidoARemover.setProx(null);
                return pedido;
            }
            else
                throw new Exception("fila vazia");
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public Nodo GetAvailabe() throws Exception{//primeiro da fila que não esta sendo separado
                Nodo aux = inicio;
                for(int i=0;i<NSepPedidos;i++){//for percorre a lista e retorna o primeiro pedido não sendo separado
                    aux = aux.getProx();
                    if(Sep1.getProx() != aux && Sep2.getProx() != aux && Sep3.getProx() != aux){
                        return aux;   
                    }
                }
                throw new Exception("a fila não tem pedidos não atentidos");//Se até o fim do for aux não for retornado, lança a exception    
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void StartSeparacao() throws Exception{
            try{
            if (NSepPedidos>0){
                if(Sep1.getProx().getPedido() == null){
                    this.Sep1.setProx(GetAvailabe());
                    //throw new Exception("a fila não tem pedidos não atentidos");
                }
                if(Sep2.getProx().getPedido() == null){
                    this.Sep2.setProx(GetAvailabe());
                    //throw new Exception("a fila não tem pedidos não atentidos");
                }    
                if(Sep3.getProx().getPedido()== null){
                    this.Sep3.setProx(GetAvailabe());
                    //throw new Exception("a fila não tem pedidos não atentidos");
                }
            }
            }
            catch (NullPointerException e){
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void UnSwap1() throws Exception{
            if(Sep1.getProx() == null){
                inicio.setPedido(aux1.getPedido());//inicio recebe de volta o pedido que tinha inicialmente
                Sep1.setProx(GetAvailabe());//Sep1 começa a separar um novo pedido
            }
        }
    
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void UnSwap2() throws Exception{
            if(Sep2.getProx() == null){
                inicio.setPedido(aux2.getPedido());//inicio recebe de volta o pedido que tinha inicialmente
                Sep2.setProx(GetAvailabe());//Sep2 começa a separar um novo pedido
            }
        }
    
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
        public void UnSwap3() throws Exception{
            if(Sep3.getProx() == null){
                inicio.setPedido(aux3.getPedido());//inicio recebe de volta o pedido que tinha inicialmente
                Sep3.setProx(GetAvailabe());//Sep3 começa a separar um novo pedido
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public boolean SwapDeqSep1() throws Exception{//Swap temporario entre o Sep1 e o incio para dar dequeue no pedido concluido
            aux1 = null;
            try{
            if(Sep1.getProx().getPedido() != null)//Se Sep1 está em um pedido
                Sep1.getProx().getPedido().SetSeparar(Sep1.getProx().getPedido().GetSeparar()-1);//Sep1 passará o ciclo separando
            if(Sep1.getProx().getPedido().GetSeparar() == 0){//Se o pedido conclui todos os seus ciclos de separação
                aux1.setPedido(inicio.getProx().getPedido());//Aux guarda o pedido afiliado a inicio
                inicio.getProx().setPedido(Sep1.getProx().getPedido());//inicio recebe o pedido concluido de Sep1
                Sep1.getProx().setProx(null);//Sep1 se torna disponivel para separar outro pedido 
                return true;//houve um swap
            }
            return false;//não houve swap
            }
            catch (NullPointerException e){
                return false;
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------    

        public boolean SwapDeqSep2() throws Exception{//Swap temporario entre o Sep2 e o inicio para dar dequeue no pedido concluido
            aux2 = null;
            try{
            if(Sep2.getProx().getPedido() != null)//Se Sep2 está em um pedido
                Sep2.getProx().pedido.SetSeparar(Sep2.getProx().getPedido().GetSeparar()-1);//Sep2 passará o ciclo separando
            if(Sep2.getProx().pedido.GetSeparar() == 0){//Se o pedido conclui todos os seus ciclos de separação
                aux2.setPedido(inicio.getProx().getPedido());//Aux guarda o pedido afiliado a inicio
                inicio.getProx().setPedido(Sep2.getProx().getPedido());//inicio recebe o pedido concluido de Sep1
                Sep2.getProx().setProx(null);//Sep2 se torna disponivel para separar outro pedido
                return true;//houve um swap
            }
            return false;//não houve swap
            }
            catch (NullPointerException e){
                return false;
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------    

        public boolean SwapDeqSep3() throws Exception{//Swap temporario entre o Sep3 e o inicio para dar dequeue no pedido concluido
            aux3 = null;
            try{
            if(Sep3.getProx() != null)//Se Sep3 está em um pedido
                Sep3.getProx().pedido.SetSeparar(Sep3.getProx().getPedido().GetSeparar()-1);//Sep3 passará o ciclo separando
            if(Sep3.getProx().pedido.GetSeparar() == 0){//Se o pedido conclui todos os seus ciclos de separação
                aux3.setPedido(inicio.getProx().getPedido());//Aux guarda o pedido afiliado a inicio
                inicio.getProx().setPedido(Sep3.getProx().getPedido());//inicio recebe o pedido concluido de Sep1
                Sep3.getProx().setProx(null);//Sep3 se torna disponivel para separar outro pedido
                return true;//houve um swap
            }
            return false;//não houve swap
            }
            catch (NullPointerException e){
                return false;
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public int size(){//retorna o tamanho da fila
            return NSepPedidos;
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public boolean IsEmpty(){//retorna verdadeiro se a fila estiver vazia
            if (NSepPedidos == 0)
                return true;
            else
                return false;
        }
    
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        public int GetThisCicloInit(int idx){
            try{
            Nodo aux = inicio;
            for(int i=0;i<idx;i++){
                aux = aux.getProx();
            }
            return aux.getPedido().GetCicloInit();
            }
            catch (NullPointerException e){
                return 0;
            }
        }



        public void Cancelar(int idx){
            Nodo aux = inicio;
            try{
            if(idx == inicio.getProx().getPedido().GetNmrPedido())//Caso o idx seja o primeiro elemento da fila
                if(Sep1.getProx() == aux.getProx())
                    Sep1.setProx(null);
                inicio.setProx(aux.getProx().getProx());//Pedido é removido da fila
                aux.getProx().setProx(null);//Pedido é removido da fila
                if(Sep2.getProx() == aux.getProx())
                    Sep2.setProx(null);
                inicio.setProx(aux.getProx().getProx());//Pedido é removido da fila
                aux.getProx().setProx(null);//Pedido é removido da fila
                if(Sep3.getProx() == aux.getProx())
                    Sep3.setProx(null);
                inicio.setProx(aux.getProx().getProx());//Pedido é removido da fila
                aux.getProx().setProx(null);//Pedido é removido da fila

            if(idx == NSepPedidos)
                for(int i = 0;i<NSepPedidos-1;i++){
                    if(Sep1.getProx() == aux.getProx()){
                        Sep1.setProx(null);
                    aux = aux.getProx();//Pedido é removido da fila
                    aux.getProx().setProx(null);//Pedido é removido da fila
                    aux.setProx(null);//Pedido é removido da fila
                    fim = aux;//Pedido é removido da fila
                    }
                    if(Sep2.getProx() == aux.getProx()){
                        Sep2.setProx(null);
                    aux = aux.getProx();//Pedido é removido da fila
                    aux.getProx().setProx(null);//Pedido é removido da fila
                    aux.setProx(null);//Pedido é removido da fila
                    fim = aux;//Pedido é removido da fila
                    }
                    if(Sep3.getProx() == aux.getProx()){
                        Sep3.setProx(null);
                    aux = aux.getProx();//Pedido é removido da fila
                    aux.getProx().setProx(null);//Pedido é removido da fila
                    aux.setProx(null);//Pedido é removido da fila
                    fim = aux;//Pedido é removido da fila
                    }
                }

            if(idx>0 && idx<NSepPedidos){
                for(int i = 0;i<idx-1;i++){
                    if(Sep1.getProx() == aux.getProx()){
                        Sep1.setProx(null);
                    aux = aux.getProx();//Pedido é removido da fila
                    Nodo save = aux.getProx().getProx();//Pedido é removido da fila
                    aux.getProx().setProx(null);//Pedido é removido da fila
                    aux.setProx(save);
                    }
                    if(Sep2.getProx() == aux.getProx()){
                        Sep2.setProx(null);
                    aux = aux.getProx();//Pedido é removido da fila
                    Nodo save = aux.getProx().getProx();//Pedido é removido da fila
                    aux.getProx().setProx(null);//Pedido é removido da fila
                    aux.setProx(save);
                    }
                    if(Sep3.getProx() == aux.getProx()){
                        Sep3.setProx(null);
                    aux = aux.getProx();//Pedido é removido da fila
                    Nodo save = aux.getProx().getProx();//Pedido é removido da fila
                    aux.getProx().setProx(null);//Pedido é removido da fila
                    aux.setProx(save);
                    }
                }
            }
            }
            catch (NullPointerException e){
            }
        }   
}
