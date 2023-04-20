import java.util.* ;
public class metodoLista  
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in) ;
        int escolha ;
        System.out.println("Insira o número do programa que será executado") ;
        escolha = input.nextInt() ;
        
        switch(escolha) 
        {
            case 1:
                System.out.println("Exercicio 1 selecionado") ;
                System.out.print("    Informe o valor do raio ") ;
                double raio = input.nextDouble() ;
                double volume = operacao(raio) ;
                System.out.printf("     O volume do raio é %.2f\n",volume) ;
                    break ;
                    
            case 2:
                    int A, B, C ;
                    System.out.printf("Insira as 3 notas \n Primeira:") ;
                    A = input.nextInt() ;
                    System.out.printf("\nSegunda:") ;
                    B = input.nextInt() ;
                    System.out.printf("\nTerceira:") ;
                    C = input.nextInt() ;
                    
                    System.out.println("Escolha uma media") ;
                    System.out.println("A para a media aritmética") ;
                    System.out.println("P para a mdia ponderada(pesos 5, 3 e 2)") ;
                    System.out.println("H para a media harmonica") ;
                    char escolhaMedia = input.next().toUpperCase().charAt(0);
                    double resultado;
                    
                    double mediaDasNotas = notas(A, B, C, escolhaMedia);
                
                if(mediaDasNotas<0)
                    System.out.println("A média solicitada é inválida");
                else
                    System.out.printf("A média das notas é %.2f\n", mediaDasNotas);
                    
                break;
            case 3:
                int talvezPrimo ;
                System.out.println("Insira um número inteiro") ;
                talvezPrimo = input.nextInt() ;    
                
                int primo = PrimoSN(talvezPrimo) ;
                
                if(primo == true)
                {
                    System.out.println("é primo") ;
                }
                if(primo == false)
                {
                    System.out.println("não é primo") ;
                }
                break ;
            case 4:
                    
            case 5:
                    
            case 6:
                default:
                System.out.println("Exercicio nao foi implementado ainda");
                       break ;
        }
    }
    
    
    //exercicio 1
    public static double operacao(double raio)
    {
        
        double volume ;
        
        volume = (4 * Math.PI *raio*raio*raio) / 3;
        
        return volume ;
    }
    
    //exercicio 2
    public static double notas(double n1,double n2,double n3, char escolhaMedia)
    {
        double resultado;

        switch(escolhaMedia)
        {
            case 'A':
                resultado=mediaAritmetica(n1, n2, n3);
                break ;
            case 'P':
                resultado=mediaPonderada(n1, n2, n3);
                break ;
            case 'H':
                resultado=mediaHarmonica(n1, n2, n3);
                break ;
            default:
                resultado=-1;
                System.out.println("A opção de média é inválida"); 
        }
        return resultado ;
    }
    
    public static double mediaAritmetica(double n1, double n2, double n3)
    {
        double resultado;
        resultado = (n1+n2+n3)/3;
        return resultado;
    }
    
    public static double mediaPonderada(double n1, double n2, double n3)
    {
        double resultado;
        resultado = (n1*5 + n2*3 + n3*2)/10;
        return resultado;
    }
    
    public static double mediaHarmonica(double n1, double n2, double n3)
    {
        double resultado;
        resultado = 3.0 / ( ((1.0/n1) + (1.0/n2) + (1.0/n3)) );
        return resultado;
    }    
    
    //exercicio 3
    public static boolean PrimoSN(int talvezPrimo)
    {
        int nd = 0 ;
        for(int I;I < talvezPrimo ;I++)
        {
            if((talvezPrimo % I) == 0)
            {
                nd ++ ;
            }
        }
        
        if(nd != 2)
            {
                return false ;
            }
            
        if(nd == 2)
            {
                return true ;
            }
    }        