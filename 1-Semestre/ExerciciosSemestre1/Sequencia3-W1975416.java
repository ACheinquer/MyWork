public class Sequencia2  
{
    public static void main(String [] args)
    {
        int I, J, pare;
        I = 1 ;
        J = 8 ;
        pare = 10 ;
    
        while(J > 5 && pare > 5) 
        {
            J-- ;
            System.out.println("I=" + I + " J=" + J) ;
            
            if(J == 5)
            {
                I += 3 ;
                J += 3 ;
                pare-- ;
            }
            
            if (I == 4)
            {
                I = 3 ;
            }
        }
    
    }
}