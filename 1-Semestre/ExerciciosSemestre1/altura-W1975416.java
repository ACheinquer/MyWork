import java.util.Scanner ;
import java.util.Random ;
public class random
{
	public static void main(String [] args)
    	{
    	    int randomVar, n ;
    	    Scanner input = new Scanner(System.in) ;
    	    randomVar = input.nextInt() ;
    	    Random ran = new Random() ; 
    	    n = 0 ;
    	    
    	    while(n <= randomVar)
            {
                int numero ;
                numero = ran.nextInt(1000) ;
                randomVar = ran.nextInt(1000000) ;
                System.out.println(n + "-->" + numero) ;
                
                n++ ;
            }
	}
}
