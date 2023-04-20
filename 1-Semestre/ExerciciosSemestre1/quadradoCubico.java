import java.util.Scanner ;
public class quadradoCubico 
{
    public static void main(String [] args)
    {
        int normal, quadrado, cubico ;
        int entrada, opera ;
        Scanner input = new Scanner(System.in) ;
        
        opera = 1 ;
        System.out.println("Insira o valor de entrada") ;
        entrada = input.nextInt() ;
        
        
        
        
        while(opera < entrada)
        {
        normal = opera ;
        quadrado = opera * opera ;
        cubico = opera * opera * opera ;
        System.out.println(normal +"  "+ quadrado +"  "+ cubico) ;
        opera++ ;
        }
    }
}