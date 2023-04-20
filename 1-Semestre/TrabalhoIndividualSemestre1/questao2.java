import java.util.Scanner ;
public class questao2  
{
	public static void main(String [] args)
    	{
    	    Scanner input = new Scanner(System.in) ;
    	    int entrada, divisores, dividir, perfeito, teste ;
    	    
    	    teste = 0 ;
    	    perfeito = 0 ;
    	    
    	    System.out.println("Insira um valor inteiro, positivo e maior que zero:") ;
            entrada = input.nextInt() ;
    	    
            
            
    	    if(entrada > 0)
    	    {
            for(dividir = 1; dividir < entrada; dividir++) 
            {
                teste = entrada % dividir ;
                if(teste == 0) //Teste divisor
        	{
        	  perfeito += dividir ;
        	}
            }
            
            if(perfeito == entrada) //Teste perfeito
            {
                System.out.println("o numero " + entrada + " é perfeito") ; //Conclusão positiva
            } else {
                System.out.println("o numero " + entrada + " não é perfeito") ; //Conclusão negativa
            }
            
        } else { //Conclusão invalido
                System.out.println("Valor invalido") ;
            }   
	}
}
