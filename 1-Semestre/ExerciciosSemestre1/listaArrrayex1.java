import java.util.Scanner ;
public class listaArrrayex1  
{
	public static void main(String [] args)
    	{
    	    int [] lista = new int [10] ;
    	    int entrada ;
    	    Scanner input = new Scanner(System.in) ;
    	    
    	    for(int i = 0;i<10;i++)
            {    System.out.println("Insira o valor de posição " + i + " da lista") ;
        	 entrada = input.nextInt() ; 
        	 lista [i] = entrada ;
            }
            
            for(int f = 0 ; f<lista.length; f++)
                System.out.println(f +"- " + lista[f]) ; 
                
            for(int g = 9 ; g>=0; g--)
                System.out.println(g +"- " + lista[g]) ;
	}
}