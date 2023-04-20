import java.util.Scanner ;
public class circulo
{
    public static void main(String [] args)
    {
        //Declaração
        double varA ;
        double area ;
        Scanner input = new Scanner(System.in) ;
        
        //input
        System.out.print("Insira o raio da circunferência ") ;
        varA = input.nextDouble() ;
        
        //operação
        area = varA * varA * 3.14159 ;
        //output
        System.out.println("A área da circunferência é " + area) ;
        
        
    
    }
}