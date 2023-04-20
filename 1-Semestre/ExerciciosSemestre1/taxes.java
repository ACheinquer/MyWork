import java.util.Scanner ;
public class taxes
{
    public static void main(String [] args)
    {
        //Declaracao
        double entrada ;
        Scanner input = new Scanner(System.in) ;
        double valorImposto ;
        double valorImpostoReal ;
        
        //input
        System.out.print("Insira o valor dos impostos ");
        entrada = input.nextDouble();
        
        //operacoes e output
        if(entrada < 0.00)
        {
            System.out.println("Valor invalido de imposto") ;
        }
        
        if(entrada > 0.00 && entrada <= 1903.98)
        {
            System.out.println("O valor da primeira faixa é isento") ;
        }
        
        if(entrada > 1903.98 && entrada <= 2826.65)
        {
            valorImpostoReal = (entrada - 1903.98) * 0.075 ; //calculo da %
            System.out.printf("O valor em impostos a pagar é isento da primeira faixa e R$" + "%04.2f",valorImpostoReal) ;
            System.out.println(" da segunda faixa ") ;
        }
        
        if(entrada > 2826.65 && entrada <= 3751.05)
        {
            valorImposto = (entrada - 2826.65) * 0.15 ; //calculo da %
            valorImpostoReal =(valorImposto + 69.20); //soma das faixas
            System.out.printf("O valor em impostos a pagar é isento da primeira faixa, R$69,20 da segunda faixa e R$" + "%04.2f",valorImposto) ;
            System.out.printf(" da terceira faixa resultando em um total de R$" + "%04.2f\n",valorImpostoReal) ;
        }
        
        if(entrada > 3751.05 && entrada <= 4664.68)
        {
            valorImposto = (entrada - 3751.05) * 0.225 ; //calculo da %
            valorImpostoReal =valorImposto + 69.20 + 562.66 ; //soma das faixas
            System.out.printf("O valor em impostos a pagar é isento da primeira faixa, R$69,20 da segunda faixa, R$562,66 da terceira faixa e R$" + "%04.2f",valorImposto) ;
            System.out.printf(" da quarta faixa resultando em um total de R$" + "%04.2f\n",valorImpostoReal) ;
        }
        
        if(entrada > 4664.68)
        {
            valorImposto = entrada * 0.275 ; //calculo da %
            valorImpostoReal =valorImposto + 69.20 + 562.66 + 834.99; //soma das faixas
            System.out.printf("O valor em impostos a pagar é isento da primeira faixa, R$69,20 da segunda faixa, R$562,66 da terceira faixa, 834,99 da quarta faixa e R$" + "%04.2f",valorImposto) ;
            System.out.printf(" da quinta faixa resultando em um total de R$" + "%04.2f\n",valorImpostoReal) ;
        }
        
        }
}