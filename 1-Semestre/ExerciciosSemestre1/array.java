import java.util.* ;
public class array 
{
    public static void main(String [] args)
        {
            Scanner input = new Scanner(System.in) ;
            Random ran = new Random() ;
            
            int tamanho ;
            
            System.out.println("Insira o tamanho do array") ;
            tamanho = input.nextInt() ;
            
            int vector [] = new int[tamanho]  ;
            
            for(int i = 0; i < tamanho; i++)
            {
                vector [i] = ran.nextInt(10000) ;
            }
        }
        
    public static void listaVetor(int [] vector)
    {
            for(int idx = 0;idx < vector.length ; idx++)
                System.out.println("vt["+idx+"]: " +vector[idx]) ;
        }
        
        public static void eliminar(int[] vector)
        {
            int pos = -1;
            Scanner input = new Scanner(System.in) ;
            
            do {
                System.out.print("Informe a posição a ser eliminada: ") ;
                pos = input.nextInt() ;
                if( !(pos>=0 && pos<vector.length))
                {
                    System.out.println("A posição não é valida") ;
                    System.out.println("    Informe um valor entre 0 e "+vector.length-1) ;
                }
            }while(pos<0 || pos >= vector.length);
        }
    
    public static int Menu() 
    {      
        Scanner input = new Scanner(System.in) ;
        int acao = -1 ;
        do
            {
                System.out.println("Informe a ação desejada:") ;
                
                
                System.out.println("0 - Desligar: fecha o terminal") ;
                System.out.println("1 - Listagem: apresenta todos os valores do vetor") ;
                System.out.println("2 - Eliminação: atribui zero a uma posição especifica") ;
                System.out.println("3 - Adição: acrescenta um número ao vetor") ;
                acao = input.nextInt() ;
            
            
                switch(acao)
                {
                    case 0:
                    System.out.println("Desligando.......") ;
                    acao = 2000;
                        break ;
                
                    case 1:
                        listaVetor(vector);
                        break ;
                
            
                }
            }while(acao < 0 || acao > 3) ;
        }
}