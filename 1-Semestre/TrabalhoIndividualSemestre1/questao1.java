public class questao1  
{
	public static void main(String [] args)
    	{
           //Declaração
    	   double Chico,Ze ;
           int ano ;
            
           //Valores iniciais
           Chico = 1.50 ;
           Ze = 1.10 ;
           ano = 2022 ;
           
           //introdução
           System.out.println("A altura inicial de Chico é 1,50 metro, enquanto a de Zé é de 1,10 metro e o ano é 2022") ;
           
           //operações
           while(Ze < Chico)
           {
               ano++ ;
               Chico += 0.02 ;
               Ze += 0.03 ;
           
               //output
               System.out.print("O ano é " + ano) ;
               System.out.printf(" Chico tem %.2f metro e Zé tem %.2f metro. \n", Chico,Ze) ;
               
           }
           //Conclusão
           System.out.println("Logo serão necessarios " + (ano - 2022) + " anos para que Zé seja maior que Chico.") ;
        }
}