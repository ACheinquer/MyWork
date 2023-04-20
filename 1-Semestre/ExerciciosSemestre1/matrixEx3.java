import java.util.*;
public class matrixEx3  
{
    public static void main(String [] args)
        {
            int [][] matriz = new int [4][4] ;
            int linMaior,colMaior,col,lin ;
            col = 0;
            lin = 0;
            linMaior=0;
            colMaior=0;
            Random ran = new Random() ;
            
            for (int i=0;i<matriz.length;i++)
                for(int j=0;j<matriz.length;j++)
                {
                        matriz[i][j] = ran.nextInt(100) ;
                        System.out.println("Posição ("+i+")("+j+") = "+matriz[i][j]) ;
                }
            System.out.println("------------------------------------------------------") ;
            for(int i=0; i<matriz.length; i++)
                for(int j=0; j<matriz[i].length; j++)
                {
                    if(matriz[linMaior][colMaior]<matriz[lin][col])
                    {
                        linMaior=lin;
                        colMaior=col;	
                    }
                }
            
            
            System.out.println("Posição ("+lin+")("+col+") = "+matriz[linMaior][colMaior]) ;           
            }
}
