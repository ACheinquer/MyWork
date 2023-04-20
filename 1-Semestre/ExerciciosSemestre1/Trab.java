import java.util.Scanner;
public class Trab
{
    public static void main (String [] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("==INICIO==");
        System.out.println();
        System.out.println("Olá!");
        System.out.println();

        String[] lojaA = {"Playstation 4", "Iphone 13", "XboxOne", "NoteBook Dell", "RTX 3060"};
        String[] lojaB = {"XboxSeriesX", "MacBook Pro", "Iphone 13", "Playstation 5", "RTX 3060"};
        //i tem que ficar igual
        
        //j++
        //for(int i =0;i<lojaA.length-1;i++)
        int i =0 ;
        int copia = 0 ;
        do
        {
            for(int j = 0;j<lojaA.length;j++)
            {
                if(lojaA[i] == lojaB[j])
                {}else
                    copia++ ;
            }
            if(copia == 4){}
            else
                System.out.println(lojaA[i]) ;
            copia = 0 ;
            i++ ;
        }while(i<lojaA.length);
        
            
        
        
        
        System.out.println("==FIM==");
    }
}