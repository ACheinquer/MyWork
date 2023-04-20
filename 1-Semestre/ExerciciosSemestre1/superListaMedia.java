import java.util.* ;
public class superListaMedia 
{
	public static void main(String [] args)
    	{
    	    Scanner input = new Scanner(System.in) ;
    	    Random ran = new Random() ;
    	    int alumni ;
    	    
    	    
    	    
    	    System.out.print("Insira o número de alunos da classe:") ;
    	    alumni = input.nextInt() ;
    	    
    	    double vector [] = new double[alumni] ;
    	    
    	    for(int i = 0;i < vector.length;i++)
    	    {
    	        vector [i] = ran.nextDouble() * 10 ;
            }
            double notaTotal = 0;
            for(double notaAtual: vector)
                notaTotal += notaAtual ;
            double media = notaTotal/vector.length;
            int acima = 0 ;
            for (double estaNota : vector)
                if(estaNota>media)
                    acima++;
                    
            System.out.println("O número de notas acima da media das notas é " + acima) ;
            
            
        }
        	
        public static void listaVetor(double [] vector)
        
        {
            for(int idx = 0;idx < vector.length ; idx++)
                System.out.println("vt["+idx+"]: " +vector[idx]) ;
        }
}