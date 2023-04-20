import java.util.*;
public class matriz  
{
	public static void main(String [] args)
    	{
    	    Scanner input = new Scanner(System.in) ;
    	    
    	    
    	    System.out.println("Insira o valor das dimensões da matriz:") ;
    	    int dim = input.nextInt() ;
    	    int [][] mat = new int [dim][dim];
    	    
    	    
    	    for(int lin = 0;lin<dim;lin++)
        	    for(int col = 0;col<dim;col++)
        	    {
                	    mat[lin][col] = lin + col ;  
                	    System.out.println("mat("+lin+")("+col+") = "+mat[lin][col]) ;
                    }
                	   
        }
}