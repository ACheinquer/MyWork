import java.util.Random ;
import java.util.Scanner ;
public class questao3  
{
	public static void main(String [] args)
    	{
            //Declaração
    	    int CanA, CanB, CanC, CanD,nulo, branco, votantes, x, votos ;
    	    Random ran = new Random() ;
    	    Scanner input = new Scanner(System.in) ;
    	    
    	    //Valores iniciais
    	    CanA = 0 ;
    	    CanB = 0 ;
    	    CanC = 0 ;
    	    CanD = 0 ;
    	    branco = 0 ;
    	    nulo = 0 ;
    	    
    	    //Input
    	    System.out.print("Insira o número de votantes ") ;
    	    votantes = input.nextInt() ;
            if(votantes > 0)
    	    {
        	for(x = 0; x < votantes; x++) //Votação
        	 {
        	       votos = ran.nextInt(6) ;  
    	       
        	       if(votos == 0)
        	       {
        	          CanA++; 
        	       }
        	       if(votos == 1)
        	       {
        	          CanB++;
        	       }
        	       if(votos == 2)
        	       {
        	          CanC++; 
        	       }
        	       if(votos == 3)
        	       {
        	          CanD++; 
        	       }
        	       if(votos == 4)
        	       {
        	          nulo++; 
        	       }
        	       if(votos == 5)
        	       {
        	          branco++; 
        	       }
                }
            }  else { //Resultado invalido
            System.out.println("Valor invalido") ;
            } 
            //Resultados
            System.out.println("O total de votos para o candidato A foram: " + CanA) ;
            System.out.println("O total de votos para o candidato B foram: " + CanB) ;
            System.out.println("O total de votos para o candidato C foram: " + CanC) ;
            System.out.println("O total de votos para o candidato D foram: " + CanD) ;
            System.out.println("O total de votos nulos foram " + nulo) ;
            System.out.println("O total de votos em branco foram " + branco) ;
	}
}