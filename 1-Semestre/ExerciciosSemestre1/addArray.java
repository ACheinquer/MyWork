public class addArray
{   
    /*
     * Aqui os produtos serão armazenados e/ou mandados de volta para a main para serem listados
     */
    private int i;//Produto em questão
    private int j;
    private int list;//Listagem
    private int quantidade;//Qts produtos existem
    private double valorTotal ;//Soma dos preços dos itens
    private double [] Vestoque = new double [10] ;//armazenamento do valor
    private int [] Qestoque = new int [10] ;//armazenamento da quantidade
    private String Pestoque [] = new String [10];//armazenamento do produto;
    //add item
    public void addProd(String StrStorage)
    {
        Pestoque[i] = StrStorage;
        quantidade++;
    }
    public void addValor(double price)
    {
        Vestoque[i] = price ;
        valorTotal+= price;       
    }
    public void addQuant(int Quant)
    {
         Qestoque[i] = Quant;
         i++;
         j++;
    }
    
    //get item
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
    
    //count para listar itens
    public void count()
    {
        list++;
    }
    public void countClear()
    {
        list = 0;
    }
}