import java.util.Scanner ;
public class multiplicacao  
{
	public static void main(String [] args)
    	{
    	    Scanner input = new Scanner(System.in) ;
    	    System.out.println("int val a: ") ;
    	    int primeiro = input.nextInt() ;
    	    System.out.println("int val b: ") ;
    	    int segundo = input.nextInt() ;
    	    
    	    int res = multInt(primeiro, segundo) ;
    	    System.out.println("O resultadoda multiplicação é " + res ) ;
	}
	
	public static int multInt(int a, int b)
	{
	   int resultado = 0;
	   for(int i=0; i<a; i++)
        	   resultado += b ;
	   return resultado;
        }
}
