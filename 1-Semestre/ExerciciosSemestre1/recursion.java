import java.util.Scanner;
public class recursion
{
  
  public static void main(String args [])
  {
    //
    Scanner usr = new Scanner(System.in);
    int nTermos = usr.nextInt();
    
    // desenvolvimento
    double resultado = metodoRecursivo(nTermos);
    
    // conclusao
    System.out.println("O resultado para "+nTermos+" termos é "+resultado);
    
    
  } 
  
  public static double metodoRecursivo(double valor)
  {
    double calculaTermo = ((2*valor)-1)/(2*valor);
    
    if(valor==1)
       return calculaTermo;
    else
       return calculaTermo + metodoRecursivo(valor-1);
    
  }
  
}