import java.util.*;
public class ListaArrayex5  
{
    public static void main(String [] args)
        {
            int vetor1 [] = new int[20] ;
            int vetor2 [] = new int[20] ;
            int vetor3 [] = new int[20] ;
            int vetor4 [] = new int[20] ;
            Random ran = new Random() ;
            
            
            for(int i = 0;i<vetor1.length;i++)
           {
                vetor1 [i] = ran.nextInt(100);
           }
           
           for(int i = 0;i<vetor2.length;i++)
           {
                vetor2 [i] = ran.nextInt(100);
           }
           
           
           
           
           for(int i = 0;i<vetor1.length;i++)
           {
                for(int j = i+1;i<vetor1.length; j++)
                   if(vetor1[i] != vetor2[i])
                    {
                        System.out.println(vetor1[i]+" != "+vetor2[i]) ;
                    }
           }
           
           //for(int i = 0;i<vetor4.length;i++)
           //{
                //vetor4 [i] = vetor1 [i] * vetor2 [i];
                //System.out.println("Posição "+i+" a multiplicação dos vetores é "+vetor4[i]) ;
           //}
    }
}