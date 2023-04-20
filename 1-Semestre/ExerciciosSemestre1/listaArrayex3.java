import java.util.* ;
public class listaArrayex3  
{
    public static void main(String [] args)
        {
            Scanner input = new Scanner(System.in) ;
            Random ran = new Random() ;
            int lista [] = new int [10] ;
            int listaAfter [] = new int [lista.length];
            
            for(int i = 0;i<lista.length;i++)
            {
                lista [i] = ran.nextInt(100);
                System.out.println("Lista(" +i+") = "+lista[i]) ;
            }
            System.out.println("------------------------") ;
            System.out.println("Começando alterações...") ;
            System.out.println("------------------------") ;
            
            for(int i = 0;i<lista.length;i++)
            {
                if(lista[i] % 2 == 0)
                {      
                    System.out.println("Pos("+i+") ="+lista[i]/2) ;
                    }else{
                    System.out.println("Pos("+i+") ="+lista[i]*3) ;
                }
            }
        }
}