
public class FilaDeEntrega{//todo pedido que é criado é automaticamente mandado para a fila de entrega
    
    // NODO ! ! !

    private class Nodo{//nodo que representa os pedidos prontos para entrega
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

        // Atributos daa fila de entrega!
        private Nodo inicio; //frente da fila
        private Nodo fim; // tras da fila
        private Nodo Entregador1,Entregador2,Entregador3;//Entregadoraradores
        private Nodo aux1,aux2,aux3;//Auxiliares para Swap e unSwap
        private int NPedidos; // elementos da fila
        
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        // Fila de entrega
        public FilaDeEntrega(){
            NPedidos = 0;
            inicio = null;
            fim = null;
            Entregador1 = null;
            Entregador2 = null;
            Entregador3 = null;
            aux1 = null;
            aux2 = null;
            aux3 = null;
        }
        
    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void enqueue(Pedido pedido){
            Nodo novoPedido = new Nodo(pedido);

            if(IsEmpty())
                inicio = novoPedido;
            else
                fim.setProx(novoPedido);

            fim = novoPedido;
            NPedidos++;
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public Pedido dequeue() throws Exception{
            if(IsEmpty()){
                Pedido pedido = inicio.getPedido();
                Nodo PedidoARemover=inicio;
                inicio=inicio.getProx();
                NPedidos--;
                PedidoARemover.setProx(null);
                return pedido;
            }
            else
                throw new Exception("fila vazia");
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public Nodo GetAvailabe() throws Exception{//primeiro da fila que não esta sendo entregue
                Nodo aux = inicio;
                for(int i=0;i<NPedidos;i++){//for percorre a lista e retorna o primeiro pedido não sendo entregue
                    aux = aux.getProx();
                    if(Entregador1.getProx() != aux && Entregador2.getProx() != aux && Entregador3.getProx() != aux){
                        return aux;   
                    }
                }
                throw new Exception("a fila não tem pedidos não atentidos");//Se até o fim do for aux não for retornado, lança a exception    
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void StartEntrega() throws Exception{
            try{
            if (IsEmpty()){
                if(Entregador1.getProx() == null)
                    Entregador1.setProx(GetAvailabe());
                if(Entregador2.getProx() == null)    
                    Entregador2.setProx(GetAvailabe());
                if(Entregador3.getProx()== null)
                    Entregador3.setProx(GetAvailabe());
            }
            }
            catch (NullPointerException e){
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        
        public void UnSwap1() throws Exception{
            if(Entregador1.getProx() == null){
                inicio.setPedido(aux1.getPedido());//inicio recebe de volta o pedido que tinha inicialmente
                Entregador1.setProx(GetAvailabe());//Entregador1 começa a separar um novo pedido
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void UnSwap2() throws Exception{
            if(Entregador2.getProx() == null){
                inicio.setPedido(aux2.getPedido());//inicio recebe de volta o pedido que tinha inicialmente
                Entregador2.setProx(GetAvailabe());//Entregador2 começa a separar um novo pedido
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void UnSwap3() throws Exception{
            if(Entregador3.getProx() == null){
                inicio.setPedido(aux3.getPedido());//inicio recebe de volta o pedido que tinha inicialmente
                Entregador3.setProx(GetAvailabe());//Entregador3 começa a separar um novo pedido
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public boolean SwapDeqEntregador1() throws Exception{//Swap temporario entre o Entregador1 e o incio para dar dequeue no pedido concluido
            aux1 = null;
            try{
            if(Entregador1.getProx() != null)//Se Entregador1 está em um pedido
                Entregador1.getProx().pedido.SetSeparar(Entregador1.getProx().getPedido().GetSeparar()-1);//Entregador1 passará o ciclo separando
            if(Entregador1.getProx().pedido.GetSeparar() == 0){//Se o pedido conclui todos os seus ciclos de separação
                aux1.setPedido(inicio.getProx().getPedido());//Aux guarda o pedido afiliado a inicio
                inicio.getProx().setPedido(Entregador1.getProx().getPedido());//inicio recebe o pedido concluido de Entregador1
                Entregador1.getProx().setProx(null);//Entregador1 se torna disponivel para separar outro pedido 
                return true;//houve um swap
            }
            return false;//não houve swap
            }
            catch (NullPointerException e){
                return false;
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------    

        public boolean SwapDeqEntregador2() throws Exception{//Swap temporario entre o Entregador2 e o inicio para dar dequeue no pedido concluido
            aux2 = null;
            try{
            if(Entregador2.getProx() != null)//Se Entregador2 está em um pedido
                Entregador2.getProx().pedido.SetSeparar(Entregador2.getProx().getPedido().GetSeparar()-1);//Entregador2 passará o ciclo separando
            if(Entregador2.getProx().pedido.GetSeparar() == 0){//Se o pedido conclui todos os seus ciclos de separação
                aux2.setPedido(inicio.getProx().getPedido());//Aux guarda o pedido afiliado a inicio
                inicio.getProx().setPedido(Entregador2.getProx().getPedido());//inicio recebe o pedido concluido de Entregador1
                Entregador2.getProx().setProx(null);//Entregador2 se torna disponivel para separar outro pedido
                return true;//houve um swap
            }
            return false;//não houve swap
            }
            catch (NullPointerException e){
                return false;
            }
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------    

        public boolean SwapDeqEntregador3() throws Exception{//Swap temporario entre o Entregador3 e o inicio para dar dequeue no pedido concluido
            aux3 = null;
            try{
            if(Entregador3.getProx() != null)//Se Entregador3 está em um pedido
                Entregador3.getProx().pedido.SetSeparar(Entregador3.getProx().getPedido().GetSeparar()-1);//Entregador3 passará o ciclo separando
            if(Entregador3.getProx().pedido.GetSeparar() == 0){//Se o pedido conclui todos os seus ciclos de separação
                aux3.setPedido(inicio.getProx().getPedido());//Aux guarda o pedido afiliado a inicio
                inicio.getProx().setPedido(Entregador3.getProx().getPedido());//inicio recebe o pedido concluido de Entregador1
                Entregador3.getProx().setProx(null);//Entregador3 se torna disponivel para separar outro pedido
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
            return NPedidos;
        }
        public boolean IsEmpty(){//retorna verdadeiro se a fila estiver vazia
            if (NPedidos == 0)
                return true;
            else
                return false;
        }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        public int GetThisCicloInit(int idx){
            Nodo aux = inicio;
            for(int i=0;i<idx;i++){
                aux = aux.getProx();
            }
            return aux.getPedido().GetCicloInit();
        }

        public void Cancelar(int idx){
            Nodo aux = inicio;
            if(idx == inicio.getProx().getPedido().GetNmrPedido())//Caso o inx seja o primeiro elemento da fila
                if(Entregador1.getProx() != aux.getProx())//if não deixam cancelar um pedido que ja saiu para entrega
                    inicio.setProx(aux.getProx().getProx());//Pedido é removido da fila
                    aux.getProx().setProx(null);//Pedido é removido da fila
                if(Entregador2.getProx() != aux.getProx())//if não deixam cancelar um pedido que ja saiu para entrega
                    inicio.setProx(aux.getProx().getProx());//Pedido é removido da fila
                    aux.getProx().setProx(null);//Pedido é removido da fila
                if(Entregador3.getProx() != aux.getProx())//if não deixam cancelar um pedido que ja saiu para entrega
                    inicio.setProx(aux.getProx().getProx());//Pedido é removido da fila
                    aux.getProx().setProx(null);//Pedido é removido da fila

            if(idx == NPedidos)
                for(int i = 0;i<NPedidos-1;i++){
                    if(Entregador1.getProx() != aux.getProx()){//if não deixam cancelar um pedido que ja saiu para entrega
                        aux = aux.getProx();//Pedido é removido da fila
                        aux.getProx().setProx(null);//Pedido é removido da fila
                        aux.setProx(null);//Pedido é removido da fila
                        fim = aux;//Pedido é removido da fila
                    }
                    if(Entregador2.getProx() != aux.getProx()){//if não deixam cancelar um pedido que ja saiu para entrega
                        aux = aux.getProx();//Pedido é removido da fila
                        aux.getProx().setProx(null);//Pedido é removido da fila
                        aux.setProx(null);//Pedido é removido da fila
                        fim = aux;//Pedido é removido da fila
                    }
                    if(Entregador3.getProx() != aux.getProx()){//if não deixam cancelar um pedido que ja saiu para entrega
                        aux = aux.getProx();//Pedido é removido da fila
                        aux.getProx().setProx(null);//Pedido é removido da fila
                        aux.setProx(null);//Pedido é removido da fila
                        fim = aux;//Pedido é removido da fila
                    }
                    }

            if(idx>0 && idx<NPedidos){
                for(int i = 0;i<idx-1;i++){
                    if(Entregador1.getProx() != aux.getProx()){//if não deixam cancelar um pedido que ja saiu para entrega
                        aux = aux.getProx();//Pedido é removido da fila
                        Nodo save = aux.getProx().getProx();//Pedido é removido da fila
                        aux.getProx().setProx(null);//Pedido é removido da fila
                        aux.setProx(save);
                    }
                    if(Entregador2.getProx() != aux.getProx()){//if não deixam cancelar um pedido que ja saiu para entrega
                        aux = aux.getProx();//Pedido é removido da fila
                        Nodo save = aux.getProx().getProx();//Pedido é removido da fila
                        aux.getProx().setProx(null);//Pedido é removido da fila
                        aux.setProx(save);
                    }
                    if(Entregador3.getProx() != aux.getProx()){//if não deixam cancelar um pedido que ja saiu para entrega
                        aux = aux.getProx();//Pedido é removido da fila
                        Nodo save = aux.getProx().getProx();//Pedido é removido da fila
                        aux.getProx().setProx(null);//Pedido é removido da fila
                        aux.setProx(save);
                    }
                }
            }
        }
}




    
    
    
    
    /* 
    public boolean remove(Pedido pedido){ //Os Pedidos serão passados por parâmetro
        int PrimeiraPos = inicio.getProx().getPedido().GetNmrPedido();//Numero do pedido da primeira pos da linked list
        int idx = pedido.GetNmrPedido(); // Idx = Index... o Index é o número do pedido a ser removido!

        if((idx>0) && (idx<NPedidos)){
            Nodo aux = inicio;
            if(idx==PrimeiraPos){
                inicio=aux.getProx();
                aux.setProx(null);
                if(Entregador1.getProx()== inicio.getProx())
                    Entregador1.setProx(null);
                if(Entregador2 == inicio.getProx())
                    Entregador2.setProx(null);
                if(Entregador3 == inicio.getProx())
                    Entregador3.setProx(null);
            }
            else{
                idx--;
                while(idx>0){
                    aux=aux.getProx();
                    idx--;
                }
                Nodo pedidoEliminar = aux.getProx();
                aux.setProx(pedidoEliminar.getProx());
                pedidoEliminar.setProx(null);
            }
            NPedidos--; // Número de pedidos reduzidos
            return true;
        }
        else
            return false;
    }
     * 
    */

