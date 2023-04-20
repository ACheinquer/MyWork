import java.util.* ;
public class addArrayMain
{
    /*
     * A Classe recebe o nome de um produto, seu valor e sua quantidade em estoque através de um menu, em seguida, 
     * neste mesmo menu, o usuário pode pedir uma lista de todos os produtos armazenados.
     * Os produtos em si, serão armzenados em uma classe separada(addArray)
     */
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in) ;
        addArray cr = new addArray() ;
        int option = 0;
        int Nprod= 0 ;
        String StrStorage[] = new String[10] ;
        do
        {   
                option = menu();
                switch(option)
                {
                    case 1: //add item
                        //Nome do produto
                        System.out.print("Insira o nome do produto: ") ;
                        String prod= input.nextLine();
                        //StrStorage[0]= input.nextLine();
                        cr.addProd(prod) ;
                        
                        System.out.println("--------------------------") ;
                        //Preço do produto
                        System.out.print("Insira o preço do produto: R$") ;
                        double price = Double.parseDouble(input.nextLine());
                          

                        cr.addValor(price) ;
                        
                        
                        System.out.println("--------------------------") ;
                        //quantidade no estoque
                        System.out.print("Insira a quantidade deste produto disponível no estoque: ") ;
                        int Quant = Integer.parseInt(input.nextLine());
                        cr.addQuant(Quant) ;
                        Nprod++;
                            break;
                    
                    case 2: //Get All Items
                        System.out.println("---Produto---Valor---Quantidade") ;
                        for(int i = 0;i<Nprod;i++)
                            {
                                System.out.printf("---"+cr.getProdname()+"---"+"%.2f"+"---"+cr.getQtd()+"\n",cr.getPrice()) ; 
                                cr.count();
                            } 
                            cr.countClear();
                            break;
                    default:
                        System.out.println("Desligando, Obrigado por utilizar o Atacadão do Xandão") ;
                }
        }while(option != 0);
    }
    
    public static int menu()
    {
        Scanner input = new Scanner(System.in) ;
        int option;
        do
        {
            
            System.out.println("-----Iniciando Atacadão do Xandão-----") ;           
            System.out.println("0 - Sair do programa") ;    
            System.out.println("1 - Adicionar um produto") ;
            System.out.println("2 - Opções de Estoque") ;
            System.out.println("3 - Entrar na Loja") ;
            System.out.println("4 - (WIP)") ;
            
            System.out.println("Escolha a opção: ") ;
            option=input.nextInt();
            
            return option;
        }while((option<0)||(option>4));
    }
}

