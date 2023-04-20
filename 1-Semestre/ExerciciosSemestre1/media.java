import java.util.Scanner ;
public class media
{
    public static void main (String [] args)
    {
        //declaração
        double valor1 ;
        double valor2 ;
        double valor3 ;
        double resultado ;
        Scanner input = new Scanner(System.in) ;
        
        //input
        System.out.println("Insira o primeiro valor da média aritmética") ;
        
        valor1 = input.nextDouble() ;
        
        System.out.println("Insira o segundo valor") ;
        
        valor2 = input.nextDouble() ;
        
        System.out.println("Insira o terceiro valor") ;
        
        valor3 = input.nextDouble() ;
        
        //operação
        resultado = (valor1 + valor2 + valor3) / 3 ;
        
        //output
        System.out.println("O resultado é " + resultado) ;        
        
        
    }
}