import java.util.Scanner ;

public class intervalo 
{
	public static void main(String [] args)
    {
        double entrada ;
        double output ;
        String saida ;
        Scanner input = new Scanner(System.in) ;
        
        
        System.out.print("Insira o número de entrada ") ;
        entrada = input. nextDouble() ;
        
        
        
        if( entrada >= 0 && entrada <= 25) 
        { 
            saida = "O número está dentro do intervalo [0,25]" ; 
            System.out.println(saida) ;
        }
        
        if( entrada > 25 && entrada <= 50) 
        { 
            saida = "O número está dentro do intervalo (25,50]" ; 
            System.out.println(saida) ;
        }
        
        if( entrada > 50 && entrada <= 75) 
        { 
            saida = "O número está dentro do intervalo (50,75]" ; 
            System.out.println(saida) ;
        }
        
        if( entrada > 75 && entrada <= 100) 
        { 
            saida = "O número está dentro do intervalo (75,100]" ; 
            System.out.println(saida) ;
        }
        
        if( entrada > 100) 
        { 
            saida = "O número está fora do intervalo" ; 
            System.out.println(saida) ;
        }
        
        
        
        
}
}
