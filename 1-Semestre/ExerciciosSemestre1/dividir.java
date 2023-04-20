import java.util.Scanner ;
public class dividir
{    
    public static void main(String [] args) 
    {
       //declaração
       double valor1 ;
       double valor2 ;
       double resultado ;
       Scanner input = new Scanner(System.in) ;
       
       //input
       System.out.println("Insira o primeiro número") ;
       
       valor1 = input.nextDouble() ;
       
       System.out.println("Insira o número que dividirá o primeiro") ;
       
       valor2 = input.nextDouble() ;
       
       //opreção
       resultado = valor1 / valor2 ;
       
       //output
       System.out.println("O resultado é " + resultado) ; 
       
    }
}