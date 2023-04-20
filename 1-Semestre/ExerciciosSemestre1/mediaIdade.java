import java.util.Scanner ;
import java.util.Random ;
public class mediaIdade  
{
    	public static void main(String [] args)
    	{
    	    Scanner input = new Scanner(System.in) ;
    	    Random ran = new Random() ;
    	    
    	    System.out.println("informe os valores a serem gerados: ") ;
    	    int nValores = input.nextInt() ;
    	    int menores = 0 ;
    	    double mediaDeIdades = 0 ;
    	    
    	    
    	    for(int x = 0; x < nValores; x++)
                {
                int idade = 15 + ran.nextInt(31) ;
            if(idade > 18)
            {
                menores++ ;
            }
                
/*
                do
                    {
                        valorValido = valor.nextInt() ;
                    }
                    while()
		{

		}
            
*/       
            mediaDeIdades = idade + mediaDeIdades ; 
            }
    	    
            
            System.out.printf("O numero de menores de idade é %d (%.2f %) de %d consultados\n",menores,((menores+0.0)/(nValores+0.0)),nValores) ;
            System.out.printf("A idade média dos consultados é %.2f anos\n", mediaDeIdades) ; 
    	    
    	    
    	    
    	    
    	    

        }
    } 


