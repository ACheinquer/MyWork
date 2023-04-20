import java.util.Scanner ;

public class Baskara 
{
    public static void main (String [] args) {
        
        double varA ;
        double varB ;
        double varC ;
        double raiz1 ;
        double raiz2 ;
        
        Scanner input = new Scanner(System.in) ;
        
        
        System.out.println("Insira a variável A:") ;
        
        varA = input.nextDouble() ;
        
        
        System.out.println("Insira a variável B:") ;
        
        varB = input.nextDouble() ;
        
        
        System.out.println("Insira a variável C:") ;
        
        varC = input.nextDouble() ;
        
        
        
        raiz1 = (- varB + Math.sqrt( varB * varB - 4 * varA * varC)) / (2 * varA) ;
        
        raiz2 = (- varB - Math.sqrt( varB * varB - 4 * varA * varC)) / (2 * varA) ;

        
        System.out.println("As raizes são " + raiz1 + " e " + raiz2) ;
    }
}
