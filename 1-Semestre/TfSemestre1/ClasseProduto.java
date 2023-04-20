public class ClasseProduto
{   
    int i;
    int list = 0;
    String Pestoque[] = new String [20] ;
    double Vestoque[] = new double [20] ;
    int Qestoque[] = new int [20] ;
    
    
    public void addProd(String prod)
    {
       Pestoque[i] = prod ;
    }
    public void addValor(double valor)
    {
       Vestoque[i] = valor ;
    }
    public void addQuant(int quant)
    {
       Qestoque[i] = quant ;
       i++;
    }
    
    //Alterar Estoque
    public void Qstock(int qual, int quanto)
    {
        int trocar = 0;
        trocar = Qestoque[qual];
        trocar += quanto;
        Qestoque[qual]= trocar;
    }
    
   
    
    //Listar disponível
    public boolean listHere(int here)
    {
        if(Qestoque[here] != 0)
                return true;
            else
                return false;
    }
    
    //listar especifico(Usado para começar uma compra)
        public String getThisProdname(int este)
    {
        return Pestoque[este] ;
    }
        public double getThisPrice(int este)
    {
        return Vestoque[este] ;
    }   
    
    //listar todos
        public String getProdname()
    {
        return Pestoque[list] ;
    }
        public double getPrice()
    {
        return Vestoque[list] ;
    }
        public int getQtd()
    {
        return Qestoque[list];
    }
        public void count()
    {
        list++;
    }
        public void countClear()
    {
        list = 0;
    }
}
