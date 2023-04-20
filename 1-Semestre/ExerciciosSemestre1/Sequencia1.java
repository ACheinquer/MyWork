public class Sequencia1  
{
	public static void main(String [] args)
    {
        int J, I, A, B;
        A = 1 ;
        B = 60 ;
        
        while(A<=102) {
        I = A += 3 ;
        J = B -= 5 ;
        
        System.out.println("I=" + I + " J=" + J) ;
        }
    }
}