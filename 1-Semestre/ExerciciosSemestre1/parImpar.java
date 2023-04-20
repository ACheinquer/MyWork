import java.util.Scanner ;
public class  parImpar 
{
	public static void main(String [] args)
        {
            Scanner input = new Scanner(System.in) ;
            double entrada,saida ;
            
            System.out.println("Insira o número de entrada") ;
            entrada = input. nextDouble() ;
            
            
            if(entrada % 2 == 0) 
            {
                System.out.println("O número é par") ;
            }else{
                System.out.println("O número é impar") ;
            }
        }
}