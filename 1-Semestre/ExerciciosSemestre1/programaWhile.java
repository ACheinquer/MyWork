public class programaWhile
{
	public static void main(String [] args)
    {
        final double rate = 5 ;
        final double initialBalance = 10000 ;
        final double target = 2 * initialBalance ;
        
        double balance = initialBalance ;
        
        int year = 0;
        
        while(balance < target)
        {
            year++ ;
            double interest = balance * (rate/100) ;
            balance += interest;
        }
        
        System.out.printf("O valor final de R$%.2f foi alcançado em %d anos\n",balance,year);
    }
}