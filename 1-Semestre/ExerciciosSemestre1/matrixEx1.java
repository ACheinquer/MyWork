import java.util.*;
public class matrixEx1  
{
	public static void main(String [] args)
    	{
    	    int [][] matriz = new int [4][4] ;
    	    Random ran = new Random() ;
    	    
    	    for (int i=0;i<4;i++)
        	    for(int j=0;j<4;j++)
        	    {
                	    matriz[i][j] = ran.nextInt(20) ;
                	    if(matriz[i][j] > 10)
                        	    System.out.println("Posição ("+i+")("+j+") = "+matriz[i][j]) ;
                    }
                	    
	}
}