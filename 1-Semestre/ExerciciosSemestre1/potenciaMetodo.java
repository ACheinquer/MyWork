import java.util.Scanner ;
public class potenciaMetodo 
{
	public static void main(String [] args)
    {
    	int opcao = 1; 
    	Scanner input = new Scanner(System.in) ;
        do
    	    {
    	    opcao = menuPrincipal() ; 
        
    	
        	if(opcao != 0)
            {
        	valor = input.nextInt() ; 
                switch(opcao)
                {
                    case 1://fatorial
                        resultado = fatorial(valor);
                        System.out.println("Fatorial de "+valor+" é "+resultado) ;
                        break;
                    
                    case 2://primo
                    System.out.println("O valor "+valor) ;
                    if(ehPrimo(valor))
                    System.out.println("é primo") ;
                    else
                        System.out.println("Não é primo") ;
                    break;
                    
                    case 3://somatorio
                    resultado = somatorio(valor) ;
                    System.out.println("O somatório do valor "+valor+ " é "+resultado) ;
                    break;
                    
                    default:
                        
                    System.out.println("A opção não é válida") ;
                }
            }
    }while(opcao != 0) ;
    
    System.out.println("Fim do programa") ;
    }
    public static int menuPrincipal()
    {    
        Scanner inputLocal = new Scanner(System.in) ;
        int usrOpcao;
        do
        {
            System.out.println("Tela do menu principal") ;
            System.out.println("Opções") ;
            System.out.println("0 - Sair") ;
            System.out.println("1 - Fatorial") ;
            System.out.println("2 - Primo") ;
            System.out.println("3 - Somatório") ;
        
            usrOpcao = inputLocal.nextInt() ;
        
            if( (usrOpcao>=0) && (usrOpcao <= 3))
            return usrOpcao;
            else 
            System.out.println("TENTE NOVAMENTE") ;
        }while( !(usrOpcao>=0) && (usrOpcao <= 3) );
    }
    }
    
    public static int fatorial(int param)
    {        
        System.out.println("Entrou no metodo é primo") ;
        return true ;
    }
    
    public static boolean ehPrimo(int param)
    {
        System.out.println("") ;
    }
}
    	   
	