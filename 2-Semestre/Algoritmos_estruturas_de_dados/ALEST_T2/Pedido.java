public class Pedido {

    //Atributos da classe pedido
    private int NmrPedido;//Numero do Pedido
    private boolean separado;//já foi separado?(True ou False);
    private int tamanho;//tamanho(1-5);
    private int separar;//ciclos para separar(tamanho+random(4));
    private int entregar;//ciclos para entregar(random(4-8));
    private boolean cancelado;//cancelado?(True ou False);
    private int CicloInit;//Ciclo quando foi pedido;


    public Pedido(int NmrPedido,int tamanho,int separar,int entregar,int CicloInit){//metodo construtor
        this.NmrPedido = NmrPedido; 
        this.tamanho = tamanho;
        this.separar = separar;
        this.entregar = entregar;
        this.CicloInit = CicloInit;
    }
    
    //Setter e Getter do Numero do Pedidos
    public void SetNmrPedido(int novo){
        this.NmrPedido = novo;
    }
    public int GetNmrPedido(){
        return this.NmrPedido;
    }
    //Setter e Getter do tamanho do pedido
    public void SetTamanho(int novo){
        this.tamanho = novo;
    }
    public int GetTamanho(){
        return this.tamanho;
    }
    //Setter e Getter do tempo necessário da separação(em ciclos)
    public void SetSeparar(int novo){
        this.separar = novo;
    }
    public int GetSeparar(){
        return this.separar;
    }
    //Setter e Getter do tempo necessario para a entrega(em ciclos)
    public void SetEntregar(int novo){
        this.entregar = novo;
    }
    public int GetEntregar(){
        return this.entregar;
    }
    //Setter e Getter do Ciclo no qual foi pedido
    public void SetCicloInit(int novo){
        this.CicloInit = novo;
    }
    public int GetCicloInit(){
        return this.CicloInit;
    }

    @Override
    //Metodo ToString
    public String toString() {
        return "Pedido [Número do pedido=" + this.NmrPedido + ", Separado?=" + this.separado + ", Quantidade de itens="
                + this.tamanho + ", Tempo para separar=" + this.separar + " ciclos" + ", Tempo para entrega="
                + this.entregar + " ciclos " + ", Pedido cancelado?=" +  this.cancelado + ", Ciclo inicial=" + this.CicloInit + "]";
    }



public static void main(String args[]){
    Pedido A = new Pedido(0, 0, 0, 0, 0);
    System.out.print(A.toString());
}

}