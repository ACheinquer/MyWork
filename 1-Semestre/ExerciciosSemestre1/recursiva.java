import java.util.*;
public class recursiva
{
    public static void main(String args[])
    {
        Scanner input = new Scanner (System.in) ;
        
        System.out.println("Insira um numero para começar o somatório");
        int n = input.nextInt();
        int resultado = Soma(n);
        
        System.out.println("Resultado = "+resultado);
    }
    
    public static int Soma(int n)
    {
        int resultado = n+n;
        
        if(n==1)
            return resultado;
        else
            return resultado+Soma(n-1);
    }
}
