import java.util.Scanner ;
public class  senha 
{
	public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in) ;       
        int tentativa ;
        
        System.out.println("Insira a senha de quatro digitos") ;
        tentativa = input.nextInt() ;
        
        if(tentativa == 2002) 
        {
            System.out.println("Senha aceita") ;
        } 
            else
        {
            System.out.println("Senha incorreta") ;
        }
        
        
        
    
        
    }
}