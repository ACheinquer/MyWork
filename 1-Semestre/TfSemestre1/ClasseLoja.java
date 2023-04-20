public class ClasseLoja
{
    private int vendas ;
    private int QuantTotal ;
    private double grana;
    private double mediaVendas;
    private double vendaPrice;
    
    public void compra(double price,int qual, double Quant)
    {
        ClasseProduto cp = new ClasseProduto(); 
        for(int Q = 0;Q<Quant;Q++)
        {
            grana -= price;
            QuantTotal++;
            vendaPrice+=price;
        }
        vendas ++;
    }
    
    //saldo para comprar
    public void saldo(double money)
    {
        grana += money;
    }
    
    public double getMedia()//media das vendas
    {
        return vendaPrice/QuantTotal;
    }
    public double getTotalPrice()//total de dinheiro das vendas
    {
        return vendaPrice;
    }
    public double getSaldo()//saldo do cliente
    {
        return grana;
    }
    public int GetSale()//quantidade total de vendas
    {
        return vendas ;
    }
    public int GetQ()//quantidade total de produtos vendidos
    {
        return QuantTotal ;
    }
}