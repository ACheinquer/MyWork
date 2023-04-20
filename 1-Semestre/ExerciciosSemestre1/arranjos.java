import java.util.Scanner ;
public class arranjos  
{
	public static void main(String [] args)
    	{
             Scanner input = new Scanner(System.in) ;
             
             int [] vector = new int[5] ;
             
             
             
             for(int i=0; i<vector.length;i++)
             {
               System.out.println("Informe um valor a ser armazenado ") ;  
               int valor = input.nextInt();
               vector [i] = valor ;
             }
             
             System.out.println("O valor contido no vetor é:") ;
             
             for (int i = 0;i<vector.length;i++)
                 System.out.println("O vetor " + i + " é " + vector[i]) ;
        }
}