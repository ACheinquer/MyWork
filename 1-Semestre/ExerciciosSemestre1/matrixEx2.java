import java.util.*;
public class matrixEx2  
{
	public static void main(String [] args)
    	{
    	    int [][] matriz = new int [4][4] ;
    	    Random ran = new Random() ;
    	    
    	    for (int i=0;i<4;i++)
        	    for(int j=0;j<4;j++)
        	    {
                	    matriz[i][j] = i*j ;
                	    System.out.println("Posição ("+i+")("+j+") = "+matriz[i][j]) ;
                    }
	}
}