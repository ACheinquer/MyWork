import java.io.IOException; //  Import das exceptions

public class App {// é a partir do App que o algoritmo irá rodar chamando as outras classes

    public static void main(String[] args) throws IOException {// throws exception
        //Variáveis
        int numeroFilhos = 0;   // Número de filhos que um pai tem
        int numeroTerrasPai = 0;    // Número de terras que o pai tem
        int numeroTerrasParaCadaFilho = 0;  //  Número de terras que um pai irá distribuir para cada um de seus filhos (numeroTerrasPai / numeroFilhos)

        arvoreGenerica ag = new arvoreGenerica();   // Instância da classe árvore genérica
        leitorPergaminho lp = new leitorPergaminho();   // Intância da classe leitor pergaminho
        TriboBarbaria[] Guerreiros; //  Criação de arranjo de guerreiros

        System.out.println("==============================");
        System.out.println("=  ANALISADOR DE PERGAMINHOS =");   // Nome do projeto
        System.out.println("==============================");
        System.out.println();
        System.out.println("Analisando pergaminho...");
        System.out.println();
        Guerreiros = lp.lerPergaminho();// O leitor irá ler o pergaminho e irá preencher o arranjo com guerreiros 
        System.out.println();

        
        //Aqui irá ocorrer a adição da raiz na lista
        ag.add(Guerreiros[0], Guerreiros[0]);  // Adicionando o pai dos guerreiros, o primeiro guerreiro do pergaminho
        // Aqui irá ocorrer a adição dos filhos na lista
        for (int i = 1; i < Guerreiros.length; i++) { // Loop for que percorrerá os guerreiros I = guerreiros filhos
            for (int j = 0; j < Guerreiros.length; j++) { // Loop for que percorrerá os guerreiros J = gurreiros pais
                if (Guerreiros[i] != null && Guerreiros[j] != null) { // Verificação que verifica se os guerreiros são nulos o não
                    //  Ao passa pela lista de guerreiros, o programa irá verificar se o o pai do filho(i) e igual ao nome do guerreiro (j)
                    //  Se isso for verdadeiro, o guerreiro i será adicionado à árovre tendo o guerreiro (j) como seu pai
                    if (Guerreiros[i].GetNomePai().equals(Guerreiros[j].GetNome())) { 
                        ag.add(Guerreiros[i], Guerreiros[j]);// adicionando o filho atual, ao pai
                    }
                }
            }
        }
        int c = 0;
        // Aqui irá começar a divisão de terras
        for (int i = 0; i < Guerreiros.length; i++) {
            numeroFilhos = 0;
            for (int j = 0; j < Guerreiros.length; j++) {
                if (Guerreiros[i] != null && Guerreiros[j] != null) {// Verificação que verifica se os guerreiros são nulos o não
                    if (Guerreiros[i].GetNome().equals(Guerreiros[j].GetNomePai())) { // Guerreiro J é o filho
                        numeroTerrasPai = Guerreiros[i].GetTerras();
                        numeroFilhos++;
                    }
                }
            }
            if (numeroFilhos != 0) {
                //    Divisão, para calcular a quantidade de terras de cada filho
                numeroTerrasParaCadaFilho = (numeroTerrasPai / numeroFilhos);
                c = i + 1;
                while (c < Guerreiros.length) {
                    if (Guerreiros[i] != null && Guerreiros[c] != null) {// Verificação que verifica se os guerreiros são nulos o não
                        if (Guerreiros[i].GetNome().equals(Guerreiros[c].GetNomePai())) // Guerreiro c é o filho
                            Guerreiros[c].SetTerras(Guerreiros[c].GetTerras() + numeroTerrasParaCadaFilho);
                    }
                    c++;
                }
            }

        }

        for (int i = 0; i < Guerreiros.length; i++) {//Dá gerações aos guerreiros
            if (Guerreiros[i] != null)// Verificação que verifica se os guerreiros são nulos ou não
                Guerreiros[i].SetGen(geracao(Guerreiros[i],0,ag));
        }

        int maiorG = 0;
        for (int i = 0; i < Guerreiros.length; i++) {//Encontra a maior geração
            if (Guerreiros[i] != null){// Verificação que verifica se os guerreiros são nulos ou não
                if(Guerreiros[i].GetGen() > maiorG){
                    maiorG = Guerreiros[i].GetGen();
                }
            }
        } 


        TriboBarbaria top = Guerreiros[0];//inicialização de top com valor placeholder
        for(int i= 0;i < Guerreiros.length; i++) {//Top recebe o valor de um guerreiro qualquer da ultima geração
            if(Guerreiros[i] != null)
                if(Guerreiros[i].GetGen() == maiorG)
                    top = Guerreiros[i];
        }
    
        for (int i = 0; i < Guerreiros.length; i++) {;//fors percorrem os guerreiros
                if (Guerreiros[i] != null)//não passa pelos valores nulos
                    if(Guerreiros[i].GetGen() == maiorG){//Veta todos os guerreiros que não são da última geração
                        if(Guerreiros[i].GetTerras() > top.GetTerras())//Compara todos os guerreiros restantes com todos os outros
                            top = Guerreiros[i];//encontra aquele da ultima geração com mais terras
                    } 
        }

        System.out.println("O guerreiro da última geração com mais terras é \n" + top); 
        System.out.println("======================================================");
        System.out.println("=                 RESTANTE DA ÁRVORE                 =");
        System.out.println("======================================================");
        ag.printTree();
    }

    public static int geracao(TriboBarbaria Guerreiro,int gen,arvoreGenerica ag){//Conta as gerações do guerreiro passado
        if(ag.getParent(Guerreiro) == null)
            return gen;
        else
            return geracao(ag.getParent(Guerreiro),gen+1,ag);
    }
}


