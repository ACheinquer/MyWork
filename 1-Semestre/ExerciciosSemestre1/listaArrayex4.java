import java.util.*;
public class listaArrayex4  
{
    public static void main(String [] args)
    {
        Random ran = new Random() ; 
        Scanner input = new Scanner(System.in) ;
        int lista[] = new int [10] ;
        int t= 4 ;
        for(int i = 0;i<lista.length;i++)
        {
            lista [i] = ran.nextInt(10);
        }
           
           
        System.out.println("Lista finalizada, adivinhe um valor de 0 a 10") ;
        while(t > 0)
        {
           for(int f = 0;f<lista.length;f++)
           {  
                int entrada = input.nextInt() ;
                if(lista [f] == entrada)
                {
                   System.out.println("Parabéns voce acertou!!!!!!!") ;
                }else{
                    t-- ;
                    System.out.println("Restam " +t+ " tentativas") ;
                }
                if(t == 0)
                    System.out.println("Acabaram as tentativas, iniciando Skynet") ;f = 2000 ;
           }
        }
    }
}
