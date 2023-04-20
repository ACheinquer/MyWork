public class Sequencia3  
{
    public static void main(String [] args)
    {
        int I, J, pare, aumento;
        I = 1 ;
        J = 8 ;
        aumento = 8 ;
        pare = 10 ;
    
        while(aumento > 5 && pare > 5) 
        {
            J-- ;
            aumento-- ;
            System.out.println("I=" + I + " J=" + J) ;
            
            if(aumento == 5)
            {
                I += 3 ;
                J += 5 ;
                aumento += 3 ;  
                pare-- ;
            }
            
            if (I == 4)
            {
                I = 3 ;
            }
        }
    
    }
}