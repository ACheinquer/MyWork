import java.util.Scanner ;
import java.util.Random ;
public class altura
{
	public static void main(String [] args)
    	{
    	    int randomVar, n ;
    	    double altura ;
    	    Scanner input = new Scanner(System.in) ;
    	    randomVar = input.nextInt() ;
    	    Random ran = new Random() ; 
    	    n = 0 ;
    	    
    	    while(n <= randomVar)
            {
                int numero ;
                numero = ran.nextInt(1000) ;
                randomVar = ran.nextInt(1000) ;
                altura = 1.05 + (1.15*ran.nextDouble()) ;
                
                System.out.printf("Criatura %d --> Altura %.2f\n",n,altura) ;
                n++ ;
            }
	}
}
