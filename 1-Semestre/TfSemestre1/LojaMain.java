import java.util.* ;
public class LojaMain
    /*
     * O programa deve simular uma loja onde o usuário pode adicionar produtosm,
     * seu preço e sua quantidade no estoque e então poderá alterar sua quanridade no estoque
     * ou fazer compras dentro da loja, depois de uma compra, também poderá ver o total de
     * vendas e de produtos vendidos.
     */
{   
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in) ;
        ClasseProduto cp = new ClasseProduto();
        ClasseLoja cl = new ClasseLoja();
        int option = 0;
        int StockOption = 0;
        int LojaOption = 0;
        int Nprod = 0;
        do
        {   
                option = menu();
                
                    switch(option)
                    {
                        case 1: //add item
                            //Nome do produto
                            System.out.print("Insira o nome do produto: ") ;
                            String prod= input.nextLine();
                            cp.addProd(prod) ;
                            System.out.println("--------------------------") ;
                            //Preço do produto
                            System.out.print("Insira o preço do produto: R$") ;
                            double price = Double.parseDouble(input.nextLine());
                            cp.addValor(price) ; 

                            System.out.println("--------------------------") ;
                            //quantidade no estoque
                            System.out.print("Insira a quantidade deste produto disponível no estoque: ") ;
                            int quant = Integer.parseInt(input.nextLine());
                            cp.addQuant(quant) ;
                            Nprod++;
                                break;
                    
                        case 2: //Opções de estoque
                            do
                            {
                                StockOption = StockMenu() ;
                                switch(StockOption)
                                {
                                    case 1://Listar Todos
                                        System.out.println("----Produto---Valor---Quantidade") ;
                                        for(int i = 0;i<Nprod;i++)
                                        {
                                            System.out.printf(i+"---"+cp.getProdname()+"---"+"%.2f"+"---"+cp.getQtd()+"\n",cp.getPrice()) ; 
                                            cp.count();
                                        } 
                                        cp.countClear();
                                            break;
                                
                                    case 2://Listar Disponível
                                        for(int lin = 0;lin<Nprod;lin++)
                                        {
                                            if(cp.listHere(lin))
                                                System.out.println(lin+ "-"+cp.getThisProdname(lin)) ;
                                        }
                                            break;
                                    case 3://Listar Esgotados
                                        for(int lin = 0;lin<Nprod;lin++)
                                        {
                                            if(!cp.listHere(lin))
                                                System.out.println(lin+ "-"+cp.getThisProdname(lin)) ;
                                        }
                                            break;
                                    case 4://Adicionar Estoque
                                        System.out.println("----Produto---Quantidade") ;
                                        for(int i = 0;i<Nprod;i++)
                                        {
                                            System.out.printf(i+"---"+cp.getProdname()+"---"+cp.getQtd()+"\n") ; 
                                            cp.count();
                                        } 
                                        cp.countClear();
                                        System.out.print("Insira a posição do produto que deseja alterar: ");
                                        int qual = Integer.parseInt(input.nextLine());
                                        System.out.print("\n Insira o valor que deseja alterar: ") ;
                                        int quanto = Integer.parseInt(input.nextLine());
                                        cp.Qstock(qual,quanto) ;
                                            break;
                                }
                            }while(StockOption!=0);
                            break;
                    case 3://Compras
                        double saldo;
                        do
                        {
                            LojaOption = LojaMenu();
                            switch(LojaOption)
                            {
                                case 1://comprar
                                    System.out.println("----Produto---Valor---Quantidade") ;
                                        for(int i = 0;i<Nprod;i++)
                                        {
                                            System.out.printf(i+"---"+cp.getProdname()+"---"+"%.2f"+"---"+cp.getQtd()+"\n",cp.getPrice()) ; 
                                            cp.count();
                                        } 
                                        System.out.printf("insira a posição do produto que deseja comprar: ") ;
                                        int compra = Integer.parseInt(input.nextLine());
                                        System.out.printf("Quantos deste produto deseja comprar? ") ;
                                        int compraQuant = Integer.parseInt(input.nextLine());
                                        cp.Qstock(compra, compraQuant-(compraQuant+compraQuant)) ;
                                        cl.compra(cp.getThisPrice(compra), compra,compraQuant);
                                        if(cl.getSaldo() < 0)
                                            System.out.println("Saldo insuficiente");
                                        else
                                            System.out.println("Compra realizada, saldo restante = "+cl.getSaldo());
                                    break;
                                    
                                    
                                case 2://saldo
                                    System.out.println("Insira a quantidade de R$ que deseja adicionar à conta:") ;
                                    saldo = Double.parseDouble(input.nextLine());
                                    cl.saldo(saldo) ;
                                    System.out.println("Salvando dados do cartão de crédito...");
                                    System.out.println("Copiando os 3 números de trás...");
                                    System.out.println("Clonando cartão...");
                                    System.out.println("Fim do processo, saldo adicionado.");
                                    break;
                                    
                                case 3://estatisticas
                                    System.out.println("O total de vendas é "+cl.GetSale());
                                    System.out.println("O total de produtos vendidos é "+cl.GetQ());
                                    System.out.println("O total do preço das vendas é "+cl.getTotalPrice());
                                    System.out.printf("a media do preço de todas as vendas é %.2f\n",cl.getMedia());
                                    break;
                            }
                        }while(LojaOption!=0);
                        
                        break;
                    default:
                        System.out.println("Desligando, Obrigado por utilizar o Atacadão do Xandão") ;
                }
        }while(option != 0);
    }
    
    public static int menu()//menu principal
    {
        Scanner input = new Scanner(System.in) ;
        int option;
        do
        {
            
            System.out.println("-----Iniciando Atacadão do Xandão-----") ;           
            System.out.println("0 - Sair do programa") ;    
            System.out.println("1 - Adicionar um produto") ;
            System.out.println("2 - Opções de Estoque") ;
            System.out.println("3 - Comprar") ;
            
            System.out.println("Escolha a opção: ") ;
            option=input.nextInt();
            
            return option;
        }while((option<0)||(option>4));
    }
    
    public static int StockMenu()//menu de estoque
    {
        Scanner input = new Scanner(System.in) ;
        int StockOption;
        do
        {
            System.out.println("-----Iniciando as opções de estoque-----") ;           
            System.out.println("0 - Voltar") ;    
            System.out.println("1 - Listar todos") ;
            System.out.println("2 - Listar disponivéis") ;
            System.out.println("3 - Listar esgotados") ;
            System.out.println("4 - Adicionar/retirar estoque") ;
           
            StockOption=input.nextInt();
            return StockOption;
        }while((StockOption<0)||(StockOption>4));
    }
    
    public static int LojaMenu()//menu de compras
    {
        Scanner input = new Scanner(System.in) ;
        int LojaOption;
        do
        {
            System.out.println("-----Iniciando as opções de compra-----") ;           
            System.out.println("0 - Voltar") ;    
            System.out.println("1 - Comprar") ;
            System.out.println("2 - Adicionar saldo") ;
            System.out.println("3 - Estatísticas") ;
            
            LojaOption=input.nextInt();
            return LojaOption;
        }while((LojaOption<0)||(LojaOption>4));
    }
    
    
}


