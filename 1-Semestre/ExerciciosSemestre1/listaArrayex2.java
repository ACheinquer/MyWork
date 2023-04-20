import java.util.* ;
public class listaArrayex2  
{
	public static void main(String [] args)
    	{
    	    Random ran = new Random() ;
    	    Scanner input = new Scanner(System.in) ;
    	    int listaInv [] = new int [ran.nextInt(100)] ;
    	    int lista [] = new int [listaInv.length] ;
    	    
    	    for(int i = 0;i<lista.length;i++)
    	    {
    	        lista [i] = ran.nextInt(10000);
        	System.out.println("Lista(" +i+") = "+lista[i]) ;
        	for(int f = lista.length;f>= 0;f--)
                {
                    listaInv[f] = lista[i] ;
                }
            }
            
            for(int g = listaInv.length ; g>=0; g--)
                System.out.println(g +"- " + listaInv[g]) ;
	}
}