import java.util.* ;
public class Principal
{
    
    public static void main(String[] args)
    {
        caixa cr = new caixa();
        Scanner input = new Scanner(System.in) ;
        int opcao = 0;
        do
        {   
            opcao = menu();
            switch(opcao)
            {
                case 1: //add item
                        double preco;
                        System.out.print("Informe o valor do produto: R$") ;
                        preco = input.nextDouble() ;
                        
                        cr.addItem(preco) ;
                    break;
                case 2: //Total a pagar
                        System.out.printf("O valor a ser pago é de R$%.2f\n",cr.getTotal()) ;
                    break;
                case 3: //itens da compra
                        System.out.println("O numero de produtos registrados é "+cr.GetCount()) ;
                    break;
                case 4: //Reset
                    cr.clear();
                    break;
                default:
                    System.out.println("Valor não tratado") ;
            }
        }while(opcao != 0);
    }
    
    public static int menu()
    {
        Scanner input = new Scanner(System.in) ;
        int opcao;
        do
        {
            
            System.out.println("Menu de opções") ;           
            System.out.println("0 - Sair do programa") ;    
            System.out.println("1 - Adicionar um item") ;
            System.out.println("2 - Total a ser pago") ;
            System.out.println("3 - Número de itens da compra") ;
            System.out.println("4 - Inicia uma nova operação") ;
            
            System.out.println("Escolha a opção: ") ;
            opcao=input.nextInt();
            
            return opcao;
        }while((opcao<0)||(opcao>4));
    }
}