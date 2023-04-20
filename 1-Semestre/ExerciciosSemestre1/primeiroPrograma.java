import java.util.Scanner ;

public class primeiroPrograma
{
    public static void main (String[] args) 
    {
        int valor = 4;
        System.out.println("O valor inicial é " + valor) ;
    
        Scanner input = new Scanner(System.in) ;
        valor = input.nextInt() ;
    
        System.out.println("O valor a ser impresso é " + valor);
        
    }
}