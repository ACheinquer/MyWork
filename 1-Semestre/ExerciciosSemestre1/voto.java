import java.util.Scanner ;
public class voto  
{
	public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in) ;
        int idade ;
        
        
        
        
        System.out.print("Insira a sua idade ") ;
        idade = input.nextInt() ;
        
        if (idade >= 16 && idade < 18 || idade > 70) 
        {
            System.out.println("Você pode votar, porém não precisa") ;	
        } 
        else if (idade >= 18 && idade <= 70)  
        {
            System.out.println("O seu voto é obrigatório") ;
        }  
        else if (idade < 16)
        {
            System.out.println("Não pode votar meu querido") ;
        }
        }
}