import java.util.*;
public class listaMatrizEx6  
{
    public static void main(String [] args)
        {
            Random ran = new Random() ;
            int[][] matriz = new int [5][5] ;
            for(int lin=0;lin<matriz.length;lin++)
                for(int col = 0;col<matriz.length;col++)
                    matriz[lin][col] = -1;
                    
            for(int lin=0;lin<matriz.length;lin++)
                for(int col = 0;col<matriz.length;col++)
                {
                    matriz[lin][col] = ran.nextInt(100) ;
                    for(int i = 0;i<matriz.length;i++)
                        for(int j = 0;j<matriz.length;j++)
                        {
                            if((i!=lin)&&(j!=col))
                                while(matriz[lin][col]==matriz[i][j])
                                    matriz[lin][col] = ran.nextInt(100);  
                                    
                        }
                }
            
            for(int lin=0;lin<matriz.length;lin++)
                for(int col = 0;col<matriz.length;col++)
                    System.out.println("Bingo("+lin+")("+col+") = "+matriz[lin][col]) ;
    }
}